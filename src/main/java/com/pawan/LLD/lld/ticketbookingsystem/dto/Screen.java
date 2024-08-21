package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatStatus;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Screen extends BaseDTO {

    private String name;
    private Integer number;
    private List<Show> shows = new ArrayList<>();
    private List<Seat> seats = new ArrayList<>();

    public void addSeats(int seatCount) {
        for(int i=0; i<seatCount; i++) {
            this.seats.add(Seat.builder()
                    .type(SeatType.SILVER)
                            .status(SeatStatus.AVAILABLE)
                    .number(seats.size() + 1).build());
        }
        log.info("Added {} {} seats in screen {}", seatCount, SeatType.SILVER, name);
    }

    public void addShow(Show show) {
        this.shows.add(show);
        show.intSeats(new ArrayList<>(this.seats));
        log.info("Added new show for movie: {}, price: {}, from: {} to: {} at screen {}", show.getMovie().getName(), show.getPrice(), show.getStartTime(), show.getEndTime(), this.name);
    }
}
