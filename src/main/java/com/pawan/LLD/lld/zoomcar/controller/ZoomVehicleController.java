package com.pawan.LLD.lld.zoomcar.controller;

import com.pawan.LLD.lld.zoomcar.enums.VehicleType;
import com.pawan.LLD.lld.zoomcar.service.ZoomVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Slf4j
@RestController
@RequestMapping(value = "/zoom-car/api/v1/vehicle")
public class ZoomVehicleController {

    private final ZoomVehicleService zoomVehicleService;

    @Autowired
    private ZoomVehicleController(ZoomVehicleService zoomVehicleService) {
        this.zoomVehicleService = zoomVehicleService;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> searchVehicle(@RequestParam(value = "type", required = false) VehicleType vehicleType,
                                           @RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "from_date", required = false) Long fromDate,
                                           @RequestParam(value = "to_date", required = false) Long toDate) {
        return new ResponseEntity<>(zoomVehicleService.searchVehicle(vehicleType,city,fromDate,toDate), HttpStatus.OK);
    }
}
