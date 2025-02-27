package com.pawan.LLD.FitFlipKart;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

import java.util.*;

@Slf4j
public class FitnessCenter {
    private String name;
    private String location;
    private Set<String> closingDays;
    private int numberOfSlot;
    private Map<WorkoutType, List<WorkoutSlot>> slots;

    public FitnessCenter(String name, String location, List<String> closingDays, int numberOfSlot) {
        this.name = name;
        this.location = location;
        this.closingDays = new HashSet<>(closingDays);
        this.numberOfSlot = numberOfSlot;
        this.slots = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getClosingDays() {
        return closingDays;
    }

    public void addWorkoutType(WorkoutType workoutType) {
        slots.putIfAbsent(workoutType, new ArrayList<>());
    }

    public void addSlot(WorkoutType workoutType, String time, int capacity) {
        if (!slots.containsKey(workoutType)) {
            log.info("Workout type not added for this center yet!");
            return;
        }
        if(slots.get(workoutType).size() == numberOfSlot) {
            log.info("All slots are full, we can't add new slow");
            return;
        }
        slots.get(workoutType).add(new WorkoutSlot(workoutType, time, capacity));
        log.info("Added new slot : {}, {}, {}, {}", name, workoutType, time, capacity);
    }

    public List<WorkoutSlot> getAvailableSlots(String date) {
        List<WorkoutSlot> availableSlots = new ArrayList<>();
        for (List<WorkoutSlot> slotList : slots.values()) {
            for (WorkoutSlot slot : slotList) {
                if (slot.getAvailableSeats(date) > 0) {
                    availableSlots.add(slot);
                }
            }
        }
        return availableSlots;
    }

    public WorkoutSlot getSlotById(int slotId) {
        for (List<WorkoutSlot> slotList : slots.values()) {
            for (WorkoutSlot slot : slotList) {
                if (slot.getSlotId() == slotId) {
                    return slot;
                }
            }
        }
        return null;
    }
}
