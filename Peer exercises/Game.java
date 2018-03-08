import java.util.Scanner;

public class Game {
	private int noOfGames;
	Scanner sc = new Scanner(System.in);
	private int noOfRocksChosen;
	private int noOfScissorsChosen;
	private int noOfPapersChosen;
	
	Player player = new Player();
	Computer computer = new Computer();
	
	public void startGame() {
		System.out.println("Welcome to rock, paper, scissors game");
		String selection = "";
		while(!selection.equals("quit")) {
			selection = menu(sc);
			if(selection.equals("play")) {
				playGame(sc);
			} else if(selection.equals("instructions")) {
				printInstructions(sc);
			}
		}
		System.out.println("Thank you for playing");
		
	}
	
	public String menu(Scanner sc) {
		System.out.println("------------------------------------------------------");
		System.out.println("Main Menu\n1. Play\n2. Instructions\n3. Quit");
		String selection = "invalid";
		while(selection.equals("invalid")) {
			selection = sc.nextLine();
			if(selection.equalsIgnoreCase("play") || selection.equalsIgnoreCase("p") || selection.equals("1")) {
				selection = "play";
			} else if(selection.equalsIgnoreCase("instructions") || selection.equalsIgnoreCase("i") || selection.equals("2")) {
				selection = "instructions";
			} else if(selection.equalsIgnoreCase("quit") || selection.equalsIgnoreCase("q") || selection.equals("3")) {
				selection = "quit";
			} else {
				System.out.println("------------------------------------------------------");
				System.out.println("Invalid Selection. Please enter a selection from the menu.");
				selection = "invalid";
			}
		}
		return selection;
	}
	
	public void playGame(Scanner sc) {
		System.out.println("------------------------------------------------------");
		System.out.println("Please enter number of rounds to play:");
		noOfGames = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < noOfGames; i++) {
			player.setPlayerChoice(sc);
			System.out.println("------------------------------------------------------");
			System.out.println("Player picks: " + player.getPlayersChoice());
			computer.setComputersChoice();
			System.out.println("Computer picks: " + computer.getComputersChoice());
			if(player.getPlayersChoice().equals("rock")) {
				noOfRocksChosen++;
				if(computer.getComputersChoice().equals("scissors")) {
					noOfScissorsChosen++;
					player.playerWins();
					System.out.println("Rock beats Scissors. Player Wins");
				} else if(computer.getComputersChoice().equals("paper")) {
					noOfPapersChosen++;
					computer.computerWins();
					System.out.println("Paper covers Rock. Computer wins");
				} else {
					noOfRocksChosen++;
					System.out.println("Both chose Rock. Draw");
				}
			} else if(player.getPlayersChoice().equals("paper")) {
				noOfPapersChosen++;
				if(computer.getComputersChoice().equals("scissors")){
					noOfScissorsChosen++;
					computer.computerWins();
					System.out.println("Scissors cuts Paper. Computer wins");
				}else if(computer.getComputersChoice().equals("rock")){
					noOfRocksChosen++;
					player.playerWins();
					System.out.print("Paper covers Rock. Player wins");
				}else {
					noOfPapersChosen++;
					System.out.println("Both chose Paper. Draw");
				}
			} else {
				noOfScissorsChosen++;
				if(computer.getComputersChoice().equals("paper")) {
					noOfPapersChosen++;
					player.playerWins();
					System.out.println("Scissors cuts Paper. Player wins");
				} else if(computer.getComputersChoice().equals("rock")) {
					noOfRocksChosen++;
					computer.computerWins();
					System.out.println("Rock beats Scissors. Computer wins");
				} else {
					noOfScissorsChosen++;
					System.out.println("Both chose Scissors. Draw");
				}
			}
		}
		System.out.println("------------------------------------------------------");
		results();
	}

	public void results() {
		System.out.println("Total games played: " + noOfGames);
		System.out.println("Number of Computer wins: " + computer.getNoOfComputerWins() + "(" + ((computer.getNoOfComputerWins()*100)/noOfGames)  + "%)");
		System.out.println("Number of Player wins: " + player.getNoOfPlayerWins() + "(" + ((player.getNoOfPlayerWins()*100)/noOfGames)  + "%)");
		System.out.println("Number of ties: " + (noOfGames - computer.getNoOfComputerWins() - player.getNoOfPlayerWins()) + "(" + (((noOfGames - computer.getNoOfComputerWins() - player.getNoOfPlayerWins())*100)/noOfGames)  + "%)");
		if(noOfRocksChosen > noOfPapersChosen && noOfRocksChosen > noOfScissorsChosen) {
			System.out.println("Most common choice was Rock: " + noOfRocksChosen + "(" + (noOfRocksChosen * 100)/(noOfGames * 2) + "%)");
		} else if(noOfPapersChosen > noOfRocksChosen && noOfPapersChosen > noOfScissorsChosen) {
			System.out.println("Most common choice was Paper: " + noOfPapersChosen + "(" + (noOfPapersChosen * 100)/(noOfGames * 2) + "%)");
		} else if(noOfScissorsChosen > noOfRocksChosen && noOfScissorsChosen > noOfPapersChosen) {
			System.out.println("Most common choice was Scissors: " + noOfScissorsChosen + "(" + (noOfScissorsChosen* 100)/(noOfGames * 2) + "%)");
		} else {
			System.out.println("There was no choice slected more often than both the others");
		}
	}
	
	public void printInstructions(Scanner sc) {
		System.out.println("------------------------------------------------------");
		System.out.println("The player and computer both make a choice from rock, paper or scissors. The choices are then compared.\n"
				+ "Rock beats Scissors\nPaper beats Rock\nScissors beats Paper\nThe player whose choice beats the opponents wins.");
		System.out.println("Please press enter to return to menu");
		String end = sc.nextLine();
	}

}
