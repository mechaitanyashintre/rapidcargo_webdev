package com.rapidcargo.ftrbackendvehiclems.dto;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rapidcargo.ftrbackendvehiclems.entity.Vehicle;

public class VehicleDTO {

    @NotEmpty(message = "{vehicle.vehicleNumber.must}")
    private String vehicleNumber;

    @NotEmpty(message = "{vehicle.vehicleName.must}")
    @Size(max = 30, message = "{vehicle.vehicleName.invalid}")
    private String vehicleName;

    @NotNull(message = "{vehicle.maxLiftingCapacity.must}")
    private Double maxLiftingCapacity;

    @NotNull(message = "{vehicle.retireDate.must}")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date retireDate;

    @NotEmpty(message = "{vehicle.vehicleStatus.must}")
    private String vehicleStatus;

    @Size(min = 5, max = 25, message = "String must have 5 - 25 characters")
    private String harborLocation;

    @Size(min = 5, max = 25, message = "String must have 5 - 25 characters")
    private String country;

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

    public Double getMaxLiftingCapacity() { return maxLiftingCapacity; }
    public void setMaxLiftingCapacity(Double maxLiftingCapacity) { this.maxLiftingCapacity = maxLiftingCapacity; }

    public Date getRetireDate() { return retireDate; }
    public void setRetireDate(Date retireDate) { this.retireDate = retireDate; }

    public String getVehicleStatus() { return vehicleStatus; }
    public void setVehicleStatus(String vehicleStatus) { this.vehicleStatus = vehicleStatus; }

    public String getHarborLocation() { return harborLocation; }
    public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public static VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setCountry(vehicle.getCountry());
        dto.setHarborLocation(vehicle.getHarborLocation());
        dto.setMaxLiftingCapacity(vehicle.getMaxLiftingCapacity());
        dto.setRetireDate(vehicle.getRetireDate());
        dto.setVehicleName(vehicle.getVehicleName());
        dto.setVehicleNumber(vehicle.getVehicleNumber());
        dto.setVehicleStatus(vehicle.getVehicleStatus());
        return dto;
    }
}
