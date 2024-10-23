package com.pawan.LLD.lld.ticketbookingsystem.service;

import com.pawan.LLD.lld.ticketbookingsystem.dao.ShowDao;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Movie;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Screen;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Show;
import com.pawan.LLD.lld.ticketbookingsystem.dto.Theater;
import com.pawan.LLD.lld.ticketbookingsystem.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class TheaterService {

    private final BookingService bookingService;
    private final ShowDao showDao;

    @Autowired
    public TheaterService(BookingService bookingService,
                          ShowDao showDao) {
        this.bookingService = bookingService;
        this.showDao = showDao;
    }

    public Theater init() {
        Theater theater = createTheater("HSR Club", "HSR");
        Show show = addShow(theater, 1, "Maharaja", 100d, 150L, new Date());
        return theater;
    }

    public Theater createTheater(String name, String location) {
        // init a new theater
        Theater theater = Theater.builder()
                .name(name)
                .location(location)
                .rating(5.0)
                .screens(new ArrayList<>())
                .build();
        log.info("Added a theater with name: {} at: {}", name, location);
        Screen screen = Screen.builder().name("Golden Hall")
                .shows(new ArrayList<>())
                .seats(new ArrayList<>()).build();
        theater.addScreen(Arrays.asList(screen));
        screen.addSeats(100);
        return theater;
    }

    public Show addShow(Theater theater, Integer screenNumber, String movieName, Double price, Long duration, Date releaseDate) {
        Movie movie = Movie.builder()
                .name(movieName)
                .releaseDate(releaseDate)
                .duration(duration)
                .build();
        Show show = Show.builder()
                .id(1L)
                .movie(movie)
                .price(price)
                .startTime(new Date())
                .endTime(new Date(new Date().getTime() + duration * 60 * 1000L))
                .build();
        theater.getScreens().get(screenNumber -1).addShow(show);
        showDao.addShow(show.getId(), show);
        return show;
    }
}
