package com.pawan.LLD.lld.zoomcar.manager;

import com.pawan.LLD.lld.zoomcar.enums.VehicleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 21/08/24.
 */
@Slf4j
@Component
public class ZoomPriceManager {

    private ConcurrentHashMap<VehicleType, Double> basePriceData = new ConcurrentHashMap<>();

    public ZoomPriceManager() {
        basePriceData = new ConcurrentHashMap<>();
        basePriceData.put(VehicleType.HATCHBACK, 100.0);
        basePriceData.put(VehicleType.SUV, 100.0);
        basePriceData.put(VehicleType.SEDAN, 100.0);
        basePriceData.put(VehicleType.THREE_WHEELER, 100.0);
        basePriceData.put(VehicleType.TRUCK, 200.0);
        basePriceData.put(VehicleType.VAN, 100.0);
        basePriceData.put(VehicleType.MOTORCYCLE, 50.0);
        basePriceData.put(VehicleType.BICYCLE, 25.0);
        // Add other vehicle types and their corresponding base prices
    }

    public Double getBookingPrice(Long fromDate, Long toDate, VehicleType vehicleType) {
        Double basePrice = basePriceData.get(vehicleType);
        double totalDays = (double) (toDate - fromDate) / (1000 * 60 * 60 * 24);
        return basePrice * totalDays;
    }
}
