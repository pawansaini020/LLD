package com.pawan.LLD.dto;

import com.pawan.LLD.WorkoutType;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Data
class FitnessCenter {
    private final String centerId;
    private final String name;
    private final String city;
    private final Map<WorkoutType, List<Slot>> workoutSlots;

    public FitnessCenter(String centerId, String name, String city) {
        this.centerId = centerId;
        this.name = name;
        this.city = city;
        this.workoutSlots = new ConcurrentHashMap<>();
    }

    public void addWorkoutSlot(WorkoutType workoutType, Slot slot) {
        workoutSlots.computeIfAbsent(workoutType, k -> new CopyOnWriteArrayList<>()).add(slot);
    }
}
