package com.pawan.LLD.lld.zoomcar.dao;

import com.pawan.LLD.lld.zoomcar.dto.VehicleDTO;
import com.pawan.LLD.lld.zoomcar.enums.VehicleStatus;
import com.pawan.LLD.lld.zoomcar.enums.VehicleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Slf4j
public class ZoomVehicleDao {

    private ConcurrentHashMap<Long, VehicleDTO> vehicleData = new ConcurrentHashMap<>();

    public void addVehicle(VehicleDTO vehicleDTO) {
        if(vehicleData.contains(vehicleDTO.getRegistrationNumber())) {
            throw new RuntimeException("Vehicle already exist.");
        }
        vehicleData.put(vehicleDTO.getId(), vehicleDTO);
    }

    public void updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
        if(!vehicleData.containsKey(vehicleId)) {
            throw new RuntimeException("Vehicle is not exist in system.");
        }
        vehicleData.put(vehicleId, vehicleDTO);
    }

    public VehicleDTO getVehicle(Long vehicleId) {
        return vehicleData.get(vehicleId);
    }

    public VehicleDTO getVehicleById(Long id) {
        return vehicleData.values().stream()
                .filter(vehicleDTO -> vehicleDTO.getId() == id).findAny().orElse(null);
    }

    public void deleteVehicle(Long vehicleId) {
        if(!vehicleData.contains(vehicleId)) {
            throw new RuntimeException("Vehicle is not exist in system.");
        }
        vehicleData.remove(vehicleId);
    }

    public List<VehicleDTO> findVehicleByVehicleType(VehicleType vehicleType, String city) {
        if(vehicleType!=null && city!=null) {
            return vehicleData.values().stream()
                    .filter(vehicleDTO -> vehicleType == vehicleDTO.getType())
                    .filter(vehicleDTO -> city.equals(vehicleDTO.getCity()))
                    .toList();
        } else if (vehicleType!=null) {
            return vehicleData.values().stream()
                    .filter(vehicleDTO -> vehicleType == vehicleDTO.getType())
                    .toList();
        } else if (city!=null) {
            return vehicleData.values().stream()
                    .filter(vehicleDTO -> city.equals(vehicleDTO.getCity()))
                    .toList();
        }
        return vehicleData.values().stream()
                .toList();
    }

    public List<VehicleDTO> findAllAvailableVehicle() {
        return vehicleData.values().stream()
                .filter(vehicleDTO -> VehicleStatus.AVAILABLE == vehicleDTO.getStatus())
                .toList();
    }
}
