package com.pawan.LLD.lld.ticketbookingsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Getter
@AllArgsConstructor
public enum SeatStatus {
    AVAILABLE, BOOKED, TEMPORARY_BOOKED;
}
