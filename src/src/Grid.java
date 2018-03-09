package src;

public class Grid {

    private String[][] shipBoard = new String[13][13];
    private final String[] letters = {"A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J ", "K ", "L "};
    private final String[] numbers = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "11", "12"};
    public static final String shipIcon = " S";
    public static final String hitIcon = " X";
    public static final String missIcon = " o";
    public static final String emptyIcon = " -";


    public Grid(){
        createBoard();
    }


    public String[][] getShipBoard() {
        return shipBoard;
    }

    public void shipPlacement(Ship ship){
        if(ship.getOrientation() == ShipManager.vertical){
            for(int i = ship.getStartLocation()[0]; i < ship.getStartLocation()[0] + ship.getShipLength(); i++){
                    shipBoard[i][ship.getStartLocation()[1]] = shipIcon;
            }
        } else if(ship.getOrientation() == ShipManager.horizontal){
            for(int i = ship.getStartLocation()[1]; i < ship.getStartLocation()[1] + ship.getShipLength(); i++){
                shipBoard[ship.getStartLocation()[0]][i] = shipIcon;
            }
        }
    }

    public void printFullBoard(){
        for (int i = 0; i < shipBoard.length; i++){
            for (int j = 0; j < shipBoard.length; j++){
                System.out.print(shipBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printTargetBoard(){
        for (int i = 0; i < shipBoard.length; i++){
            for (int j = 0; j < shipBoard.length; j++){
                if(shipBoard[i][j].equals(shipIcon)){
                    System.out.println(emptyIcon);
                }else {
                    System.out.print(shipBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void resetBoard(){
        shipBoard = new String[13][13];
        createBoard();
    }

    public void createBoard(){
        shipBoard[0][0] = "   ";
        for(int i = 1; i < shipBoard.length; i++){
            for(int j = 1; j < shipBoard.length; j++){
                shipBoard[i][j] = emptyIcon;
            }
            shipBoard[0][i] = numbers[i - 1];
            shipBoard[i][0] = letters[i - 1];
        }
    }

    public boolean checkShotInvalid(int[] shotLocation){
        return false;
    }
}
