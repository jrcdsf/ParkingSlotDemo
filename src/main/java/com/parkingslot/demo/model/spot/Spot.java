package com.parkingslot.demo.model.spot;

/*
 *
 * If you need more classes, simply define them inline.

 */
public abstract class Spot {
    private boolean free = true;

    public void takeSpot() {
        free = false;
    }

    public boolean isFree() {
        return free;
    }
}
