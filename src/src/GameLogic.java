package src;

import java.util.HashMap;

public class GameLogic {

    private HashMap<String, Integer> stringLetterToNum = new HashMap<>();
    private HashMap<String, Integer> stringNumToNum = new HashMap<>();

    public GameLogic(){
        stringLetterToNum.put("A", 1);
        stringLetterToNum.put("B", 2);
        stringLetterToNum.put("C", 3);
        stringLetterToNum.put("D", 4);
        stringLetterToNum.put("E", 5);
        stringLetterToNum.put("F", 6);
        stringLetterToNum.put("G", 7);
        stringLetterToNum.put("H", 8);
        stringLetterToNum.put("I", 9);
        stringLetterToNum.put("J", 10);
        stringLetterToNum.put("K", 11);
        stringLetterToNum.put("L", 12);
        stringLetterToNum.put("a", 1);
        stringLetterToNum.put("b", 2);
        stringLetterToNum.put("c", 3);
        stringLetterToNum.put("d", 4);
        stringLetterToNum.put("e", 5);
        stringLetterToNum.put("f", 6);
        stringLetterToNum.put("g", 7);
        stringLetterToNum.put("h", 8);
        stringLetterToNum.put("i", 9);
        stringLetterToNum.put("j", 10);
        stringLetterToNum.put("k", 11);
        stringLetterToNum.put("l", 12);

        stringNumToNum.put("1", 1);
        stringNumToNum.put("2", 2);
        stringNumToNum.put("3", 3);
        stringNumToNum.put("4", 4);
        stringNumToNum.put("5", 5);
        stringNumToNum.put("6", 6);
        stringNumToNum.put("7", 7);
        stringNumToNum.put("8", 8);
        stringNumToNum.put("9", 9);
        stringNumToNum.put("10", 10);
        stringNumToNum.put("11", 11);
        stringNumToNum.put("12", 12);
    }

    public void autoShipPlacement(Grid grid, ShipManager ships){
        int[] randomStartPosition = new int[2];
        int orientation = ShipManager.horizontal;
        int random;
        for(Ship ship:ships.getShipList()){
            boolean validPlace = false;
            while(!validPlace) {
                randomStartPosition[0] = (int)(Math.random() * 12) + 1;
                randomStartPosition[1] = (int)(Math.random() * 12) + 1;
                random = (int) (Math.random() * 2) + 1;
                if (random == 1) {
                    orientation = ShipManager.horizontal;
                } else if (random == 2) {
                    orientation = ShipManager.vertical;
                }
                validPlace = ships.checkValidPlace(ship, grid, randomStartPosition, orientation);
            }
            ships.placeShip(ship, randomStartPosition, grid, orientation);
        }
    }

    public boolean playerShipPlacement(Grid grid, ShipManager ships, int[] inputLocation, Ship ship, int orientation) {
        boolean isNotPlaced = true;
        if(orientation == 0){
            isNotPlaced = true;
        }else if(ships.checkValidPlace(ship, grid, inputLocation, orientation)){
            ships.placeShip(ship, inputLocation, grid, orientation);
            isNotPlaced = false;
        }
        return isNotPlaced;
    }

    public void reset(Grid player1Grid, Grid player2Grid, ShipManager player1Ships, ShipManager player2Ships){
        player1Grid.resetBoard();
        player2Grid.resetBoard();
        player1Ships.resetShips();
        player2Ships.resetShips();
    }

    public int[] stringToCoordinates(String inputLocation){
        String letterCoordinate = "";
        if(!inputLocation.equals(null)){
            letterCoordinate = Character.toString(inputLocation.charAt(0));
        }
        String numberCoordinate = "";
        if(inputLocation.length() > 1){
            numberCoordinate = inputLocation.substring(1);
        }
        int[] startLocation = new int[2];
        startLocation[0] = letterToNum(letterCoordinate);
        startLocation[1] = numberToNumber(numberCoordinate);
        return startLocation;
    }

    private int letterToNum(String letterCoordinate){
        if(!letterCoordinate.equals("")) {
            return stringLetterToNum.get(letterCoordinate);
        } else {
            return 0;
        }
    }

    private int numberToNumber(String numberCoordinate){
        if(!numberCoordinate.equals("")) {
            return stringNumToNum.get(numberCoordinate);
        } else {
            return 0;
        }
    }


}
