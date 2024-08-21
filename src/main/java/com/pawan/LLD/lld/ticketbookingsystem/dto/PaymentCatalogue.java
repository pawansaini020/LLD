package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.ticketbookingsystem.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentCatalogue {

    private String mode;
    private Date updatedTime;
    private Double price;
    private String paymentId;
    private PaymentStatus status;
}
