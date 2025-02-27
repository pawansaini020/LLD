package com.pawan.LLD.FitFlipKart;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkoutSlot {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private int slotId;
    private WorkoutType workoutType;
    private String time;
    private int totalSeats;
    private Map<String, Integer> availableSeatsPerDate; // Tracks available seats by date

    public WorkoutSlot(WorkoutType workoutType, String time, int totalSeats) {
        this.slotId = ID_GENERATOR.getAndIncrement();
        this.workoutType = workoutType;
        this.time = time;
        this.totalSeats = totalSeats;
        this.availableSeatsPerDate = new HashMap<>();
    }

    public int getSlotId() {
        return slotId;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public String getTime() {
        return time;
    }

    public int getAvailableSeats(String date) {
        return availableSeatsPerDate.getOrDefault(date, totalSeats);
    }

    public synchronized boolean bookSeat(String date) {
        int seats = availableSeatsPerDate.getOrDefault(date, totalSeats);
        if (seats > 0) {
            availableSeatsPerDate.put(date, seats - 1);
            return true;
        }
        return false;
    }

    public synchronized void cancelSeat(String date) {
        int seats = availableSeatsPerDate.getOrDefault(date, totalSeats);
        if (seats < totalSeats) {
            availableSeatsPerDate.put(date, seats + 1);
        }
    }
}
