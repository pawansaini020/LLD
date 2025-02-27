package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;
import lombok.Data;

import java.util.ArrayList;
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

    private final String name;
    private final String city;
    private int numberOfSlots;
    private List<String> closedDays;
    private final Map<WorkoutType, List<Slot>> workoutSlots;

    public FitnessCenter(String name, String city, List<String> closedDays, int numberOfSlots) {
        this.name = name;
        this.city = city;
        this.closedDays = closedDays;
        this.numberOfSlots = numberOfSlots;
        this.workoutSlots = new ConcurrentHashMap<>();
    }

    public void addWorkoutSlot(WorkoutType workoutType, Slot slot) {
        workoutSlots.computeIfAbsent(workoutType, k -> new CopyOnWriteArrayList<>()).add(slot);
    }

    public void addWorkoutType(WorkoutType workoutType) {
        if(!workoutSlots.containsKey(workoutType)) {
            workoutSlots.put(workoutType, new ArrayList<>());
        }
    }

    public List<Slot> getAvailableSlots() {
        List<Slot> availableslots = new ArrayList<>();
        for(List<Slot> slot : workoutSlots.values()) {
            availableslots.addAll(slot);
        }
        return availableslots;
    }
}
