package com.pawan.LLD.lld.zoomcar.manager;

import com.pawan.LLD.lld.zoomcar.dto.PaymentCatalogue;
import com.pawan.LLD.lld.zoomcar.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


@Component
@Slf4j
public class ZoomPaymentManager {

    public PaymentCatalogue makePayment(Double price) {
        return PaymentCatalogue.builder()
                .mode("Flipcart Credit Card")
                .amount(price)
                .paymentId(UUID.randomUUID().toString())
                .time(new Date())
                .status(PaymentStatus.FAILED.SUCCESS)
                .build();
    }
}
