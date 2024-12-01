//Micah Jenkins - Rock Paper Scissors
import java.util.Scanner;
import java.util.Random;
public class RPS {

	//the 0-2 will be the choice for the computer
	public static final int RPS = 2;
	
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		Random r = new Random();
		
		String inputPA = "";
		
		do{
			System.out.println("TIME FOR A ROUSING GAME OF ROCK PAPER SCISSORS!!");
			
			int pointPlay = 0;
			int pointCPU = 0;

			
			for(int i = 0; i < 3; i++)
			{
				
				//the 3 games played_
				
				//generate the choice for the computer_
				/*
				 * key:
				 * rock: 0
				 * paper: 1
				 * scissors: 2
				 */
				
				int gamer = r.nextInt(RPS);
				String cpuC = "";
				
				switch(gamer)
				{
				case 0:
					cpuC = "rock";
					break;
				case 1:
					cpuC = "paper";
					break;
				case 2:
					cpuC = "scissors";
					break;
				}
			
				
			
			//ask the player for their choice_ 
			System.out.println("Enter \"rock\", \"paper\" or \"scissors\".");
			String playerC = key.next();
			
			//determine the outcome of the round_
			System.out.print("Time for round " + (i + 1) + "! ");
			System.out.println("Shoot!");
			
			//case rock
			if(playerC.equalsIgnoreCase("rock"))
			{
				if(cpuC == "rock")
				{
					System.out.println(cpuC + " vs. " + playerC + ". It's a Tie!");
				}
				else if(cpuC == "paper")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Paper wins. The Computer wins!");
					pointCPU += 1;
				}
				else if(cpuC == "scissors")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Rock wins. You win, Player!");
					pointPlay += 1;
				}
			}
			
			//case paper
			else if(playerC.equalsIgnoreCase("paper"))
			{
				if(cpuC == "rock")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Paper wins. You win, Player!");
					pointPlay += 1;
				}
				else if(cpuC == "paper")
				{
					System.out.println(cpuC + " vs. " + playerC + ". It's a Tie!");
				}
				else if(cpuC == "scissors")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Scissors wins. The Computer wins!");
					pointCPU += 1;
				}
			}
			
			//case scissors
			else if(playerC.equalsIgnoreCase("scissors"))
			{
				if(cpuC == "rock")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Rock wins. The computer wins!");
					pointCPU += 1;
				}
				else if(cpuC == "paper")
				{
					System.out.println(cpuC + " vs. " + playerC + ". Scissors wins. You win, Player!");
					pointPlay += 1;
				}
				else if(cpuC == "scissors")
				{
					System.out.println(cpuC + " vs. " + playerC + ". It's a Tie!");
				}
			}
			
			//invalid statements
			else
			{
				System.out.println("Invalid choice. The computer gets a point.");
				pointCPU += 1;
			}
		}
			
			//determine overall winner
			if(pointCPU > pointPlay)
			{
				System.out.println("THE COMPUTER WINS!");
			}
			else if(pointCPU < pointPlay)
			{
				System.out.println("YOU WIN!");
			}
			else if(pointCPU == pointPlay)
			{
				System.out.println("IT'S A TIE OVERALL!");
			}
			
		
		//The replay factor_
			System.out.println("Would you like to play again? Type \"yes\" or \"no\".\n");
			inputPA = key.next();
			
			
		}while(inputPA.equalsIgnoreCase("Yes"));
		
		System.out.println("Good Game. We should play agin sometime! Goodbye!");
		System.exit(0);

	}

}
