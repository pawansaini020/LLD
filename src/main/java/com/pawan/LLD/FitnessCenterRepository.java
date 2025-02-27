package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */

public class FitnessCenterRepository {

    private final Map<String, FitnessCenter> centers = new ConcurrentHashMap<>();

    public Optional<FitnessCenter> findByName(String name) {
        return Optional.of(centers.get(name));
    }

    // Thread-safe addCenter method
    public void addCenter(String centerName, String city, List<String> closedDays, int numberOfSlots) {
        centers.put(centerName, new FitnessCenter(centerName, city, closedDays, numberOfSlots));
    }

    public void addWorkOutType(String centerName, String workoutType) {
        FitnessCenter center = centers.get(centerName);
        WorkoutType type = WorkoutType.getWorkOutType(workoutType);
        if (center != null) {
            center.addWorkoutType(type);
        }
    }

    public void addSlots(String centerName, String workoutType, LocalTime startTime, int numberOfSeats) {
        FitnessCenter center = centers.get(centerName);
        WorkoutType type = WorkoutType.getWorkOutType(workoutType);
        if (center != null) {
            center.addWorkoutSlot(type, new Slot(UUID.randomUUID().toString(), startTime, numberOfSeats));
        }
    }

    public List<Slot> getAvailableSlots(String centerName, String date) {
        FitnessCenter center = centers.get(centerName);
        return center != null ? center.getAvailableSlots() : new ArrayList<>();
    }

    public List<FitnessCenter> getAllCenter() {
        List<FitnessCenter> fitnessCenters = new ArrayList<>();
        for(FitnessCenter value : (centers.values())) {
            fitnessCenters.add(value);
        }
        return fitnessCenters;
    }
}
