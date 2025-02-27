package com.pawan.LLD;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
public enum WorkoutType {
    WEIGHTS, CARDIO, YOGA, SWIMMING;

    public static WorkoutType getWorkOutType(String type) {
        return WorkoutType.valueOf(type.toUpperCase());
    }
}
