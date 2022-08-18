package com.parkingslot.demo.model;


import com.parkingslot.demo.model.spot.CarSpot;
import com.parkingslot.demo.model.spot.LargeSpot;
import com.parkingslot.demo.model.spot.MotorcycleSpot;
import com.parkingslot.demo.model.spot.Spot;
import com.parkingslot.demo.model.vehicle.Car;
import com.parkingslot.demo.model.vehicle.Motorcycle;
import com.parkingslot.demo.model.vehicle.Vehicle;

import java.util.List;


public class ParkingSlot {

    private final List<Spot> spots;

    public ParkingSlot(List<Spot> initialSpots) {
        this.spots = initialSpots;
    }

    public void park(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) {
            Spot spot = this.spots.stream().filter(Spot::isFree).findFirst().orElse(null);
            if (spot != null) {
                spot.takeSpot();
            } else throw new RuntimeException("Unable to park " + vehicle);
        }

        if (vehicle instanceof Car) {
            Spot spot = this.spots.stream().filter(sp -> sp instanceof CarSpot || sp instanceof LargeSpot).findFirst().orElse(null);
            if (spot != null) {
                spot.takeSpot();
            } else throw new RuntimeException("Unable to park " + vehicle);
        }

        if (vehicle instanceof Car) {
            Spot spot = this.spots.stream().filter(sp -> sp instanceof LargeSpot).findFirst().orElse(null);
            if (spot != null) {
                spot.takeSpot();
            } else throw new RuntimeException("Unable to park " + vehicle);
        }
    }

    public int getAvailableSpots() {
        return (int) this.spots.stream().filter(Spot::isFree).count();
    }

    public int getTotalSpots() {
        return this.spots.size();
    }

    public boolean isFull() {
        return (int) this.spots.stream().filter(Spot::isFree).count() == 0;
    }

    public boolean areMotorcycleSpotsAvailable() {
        return this.spots.stream().anyMatch(spot -> spot instanceof MotorcycleSpot && spot.isFree());
    }

    public boolean areCarSpotsAvailable() {
        return this.spots.stream().anyMatch(spot -> spot instanceof CarSpot && spot.isFree());
    }

    public boolean areLargeSpotsAvailable() {
        return this.spots.stream().anyMatch(spot -> spot instanceof LargeSpot && spot.isFree());
    }

    public int getAvailableSpotByType(Spot spot) {
        return (int) this.spots.stream().filter(sp -> sp.getClass() == spot.getClass() && sp.isFree()).count();
    }
}
