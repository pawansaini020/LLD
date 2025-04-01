package com.pawan.LLD.interview;

import com.pawan.LLD.lld.zoomcar1.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Zupee {

    public class Stop {
        int time;
        int passengers;
        int boardingTime;
    }

    static int maxBoardedPassenger = 0;
    static List<Integer> optimalResult = new ArrayList<>();

    public static final void main(String[] args) {
        int n = 10;
        Stop[] stops = new Stop[n];
        int[] stoppageDuration = new int[n];
        List<Integer> result = new ArrayList<>();
        passengerPickAlgo(stops, stoppageDuration, 0, stops[0].time, result, 0, 30);
    }

    public static void passengerPickAlgo(Stop[] stops, int[] stoppageDuration, int i, int time, List<Integer> result, int boardedPassenger, int capacity) {
        if(boardedPassenger>=capacity) {
            maxBoardedPassenger = capacity;
            if(optimalResult.isEmpty() || optimalResult.size() > result.size()) {
                optimalResult = new ArrayList<>(result);
            }
        }
        if(i==stops.length) {
            if(optimalResult.isEmpty() || optimalResult.size() > result.size()) {
                optimalResult = new ArrayList<>(result);
            }
            return;
        }

        if(time == stops[i].time) {
            result.add(i);
            passengerPickAlgo(stops, stoppageDuration, i + 1, time+stops[i].boardingTime+stoppageDuration[i], result, boardedPassenger+stops[i].passengers, capacity);
            result.remove(result.size()-1);
        }
        passengerPickAlgo(stops, stoppageDuration, i + 1, time+stoppageDuration[i], result, boardedPassenger, capacity);
    }
}
