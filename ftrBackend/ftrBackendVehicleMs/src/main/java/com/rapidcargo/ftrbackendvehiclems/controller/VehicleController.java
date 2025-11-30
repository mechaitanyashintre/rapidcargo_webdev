package com.rapidcargo.ftrbackendvehiclems.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rapidcargo.ftrbackendvehiclems.dto.VehicleDTO;
import com.rapidcargo.ftrbackendvehiclems.entity.Vehicle;
import com.rapidcargo.ftrbackendvehiclems.exception.VehicleException;
import com.rapidcargo.ftrbackendvehiclems.repository.VehicleRepository;
import com.rapidcargo.ftrbackendvehiclems.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

    // insertNewVehicle
    @PostMapping
    public ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO dto) throws VehicleException {
        return new ResponseEntity<>(vehicleService.insertNewVehicle(dto), HttpStatus.OK);
    }

    // fetchAvailableVehicles
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws VehicleException {
        return new ResponseEntity<>(vehicleService.fetchAvailableVehicles(), HttpStatus.OK);
    }

    // updateVehicleStatus
    @PutMapping("/{vehicleNumber}")
    public ResponseEntity<String> updateVehicleStatus(@PathVariable String vehicleNumber, @RequestBody VehicleDTO dto)
            throws VehicleException {
        return new ResponseEntity<>(vehicleService.updateVehicleStatus(vehicleNumber, dto), HttpStatus.OK);
    }

    // fetchVehicleDetailsByVehicleName
    @GetMapping("/managed-name/{vehicleName}")
    public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName)
            throws VehicleException {
        return new ResponseEntity<>(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName), HttpStatus.OK);
    }

    // removeVehicle
    @DeleteMapping("/{vehicleNum}")
    public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNum) throws VehicleException {
        return new ResponseEntity<>(vehicleService.removeVehicle(vehicleNum), HttpStatus.OK);
    }

    // fetchVehicleDetailsByVehicleNumber
    @GetMapping("/managed-number/{vehicleNumber}")
    public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable String vehicleNumber)
            throws VehicleException {
        return new ResponseEntity<>(vehicleService.fetchVehicleByVehicleNumber(vehicleNumber), HttpStatus.OK);
    }

    // checkHarborLoc
    @GetMapping("/checkHarborLoc/{vehicleNumber}/{selectedHarborLocation}")
    public boolean checkHarborLoc(@PathVariable String vehicleNumber,
                                  @PathVariable String selectedHarborLocation) {
        if (selectedHarborLocation.contains("_")) {
            selectedHarborLocation = selectedHarborLocation.replaceAll("_", " ");
        }
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        return vehicle != null && vehicle.getHarborLocation().equals(selectedHarborLocation)
                && "Active".equals(vehicle.getVehicleStatus());
    }

    // updateVehicleStatus - workitem
    @PutMapping("/updateVehicleStatus/{vehicleNumber}")
    public void updateVehicleStatus(@PathVariable String vehicleNumber) {
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicle != null) {
            vehicle.setVehicleStatus("Active");
            vehicleRepository.save(vehicle);
        }
    }
}
