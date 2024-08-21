package com.pawan.LLD.lld.ticketbookingsystem.service;

import com.pawan.LLD.lld.ticketbookingsystem.dao.BookingDao;
import com.pawan.LLD.lld.ticketbookingsystem.dao.ShowDao;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Booking;
import com.pawan.LLD.lld.ticketbookingsystem.dto.PaymentCatalogue;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Seat;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Show;
import com.pawan.LLD.lld.ticketbookingsystem.dto.User;
import com.pawan.LLD.lld.ticketbookingsystem.manager.BookingManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Service
@Slf4j
public class BookingService {

    private final ShowDao showDao;
    private final BookingDao bookingDao;
    private final BookingManager bookingManager;
    private final PaymentService paymentService;

    @Autowired
    public BookingService(ShowDao showDao,
                          BookingManager bookingManager,
                          PaymentService paymentService,
                          BookingDao bookingDao) {
        this.showDao = showDao;
        this.bookingManager = bookingManager;
        this.paymentService = paymentService;
        this.bookingDao = bookingDao;
    }

    public void bookShowForUser(String name, Long id, List<Integer> seats, Long showId) {
        User user = User.builder()
                .id(id).name(name)
                .age(25)
                .build();
        if(user == null) {
            throw new RuntimeException("User Not Found.");
        }

        Show show = showDao.getShow(showId);
        if(show == null) {
            throw new RuntimeException("Show Not Found.");
        }
        bookSeat(user, seats, show);
    }

    public Booking bookSeat(User user, List<Integer> bookSeats, Show show) {
        List<Seat> availableSeats = showDao.getAvailableSeats(show);
        log.info("below seats are available: {}", availableSeats);

        Booking booking = null;
        if(bookingManager.eligibleToBookSeats(availableSeats, bookSeats)) {
            List<Seat> blockedSeats = bookingManager.blockSeats(availableSeats, bookSeats, show);
            double price = getPrice(blockedSeats, show);
            PaymentCatalogue paymentCatalogue = paymentService.makePayment(price, blockedSeats, show);
            booking = bookingManager.bookSeats(user, blockedSeats, price, show, paymentCatalogue);
            bookingDao.addBooking(user.getId(), booking);
            log.info("Seat booked with: {}, {}, {}, {}", show.getMovie().getName(), booking.getPrice(), booking.getStatus(), blockedSeats);
        }
        return booking;
    }

    private double getPrice(List<Seat> blockedSeats, Show show) {
        double price = 0;
        for(Seat seat : blockedSeats) {
            switch (seat.getType()) {
                case DIAMOND -> price += show.getPrice() * 3;
                case GOLD -> price += show.getPrice() * 2;
                case SILVER -> price += show.getPrice() * 1;
            }
        }
        return price;
    }

    public List<Booking> getUserBooking(Long userId) {
        List<Booking> bookings = bookingDao.getUserBooking(userId);
        log.info("User has these bookings: {}", bookings);
        return bookings;
    }
}
