package com.pawan.LLD.lld.zoomcar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Getter
@AllArgsConstructor
public enum BookingStatus {
    INITIATED, SUCCESS, CAR_PICKED, CANCEL, FAILED, PENDING;
}
