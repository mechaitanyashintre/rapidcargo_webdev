package com.infosys.ftrbackendworkitemms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("FTRBACKENDVEHICLEMS")
public interface VehicleMsFeign {
    @PutMapping("/vehicles/updateVehicleStatus/{vehicleNumber}")
    void updateVehicleStatus(@PathVariable String vehicleNumber);

    @GetMapping("/vehicles/checkHarborLoc/{vehicleNumber}/{selectedHarborLocation}")
    boolean checkHarborLoc(@PathVariable String vehicleNumber, @PathVariable String selectedHarborLocation);
}
