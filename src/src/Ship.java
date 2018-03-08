package src;

public class Ship {

    private int[] startLocation;
    private int orientation;
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

    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void shipSetter(int[] startLocation, int orientation){
        this.startLocation = startLocation;
        this.orientation = orientation;
    }

}
