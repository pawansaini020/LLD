package com.pawan.LLD;

import com.pawan.LLD.dto.Slot;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Slf4j
public class BookingService {
     private final FitnessCenterRepository centerRepository;
    private final ExecutorService notificationExecutor = Executors.newFixedThreadPool(5);

    public BookingService(FitnessCenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public boolean bookSlot(String centerName, String userId, WorkoutType workoutType, LocalTime time) {
        Optional<FitnessCenter> centerOpt = centerRepository.findByName(centerName);
        if (centerOpt.isEmpty()) return false;

        FitnessCenter center = centerOpt.get();
        List<Slot> slots = center.getWorkoutSlots().get(workoutType);

        for (Slot slot : slots) {
            if (slot.getStartTime().equals(time) && slot.bookSlot(userId)) {
                return true;
            }
        }

        return slots.get(0).addToWaitlist(userId);
    }

    public void cancelSlot(String centerName, String userId, WorkoutType workoutType, LocalTime time) {
        Optional<FitnessCenter> centerOpt = centerRepository.findByName(centerName);
        if (centerOpt.isEmpty()) return;

        FitnessCenter center = centerOpt.get();
        List<Slot> slots = center.getWorkoutSlots().get(workoutType);

        for (Slot slot : slots) {
            if (slot.getStartTime().equals(time)) {
                slot.cancelSlot(userId);

                slot.promoteWaitlistedUser().ifPresent(waitlistedUser -> {
                    notificationExecutor.submit(() -> notifyUser(waitlistedUser));
                });

                return;
            }
        }
    }

    private void notifyUser(String userId) {
        System.out.println("Notifying user " + userId + " about slot availability.");
    }

    public List<Slot> viewUserBookings(String varun, String s) {
        List<Slot> slots = new ArrayList<>();
//        Optional<FitnessCenter> centerOpt = centerRepository.findByName(s);
//        if (centerOpt.isEmpty()) return false;
//
//        FitnessCenter center = centerOpt.get();
//        List<Slot> slots = center.getWorkoutSlots().get(workoutType);
//
//        for (Slot slot : slots) {
//            if (slot.getStartTime().equals(time) && slot.bookSlot(userId)) {
//                return true;
//            }
//        }
        return new ArrayList<>();
    }

    public List<Slot> getAvailableSlots(String bellandur, String s) {
        return new ArrayList<>();
    }
}
