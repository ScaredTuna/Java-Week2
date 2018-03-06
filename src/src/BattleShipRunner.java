package src;

public class BattleShipRunner {

    public static void main(String[] args){

        Grid player1Grid = new Grid();
        ShipManager player1Ships = new ShipManager();
        int[] start = {1,1};
        String orientation = "Vertical";
        player1Ships.placeShip(player1Ships.getShipList()[0], start, player1Grid, orientation);
        orientation = "Horizontal";
        start[0] = 0;
        start[1] = 1;
        player1Ships.placeShip(player1Ships.getShipList()[1], start, player1Grid, orientation);
        for (int i = 0; i < player1Grid.getShipBoard().length; i++){
            for (int j = 0; j < player1Grid.getShipBoard().length; j++){
                System.out.print(player1Grid.getShipBoard()[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        Grid player2Grid = new Grid();
        ShipManager player2Ships = new ShipManager();
        int[] start2 = {1,2};
        String orientation2 = "Vertical";
        player2Ships.placeShip(player2Ships.getShipList()[0], start2, player2Grid, orientation2);
        orientation2 = "Horizontal";
        start2[0] = 0;
        start2[1] = 0;
        player2Ships.placeShip(player2Ships.getShipList()[1], start2, player2Grid, orientation2);
        for (int i = 0; i < player2Grid.getShipBoard().length; i++){
            for (int j = 0; j < player2Grid.getShipBoard().length; j++){
                System.out.print(player2Grid.getShipBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }
}


