package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
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
public class Show extends BaseDTO {

    private Movie movie;
    private Double price;
    private Date startTime;
    private Date endTime;
    private List<Seat> seatList;

    public void intSeats(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
