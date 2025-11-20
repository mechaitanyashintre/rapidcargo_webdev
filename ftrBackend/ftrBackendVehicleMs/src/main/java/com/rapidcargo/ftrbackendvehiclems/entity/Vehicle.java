package com.rapidcargo.ftrbackendvehiclems.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.rapidcargo.ftrbackendvehiclems.dto.VehicleDTO;

@Entity
@Table(name = "ftr_vehicles")
public class Vehicle {

    @Id
    private String vehicleNumber;
    private String vehicleName;
    private Double maxLiftingCapacity;
    private Date retireDate;
    private String vehicleStatus;
    private String harborLocation;
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

    public static Vehicle toEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setCountry(dto.getCountry());
        vehicle.setHarborLocation(dto.getHarborLocation());
        vehicle.setMaxLiftingCapacity(dto.getMaxLiftingCapacity());
        vehicle.setRetireDate(dto.getRetireDate());
        vehicle.setVehicleName(dto.getVehicleName());
        vehicle.setVehicleNumber(dto.getVehicleNumber());
        vehicle.setVehicleStatus(dto.getVehicleStatus());
        return vehicle;
    }
}
