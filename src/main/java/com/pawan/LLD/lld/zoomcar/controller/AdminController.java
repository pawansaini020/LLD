package com.pawan.LLD.lld.zoomcar.controller;

import com.pawan.LLD.lld.zoomcar.dto.VehicleDTO;
import com.pawan.LLD.lld.zoomcar.service.ZoomVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/zoom-car/api/v1/admin")
public class AdminController {

    private final ZoomVehicleService zoomVehicleService;

    @Autowired
    public AdminController(ZoomVehicleService zoomVehicleService) {
        this.zoomVehicleService = zoomVehicleService;
    }

    @PostMapping("/vehicle/add")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        zoomVehicleService.addVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/vehicle/update/{vehicle_id}")
    public ResponseEntity<?> updateVehicle(@PathVariable(value = "vehicle_id") Long vehicleId,
            @RequestBody VehicleDTO vehicleDTO) {
        zoomVehicleService.updateVehicle(vehicleId, vehicleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/vehicle/delete/{vehicle_id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable(value = "vehicle_id") Long vehicleId) {
        zoomVehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicle/get")
    public ResponseEntity<?> getVehicle(@RequestParam(value = "vehicle_id") Long vehicleId) {
        return new ResponseEntity<>(zoomVehicleService.getVehicle(vehicleId), HttpStatus.OK);
    }
}
