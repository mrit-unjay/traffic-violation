package com.traffic.trafficapp.repo;

import com.traffic.trafficapp.model.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<VehicleData, Long> {
}