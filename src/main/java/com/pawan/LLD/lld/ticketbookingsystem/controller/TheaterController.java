package com.pawan.LLD.lld.ticketbookingsystem.controller;

import com.pawan.LLD.lld.ticketbookingsystem.dto.Theater;
import com.pawan.LLD.lld.ticketbookingsystem.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping(value = "/theater")
@Slf4j
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    public void addTheater() {
        Theater theater = theaterService.init();
    }
}
