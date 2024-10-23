package com.pawan.LLD.lld.ticketbookingsystem.controller;

import com.pawan.LLD.lld.ticketbookingsystem.dto.Theater;
import com.pawan.LLD.lld.ticketbookingsystem.service.BookingService;
import com.pawan.LLD.lld.ticketbookingsystem.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping(value = "/booking")
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/add")
    public void booking() {
        bookingService.bookShowForUser("Pawan", 1L, Arrays.asList(1,2,3,4,5), 1L);
    }

    @GetMapping("/get/{user_id}")
    public ResponseEntity<?> getBooking(@PathVariable(value = "user_id") Long userId) {
        return new ResponseEntity<>(bookingService.getUserBooking(userId), HttpStatus.OK);
    }
}
