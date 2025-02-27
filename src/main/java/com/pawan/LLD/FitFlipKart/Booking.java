package com.pawan.LLD.FitFlipKart;

public class Booking {
    private int slotId;
    private String centerName;
    private WorkoutType workoutType;
    private String time;
    private String date;

    public Booking(int slotId, String centerName, WorkoutType workoutType, String time, String date) {
        this.slotId = slotId;
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.time = time;
        this.date = date;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return slotId + ", " + centerName + ", " + workoutType + ", " + time;
    }
}

