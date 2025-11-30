package com.rapidcargo.ftrbackendvehiclems.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rapidcargo.ftrbackendvehiclems.dto.VehicleDTO;
import com.rapidcargo.ftrbackendvehiclems.exception.VehicleException;

public class VehicleValidator {

    private static final List<String> VALID_NAMES = Arrays.asList(
            "Tower crane", "FirePlace Crane", "Double treadwheel Crane", "Crawler Crane",
            "Aerial Crane", "Deck Crane");

    private static final List<String> VALID_STATUS = Arrays.asList("Active", "InProgress", "Retired");

    public Boolean validateVehicle(VehicleDTO dto) throws VehicleException {
        if (dto == null) {
            throw new VehicleException("vehicle.invalid.data");
        }
        return isVehicleNameValid(dto.getVehicleName())
                && isVehicleStatusValid(dto.getVehicleStatus())
                && isVehicleNumberValid(dto.getVehicleNumber());
    }

    private Boolean isVehicleNameValid(String name) throws VehicleException {
        if (name == null) {
            throw new VehicleException("vehicle.vehicleName.invalid");
        }
        if (VALID_NAMES.contains(name)) {
            return true;
        }
        throw new VehicleException("vehicle.vehicleName.invalid");
    }

    public Boolean isVehicleStatusValid(String status) throws VehicleException {
        if (status == null) {
            throw new VehicleException("vehicle.vehicleStatus.invalid");
        }
        if (VALID_STATUS.contains(status)) {
            return true;
        }
        throw new VehicleException("vehicle.vehicleStatus.invalid");
    }

    private Boolean isVehicleNumberValid(String vehicleNumber) throws VehicleException {
        if (vehicleNumber == null) {
            throw new VehicleException("vehicle.vehicleNumber.invalid");
        }
        // Pattern: 2 letters followed by 6 digits (example); adjust if required
        Pattern pattern = Pattern.compile("^[A-Za-z]{2}[0-9]{6}$");
        Matcher hasPattern = pattern.matcher(vehicleNumber);
        if (hasPattern.find()) {
            return true;
        }
        throw new VehicleException("vehicle.vehicleNumber.invalid");
    }
}
