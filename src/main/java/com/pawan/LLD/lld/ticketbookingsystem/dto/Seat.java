package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatStatus;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seat extends BaseDTO {

    private int number;
    private SeatType type;
    private SeatStatus status = SeatStatus.AVAILABLE;
}
