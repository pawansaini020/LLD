package com.pawan.LLD.lld.zoomcar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.zoomcar.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentCatalogue {

    private String paymentId;
    private String mode;
    private Date time;
    private Double amount;
    private PaymentStatus status;
}
