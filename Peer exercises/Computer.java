
public class Computer {
	private int noOfComputerWins = 0;
	private String computersChoice;
	
	
	public void setComputersChoice() {
		String choice = "rock";
		boolean invalidChoice = true;
		while(invalidChoice) {
			int random = (int)(Math.random()*3)+1;
			if (random == 1) {
				choice = "rock";
				invalidChoice = false;
			} else if(random == 2) {
				choice = "paper";
				invalidChoice = false;
			}else if(random == 3) {
				choice = "scissors";
				invalidChoice = false;
			}
			
			
		}
		this.computersChoice = choice;
	}
	public void computerWins() {
		this.noOfComputerWins++;
	}
	public void reset() {
		this.noOfComputerWins = 0;
	}
	public int getNoOfComputerWins() {
		return noOfComputerWins;
	}
	
	public String getComputersChoice() {
		return computersChoice;
	}



}
