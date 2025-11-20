// VehicleWorkitemDTO.java
package com.rapidcargo.ftrbackendworkitemms.dto;

import com.rapidcargo.ftrbackendworkitemms.entity.VehicleWorkitem;

public class VehicleWorkitemDTO {
    private String workitemId;
    private String vehicleNumber;
    private String driverId;
    private String assignedWorkitemStatus;

    public String getWorkitemId() { return workitemId; }
    public void setWorkitemId(String workitemId) { this.workitemId = workitemId; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getAssignedWorkitemStatus() { return assignedWorkitemStatus; }
    public void setAssignedWorkitemStatus(String assignedWorkitemStatus) { this.assignedWorkitemStatus = assignedWorkitemStatus; }

    public static VehicleWorkitemDTO toDTO(VehicleWorkitem vehicleWorkitem) {
        VehicleWorkitemDTO dto = new VehicleWorkitemDTO();
        dto.setAssignedWorkitemStatus(vehicleWorkitem.getAssignedWorkitemStatus());
        dto.setDriverId(vehicleWorkitem.getDriverId());
        dto.setVehicleNumber(vehicleWorkitem.getVehicleNumber());
        dto.setWorkitemId(vehicleWorkitem.getWorkitemId());
        return dto;
    }
}
