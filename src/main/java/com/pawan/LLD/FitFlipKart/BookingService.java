package com.pawan.LLD.FitFlipKart;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BookingService {
    private UserManager userManager;
    private Map<String, FitnessCenter> centers;


    public BookingService(UserManager userManager) {
        this.userManager = userManager;
        this.centers = new HashMap<>();
    }

    public void addCenter(String name, String location, List<String> closingDays, int numberOfSlot) {
        centers.put(name, new FitnessCenter(name, location, closingDays, numberOfSlot));
        log.info("Added new center : {}, {}, {}", name, location, numberOfSlot);
    }

    public void addWorkoutType(String centerName, WorkoutType workoutType) {
        centers.get(centerName).addWorkoutType(workoutType);
        log.info("Added new workout type : {}, {}", centerName, workoutType);
    }

    public void addSlots(String centerName, WorkoutType workoutType, String time, int capacity) {
        centers.get(centerName).addSlot(workoutType, time, capacity);
    }

    public void getAvailableSlots(String centerName, String date) {
        List<WorkoutSlot> slots = centers.get(centerName).getAvailableSlots(date);
        for (WorkoutSlot slot : slots) {
            log.info(slot.getSlotId() + ", " + centerName + ", " + slot.getWorkoutType() + ", " + slot.getTime() + ", " + slot.getAvailableSeats(date));
        }
    }

    public void bookSlot(String centerName, String userName, int slotId, String date) {
        User user = userManager.getUser(userName);
        WorkoutSlot slot = centers.get(centerName).getSlotById(slotId);

        if (slot != null && slot.bookSeat(date)) {
            user.addBooking(new Booking(slot.getSlotId(), centerName, slot.getWorkoutType(), slot.getTime(), date));
            log.info("Booking successful!");
        } else {
            log.info("Booking failed!");
        }
    }

    public void cancelSlot(String centerName, String userName, int slotId, String date) {
        userManager.getUser(userName).removeBooking(slotId);
        centers.get(centerName).getSlotById(slotId).cancelSeat(date);
        log.info("Booking cancelled successfully.");
    }

    public void viewUserBookings(String userName, String date) {
        List<Booking> bookings = userManager.getUser(userName).getBookingsForDate(date);
        if (bookings.isEmpty()) {
            log.info("No booking for the date");
        } else {
            bookings.forEach(System.out::println);
        }
    }
}
