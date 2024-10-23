package com.pawan.LLD.lld.zoomcar.service;

import com.pawan.LLD.lld.zoomcar.dao.ZoomVehicleDao;
import com.pawan.LLD.lld.zoomcar.dto.BookingDTO;
import com.pawan.LLD.lld.zoomcar.dto.VehicleDTO;
import com.pawan.LLD.lld.zoomcar.enums.BookingStatus;
import com.pawan.LLD.lld.zoomcar.manager.ZoomBookingManager;
import com.pawan.LLD.lld.zoomcar.manager.ZoomCommunicationManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class ZoomBookingService {

    private final ZoomVehicleDao zoomVehicleDao;
    private final ZoomBookingManager zoomBookingManager;
    private final ZoomCommunicationManager zoomCommunicationManager;

    @Autowired
    public ZoomBookingService(ZoomVehicleDao zoomVehicleDao,
                              ZoomBookingManager zoomBookingManager,
                              ZoomCommunicationManager zoomCommunicationManager) {
        this.zoomVehicleDao = zoomVehicleDao;
        this.zoomBookingManager = zoomBookingManager;
        this.zoomCommunicationManager = zoomCommunicationManager;
    }

    public BookingDTO createBooking(Long userId, Long fromDate, Long toDate, Long vehicleId) {
        VehicleDTO vehicleDTO = zoomVehicleDao.getVehicleById(vehicleId);
        if(vehicleDTO == null) {
            throw new RuntimeException("Vehicle is not exist in system.");
        }
        return zoomBookingManager.bookingVehicle(userId, fromDate, toDate, vehicleDTO);
    }

    public BookingDTO updateBooking(Long vehicleId, Long bookingId, BookingStatus bookingStatus) {
        BookingDTO bookingDTO = zoomBookingManager.updateBooking(vehicleId, bookingId, bookingStatus);
        if(BookingStatus.SUCCESS == bookingStatus) {
            zoomCommunicationManager.sendInvoice(bookingDTO);
        }
        return bookingDTO;
    }

    public BookingDTO cancelBooking(Long vehicleId, Long bookingId) {
        return zoomBookingManager.updateBooking(vehicleId, bookingId, BookingStatus.CANCEL);
    }

    public List<BookingDTO> getBookings(Long vehicleId) {
        return zoomBookingManager.getBookings(vehicleId);
    }
}
