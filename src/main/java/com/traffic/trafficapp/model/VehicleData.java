package com.traffic.trafficapp.model;

import jakarta.persistence.*;

@Entity
public class VehicleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleId;
    private double speed;
    private String zone;
    private boolean emergency;

    private double fine;
    private String violationType;

    public Long getId() { return id; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public boolean isEmergency() { return emergency; }
    public void setEmergency(boolean emergency) { this.emergency = emergency; }

    public double getFine() { return fine; }
    public void setFine(double fine) { this.fine = fine; }

    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
}