package com.rapidcargo.ftrbackendvehiclems.service;

import java.util.List;
import com.rapidcargo.ftrbackendvehiclems.dto.VehicleDTO;
import com.rapidcargo.ftrbackendvehiclems.exception.VehicleException;

public interface VehicleService {
    // insertNewVehicle
    String insertNewVehicle(VehicleDTO vehicleDTO) throws VehicleException;

    // fetchAvailableVehicles
    List<VehicleDTO> fetchAvailableVehicles() throws VehicleException;

    // updateVehicleStatus
    String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws VehicleException;

    // fetchVehicleDetailsByVehicleName
    List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException;

    // fetchVehicleDetailsByVehicleNumber
    VehicleDTO fetchVehicleByVehicleNumber(String vehicleNumber) throws VehicleException;

    // removeVehicle
    String removeVehicle(String vehicleNum) throws VehicleException;
}
