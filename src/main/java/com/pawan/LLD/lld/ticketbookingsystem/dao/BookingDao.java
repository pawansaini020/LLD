package com.pawan.LLD.lld.ticketbookingsystem.dao;

import com.pawan.LLD.lld.ticketbookingsystem.dto.Booking;
import com.pawan.LLD.lld.ticketbookingsystem.dto.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 20/08/24.
 */
@Component
public class BookingDao {

    private ConcurrentHashMap<Long, List<Booking>> BOOKING_MAP = new ConcurrentHashMap<>();

    public void addBooking(Long userId, Booking booking) {
        if(BOOKING_MAP.get(userId) == null) {
            List<Booking> bookings = new ArrayList<>();
            BOOKING_MAP.put(userId, bookings);
        }
        BOOKING_MAP.get(userId).add(booking);
    }

    public List<Booking> getUserBooking(Long userId) {
        return BOOKING_MAP.get(userId);
    }
}
