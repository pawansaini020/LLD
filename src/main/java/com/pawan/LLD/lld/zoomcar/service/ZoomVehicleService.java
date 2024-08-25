package com.pawan.LLD.lld.zoomcar.service;

import com.pawan.LLD.lld.zoomcar.dao.ZoomVehicleDao;
import com.pawan.LLD.lld.zoomcar.dto.VehicleDTO;
import com.pawan.LLD.lld.zoomcar.enums.VehicleType;
import com.pawan.LLD.lld.zoomcar.manager.ZoomBookingManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Slf4j
@Service
public class ZoomVehicleService {

    private final ZoomVehicleDao zoomVehicleDao;
    private final ZoomBookingManager zoomBookingManager;

    @Autowired
    public ZoomVehicleService(ZoomVehicleDao zoomVehicleDao,
                              ZoomBookingManager zoomBookingManager) {
        this.zoomVehicleDao = zoomVehicleDao;
        this.zoomBookingManager = zoomBookingManager;
    }

    public void addVehicle(VehicleDTO vehicleDTO) {
        zoomVehicleDao.addVehicle(vehicleDTO);
    }

    public void updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
        zoomVehicleDao.updateVehicle(vehicleId, vehicleDTO);
    }

    public void deleteVehicle(Long vehicleId) {
        zoomVehicleDao.deleteVehicle(vehicleId);
    }

    public List<VehicleDTO> searchVehicle(VehicleType vehicleType, String city, Long fromDate, Long toDate) {
        List<VehicleDTO> vehicleDTOList = zoomVehicleDao.findVehicleByVehicleType(vehicleType, city);
        return zoomBookingManager.filterVehicleBasedOnTime(vehicleDTOList, fromDate, toDate);
    }

    public VehicleDTO getVehicle(Long vehicleId) {
        return zoomVehicleDao.getVehicle(vehicleId);
    }
}
