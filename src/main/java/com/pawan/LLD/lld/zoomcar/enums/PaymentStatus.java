package com.pawan.LLD.lld.zoomcar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PaymentStatus {
    SUCCESS, FAILED, PENDING, INITIATED;
}
