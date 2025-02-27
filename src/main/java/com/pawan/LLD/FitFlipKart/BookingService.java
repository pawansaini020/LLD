package com.pawan.LLD.FitFlipKart;

import java.util.*;

public class BookingService {
    private static BookingService instance;
    private Map<String, FitnessCenter> centers;
    private Map<String, User> users;

    private BookingService() {
        this.centers = new HashMap<>();
        this.users = new HashMap<>();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public void addCenter(String name, String location, List<String> closingDays, int openDays) {
        centers.put(name, new FitnessCenter(name, location, closingDays, openDays));
    }

    public void addWorkoutType(String centerName, WorkoutType workoutType) {
        centers.get(centerName).addWorkoutType(workoutType);
    }

    public void addSlots(String centerName, WorkoutType workoutType, String time, int capacity) {
        centers.get(centerName).addSlot(workoutType, time, capacity);
    }

    public void registerUser(String name, int age, String location) {
        users.put(name, new User(name, age, location));
    }

    public void getAvailableSlots(String centerName, String date) {
        List<WorkoutSlot> slots = centers.get(centerName).getAvailableSlots(date);
        for (WorkoutSlot slot : slots) {
            System.out.println(slot.getSlotId() + ", " + centerName + ", " + slot.getWorkoutType() + ", " + slot.getTime() + ", " + slot.getAvailableSeats(date));
        }
    }

    public void bookSlot(String centerName, String userName, int slotId, String date) {
        User user = users.get(userName);
        WorkoutSlot slot = centers.get(centerName).getSlotById(slotId);

        if (slot != null && slot.bookSeat(date)) {
            user.addBooking(new Booking(slot.getSlotId(), centerName, slot.getWorkoutType(), slot.getTime(), date));
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed!");
        }
    }

    public void cancelSlot(String centerName, String userName, int slotId, String date) {
        users.get(userName).removeBooking(slotId);
        centers.get(centerName).getSlotById(slotId).cancelSeat(date);
        System.out.println("Booking cancelled successfully.");
    }

    public void viewUserBookings(String userName, String date) {
        List<Booking> bookings = users.get(userName).getBookingsForDate(date);
        if (bookings.isEmpty()) {
            System.out.println("No booking for the date");
        } else {
            bookings.forEach(System.out::println);
        }
    }
}
