package com.infosys.ftrbackendworkitemms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.ftrbackendworkitemms.dto.VehicleDTO;
import com.infosys.ftrbackendworkitemms.dto.VehicleWorkitemDTO;
import com.infosys.ftrbackendworkitemms.dto.WorkitemDTO;
import com.infosys.ftrbackendworkitemms.exception.WorkitemException;

@Service
public interface WotkitemService {

    // Create WorkItem
    WorkitemDTO createWorkitem(WorkitemDTO workitemDto) throws WorkitemException;

    // Fetch available harbor locations for a country
    List<String> fetchAvailableHarborLocations(String country) throws WorkitemException;

    // Update WorkItem harbor and shipping info
    String updateWorkitemId(String workitemId, WorkitemDTO workitemDTO) throws WorkitemException;

    // Fetch all WorkItem details
    List<WorkitemDTO> fetchWorkItemDetails() throws WorkitemException;

    // Track WorkItem by user
    List<VehicleWorkitemDTO> trackWorkitemByUser(Integer userId) throws WorkitemException;

    // Allocate vehicle to WorkItem
    String allocateVehicle(String workitemId, VehicleDTO vehicleDTO) throws WorkitemException;

    // Fetch WorkItem status
    VehicleWorkitemDTO fetchWorkItemStatus(String workitemId) throws WorkitemException;

    // Update WorkItem status (mark completed)
    String updateWorkItemStatus(String workitemId) throws WorkitemException;

    // Fetch WorkItem details by vehicle number
    VehicleWorkitemDTO fetchWorkItemDetailsByVehicleNumber(String vehicleNumber) throws WorkitemException;

    // Assign terminal for WorkItem
    String assignTerminalForWorkitem(String workitemId);
}
