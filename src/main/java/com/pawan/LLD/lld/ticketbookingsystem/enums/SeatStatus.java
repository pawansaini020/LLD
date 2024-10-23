package com.pawan.LLD.lld.ticketbookingsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum SeatStatus {
    AVAILABLE, BOOKED, TEMPORARY_BOOKED;
}
