package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Theater extends BaseDTO {

    private String name;
    private String location;
    private Double rating;
    private List<Screen> screens = new ArrayList<>();

    public void addScreen(List<Screen> screens) {
        for(Screen screen : screens) {
            screen.setNumber(this.screens.size()+1);
            this.screens.add(screen);
            log.info("Added a screen with name: {} number: {}", screen.getName(), screen.getNumber());
        }
    }
}
