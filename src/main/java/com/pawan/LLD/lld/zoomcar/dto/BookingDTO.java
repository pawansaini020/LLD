package com.pawan.LLD.lld.zoomcar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.zoomcar.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO extends BaseDTO {

    private Long userId;
    private Long vehicleId;
    private Long fromDate;
    private Long toDate;
    private Double price;
    private BookingStatus status = BookingStatus.INITIATED;
    private List<PaymentCatalogue> paymentCatalogues = new ArrayList<>();
}
