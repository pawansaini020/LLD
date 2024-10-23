package com.pawan.LLD.lld.zoomcar.manager;

import com.pawan.LLD.lld.zoomcar.dto.BookingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ZoomCommunicationManager {

    public void sendInvoice(BookingDTO bookingDTO) {
        log.info("Booking invoice sent successfully for: {}", bookingDTO);
    }
}
