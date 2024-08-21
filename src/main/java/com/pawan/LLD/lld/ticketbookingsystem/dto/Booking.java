package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.ticketbookingsystem.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking extends BaseDTO {

    private User user;
    private Long showId;
    private Double price;
    private List<Seat> seats;
    private List<PaymentCatalogue> payment;
    private BookingStatus status;
}
