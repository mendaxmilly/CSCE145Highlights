//Micah Jenkins
//My CYOA will be a simple verbal fight between the user and dragons_

import java.util.Scanner;
import java.util.Random;

public class DraconicSimulator {

	public static final int DISTRACTION = 4;
	
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		Random r = new Random();
		
		//First, I will generate 3 prompts to influence the dragon to lend you his power_
		System.out.println("WELCOME TO MJ'S DRACONIC SIMULATOR, OR THE MJDS_\n"
				+ "IN THIS SIMULATION, YOU ARE FACED WITH THE CHALLENGE OF CLAIMING THE DRAGONS GOLDENSAAX'S RICHES_\n"
				+ "YOU ARE EQUIPPED WITH A TRICK BAG, AND A SHORT AND LONG RANGE WEAPON_\n"
				+ "MAKE CHOICES CAREFULLY, AND LEAVE WITH YOUR RICHES AND YOUR LIFE_\n"
				+ "BEGIN THE SIMULATION_");
		
		boolean endReached = false;
		boolean properEntry;
		boolean vChoice1 = false;
		
		//1st input validation
		while (!vChoice1) {
			
			//The player will be prompted with conflict or distraction.
		System.out.println("What would you like to do? Press \"1\" to engage in battle, or press \"2\" to speak with him: ");
		String goldRes1 = key.next();
		
		//The choice of Fight (Battle begins)
		
		if(goldRes1.equalsIgnoreCase("1"))
		{
			//the factors_
			int GoldHealth = 50;
			boolean deadGold = false;
			int turnsTillDeath = 5;
			int poisonDam = 0;
			
			while (deadGold == false && turnsTillDeath != 0)
			{
				if(GoldHealth <= 0)
				{
					deadGold = true;
					System.out.println("A FATAL HIT!!!");
					break;
				}
				else
				{
					System.out.println("Goldensaax has " + GoldHealth + " HP.");
				}
				
				//The choices_
				System.out.println("You have " + turnsTillDeath + " turns until Goldensaax attacks.");
				System.out.println("How do you wish to attack? "
						+ "\nPress \"1\" to strike with your sword."
						+ "\nPress \"2\" to fire an arrow."
						+ "\nPress \"3\" to use magic.");
				String battle = key.next();
				
				if(battle.equalsIgnoreCase("1"))
				{
					int baseDam = r.nextInt(16);
					GoldHealth = GoldHealth - (baseDam / 4)  - poisonDam;
					System.out.println("You attack with your sword! The attack is not very effective as Goldensaax' scales are as hard as diamond...");
					turnsTillDeath -= 1;
				}	
				
				else if(battle.equalsIgnoreCase("2"))
				{
					int baseDam = r.nextInt(16);
					GoldHealth = GoldHealth - (baseDam * 2)  - poisonDam;
					System.out.println("You see an opening within the drake's scales! Good hit! The creature winces.");
					turnsTillDeath -= 1;
				}	
				
				else if(battle.equalsIgnoreCase("3"))
				{
					//Magic choices_
					// and input validation
					boolean validSpell = false;
	                while (!validSpell) {
					System.out.println("Which spell do you wish to use? "
							+ "\nPress \"1\" to use a sleep spell."
							+ "\nPress \"2\" to cast FIREBALL!"
							+ "\nPress \"3\" to unleash a lightning bolt."
							+ "\nPress \"4\" to loose a cloud of poison.");	
					
					String spellCast = key.next();
					
					// Sleep spell_
					if(spellCast.equalsIgnoreCase("1"))
					{ // this option brings the player out of battle_
						System.out.println("You lull the dragon into a deep sleep with a feather and a piece of fleece from your trick bag.");
						System.out.println("With this, the battle ends.");
						System.out.println("You can choose to gather some of his riches, but you risk waking the dragon.");
						System.out.println("What would you like to do? \n"
								+ "Press \"1\" to steal from the hoard.\n"
								+ "Press \"2\" to steal from the gemstones in the cave.\n"
								+ "Press \"3\" to harvest one of Goldensaax's scales.");
						String sleepChoice = key.next();
						
						if(sleepChoice.equalsIgnoreCase("1"))
						{ // the player can leave with riches_
							System.out.println("You were able to claim a large amount of the hoard.");
							System.out.println("YOU GOT THE GOOD HARVEST END_ \nSOLID CHOICES, USING THAT SLEEP SPELL WAS SMART_");
							endReached = true;
							return;
						}
						if(sleepChoice.equalsIgnoreCase("2"))
						{ // this option leaves the player in the dark of the cave was a slumbering Goldensaax_ 
							System.out.println("You grab all of the gemstones you can find in the cave.\n"
									+ "Unfortunately those were the only thing lighting the cave. Essentially blinded, You're unable to leave, "
									+ "\nstuck in the lair of a slumbering Goldensaax until he wakes and sees what you've done.");
							System.out.println("YOU GOT THE DARKEST END_ \nMAYBE DON'T STEAL THE ONLY THINGS LIGHTING THE CAVE_?");
							endReached = true;
							return;
						}
						if(sleepChoice.equalsIgnoreCase("3"))
						{ // this option kills the player for their greed and daring (AKA GREED ENDING) 
							System.out.println("A gleaming scale from a gold dragon is the most precious thing to posess. Boundless riches \n"
									+ "await those who claim and trade for it. So you climb upon the back of the dragon to pluck your prize. \n"
									+ "The scale unwedges as you drive your sword into it. You claim your trophy, grinning ear to ear \n"
									+ "from the accomplishment. But as you slide down the back of Goldensaax and jump, you land among the \n"
									+ "hoard, causing treasures to fly everywhere, waking the dragon. You are swiftly taken into one of his claws \n"
									+ "and eaten.");
							System.out.println("YOU GOT THE GOLDEN ICARUS END_ \nYOU SHOULD NEVER FLY TOO CLOSE TO THE SUN_");
							endReached = true;
							return;
						}
					}	
					
					// Fireball spell_
					else if(spellCast.equalsIgnoreCase("2"))
					{ // this option ends up burning the player alive (AKA BURNT ENDING)_
						System.out.println("You pluck gunpowder, sulfur, and a match from your trick bag and exclaim a thunderously \n"
								+ "resounding \"FIREBALL!!\" which echoes throughout the cave's hollows. Unfortunately, you forgot that \n"
								+ "Goldensaax actually reflects fire attacks, as he does not flinch once the attack hits his hide and reflects towards you.\n"
								+ "Unable to dodge, you perish in a glorious blaze.");
						System.out.println("YOU GOT THE BLAZING END_ \nTURNS OUT FIREBALL DOESN'T SOLVE EVERYTHING_");
						endReached = true;
						return;
					}	
					
					// Lightning Bolt spell_
					else if(spellCast.equalsIgnoreCase("3"))
					{ // this option crits goldy but gives him less time to charge his attack_
						int baseDam = r.nextInt(16);
						GoldHealth = GoldHealth - (baseDam * 5) - poisonDam;
						System.out.println("You flip a coin and strike it with a copper rod from your trick bag!");
						System.out.println("An effective move!! The lightning from the surfaces smacks Goldensaxx where it hurts!");
						System.out.println("Goldensaax becomes supercharged!");
						turnsTillDeath -= 2;
						validSpell = true;
					}
					else if(spellCast.equalsIgnoreCase("4"))
					{ // this option makes goldy take extra damage_
						poisonDam = r.nextInt(6);
						GoldHealth = GoldHealth - poisonDam;
						System.out.println("You loose a cloud of poisionous smog from a vial of snake venom!");
						System.out.println("Goldensaax is poisoned!");
						turnsTillDeath -= 1;
						validSpell = true;
					}
					else {
                        System.out.println("Invalid input. Please choose a valid spell.");
                    }
                }
            } else {
                System.out.println("Invalid input. Please choose a valid attack option.");
            }
        }
			
			if(GoldHealth <= 0 && turnsTillDeath == 0) 
			{
				// somehow, they both landed a killing blow_ (BATTLE DRAW ENDING)
				System.out.println("You both perish, with Goldensaax dropping dead after you stab the inside of his stomach after being swallowed whole.");
				
				System.out.println("YOU GOT THE WELL FOUGHT END_ \nWELL FOUGHT INDEED, BUT THE GOAL WAS HIS HOARD, AND IN THE END, YOU BOTH TOOK EACH OTHER OUT_ \nYOU MAY WANT TO TRY AGAIN_");
				endReached = true;
				return;
			}

			if(turnsTillDeath == 0)
			{
				// if the player can't defeat goldy within 5 turns, they will perish_ (BATTLE LOSE ENDING)
				System.out.println("\nGOLDENSAAX: \"A brave but futile effort. None can even hope to defeat a dragon of my standing. Good riddance, adventurer.\""
						+ "\nAnd with a swift golden wind, you are sliced to shreds.");
				
				System.out.println("YOU GOT THE BEATEN END_ \nYOU TRIED_");
				endReached = true;
				return;
			}
				
			if(GoldHealth <= 0)
			{
				// the player managed to best a dragon in battle, but the goal was rapport_ (BATTLE WIN ENDING)
				System.out.println("YOU GOT THE DRAGONSLAYER END_ \nNICE KILL, BUT IS THERE ANY OTHER OPTION THAT MAY BE A BIT MORE MERCIFUL_?");
				endReached = true;
				return;
			}
	
			
		// end of FIGHT CHOICE 
		}
		
	//The choice of Distraction
		else if(goldRes1.equalsIgnoreCase("2"))
		{
			System.out.println("You ask about how Dragon Goldensaax about he obtained his riches."
							+ "\nThe dragon begins to recount each of his many aqcuisitions of his hoard. A successful distraction. \n"
							+ "What will you choose to do next? "
							+ "\nPress \"1\" to attempt to steal. "
							+ "\nPress \"2\" to go for an oppurtunity attack."
							+ "\nPress \"3\" to listen to the dragon.");
			String choiceTalk1= key.next();
			
			//input validation 2
			boolean validChoice = false;
			while (!validChoice) {
			if(choiceTalk1.equalsIgnoreCase("1"))
			{
				System.out.println("What would you like to steal? \n"
						+ "Press \"1\" to steal from the hoard.\n"
						+ "Press \"2\" to steal from the gemstones in the cave.\n");
				String choiceSteal1 = key.next();
				if(choiceSteal1.equalsIgnoreCase("1"))
				{
					// the player is punished for stealing from the hoard.
					System.out.println("As the dragon yaps, you seize a moment of oppurtunity. As he talks, you turn your attention towards the hoard. \n"
							+ "You are able to sneak around to the back of it and place a heap of treasure in your trick bag. \n"
							+ "You attempt to leave but Goldensaax catches you in the act and petrifies you in gold encasing.");
					System.out.println("YOU GOT THE MIDAS END_ \nWHY WOULD YOU TRY AND STEAL FROM THE HOARD_?");
					endReached = true;
					return;
				}
				else if(choiceSteal1.equalsIgnoreCase("2"))
				{
					// the player is able to leave with what little they can.
					System.out.println("As the dragon yaps, you seize a moment of oppurtunity. As he talks, you turn your attention towards the gemstones surrounding the cave. \n"
							+ "You flutter around the cave as the dragon goes on and on about whatever, \n"
							+ "placing the most precious looking gems inside your trick bag. \n"
							+ "Turning to leave, you look back upon Goldensaax, still talking into the darkness of the cave. A mischevious smirk creases your face as you escape.");
					System.out.println("YOU GOT THE THIEF END_ \nYOU WERE ABLE TO ESCAPE WITH SOME GOOD LOOT, BUT PERHAPS SOMETHING BETTER LAY IN WAIT_ \nMAYBE BE A BIT MORE BOLD WITH YOUR CHOICES; GET MESSY_");
					endReached = true;
					return;
				}	
				else {
                    System.out.println("Invalid input. Please choose a preset choice.");
                }
			}
			
			else if(choiceTalk1.equalsIgnoreCase("2"))
			{ // the player is punished for attempting a backstab.
				System.out.println("As the dragon yaps, you seize a moment of oppurtunity. You creep carefully around the dragons back \n"
						+ "and as his head comes up, you dash across his back and go for his neck with your sword! \n"
						+ "You are swiftly apprehended as Goldensaax uses his teeth to stop the blade and chomp your head off.");
				System.out.println("YOU GOT THE BACKSTABBER'S END_ \nYOU SHOULD KNOW TO NEVER CROSS A DRAGON_");
				endReached = true;
				return;
			}
			else if(choiceTalk1.equalsIgnoreCase("3"))
			{
				System.out.println("You take a seat among the hoard and listen intently to Goldensaax' rambling. You actually find it quite cathartic. "
						+ "\nHe begins to bring up an interest topic as he talks.");
				System.out.println("GOLDENSAAX: \"I actually do recieve some 'treasures' from certain adventurers, some like yourself. "
						+ "\nUnfortunately, most who do find themselves on the opposing end of my golden winds. "
						+ "\nI believe that's why I find myself talking with you so much. "
						+ "\nI sense you had the option to be like those others, but instead you chose to talk with me.\"");
				// a friendly ending, probably the best one.
				System.out.println("With this, an idea strikes you.");
				System.out.println("You dig your hand into your trick bag, fetching one of Goldensaax' favorite snacks that he had mentioned from his talking: A golden melon."
							+ "\nYou offer it to him, freely. He gets very excited, almost child-like.");
				System.out.println("GOLDENSAAX: \"Oh, it's been an eternity since I've had one of these! You know, flesh just isn't all that appealing."
							+ "\nWherever did you find one?! No matter. You, my friend, have done me a service. "
							+ "\n I got to finally voice my feelings and you feed me my favorite treat! What's mine is yours. Thank you.\"");
				System.out.println("YOU GOT THE FRI-END_ \nYOU'RE FRIENDS WITH A DRAGON_! \nTHINK OF ALL THE FAVORS YOU COULD HAVE_");
				endReached = true;
				return;
			} 
			else {
                System.out.println("Invalid input. Please choose a valid choice1.");
                choiceTalk1 = key.next();
					}
		//end of DISTRACT CODES_
				}
	//end of code.
			}
		else {
            System.out.println("Invalid input. Please choose a valid option.");
			}
		}
		
	}
}
