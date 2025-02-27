package com.pawan.LLD.FitFlipKart;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Slf4j
public class FitnessCenterManager {

    private Map<String, FitnessCenter> centers;

    public FitnessCenterManager() {
        centers = new HashMap<>();
    }

    public void addCenter(String name, String location, List<String> closingDays, int numberOfSlot) {
        centers.put(name, new FitnessCenter(name, location, closingDays, numberOfSlot));
        log.info("Added new center : {}, {}, {}", name, location, numberOfSlot);
    }

    public void addWorkoutType(String centerName, WorkoutType workoutType) {
        FitnessCenter center = centers.get(centerName);
        center.addWorkoutType(workoutType);
        log.info("Added new workout type : {}, {}", centerName, workoutType);
    }

    public void addSlots(String centerName, WorkoutType workoutType, String time, int capacity) {
        FitnessCenter center = centers.get(centerName);
        center.addSlot(workoutType, time, capacity);
    }

    public void getAvailableSlots(String centerName, String date) {
        FitnessCenter center = centers.get(centerName);
        List<WorkoutSlot> slots = center.getAvailableSlots(date);
        for (WorkoutSlot slot : slots) {
            log.info(slot.getSlotId() + ", " + centerName + ", " + slot.getWorkoutType() + ", " + slot.getTime() + ", " + slot.getAvailableSeats(date));
        }
    }

    public FitnessCenter getCenter(String centerName) {
        return centers.get(centerName);
    }
}
