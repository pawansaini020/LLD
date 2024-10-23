package com.pawan.LLD.lld.ticketbookingsystem.dao;

import com.pawan.LLD.lld.ticketbookingsystem.dto.Seat;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Show;
import com.pawan.LLD.lld.ticketbookingsystem.enums.SeatStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Component
@Slf4j
public class ShowDao {

    private ConcurrentHashMap<Long, Show> SEAT_MAP = new ConcurrentHashMap<>();

    public void addShow(Long showId, Show show) {
        SEAT_MAP.put(showId, show);
    }

    public Show getShow(Long showId) {
        return SEAT_MAP.get(showId);
    }

    public List<Seat> getAvailableSeats(Show show) {
        return SEAT_MAP.get(show.getId()).getSeatList().stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public boolean bookSeats(List<Seat> seats) {
        for(Seat seat : seats) {
            if(seat.getStatus() != SeatStatus.TEMPORARY_BOOKED) {
                return false;
            }
        }

        for(Seat seat : seats) {
            seat.setStatus(SeatStatus.BOOKED);
        }
        return true;
    }

    public void blockSeats(List<Seat> seats, Show show) {
        for(Seat seat : seats) {
            blockSeat(seat, show);
        }
    }

    public void blockSeat(Seat seat, Show show) {
        seat.setStatus(SeatStatus.TEMPORARY_BOOKED);
        log.info("Seat {} is blocked for show: {}, from: {}, to: {}", seat.getNumber(), show.getMovie().getName(), show.getStartTime(), show.getEndTime());
    }
}
