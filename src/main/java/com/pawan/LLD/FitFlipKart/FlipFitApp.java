package com.pawan.LLD.FitFlipKart;

import java.util.Arrays;

public class FlipFitApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        FitnessCenterManager fitnessCenterManager = new FitnessCenterManager();
        BookingManager bookingManager = new BookingManager();
        WaitlistNotifier notifier = new WaitlistNotifier();
        BookingService bookingService = new BookingService(userManager, fitnessCenterManager, bookingManager, notifier);

        // Adding a fitness center
        fitnessCenterManager.addCenter("bellandur", "bangalore", Arrays.asList("monday","sunday"), 5);
        fitnessCenterManager.addWorkoutType("bellandur", WorkoutType.WEIGHTS);
        fitnessCenterManager.addWorkoutType("bellandur", WorkoutType.CARDIO);
        fitnessCenterManager.addWorkoutType("bellandur", WorkoutType.YOGA);
        fitnessCenterManager.addSlots("bellandur", WorkoutType.WEIGHTS, "06:00", 2);
        fitnessCenterManager.addSlots("bellandur", WorkoutType.YOGA, "08:00", 1);

        // Registering users
        userManager.registerUser("Vivek", 16, "bangalore");
        userManager.registerUser("Pavan", 20, "bangalore");
        userManager.registerUser("Varun", 22, "bangalore");

        // Checking available slots on a specific date
        System.out.println("\n--- Available Slots on 28-05-2021 ---");
        fitnessCenterManager.getAvailableSlots("bellandur", "28-05-2021");

        // Booking a slot
        System.out.println("\n--- Booking Slot ---");
        bookingService.bookSlot("bellandur", "Vivek", 1, "28-05-2021");

        // Viewing user bookings
        System.out.println("\n--- Vivek's Bookings on 28-05-2021 ---");
        bookingService.viewUserBookings("Vivek", "28-05-2021");

        // Cancel booking
        System.out.println("\n--- Cancelling Booking ---");
        bookingService.cancelSlotBooking("bellandur", "Vivek", 1, "28-05-2021");

        // Viewing user bookings after cancellation
        System.out.println("\n--- Vivek's Bookings on 28-05-2021 (After Cancellation) ---");
        bookingService.viewUserBookings("Vivek", "28-05-2021");

        System.out.println("\n--- Booking Slot ---");
        bookingService.bookSlot("bellandur", "Vivek", 1, "28-05-2021");

        bookingService.bookSlot("bellandur", "Pavan", 1, "28-05-2021");
        bookingService.bookSlot("bellandur", "Vivek", 1, "28-05-2021");

        bookingService.cancelSlotBooking("bellandur", "Pavan", 1, "28-05-2021");
    }
}

