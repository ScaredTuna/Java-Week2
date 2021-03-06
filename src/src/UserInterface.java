package src;

import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private Grid player1Grid = new Grid();
    private Grid player2Grid = new Grid();
    private ShipManager player1Ships = new ShipManager();
    private ShipManager player2Ships = new ShipManager();
    private GameLogic game = new GameLogic();
    private boolean gameContinue = true;
    private final int play1 = 1;
    private final int play2 = 2;
    private final int rules = 3;
    private final int quit = 4;
    private final String yes = "y";
    private final String no = "n";

    public void startGame(){
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("Welcome to BattleShips");
        System.out.println();
        int input = 0;
        while(input != quit){
            input = menu();
            if(input == play1){
                game1Player();
            } else if(input == play2){
                game2Player();
            } else if(input == rules){
                showRules();
            }
        }
        System.out.println("Thank you for Playing");
    }

    private int menu(){
        System.out.println("-----------------------------------------------");
        System.out.println("1. 1 Player\n2. 2 Players\n3. Rules\n4. Quit");
        boolean invalidChoice = true;
        int output = 0;
        while(invalidChoice) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("1 player") || input.equals("1")) {
                invalidChoice = false;
                 output = play1;
            } else if (input.equalsIgnoreCase("2 players") || input.equals("2")) {
                invalidChoice = false;
                output = play2;
            } else if (input.equalsIgnoreCase("rules") || input.equals("3")) {
                invalidChoice = false;
                output = rules;
            } else if (input.equalsIgnoreCase("quit") || input.equals("4")) {
                invalidChoice = false;
                output = quit;
            } else {
                System.out.println("-----------------------------------------------");
                System.out.println("Invalid Selection. Please enter an entry on the list or it's number");
            }
        }
        return output;
    }

    private void game1Player(){
        System.out.println("-----------------------------------------------");
        System.out.println("Computer not yet implemented");
    }

    private void game2Player(){
        System.out.println("-----------------------------------------------");
        System.out.println("PLAYER 1 SHIP PLACEMENT");
        shipPlacement(player1Grid, player1Ships);
        System.out.println("-----------------------------------------------");
        System.out.println("PLAYER 2 SHIP PLACEMENT");
        shipPlacement(player2Grid, player2Ships);
        while(gameContinue) {
            System.out.println("-----------------------------------------------");
            System.out.println("PLAYER 1's TURN");
            playerShot(player2Grid, player2Ships);
        }
        game.reset(player1Grid, player2Grid, player1Ships, player2Ships);
        System.out.println("-----------------------------------------------");
        System.out.println("Press enter to return to menu");
        String wait = sc.nextLine();
    }

    private void showRules(){
        System.out.println("-----------------------------------------------");
        System.out.println("In the game of BattleShips, each player has 7 ships that must be placed horizontally\n" +
                "or vertically on a 12 x 12 grid. These ships include:\n\n2 x Patrol Boats of length 2\n2 x Cruisers" +
                " of length 3\n1 x Submarine of length 3\n1 x Battleship of length 4\n1 x Carrier of length 5\n\n" +
                "The players will then take turns picking a location on the opponents grid to shoot. If that location\n" +
                "holds a ship, they score a hit and take another shot. If not then they miss and it is the other\n" +
                "players turn. A ship is sunk if it is hit on all its grid locations. The game continues until one\n" +
                "player has sunk all of an opponents ships.");
        System.out.println("\nPress enter to return to menu");
        String wait = sc.nextLine();
    }

    private void shipPlacement(Grid grid, ShipManager ships){
        String input = "";
        boolean invalidInput = true;
        System.out.println("-----------------------------------------------");
        while(invalidInput) {
            System.out.println("Do you want to automatically place ships (y/n)?");
            input = sc.nextLine();
            if(input.equalsIgnoreCase("y")){
                input = yes;
                invalidInput = false;
            } else if(input.equalsIgnoreCase("n")){
                input = no;
                invalidInput = false;
            }else{
                System.out.println("-----------------------------------------------");
                System.out.println("Invalid input. Please enter y for yes or n for no");
            }
        }
        if(input.equals(yes)){
            game.autoShipPlacement(grid, ships);
        } else{
            for(Ship ship:ships.getShipList()) {
                boolean shipNotPlaced = true;
                int[] inputStartLocation = new int[2];
                int orientation = ShipManager.horizontal;
                grid.printFullBoard();
                while (shipNotPlaced) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Please enter the starting grid coordinates for: " + ship.getShipType() + "\nLength: " + ship.getShipLength());
                    input = sc.nextLine();
                    inputStartLocation = game.stringToCoordinates(input);
                    if(inputStartLocation[0] == 0 || inputStartLocation[1] == 0){
                        System.out.println("Invalid location. Please enter a valid grid coordinate (Letter then number eg A5)");
                        continue;
                    }
                    System.out.println("Please enter an orientation for the ship (horizontal/vertical):");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("horizontal") || input.equalsIgnoreCase("h")){
                        orientation = ShipManager.horizontal;
                    } else if(input.equalsIgnoreCase("vertical") || input.equalsIgnoreCase("v")){
                        orientation = ShipManager.vertical;
                    } else{
                        orientation = 0;
                    }
                    shipNotPlaced = game.playerShipPlacement(grid, ships, inputStartLocation, ship, orientation);
                    if(shipNotPlaced){
                        System.out.println("-----------------------------------------------");
                        System.out.println("Invalid location. Please enter a valid grid coordinate (Letter then number eg A5)\n" +
                                "and valid orientation (horizontal, vertical or h/v) that do not overlap another\n" +
                                "ship/edge of board. Ships are placed horizontally to the right, or vertically\ndownwards from this point");
                    }
                }
            }
        }
        System.out.println("-----------------------------------------------");
        System.out.println("If you want to view current ship placement then enter board. Otherwise press enter");
        input = sc.nextLine();
        if(input.equalsIgnoreCase("board") || input.equalsIgnoreCase("b")) {
            grid.printFullBoard();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Ship placement complete. Press enter to continue");
        input = sc.nextLine();
    }

    private void playerShot(Grid playerGrid, ShipManager playerShips){
        boolean invalidShot = true;
        String input = "";
        int[] shotLocation = new int[2];
        while(invalidShot){
            System.out.println("-----------------------------------------------");
            playerGrid.printTargetBoard();
            System.out.println();
            System.out.println("Please enter a coordinate to fire at (eg A4)");
            input = sc.nextLine();
            shotLocation = game.stringToCoordinates(input);
            invalidShot = playerGrid.checkShotInvalid(shotLocation);
        }
    }
}
