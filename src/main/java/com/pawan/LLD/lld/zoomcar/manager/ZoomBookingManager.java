package com.pawan.LLD.lld.zoomcar.manager;

import com.pawan.LLD.lld.zoomcar.dao.ZoomBookingDao;
import com.pawan.LLD.lld.zoomcar.dto.BookingDTO;
import com.pawan.LLD.lld.zoomcar.dto.PaymentCatalogue;
import com.pawan.LLD.lld.zoomcar.dto.VehicleDTO;
import com.pawan.LLD.lld.zoomcar.enums.BookingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Component
@Slf4j
public class ZoomBookingManager {

    private ZoomBookingDao zoomBookingDao;
    private ZoomPriceManager zoomPriceManager;
    private ZoomPaymentManager zoomPaymentManager;

    @Autowired
    public ZoomBookingManager(ZoomBookingDao zoomBookingDao,
                              ZoomPriceManager zoomPriceManager,
                              ZoomPaymentManager zoomPaymentManager) {
        this.zoomBookingDao = zoomBookingDao;
        this.zoomPriceManager = zoomPriceManager;
        this.zoomPaymentManager = zoomPaymentManager;
    }

    public BookingDTO bookingVehicle(Long userId, Long fromDate, Long toDate, VehicleDTO vehicleDTO) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setUserId(userId);
        bookingDTO.setVehicleId(vehicleDTO.getId());
        bookingDTO.setFromDate(fromDate);
        bookingDTO.setToDate(toDate);
        bookingDTO.setPrice(zoomPriceManager.getBookingPrice(fromDate, toDate, vehicleDTO.getType()));
        PaymentCatalogue paymentCatalogue = zoomPaymentManager.makePayment(bookingDTO.getPrice());
        bookingDTO.getPaymentCatalogues().add(paymentCatalogue);
        zoomBookingDao.save(bookingDTO);
        return bookingDTO;
    }

    public BookingDTO updateBooking(Long vehicleId, Long bookingId, BookingStatus bookingStatus) {
        BookingDTO bookingDTO = zoomBookingDao.getBookingByBookingId(vehicleId, bookingId);
        if(bookingDTO == null) {
            throw new RuntimeException("Booking is not exist in system.");
        }
        bookingDTO.setStatus(bookingStatus);
        zoomBookingDao.save(bookingDTO);
        return bookingDTO;
    }

    public List<VehicleDTO> filterVehicleBasedOnTime(List<VehicleDTO> vehicleDTOList, Long fromDate, Long toDate) {
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(VehicleDTO vehicleDTO : vehicleDTOList) {
            if(!zoomBookingDao.getBookingByVehicleIdAndTime(vehicleDTO.getId(), fromDate).isEmpty()) {
                continue;
            }
            if(!zoomBookingDao.getBookingByVehicleIdAndTime(vehicleDTO.getId(), toDate).isEmpty()) {
                continue;
            }
            vehicleDTOS.add(vehicleDTO);
        }
        return vehicleDTOS;
    }

    public List<BookingDTO> getBookings(Long vehicleId) {
        return zoomBookingDao.getBookingByVehicleId(vehicleId);
    }
}
