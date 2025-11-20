package com.infosys.ftrbackendvehiclems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infosys.ftrbackendvehiclems.dto.VehicleDTO;
import com.infosys.ftrbackendvehiclems.entity.Vehicle;
import com.infosys.ftrbackendvehiclems.exception.VehicleException;
import com.infosys.ftrbackendvehiclems.repository.VehicleRepository;
import com.infosys.ftrbackendvehiclems.validator.VehicleValidator;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class VehicleServiceImp implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private Environment env;

    // insertNewVehicle
    @Override
    public String insertNewVehicle(VehicleDTO vehicleDTO) throws VehicleException {
        try {
            VehicleValidator vehicleValidator = new VehicleValidator();
            vehicleValidator.validateVehicle(vehicleDTO);

            Vehicle vehicle = Vehicle.toEntity(vehicleDTO);
            vehicleRepository.save(vehicle);
            return "Vehicle details are inserted successfully with vehicle number: " + vehicleDTO.getVehicleNumber();
        } catch (VehicleException ve) {
            throw ve;
        } catch (Exception e) {
            String msg = env.getProperty("invalid.data", "INVALID_DATA");
            throw new VehicleException(msg, e);
        }
    }

    // fetchAvailableVehicles
    @Override
    public List<VehicleDTO> fetchAvailableVehicles() throws VehicleException {
        List<Vehicle> availabVehicles = vehicleRepository.findByVehicleStatus("Active");
        if (availabVehicles == null || availabVehicles.isEmpty()) {
            String msg = env.getProperty("vehicle.not.found", "VEHICLE_NOT_FOUND");
            throw new VehicleException(msg);
        }
        List<VehicleDTO> availabVehiclesDTO = new ArrayList<>();
        for (Vehicle vehicle : availabVehicles) {
            availabVehiclesDTO.add(VehicleDTO.toDTO(vehicle));
        }
        return availabVehiclesDTO;
    }

    // updateVehicleStatus
    @Override
    public String updateVehicleStatus(String vehicleNumber, VehicleDTO dto) throws VehicleException {
        try {
            VehicleValidator vehicleValidator = new VehicleValidator();
            vehicleValidator.isVehicleStatusValid(dto.getVehicleStatus());

            Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
            if (vehicle == null) {
                String msg = env.getProperty("vehicle.not.found", "VEHICLE_NOT_FOUND");
                throw new VehicleException(msg);
            }
            if (vehicle.getVehicleStatus() != null && vehicle.getVehicleStatus().equals(dto.getVehicleStatus())) {
                String msg = env.getProperty("vehicle.update.already.exists", "VEHICLE_UPDATE_ALREADY_EXISTS");
                throw new VehicleException(msg);
            }
            vehicle.setVehicleStatus(dto.getVehicleStatus());
            vehicleRepository.save(vehicle);
            return "Status of vehicleNumber: " + vehicle.getVehicleNumber() + " updated successfully";
        } catch (VehicleException ve) {
            throw ve;
        } catch (Exception e) {
            String msg = env.getProperty("invalid.data", "INVALID_DATA");
            throw new VehicleException(msg, e);
        }
    }

    // fetchVehicleDetailsByVehicleName
    @Override
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException {
        List<Vehicle> vehicleList = vehicleRepository.findByVehicleName(vehicleName);
        if (vehicleList == null || vehicleList.isEmpty()) {
            String msg = env.getProperty("vehicle.not.found", "VEHICLE_NOT_FOUND");
            throw new VehicleException(msg);
        }
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(VehicleDTO.toDTO(vehicle));
        }
        return vehicleDTOList;
    }

    // removeVehicle
    @Override
    public String removeVehicle(String vehicleNum) throws VehicleException {
        try {
            Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNum);
            if (vehicle == null) {
                String msg = env.getProperty("invalid.data", "INVALID_DATA");
                throw new VehicleException(msg);
            }
            vehicleRepository.delete(vehicle);
            return "Vehicle details are deleted successfully";
        } catch (VehicleException ve) {
            throw ve;
        } catch (Exception e) {
            String msg = env.getProperty("invalid.data", "INVALID_DATA");
            throw new VehicleException(msg, e);
        }
    }

    // fetchVehicleDetailsByVehicleNumber
    @Override
    public VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber) throws VehicleException {
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicle == null) {
            String msg = env.getProperty("vehicle.not.found", "VEHICLE_NOT_FOUND");
            throw new VehicleException(msg);
        }
        return VehicleDTO.toDTO(vehicle);
    }
}
