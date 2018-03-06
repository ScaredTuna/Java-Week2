package src;

public class Grid {

    private char[][] shipBoard = new char[12][12];


    public Grid(){
        for(int i = 0; i < shipBoard.length; i++){
            for(int j = 0; j < shipBoard.length; j++){
                shipBoard[i][j] = '-';
            }
        }
    }


    public char[][] getShipBoard() {
        return shipBoard;
    }

    public void shipPlacement(Ship ship){
        if(ship.getOrientation().equalsIgnoreCase("vertical")){
            for(int i = ship.getStartLocation()[0]; i < ship.getStartLocation()[0] + ship.getShipLength(); i++){
                    shipBoard[i][ship.getStartLocation()[1]] = 'S';
            }
        } else if(ship.getOrientation().equalsIgnoreCase("horizontal")){
            for(int i = ship.getStartLocation()[1]; i < ship.getStartLocation()[1] + ship.getShipLength(); i++){
                shipBoard[ship.getStartLocation()[0]][i] = 'S';
            }
        }
    }
}
