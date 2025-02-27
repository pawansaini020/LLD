package com.pawan.LLD.FitFlipKart;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
public class BookingManager {

    public synchronized boolean bookSeat(WorkoutSlot slot, String date) {
        int seats = slot.getAvailableSeatsPerDate().getOrDefault(date, slot.getTotalSeats());
        if (seats > 0) {
            slot.getAvailableSeatsPerDate().put(date, seats - 1);
            return true;
        }
        return false;
    }

    public synchronized void cancelSeat(WorkoutSlot slot, String date) {
        int seats = slot.getAvailableSeatsPerDate().getOrDefault(date, slot.getTotalSeats());
        if (seats < slot.getTotalSeats()) {
            slot.getAvailableSeatsPerDate().put(date, seats + 1);
        }
    }
}
