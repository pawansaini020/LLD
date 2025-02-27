package com.pawan.LLD.FitFlipKart;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BookingService {
    private UserManager userManager;
    private FitnessCenterManager fitnessCenterManager;
    private BookingManager bookingManager;
    private WaitlistNotifier notifier;

    public BookingService(UserManager userManager,
                          FitnessCenterManager fitnessCenterManager,
                          BookingManager bookingManager,
                          WaitlistNotifier notifier) {
        this.userManager = userManager;
        this.fitnessCenterManager = fitnessCenterManager;
        this.bookingManager = bookingManager;
        this.notifier = notifier;
    }

    public void bookSlot(String centerName, String userName, int slotId, String date) {
        User user = userManager.getUser(userName);
        FitnessCenter center = fitnessCenterManager.getCenter(centerName);
        WorkoutSlot slot = center.getSlotById(slotId);

        if (slot != null && bookingManager.bookSeat(slot, date)) {
            user.addBooking(new Booking(slot.getSlotId(), centerName, slot.getWorkoutType(), slot.getTime(), date));
            log.info("Booking successful!");
        } else {
            log.info("Booking failed!");
            notifier.addToWaitlist(slotId, user);
        }
    }

    public void cancelSlotBooking(String centerName, String userName, int slotId, String date) {
        userManager.getUser(userName).removeBooking(slotId);
        WorkoutSlot slot = fitnessCenterManager.getCenter(centerName).getSlotById(slotId);
        bookingManager.cancelSeat(slot,  date);
        notifier.notifyUsers(slotId);
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
