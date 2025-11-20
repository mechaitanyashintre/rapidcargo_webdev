package com.rapidcargo.ftrbackendworkitemms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.rapidcargo.ftrbackendworkitemms.dto.HarborDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.TerminalDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.VehicleDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.VehicleWorkitemDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.WorkitemDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.WorkitemTerminalDTO;
import com.rapidcargo.ftrbackendworkitemms.entity.Harbor;
import com.rapidcargo.ftrbackendworkitemms.entity.VehicleWorkitem;
import com.rapidcargo.ftrbackendworkitemms.entity.Workitem;
import com.rapidcargo.ftrbackendworkitemms.entity.WorkitemTerminal;
import com.rapidcargo.ftrbackendworkitemms.exception.WorkitemException;
import com.rapidcargo.ftrbackendworkitemms.repository.HarborRepository;
import com.rapidcargo.ftrbackendworkitemms.repository.VehicleWorkitemRepository;
import com.rapidcargo.ftrbackendworkitemms.repository.WorkitemRepository;
import com.rapidcargo.ftrbackendworkitemms.repository.WorkitemTerminalRepository;
import com.rapidcargo.ftrbackendworkitemms.feign.VehicleMsFeign;
import com.rapidcargo.ftrbackendworkitemms.feign.TerminalMsFeign;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class WorkitemServiceImp implements WotkitemService {

    @Autowired
    private WorkitemRepository workitemRepository;

    @Autowired
    private HarborRepository harborRepository;

    @Autowired
    private VehicleWorkitemRepository vehicleWorkitemRepository;

    @Autowired
    private WorkitemTerminalRepository workitemTerminalRepository;

    @Autowired
    private VehicleMsFeign vehicleMsFeign;

    @Autowired
    private TerminalMsFeign terminalMsFeign;

    @Autowired
    private Environment env;

    @Override
    public WorkitemDTO createWorkitem(WorkitemDTO workitemDto) throws WorkitemException {
        List<String> allWorkitemId = workitemRepository.getAllWorkitemId();
        String temp1 = allWorkitemId.get(allWorkitemId.size() - 1);
        int temp2 = Integer.parseInt(temp1.substring(1)) + 1;
        workitemDto.setWorkitemId("J" + temp2);

        String itemType = workitemDto.getItemType();
        switch (itemType) {
            case "Computer Hardware":
                workitemDto.setAmount(15999 * Integer.parseInt(workitemDto.getQuantity()));
                break;
            case "Oil Container":
                double temp = 22.54 * Integer.parseInt(workitemDto.getQuantity());
                workitemDto.setAmount((int) temp);
                break;
            case "Wood":
                workitemDto.setAmount(130000 * Integer.parseInt(workitemDto.getQuantity()));
                break;
            case "Motorcycles":
                workitemDto.setAmount(6336 * Integer.parseInt(workitemDto.getQuantity()));
                break;
            case "Electronics":
                workitemDto.setAmount(13490 * Integer.parseInt(workitemDto.getQuantity()));
                break;
            default:
                workitemDto.setAmount(0);
                break;
        }

        Workitem workitem = Workitem.toEntity(workitemDto);
        workitemRepository.save(workitem);
        return workitemDto;
    }

    @Override
    public List<String> fetchAvailableHarborLocations(String country) throws WorkitemException {
        Optional<Harbor> result = harborRepository.findById(country);
        Harbor harbor = result.orElseThrow(() -> new WorkitemException("harbor.notFound"));
        return Arrays.asList(harbor.getAvailableHarborLocations().split(","));
    }

    @Override
    public String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) throws WorkitemException {
        try {
            Optional<Workitem> result = workitemRepository.findById(workitemId);
            Workitem workitem = result.orElseThrow(() -> new WorkitemException("workitem.notFound"));
            workitem.setSelectedHarborLocation(workitemDTO.getSelectedHarborLocation());
            workitem.setShippingDate(workitemDTO.getShippingDate());
            workitemRepository.save(workitem);
            return "Harbor location and shipping date got updated successfully.";
        } catch (Exception e) {
            return new WorkitemException(env.getProperty("invalid.data")).getMessage();
        }
    }

    @Override
    public List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException {
        List<Workitem> results = workitemRepository.findAll();
        if (results.isEmpty()) throw new WorkitemException("workitem.notFound");
        List<WorkitemDTO> workitemDTOList = new ArrayList<>();
        for (Workitem workitem : results) {
            workitemDTOList.add(WorkitemDTO.toDto(workitem));
        }
        return workitemDTOList;
    }

    @Override
    public List<VehicleWorkitemDTO> trackWorkitemByUser(Integer userId) throws WorkitemException {
        List<Workitem> results = workitemRepository.findByUserId(userId.longValue());
        if (results.isEmpty()) throw new WorkitemException("workitem.notFound");
        List<VehicleWorkitemDTO> vehicleWorkitemDTOList = new ArrayList<>();
        for (Workitem workitem : results) {
            Optional<VehicleWorkitem> result2 = vehicleWorkitemRepository.findById(workitem.getWorkitemId());
            result2.ifPresent(vw -> vehicleWorkitemDTOList.add(VehicleWorkitemDTO.toDTO(vw)));
        }
        return vehicleWorkitemDTOList;
    }

    @Override
    public String allocateVehicle(String workitemId, VehicleDTO vehicleDTO) throws WorkitemException {
        try {
            Optional<VehicleWorkitem> result1 = vehicleWorkitemRepository.findById(workitemId);
            VehicleWorkitem vehicleWorkitem = result1.orElseThrow(() -> new WorkitemException("vehicle.notFound"));

            if ("Completed".equals(vehicleWorkitem.getAssignedWorkitemStatus())) {
                Optional<Workitem> result2 = workitemRepository.findById(workitemId);
                Workitem workitem = result2.get();
                Optional<WorkitemTerminal> result3 = workitemTerminalRepository.findById(workitemId);
                WorkitemTerminal workitemTerminal = result3.get();

                String temp2 = workitem.getSelectedHarborLocation().replaceAll(" ", "_");
                boolean temp3 = terminalMsFeign.checkItemType(workitemTerminal.getTerminalId(), workitem.getItemType());
                boolean temp4 = vehicleMsFeign.checkHarborLoc(vehicleDTO.getVehicleNumber(), temp2);

                if (temp3 && temp4) {
                    VehicleWorkitem vehicleWorkitemOp = new VehicleWorkitem();
                    vehicleWorkitemOp.setWorkitemId(workitemId);
                    vehicleWorkitemOp.setVehicleNumber(vehicleDTO.getVehicleNumber());
                    vehicleWorkitemOp.setAssignedWorkitemStatus("InProgress");
                    vehicleWorkitemRepository.save(vehicleWorkitemOp);
                    return "WorkItem allocated with vehicle";
                }
            }
            return "Invalid Data";
        } catch (Exception e) {
            return new WorkitemException(env.getProperty("invalid.data")).getMessage();
        }
    }

    @Override
    public VehicleWorkitemDTO fetchWorkItemStatus(String workitemId) throws WorkitemException {
        Optional<VehicleWorkitem> results = vehicleWorkitemRepository.findById(workitemId);
        VehicleWorkitem vehicleWorkitem = results.orElseThrow(() -> new WorkitemException("vehicle.notFound"));
        return VehicleWorkitemDTO.toDTO(vehicleWorkitem);
    }

    @Override
    public String updateWorkItemStatus(String workitemId) throws WorkitemException {
        Optional<Workitem> results = workitemRepository.findById(workitemId);
        Workitem workitem = results.orElseThrow(() -> new WorkitemException("WORKITEM_NOT_FOUND"));

        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(workitem.getShippingDate()));
        if (localDate.compareTo(LocalDate.now()) <= 0) {
            Optional<VehicleWorkitem> results2 = vehicleWorkitemRepository.findById(workitemId);
            VehicleWorkitem vehicleWorkitem = results2.orElseThrow(() -> new WorkitemException("WORKITEM_NOT_FOUND"));
            vehicleWorkitem.setAssignedWorkitemStatus("Completed");
            vehicleWorkitemRepository.save(vehicleWorkitem);

            vehicleMsFeign.updateVehicleStatus(vehicleWorkitem.getVehicleNumber());
            WorkitemTerminal workitemTerminal = workitemTerminalRepository.getById(workitemId);
            terminalMsFeign.updateTerminalCapacity(workitemTerminal.getTerminalId(), workitem.getQuantity());
            return "Workitem status has updated successfully";
        }
        return "Item is not yet delivered";
    }

    @Override
    public VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) throws WorkitemException {
        Optional<VehicleWorkitem> results = vehicleWorkitemRepository.findByVehicleNumber(vehicleNumber);
        VehicleWorkitem vehicleWorkitem = results.orElseThrow(() -> new WorkitemException("terminal.notAvailable"));
        return VehicleWorkitemDTO.toDTO(vehicleWorkitem);
    }

    @Override
    public String assignTerminalForWorkitem(String workitemId) {
        try {
            Optional<Workitem> results = workitemRepository.findById(workitemId);
            Workitem workitem = results.get();

            String temp1 = workitem.getItemType().replaceAll(" ", "-");
            String temp2 = terminalMsFeign.assignTerminal(temp1, workitem.getQuantity());

            WorkitemTerminal workitemTerminal = new WorkitemTerminal();
            workitemTerminal.setWorkitemId(workitemId);
            workitemTerminal.setTerminalId("T" + temp2);
            workitemTerminalRepository.save(workitemTerminal);

            return "Terminal capacity of " + temp2 + " is reduced";
        } catch (Exception e) {
            return new WorkitemException(env.getProperty("invalid.data")).getMessage();
        }
    }
}
