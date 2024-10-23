package com.pawan.LLD.lld.zoomcar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.zoomcar.enums.VehicleStatus;
import com.pawan.LLD.lld.zoomcar.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO extends BaseDTO {

    private Long ownerId;
    private String name;
    private String registrationNumber;
    private VehicleType type;
    private String city;
    private VehicleStatus status;
}
