package com.pawan.LLD.soldprinciple;

import lombok.Getter;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class OpenClosedPrinciple {

//    Module should be open for extension but closed for modification

    class Vehicle {

        @Getter
        int number;
    }

    class Car extends Vehicle {

    }

    class Bike extends Vehicle {

    }

    public class VehicleInfo {
        public double vehicleNumber(Vehicle vcl) {
            if (vcl instanceof Car) {
                return vcl.getNumber();
            }
            if (vcl instanceof Bike) {
                return vcl.getNumber();
            }
            return 0;
        }
    }

    public class Truck extends VehicleInfo {
        @Getter
        int value;
        public double vehicleNumber() {
            return this.getValue();
        }
    }
    public class Car1 extends Truck {

        public double vehicleNumber() {
            return this.getValue();
        }
    }
}
