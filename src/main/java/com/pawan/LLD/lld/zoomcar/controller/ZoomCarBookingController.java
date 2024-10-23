package com.pawan.LLD.lld.zoomcar.controller;

import com.pawan.LLD.lld.zoomcar.enums.BookingStatus;
import com.pawan.LLD.lld.zoomcar.service.ZoomBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Slf4j
@RestController
@RequestMapping(value = "/zoom-car/api/v1/booking")
public class ZoomCarBookingController {

    private final ZoomBookingService zoomBookingService;

    @Autowired
    private ZoomCarBookingController(ZoomBookingService zoomBookingService) {
        this.zoomBookingService = zoomBookingService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getBooking(@RequestParam(value = "vehicle_id") Long vehicleId) {
        return new ResponseEntity<>(zoomBookingService.getBookings(vehicleId), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createBooking(@RequestParam(value = "user_id") Long userId,
                                           @RequestParam(value = "from_date") Long fromDate,
                                           @RequestParam(value = "to_date") Long toDate,
                                           @RequestParam(value = "vehicle_id") Long vehicleId) {
        return new ResponseEntity<>(zoomBookingService.createBooking(userId, fromDate, toDate, vehicleId), HttpStatus.OK);
    }

    @PutMapping (value = "/update")
    public ResponseEntity<?> updateBooking(@RequestParam(value = "booking_id") Long bookingId,
                                           @RequestParam(value = "vehicle_id") Long vehicleId,
                                           @RequestParam(value = "booking_status") BookingStatus bookingStatus) {
        return new ResponseEntity<>(zoomBookingService.updateBooking(vehicleId, bookingId, bookingStatus), HttpStatus.OK);
    }

    @DeleteMapping(value = "/cancel")
    public ResponseEntity<?> updateBooking(@RequestParam(value = "booking_id") Long bookingId,
                                           @RequestParam(value = "vehicle_id") Long vehicleId) {
        return new ResponseEntity<>(zoomBookingService.cancelBooking(vehicleId, bookingId), HttpStatus.OK);
    }
}
