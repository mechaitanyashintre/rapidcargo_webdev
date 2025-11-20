package com.infosys.ftrbackendworkitemms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.ftrbackendworkitemms.entity.VehicleWorkitem;

public interface VehicleWorkitemRepository extends JpaRepository<VehicleWorkitem, String> {
    Optional<VehicleWorkitem> findByVehicleNumber(String vehicleNumber);
}
