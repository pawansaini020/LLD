package com.pawan.LLD.lld.ticketbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 12/08/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie extends BaseDTO {

    private String name;
    private String Description;
    private Long duration; //minutes
    private Date releaseDate; //minutes
    private Double rating;
}
