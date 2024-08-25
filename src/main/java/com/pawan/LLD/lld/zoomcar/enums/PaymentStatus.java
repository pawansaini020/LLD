package com.pawan.LLD.lld.zoomcar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Getter
@AllArgsConstructor
public enum PaymentStatus {
    SUCCESS, FAILED, PENDING, INITIATED;
}
