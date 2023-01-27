package disc06.ParkingLot;

public class Car {
    private boolean isCompact;
    private boolean isHandicapped;
    public Car(boolean isCompact, boolean isHandicapped) {
        this.isCompact = isCompact;
        this.isHandicapped = isHandicapped;
    }
    /**
     *  returns whether or not a car can fit in a compact space.
     * */
    public boolean isCompact() {
        return isCompact;
    }
    /**
     * returns whether or not a car may park in a handicapped space.
     * */
    public boolean isHandicapped() {
        return isHandicapped;
    }
    /**
     * attempts to park this car in a spot, returning true if successful.
     * */
    // TODO: park the car
/*    public boolean Park() {
        return findSpotAndPark(this);
    }*/
    // TODO: leave the parking lot.
    /*public void leaveSpot() {

    }*/


}