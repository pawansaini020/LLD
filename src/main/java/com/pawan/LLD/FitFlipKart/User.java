package com.pawan.LLD.FitFlipKart;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String location;
    private List<Booking> bookings;

    public User(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(int slotId) {
        bookings.removeIf(b -> b.getSlotId() == slotId);
    }

    public List<Booking> getBookingsForDate(String date) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getDate().equals(date)) {
                userBookings.add(b);
            }
        }
        return userBookings;
    }
}

