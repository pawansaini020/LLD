package com.pawan.LLD.solidprinciple;

import org.springframework.stereotype.Service;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class LiskovSubstitutionPrinciple {

    //  traditional method
    public interface Bike {
        void turnOnEngine();
        void accelerate();
    }

    public class MotorCycle implements Bike {

        private boolean isEngineStarted;
        private double speed;

        @Override
        public void turnOnEngine() {
            isEngineStarted = true;
            System.out.println("Engine is started");
        }

        @Override
        public void accelerate() {
            speed = speed + 10;
        }
    }

    public class Bicycle implements Bike {

        @Override
        public void turnOnEngine() {
            throw new AssertionError("There is no engine");
            //  this is narrow downing the functionality
        }

        @Override
        public void accelerate() {
            System.out.println("accelerate the speed by force");
        }
    }
}
