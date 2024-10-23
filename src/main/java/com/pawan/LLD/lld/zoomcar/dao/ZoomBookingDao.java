package com.pawan.LLD.lld.zoomcar.dao;

import com.pawan.LLD.lld.zoomcar.dto.BookingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Slf4j
public class ZoomBookingDao {

    private ConcurrentHashMap<Long, List<BookingDTO>> bookingData = new ConcurrentHashMap<>();

    public void save(BookingDTO bookingDTO) {
        bookingData.computeIfAbsent(bookingDTO.getVehicleId(), k -> new ArrayList<>());
        bookingData.get(bookingDTO.getVehicleId()).add(bookingDTO);
    }

    public List<BookingDTO> getBookingByVehicleId(Long vehicleId) {
        return bookingData.get(vehicleId);
    }

    public BookingDTO getBookingByBookingId(Long vehicleId, Long bookingId) {
        return bookingData.get(vehicleId).stream().filter(bookingDTO -> bookingDTO.getId() == bookingId).toList().getFirst();
    }

    public List<BookingDTO> getBookingByVehicleIdAndTime(Long vehicleId, Long fromDate) {
        if(bookingData.get(vehicleId)!=null) {
            return bookingData.get(vehicleId).stream()
                    .filter(bookingDTO -> bookingDTO.getFromDate() <= fromDate)
                    .filter(bookingDTO -> bookingDTO.getToDate() >= fromDate)
                    .toList();
        }
        return new ArrayList<>();
    }
}
