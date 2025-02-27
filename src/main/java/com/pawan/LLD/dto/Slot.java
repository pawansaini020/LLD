package com.pawan.LLD.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Data
public class Slot {
    private final String slotId;
    private final LocalTime startTime;
    private final int capacity;
    private final AtomicInteger bookedSeats;
    private final Queue<String> waitlist;  // User IDs in waiting list

    public Slot(String slotId, LocalTime startTime, int capacity) {
        this.slotId = slotId;
        this.startTime = startTime;
        this.capacity = capacity;
        this.bookedSeats = new AtomicInteger(0);
        this.waitlist = new ConcurrentLinkedQueue<>();
    }

    public boolean bookSlot(String userId) {
        if (bookedSeats.get() < capacity) {
            bookedSeats.incrementAndGet();
            return true;
        }
        return false;
    }

    public void cancelSlot(String userId) {
        if (bookedSeats.get() > 0) {
            bookedSeats.decrementAndGet();
        }
    }

    public boolean addToWaitlist(String userId) {
        return waitlist.offer(userId);
    }

    public Optional<String> promoteWaitlistedUser() {
        return Optional.ofNullable(waitlist.poll());
    }
}
