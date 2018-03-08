import java.util.Scanner;

public class Player {
	private String playersChoice;
	private int noOfPlayerWins = 0;
	
	
	
	public String getPlayersChoice() {
		return playersChoice;
	}

	public int getNoOfPlayerWins() {
		return noOfPlayerWins;
	}

	public void setPlayerChoice(Scanner sc) {
		String choice = "rock";
		boolean invalidChoice = true;
		
		while(invalidChoice) {
			System.out.println("Please enter your choice (rock/paper/scissors):");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("R")) {
				choice = "rock";
				invalidChoice = false;
			} else if(choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("P")) {
				choice = "paper";
				invalidChoice = false;
			} else if(choice.equalsIgnoreCase("Scissors") || choice.equalsIgnoreCase("S")) {
				choice = "scissors";
				invalidChoice = false;
			}else {
				System.out.println("Invalid choice, please select another.");
			}
		}
		this.playersChoice = choice;
	}

	public void playerWins() {
		this.noOfPlayerWins++;
	}
	
	public void reset() {
		this.noOfPlayerWins = 0;
	}
}
