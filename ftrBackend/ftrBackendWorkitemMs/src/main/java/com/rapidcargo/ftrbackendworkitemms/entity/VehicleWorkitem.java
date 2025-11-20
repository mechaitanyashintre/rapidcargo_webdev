package com.rapidcargo.ftrbackendworkitemms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rapidcargo.ftrbackendworkitemms.dto.VehicleWorkitemDTO;

@Entity
@Table(name = "ftr_vehicle_workitem")
public class VehicleWorkitem {
    @Id
    private String workitemId;
    private String vehicleNumber;
    private String driverId;
    private String assignedWorkitemStatus;

    public String getWorkitemId() { return this.workitemId; }
    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public String getVehicleNumber() { return this.vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getDriverId() { return this.driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getAssignedWorkitemStatus() { return this.assignedWorkitemStatus; }
    public void setAssignedWorkitemStatus(String assignedWorkitemStatus) { this.assignedWorkitemStatus = assignedWorkitemStatus; }

    public static VehicleWorkitem toEntity(VehicleWorkitemDTO dto) {
        VehicleWorkitem entity = new VehicleWorkitem();
        entity.setAssignedWorkitemStatus(dto.getAssignedWorkitemStatus());
        entity.setDriverId(dto.getDriverId());
        entity.setVehicleNumber(dto.getVehicleNumber());
        entity.setWorkitemId(dto.getWorkitemId());
        return entity;
    }
}
