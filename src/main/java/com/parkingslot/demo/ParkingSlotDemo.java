package com.parkingslot.demo;

import com.parkingslot.demo.model.ParkingSlot;
import com.parkingslot.demo.model.spot.CarSpot;
import com.parkingslot.demo.model.spot.LargeSpot;
import com.parkingslot.demo.model.spot.MotorcycleSpot;
import com.parkingslot.demo.model.spot.Spot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class ParkingSlotDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        List<Spot> initialSpotLayout = new ArrayList<>(Arrays.asList(
                new CarSpot(),
                new CarSpot(),
                new MotorcycleSpot(),
                new LargeSpot()
        ));
        ParkingSlot parkingSlot = new ParkingSlot(initialSpotLayout);
    }
}
