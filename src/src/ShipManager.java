package src;

import java.util.List;

public class ShipManager {

    private Ship[] shipList = new Ship[7];
    private Ship patrolBoat1 = new Ship("Patrol Boat", 2);
    private Ship patrolBoat2 = new Ship("Patrol Boat", 2);
    private Ship cruiser1 = new Ship("Cruiser", 3);
    private Ship cruiser2 = new Ship("Cruiser", 3);
    private Ship submarine = new Ship("Submarine", 3);
    private Ship battleship = new Ship("Battleship", 4);
    private Ship carrier = new Ship("Carrier", 5);

    public ShipManager(){
        shipList[0] = patrolBoat1;
        shipList[1] = patrolBoat2;
        shipList[2] = cruiser1;
        shipList[3] = cruiser2;
        shipList[4] = submarine;
        shipList[5] = battleship;
        shipList[6] = carrier;
    }

    public Ship[] getShipList() {
        return shipList;
    }

    public boolean checkValidPlace(Ship ship, Grid grid, int[] startLocation, String orientation){
        int i = startLocation[0];
        int j = startLocation[1];
        if(orientation.equalsIgnoreCase("vertical")){
            if((i + ship.getShipLength() - 1) >= grid.getShipBoard().length || i < 0){
                return false;
            } else {
                for (int a = i; a < i + ship.getShipLength(); a++){
                    if(grid.getShipBoard()[a][j] == 'S'){
                        return false;
                    }
                }
            }
        } else if(orientation.equalsIgnoreCase("horizontal")){
            if(j + ship.getShipLength() - 1 >= grid.getShipBoard().length || j < 0){
                return false;
            } else {
                for (int a = j; a < j + ship.getShipLength(); a++){
                    if(grid.getShipBoard()[i][a] == 'S'){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void placeShip(Ship ship, int[] startLocation, Grid grid, String orientation){
        if(checkValidPlace(ship, grid, startLocation, orientation)){
            ship.shipSetter(startLocation, orientation);
            grid.shipPlacement(ship);
        }
    }
}

