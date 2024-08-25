package com.pawan.LLD.lld.zoomcar.manager;

import com.pawan.LLD.lld.zoomcar.dto.BookingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Component
@Slf4j
public class ZoomCommunicationManager {

    public void sendInvoice(BookingDTO bookingDTO) {
        log.info("Booking invoice sent successfully for: {}", bookingDTO);
    }
}
