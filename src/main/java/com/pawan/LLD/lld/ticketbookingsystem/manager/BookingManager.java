package com.pawan.LLD.lld.ticketbookingsystem.manager;

import com.pawan.LLD.lld.ticketbookingsystem.dao.ShowDao;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Booking;
import com.pawan.LLD.lld.ticketbookingsystem.dto.PaymentCatalogue;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Seat;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Show;
import com.pawan.LLD.lld.ticketbookingsystem.dto.User;
import com.pawan.LLD.lld.ticketbookingsystem.enums.BookingStatus;
import com.pawan.LLD.lld.ticketbookingsystem.enums.PaymentStatus;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@Slf4j
@Component
public class BookingManager {

    private final ShowDao showDao;

    @Autowired
    public BookingManager(ShowDao showDao) {
        this.showDao = showDao;
    }

    public boolean eligibleToBookSeats(List<Seat> availableSeats, List<Integer> bookSeats) {
        for(Integer seatNo : bookSeats) {
            if(availableSeats.get(seatNo-1).getStatus() != SeatStatus.AVAILABLE) {
                log.info("User is not eligable to booking seat due to seat: {}, unavailable with status : {}", seatNo, availableSeats.get(seatNo-1).getStatus());
                return false;
            }
        }
        return true;
    }

    public List<Seat> blockSeats(List<Seat> availableSeats, List<Integer> bookSeats, Show show) {
        List<Seat> blockedSeats = new ArrayList<>();
        for(Integer seatNo : bookSeats) {
            Seat seat = availableSeats.get(seatNo-1);
            showDao.blockSeat(seat, show);
            blockedSeats.add(seat);
        }
        return blockedSeats;
    }

    public Booking bookSeats(User user, List<Seat> blockedSeats, double price, Show show, PaymentCatalogue paymentCatalogue) {
        Booking.BookingBuilder bookingBuilder = Booking.builder()
                .id(new Random().nextLong(0, 100))
                .user(user)
                .showId(show.getId())
                .price(price)
                .seats(blockedSeats)
                .payment(Collections.singletonList(paymentCatalogue))
                .status(BookingStatus.PENDING);
        if(paymentCatalogue != null && paymentCatalogue.getStatus() == PaymentStatus.SUCCESS) {
            bookingBuilder.status(BookingStatus.SUCCESS);
        }
        showDao.bookSeats(blockedSeats);
        return bookingBuilder.build();
    }
}
