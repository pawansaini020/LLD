package com.pawan.LLD.lld.zoomcar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BookingStatus {
    INITIATED, SUCCESS, CAR_PICKED, CANCEL, FAILED, PENDING;
}
