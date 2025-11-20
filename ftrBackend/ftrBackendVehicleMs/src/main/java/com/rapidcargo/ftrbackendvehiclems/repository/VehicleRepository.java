package com.infosys.ftrbackendvehiclems.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.ftrbackendvehiclems.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    // fetchAvailableVehicles
    List<Vehicle> findByVehicleStatus(String vehicleStatus);

    // fetchVehicleDetailsByVehicleNumber
    Vehicle findByVehicleNumber(String vehicleNumber);

    // fetchVehicleDetailsByVehicleName
    List<Vehicle> findByVehicleName(String vehicleName);
}
