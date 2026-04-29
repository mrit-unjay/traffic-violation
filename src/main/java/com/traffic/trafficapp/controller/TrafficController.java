package com.traffic.trafficapp.controller;

import com.traffic.trafficapp.model.VehicleData;
import com.traffic.trafficapp.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api") 
@CrossOrigin(origins = "*")
public class TrafficController {

    @Autowired
    VehicleRepo repo;

    // ADD DATA
    @PostMapping("/add")
    public VehicleData add(@RequestBody VehicleData data) {

        if (data.isEmergency()) {
            data.setFine(0);
            data.setViolationType("Emergency");
        } else if (data.getSpeed() > 100) {
            data.setFine(2000);
            data.setViolationType("Severe");
        } else if (data.getSpeed() > 80) {
            data.setFine(1000);
            data.setViolationType("Overspeed");
        } else {
            data.setFine(0);
            data.setViolationType("Safe");
        }

        return repo.save(data);
    }

    // GET ALL
    @GetMapping("/all")
    public List<VehicleData> getAll() {
        return repo.findAll();
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Vehicle not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
    // STATS (FIXED UNDEFINED ISSUE)
    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        List<VehicleData> list = repo.findAll();

        int totalVehicles = list.size();

        int violations = (int) list.stream()
                .filter(v -> v.getFine() > 0)
                .count();

        double totalFine = list.stream()
                .mapToDouble(VehicleData::getFine)
                .sum();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalVehicles", totalVehicles);
        stats.put("violations", violations);
        stats.put("totalFine", totalFine);

        return stats;
    }

    // ZONE ANALYTICS
    @GetMapping("/zone-stats")
    public Map<String, Long> zoneStats() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(
                        VehicleData::getZone,
                        Collectors.counting()
                ));
    }
}