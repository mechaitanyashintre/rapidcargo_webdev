// WorkitemApi.java
package com.rapidcargo.ftrbackendworkitemms.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rapidcargo.ftrbackendworkitemms.dto.VehicleDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.VehicleWorkitemDTO;
import com.rapidcargo.ftrbackendworkitemms.dto.WorkitemDTO;
import com.rapidcargo.ftrbackendworkitemms.exception.WorkitemException;
import com.rapidcargo.ftrbackendworkitemms.service.WotkitemService;

@RestController
@RequestMapping(value = "workitems")
public class WorkitemApi {

    @Autowired
    private WotkitemService workitemService;

    @PostMapping
    public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody WorkitemDTO newWorkitem) throws WorkitemException {
        return new ResponseEntity<>(workitemService.createlorkitem(newWorkitem), HttpStatus.OK);
    }

    @GetMapping("/{fromCountry}")
    public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String fromCountry) throws WorkitemException {
        return new ResponseEntity<>(workitemService.fetchAvailableHarborLocations(fromCountry), HttpStatus.OK);
    }

    @PutMapping("/{workitemId}")
    public ResponseEntity<String> updateWorkItem(@PathVariable String workitemId, @RequestBody WorkitemDTO workitemDTO) throws WorkitemException {
        return new ResponseEntity<>(workitemService.updateWorkitemId(workitemId, workitemDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails() throws WorkitemException {
        return new ResponseEntity<>(workitemService.fetchWorkItemDetails(), HttpStatus.OK);
    }

    @GetMapping("/managed-user/{userId}")
    public ResponseEntity<List<VehicleWorkitemDTO>> trackWorkitemByUser(@PathVariable Integer userId) throws WorkitemException {
        return new ResponseEntity<>(workitemService.trackWorkitemByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/managed-vehicle/{workitemId}")
    public ResponseEntity<String> allocateVehicle(@PathVariable String workitemId, @RequestBody VehicleDTO vehicleDTO) throws WorkitemException {
        return new ResponseEntity<>(workitemService.allocateVehicle(workitemId, vehicleDTO), HttpStatus.OK);
    }

    @GetMapping("/managed-status/{workitemId}")
    public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemStatus(@PathVariable String workitemId) throws WorkitemException {
        return new ResponseEntity<>(workitemService.fetchWorkItemStatus(workitemId), HttpStatus.OK);
    }

    @PutMapping("/managed-update/{workitemId}")
    public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workitemId) throws WorkitemException {
        String temp = workitemService.updateWorkItemStatus(workitemId);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/managed-vehicle/{vehicleNumber}")
    public ResponseEntity<VehicleWorkitemDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws WorkitemException {
        return new ResponseEntity<>(workitemService.fetchWorkItemDetailsByVehicleNumber(vehicleNumber), HttpStatus.OK);
    }

    @PostMapping("/managed-terminal/{workitemId}")
    public ResponseEntity<String> assignTerminalForWorkitem(@PathVariable String workitemId) throws WorkitemException {
        return new ResponseEntity<>(workitemService.assignTerminalForWorkitem(workitemId), HttpStatus.OK);
    }
}
