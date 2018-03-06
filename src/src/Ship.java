package src;

public class Ship {

    private int[] startLocation;
    private String orientation;
    private String shipType;
    private int shipLength;
    private boolean isDestroyed = false;

    public Ship(String shipType, int shipLength) {
        this.shipType = shipType;
        this.shipLength = shipLength;
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public String getShipType() {
        return shipType;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void shipSetter(int[] startLocation, String orientation){
        this.startLocation = startLocation;
        this.orientation = orientation;
    }

}
