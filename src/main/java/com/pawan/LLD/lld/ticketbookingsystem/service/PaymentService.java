package com.pawan.LLD.lld.ticketbookingsystem.service;

import com.pawan.LLD.lld.ticketbookingsystem.dto.PaymentCatalogue;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Seat;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Show;
import com.pawan.LLD.lld.ticketbookingsystem.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class PaymentService {

    public PaymentCatalogue makePayment(double price, List<Seat> blockedSeats, Show show) {
        PaymentCatalogue.PaymentCatalogueBuilder paymentCatalogue = PaymentCatalogue.builder();
        try {
            paymentCatalogue.price(price)
                    .mode("PhonePe")
                    .status(PaymentStatus.INITIATED)
                    .updatedTime(new Date()).build();
            String paymentId = payPayment(price);
            if (paymentId != null) {
                paymentCatalogue.paymentId(paymentId)
                        .status(PaymentStatus.SUCCESS);
            } else {
                paymentCatalogue.status(PaymentStatus.SUCCESS);
            }
        } catch (Exception e) {
            log.error("Error while making payment: {}, {}", show.getId(), blockedSeats, e);
        }
        return paymentCatalogue.build();
    }

    private String payPayment(double price) {
        String paymentId = UUID.randomUUID().toString();
        log.info("Payment make for price: {}, {}", price, paymentId);
        return paymentId;
    }
}
