// VehicleDTO.java
package com.infosys.ftrbackendworkitemms.dto;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class VehicleDTO {

    @NotEmpty(message = "vehicleNumber must not be empty")
    @Pattern(regexp = "[a-zA-Z]{2}[0-9]{6}", message = "vehicleNumber invalid")
    private String vehicleNumber;

    @NotEmpty(message = "vehicleName must not be empty")
    @Size(max = 30, message = "vehicleName invalid")
    private String vehicleName;

    @NotNull(message = "maxLiftingCapacity must not be null")
    private Integer maxLiftingCapacity;

    @NotNull(message = "retireDate must not be null")
    private Date retireDate;

    @NotEmpty(message = "vehicleStatus must not be empty")
    private String vehicleStatus;

    @Size(min = 5, max = 25, message = "harborLocation must have 5-25 characters")
    private String harborLocation;

    @Size(min = 5, max = 25, message = "country must have 5-25 characters")
    private String country;

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

    public Integer getMaxLiftingCapacity() { return maxLiftingCapacity; }
    public void setMaxLiftingCapacity(Integer maxLiftingCapacity) { this.maxLiftingCapacity = maxLiftingCapacity; }

    public Date getRetireDate() { return retireDate; }
    public void setRetireDate(Date retireDate) { this.retireDate = retireDate; }

    public String getVehicleStatus() { return vehicleStatus; }
    public void setVehicleStatus(String vehicleStatus) { this.vehicleStatus = vehicleStatus; }

    public String getHarborLocation() { return harborLocation; }
    public void setHarborLocation(String harborLocation) { this.harborLocation = harborLocation; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
