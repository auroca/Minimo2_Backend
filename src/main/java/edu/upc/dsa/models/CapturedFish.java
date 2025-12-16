package edu.upc.dsa.models;

import java.sql.Timestamp;

public class CapturedFish {
    private int id;  // uuid¡
    private Fish fishSpecies;
    private double weight;
    private Timestamp captureTime;  // time of capture

    public CapturedFish() {
    }

    public CapturedFish(Fish fishSpecies, double weight, Timestamp captureTime) {
        this.id = 0;
        this.fishSpecies = fishSpecies;
        this.weight = weight;
        this.captureTime = captureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fish getFishSpecies() {
        return fishSpecies;
    }

    public void setFishId(Fish fishSpecies) {
        this.fishSpecies = fishSpecies;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Timestamp captureTime) {
        this.captureTime = captureTime;
    }
}
