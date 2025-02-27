package com.pawan.LLD.FitFlipKart;

import java.util.Arrays;

import java.util.Arrays;

public class FlipFitApp {
    public static void main(String[] args) {
        BookingService bookingService = BookingService.getInstance();

        // Adding a fitness center
        bookingService.addCenter("bellandur", "bangalore", Arrays.asList("Sunday","Monday"), 5);
        bookingService.addWorkoutType("bellandur", WorkoutType.WEIGHTS);
        bookingService.addWorkoutType("bellandur", WorkoutType.YOGA);
        bookingService.addSlots("bellandur", WorkoutType.WEIGHTS, "06:00", 2);
        bookingService.addSlots("bellandur", WorkoutType.YOGA, "08:00", 1);

        // Registering users
        bookingService.registerUser("Vivek", 16, "bangalore");
        bookingService.registerUser("Pavan", 20, "bangalore");
        bookingService.registerUser("Varun", 22, "bangalore");

        // Checking available slots on a specific date
        System.out.println("\n--- Available Slots on 28-05-2021 ---");
        bookingService.getAvailableSlots("bellandur", "28-05-2021");

        // Booking a slot
        System.out.println("\n--- Booking Slot ---");
        bookingService.bookSlot("bellandur", "Vivek", 1, "28-05-2021");

        // Viewing user bookings
        System.out.println("\n--- Vivek's Bookings on 28-05-2021 ---");
        bookingService.viewUserBookings("Vivek", "28-05-2021");

        // Cancel booking
        System.out.println("\n--- Cancelling Booking ---");
        bookingService.cancelSlot("bellandur", "Vivek", 1, "28-05-2021");

        // Viewing user bookings after cancellation
        System.out.println("\n--- Vivek's Bookings on 28-05-2021 (After Cancellation) ---");
        bookingService.viewUserBookings("Vivek", "28-05-2021");
    }
}

