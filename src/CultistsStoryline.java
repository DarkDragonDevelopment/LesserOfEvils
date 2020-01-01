import java.util.Scanner;
import java.security.SecureRandom;

public class CultistsStoryline {
	private static final SecureRandom RNG = new SecureRandom();
	private static final Scanner input = new Scanner(System.in);
	private static int gameOver = 0;
	private static int armorType = 0;
	private static int weaponType = 0;
	private static int pcHealth = 200; // player health
	private static int crusaderLead = 100; // crusade leader health
	private static int crusader = 50; // guard health
	private static int pcHit;
	private static int npclHit = 15; // crusade leader hit damage
	private static int npcHit = 13; // guard hit damage
	private static int pcAttack;
	private static int pcStrongAttack;
	private static int battleResult = 0;
	
	public static void theCultDustSettles() {
		System.out.printf("You help the Cultists and defeat the Crusaders. You are confused from "
				+ "what happened but pumped from the battle.\n");
		System.out.println("You choose to...");
		System.out.println("1 - Pray for the dead");
		System.out.println("2 - Gain some insight");
		String playerInput = input.nextLine();
			
		if (playerInput.equals("1")){
			System.out.println("You pray for the souls of your enemies.");
			theCultTrainingRewards();
		}
		else if (playerInput.equals("2")) {
			System.out.printf("In shock and awe, you try to reflect on the chaos, mourning for the "
					+ "countless lives that must've been lost to this war.");
			theCultTrainingRewards();
		}
		else {
		    System.out.println("That's not a valid answer. Try again.\n");
		    theCultDustSettles();
		}
	}
		
	public static void theCultTrainingRewards() {
		System.out.printf("After, you follow the Cultists and learn how to bless and heal. "
				+ "You train with the Cultists and as a result you become holier, resolute, and more "
				+ "decisive in your judgements. After training you are awarded armor and weapon choices.\n\n");
		System.out.printf("Which weapon do you choose to use?"
				+ "%n1 - Steel sword %n2 - Steel Battleaxe%n");
		int weapon = input.nextInt();
			
		if (weapon == 1) {
			weaponType = 1;
			System.out.printf("You are granted a blood-stained and huge, jagged sword nearly the "
					+ "length of your body.\n");
		}
		else {
			weaponType = 2;
			System.out.printf("You are granted a light, one-handed battleaxe complete with sharp, "
					+ "intentionally jagged blade edges.\n");
		}
			
		System.out.printf("Which armor do you choose to wear?"
				+ "%n1 - Steel Plate armor %n2 - Leather armor%n");
		int armor = input.nextInt();
			
		if (armor == 1) {
			armorType = 1;
			System.out.printf("You are granted a dark grey, vicious-looking, blood-encrusted suit "
					+ "of platemail armor.\n");
			meetingWithCultistLeader();
		}
		else {
			armorType = 2;
			System.out.printf("You are granted a full set of light leather armour, dark grey with a "
					+ "leather hood atop.\n");
			meetingWithCultistLeader();
		}
	}
		
	public static void meetingWithCultistLeader() {
		Scanner scan = new Scanner(System.in);
			
		System.out.printf("You go with the Cultists and meet the Cultists' Leader, and he tells "
				+ "you of this great threat to them, their way of life and even to the entire world "
				+ "as they see it. They ask you to help them and defeat the Crusaders.\n");
		System.out.println("1 - Accept");
		System.out.println("2 - Betray");
		String playerInput = scan.nextLine();
			
		if (playerInput.equals("1")){
	        cultistLoyalty();
		}
		else if (playerInput.equals("2")) {
			if (MainStory.crusaderStart == 1) {
				betrayedCultistsAndCrusaders();
			}
			if (MainStory.crusaderStart == 0) {
				comeToTheCrusadeSide();
				MainStory.crusaderStart = 1;
				CrusadersStoryline.theCrusadeDustSettles();
			}
		}
		else {
	        System.out.println("That's not a valid answer. Try again.\n");
	        meetingWithCultistLeader();
	    }
	}
		
	public static void betrayedCultistsAndCrusaders() {
		System.out.printf("You betray the Cultists and do your best at killing the Cultists' "
				+ "Leader but ultimately fail and are beaten to near-death and tossed into a "
				+ "nearby river. You wake up at a river bank by a group of Crusaders who found "
				+ "you. They recognize you as the one who had betrayed them and kill you where "
				+ "you stand.\n");
		System.out.println("End Game.");
	}
		
	public static void comeToTheCrusadeSide() {
		System.out.printf("You betray the Cultists and do your best at killing the Cultists' "
				+ "Leader but ultimately fail and are beaten to near-death and tossed into a "
				+ "nearby river. You wake up at a river bank by a group of Crusaders who found "
				+ "you. They recognize you as the chosen one they had been looking for. "
				+ "Suddenly you and the Crusaders are attacked by a roaming band of Cultists.\n");
	}
		
	public static void cultistLoyalty() {
		Scanner scan = new Scanner(System.in);
			
		System.out.printf("You eagerly take on the challenge and the chance to cleanse more "
				+ "sinners and spread the spirit. To prepare, you venture into the woods to "
				+ "exercise some lone travelers for their own good. While exercising a traveler "
				+ "you notice something out of the corner of your eye. You spot some "
				+ "stranded villagers in need of cleansing.\n");
		System.out.println("You choose to...");
		System.out.println("1 - Finish what you started");
		System.out.println("2 - Do the work of your deity");
		String playerInput = scan.nextLine();
			
		if (playerInput.equals("1")){
	        System.out.println("You’re too busy exercising the lone traveler with his wailing "
	        		+ "and flailing to take on a group of sinner right now.\n");
	        crusadersLabyrinth();
		}
		else if (playerInput.equals("2")) {
			System.out.printf("You see the traveler as a lone sinner and decide to mass-cleanse "
					+ "the group and free them from their evil.\n");
			crusadersLabyrinth();
		}
		else {
	        System.out.println("That's not a valid answer. Try again.\n");
	        cultistLoyalty();
	    }
	}
		
	public static void crusadersLabyrinth() {
		System.out.printf("At long last it is time to take on your destiny and topple the enemy "
				+ "at their source. As you go towards the location of the Crusaders' massive "
				+ "behemoth-like fortress, compass and water pouch in-hand, you see that the main "
				+ "entrance is puzzling and blocked by a maze full of twists and turns. Upon "
				+ "further inspection, you see that there is another way in but it seems to be "
				+ "shrouded by traps and diversions.\n"
				+ "Which way do you go?");
			
		System.out.printf("%n1 - Decide to avoid the danger of the traps and venture through the "
				+ "maze"
				+ "%n2 - Brave your way through the traps and enter the main castle faster%n");
		int castle = input.nextInt();
		
		if (castle == 1) {
			int maze = RNG.nextInt(20);
			System.out.printf("Roll was %d.%n", maze);
			switch (maze) {
			case 20:
				System.out.printf("You become completely lost inside the trappings of the maze, "
						+ "never escaping and dying from starvation.");
				gameOver = 1;
				OtherCauseOfDeathCheck(gameOver);
				break;
			case 19:
				System.out.printf("You lose your way at first, afterwards deciding to rest for a "
						+ "a good while and waiting until night to use the stars to lead your way "
						+ "through the maze.");
				gameOver = 0;
				OtherCauseOfDeathCheck(gameOver);
				break;
			default:
				System.out.printf("You quickly find your way through the maze, not "
						+ "wasting too much time inside.");
				gameOver = 0;
				OtherCauseOfDeathCheck(gameOver);
				break;
			}
		}
		else {
			int trap = RNG.nextInt(10);
			System.out.printf("Roll was %d.%n", trap);
			if (trap <= 5) {
				switch (trap) {
				case 1:
				case 0:
					System.out.printf("As you are walking down a corridor, you hear a faint "
							+ "clicking sound and feel the ground beneath your feet tremble.%n"
							+ "A pit opens up, reavealing a river of lava beneath you. You fall in "
							+ "and slowly burn to your death.");
					gameOver = 1;
					OtherCauseOfDeathCheck(gameOver);
					break;
				default:
					System.out.printf("The path ahead is filled with giant swinging axeblades and "
							+ "spikes as far as the eye can see. %nYou decide to brave the passage, "
							+ "but unfortunately you underestimate the difficulty of the traps. %n"
							+ "You are sliced into bits as you try to traverse the tunnel.");
					gameOver = 1;
					OtherCauseOfDeathCheck(gameOver);
					break;
				}	
			}
			else {
				System.out.printf("%nYou masterfully dodge and avoid all of the traps lining the "
						+ "passageway, "
						+ "making your way past them in record speed!");
				gameOver = 0;
				OtherCauseOfDeathCheck(gameOver);
			}
		}
			
		System.out.printf("%nAs you approach the door to the Crusaders' throne room, you notice that "
				+ "the door is slightly open.\n"
				+ "You choose to...");
		System.out.printf("%n1 - Try to sneak through the crack in the door and surpise [Crusader "
				+ "Leader] %n2 - Barge through the door and charge towards Modeko, The Crusader Leader%n");
		int throneRoom = input.nextInt();
		
		if (throneRoom == 1) {
			if (armorType == 1) {
				System.out.printf("%nAs you try to sneak through the door, your armor clunks around "
						+ "and gives you away.\n"
						+ "Prepare for battle!");
				cultThroneBattle(castle, armorType, weaponType);
			}
			else {
				System.out.printf("%nYou quickly sneak through the door and get the element of "
						+ "surprise. Time for battle!");
				cultThroneBattle(castle, armorType, weaponType);
			}
		}
		else {
			//Barge through option to be made
			System.out.printf("You barge through the room and prepare yourself for the incoming "
					+ "fight!");
			cultThroneBattle(castle, armorType, weaponType);
		}
	}
	
	public static int cultThroneBattle(int castle, int armorType, int weaponType) {
		if (armorType == 1) {
			pcHit = 18;
		}
		else {
			pcHit = 13;
		}
		if (castle == 1) {
			System.out.printf("%nAs you approach Modeko, The Crusader Leader, you see one of his high guards "
					+ "appear from behind him. Looks like you'll be fighting both of them.%n ");
			 if (armorType == 1) {
				 while (pcHealth > 0 && crusader > 0) {
					 System.out.printf("%nYour AC is %d. ", pcHit);
					 System.out.printf("%nThe High Guard takes a swing at you! ");
					 int npcToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npcToHit);
					 if (npcToHit >= pcHit) {
						 int npcAttack = 6 + RNG.nextInt(8);
						 pcHealth = pcHealth - npcAttack;
						 System.out.printf("%nThe High Guard slices into you! You take %d "
						 		+ "damage. ", npcAttack);
					 }
					 else {
						 System.out.printf("%nThe High Guard misses as you dodge out of the "
						 		+ "way. ");
					 }
					 System.out.printf("You see The High Guard in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at The High Guard."
						 		+ "%n2: Take a swing at The High Guard."
						 		+ "%n3: Guard against The High Guard's attacks.\n");
					 int attack = input.nextInt();
					 
					 if (armorType == 1) {
							pcHit = 18;
						}
						else {
							pcHit = 13;
						}
					 
					 switch (attack) {
					 case 1:
						int pcToHit = 4 + RNG.nextInt(20);
						if (pcToHit >= npcHit) {
							if (weaponType == 1) {
								pcStrongAttack = 13 + RNG.nextInt(8);
							}
							else {
								pcStrongAttack = 13 + RNG.nextInt(12);
							}
							crusader = crusader - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at The High "
									+ "Guard, dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "The High Guard that you miss. ");
						}
						break;
					 case 2:
						 pcToHit = 4 + RNG.nextInt(20);
							if (pcToHit >= npcHit) {
								if (weaponType == 1) {
									pcAttack = 8 + RNG.nextInt(8);
								}
								else {
									pcAttack = 8 + RNG.nextInt(12);
								}
								crusader = crusader - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at The High "
										+ "Guard, dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at The High Guard, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (crusader <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Guard cries "
						 		+ "out, \"It doesn't matter! My Master will defeat you!\""
						 		+ "%nYou defeated The High Guard!");
						 battleResult = 1;
						 FinalBattle(castle, armorType, weaponType);
						 break;
					 }
				 }
			 }
			 else {
				 while (pcHealth > 0 && crusader > 0) {
					 System.out.printf("Your AC is %d. ", pcHit);
					 System.out.printf("You see The High Guard in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at The High Guard."
						 		+ "%n2: Take a swing at The High Guard."
						 		+ "%n3: Guard against The High Guard's attacks.\n");
					 int attack = input.nextInt();
					 
					 if (armorType == 1) {
							pcHit = 18;
						}
						else {
							pcHit = 13;
						}
					 
					 switch (attack) {
					 case 1:
						int pcToHit = 4 + RNG.nextInt(20);
						if (pcToHit >= npcHit) {
							if (weaponType == 1) {
								pcStrongAttack = 13 + RNG.nextInt(8);
							}
							else {
								pcStrongAttack = 13 + RNG.nextInt(12);
							}
							crusader = crusader - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at The High "
									+ "Guard, dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "The High Guard that you miss. ");
						}
						break;
					 case 2:
						 pcToHit = 4 + RNG.nextInt(20);
							if (pcToHit >= npcHit) {
								if (weaponType == 1) {
									pcAttack = 8 + RNG.nextInt(8);
								}
								else {
									pcAttack = 8 + RNG.nextInt(12);
								}
								crusader = crusader - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at The High "
										+ "Guard, dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at The High Guard, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (crusader <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Guard cries "
						 		+ "out, \"It doesn't matter! My Master will defeat you!\""
						 		+ "%nYou defeated The High Guard!");
						 battleResult = 1;
						 FinalBattle(castle, armorType, weaponType);
						 break;
					 }
						 
					 System.out.printf("%nThe High Guard takes a swing at you! ");
					 int npcToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npcToHit);
					 if (npcToHit >= pcHit) {
						 int npcAttack = 10 + RNG.nextInt(10);
						 pcHealth = pcHealth - npcAttack;
						 System.out.printf("%nThe High Guard slices into you! You take %d damage. "
								 , npcAttack);
					 }
					 else {
						 System.out.printf("%nThe High Guard misses as you dodge out of the way. ");
					 }
					 if (crusader <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Guard cries "
							 		+ "out, \"It doesn't matter! My Master will defeat you!\""
							 		+ "%nYou defeated The High Guard!");
						 battleResult = 1;
						 FinalBattle(castle, armorType, weaponType);
						 break;
					 }
				 }
			 }
		}
		if (pcHealth <= 0) {
			int gameOver = 1;
			BattleDeathCheck(gameOver);
		}
		return battleResult;
	}

	public static int FinalBattle(int caves, int armorType, int weaponType) {
		if (armorType == 1) {
			pcHit = 18;
		}
		else {
			pcHit = 13;
		}
		if (caves == 1) {
			System.out.printf("%n%nYou see that Modeko, The Crusader Leader sits on his throne, sword "
					+ "at his side. He stands up,"
					+ "%n grabs his sword, and sneers at you. prepare for battle! ");
			 if (armorType == 1) {
				 while (pcHealth > 0 && crusaderLead > 0) {
					 System.out.printf("%nYour AC is %d. ", pcHit);
					 System.out.printf("%nModeko, The Crusader Leader takes a swing at you! ");
					 int npclToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npclToHit);
					 if (npclToHit >= pcHit) {
						 int npclAttack = 6 + RNG.nextInt(8);
						 pcHealth = pcHealth - npclAttack;
						 System.out.printf("%nModeko, The Crusader Leader slices into you! You take %d "
						 		+ "damage. ", npclAttack);
					 }
					 else {
						 System.out.printf("%nModeko, The Crusader Leader misses as you dodge out of the "
						 		+ "way. ");
					 }
					 System.out.printf("You see Modeko, The Crusader Leader in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at Modeko, The Crusader Leader."
						 		+ "%n2: Take a swing at Modeko, The Crusader Leader."
						 		+ "%n3: Guard against Modeko, The Crusader Leader's attacks.\n");
					 int attack = input.nextInt();
					 
					 if (armorType == 1) {
							pcHit = 18;
						}
						else {
							pcHit = 13;
						}
					 
					 switch (attack) {
					 case 1:
						int pcToHit = 4 + RNG.nextInt(20);
						if (pcToHit >= npclHit) {
							if (weaponType == 1) {
								pcStrongAttack = 13 + RNG.nextInt(8);
							}
							else {
								pcStrongAttack = 13 + RNG.nextInt(12);
							}
							crusaderLead = crusaderLead - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at Modeko, The Crusader Leader "
									+ ", dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "Modeko, The Crusader Leader that you miss. ");
						}
						break;
					 case 2:
						 pcToHit = 4 + RNG.nextInt(20);
							if (pcToHit >= npclHit) {
								if (weaponType == 1) {
									pcAttack = 8 + RNG.nextInt(8);
								}
								else {
									pcAttack = 8 + RNG.nextInt(12);
								}
								crusaderLead = crusaderLead - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at Modeko, The Crusader Leader "
										+ ", dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at Modeko, The Crusader Leader, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (crusaderLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Modeko, The Crusader Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Crusade!"
						 		+ "%nYou win!");
						 MainStory.EndStory();
						 break;
					 }
				 }
			 }
			 else {
				 while (pcHealth > 0 && crusaderLead > 0) {
					 System.out.printf("Your AC is %d. ", pcHit);
					 System.out.printf("You see Modeko, The Crusader Leader in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at Modeko, The Crusader Leader."
						 		+ "%n2: Take a swing at Modeko, The Crusader Leader."
						 		+ "%n3: Guard against Modeko, The Crusader Leader's attacks.\n");
					 int attack = input.nextInt();
					 
					 if (armorType == 1) {
							pcHit = 18;
						}
						else {
							pcHit = 13;
						}
					 
					 switch (attack) {
					 case 1:
						int pcToHit = 4 + RNG.nextInt(20);
						if (pcToHit >= npclHit) {
							if (weaponType == 1) {
								pcStrongAttack = 13 + RNG.nextInt(8);
							}
							else {
								pcStrongAttack = 13 + RNG.nextInt(12);
							}
							crusaderLead = crusaderLead - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at Modeko, The Crusader Leader "
									+ ", dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "Modeko, The Crusader Leader that you miss. ");
						}
						break;
					 case 2:
						 pcToHit = 4 + RNG.nextInt(20);
							if (pcToHit >= npclHit) {
								if (weaponType == 1) {
									pcAttack = 8 + RNG.nextInt(8);
								}
								else {
									pcAttack = 8 + RNG.nextInt(12);
								}
								crusaderLead = crusaderLead - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at Modeko, The Crusader Leader "
										+ ", dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at Modeko, The Crusader Leader, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (crusaderLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Modeko, The Crusader Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Crusade!"
						 		+ "%nYou win!");
						 MainStory.EndStory();
						 break;
					 }
						 
					 System.out.printf("%nModeko, The Crusader Leader takes a swing at you! ");
					 int npclToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npclToHit);
					 if (npclToHit >= pcHit) {
						 int npclAttack = 10 + RNG.nextInt(10);
						 pcHealth = pcHealth - npclAttack;
						 System.out.printf("%nModeko, The Crusader Leader slices into you! You take %d damage. "
								 , npclAttack);
					 }
					 else {
						 System.out.printf("%nModeko, The Crusader Leader misses as you dodge out of the way. ");
					 }
					 if (crusaderLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Modeko, The Crusader Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Crusade!"
						 		+ "%nYou win!");
						 MainStory.EndStory();
						 break;
					 }
				 }
			 }
		}
		if (pcHealth <= 0) {
			int gameOver = 1;
			BattleDeathCheck(gameOver);
		}
		return battleResult;
	}
	
	public static void BattleDeathCheck(int gameOver) {
		if (gameOver == 1) {
			System.out.printf("%nDespite your efforts, your are defeated by your enemy!\n"
					+ "Game over!");
			System.exit(0);
		}
	}
	public static void OtherCauseOfDeathCheck(int otherGameOver) {
		if (gameOver == 1) {
			System.out.printf("%nYou have died!\n"
					+ "Game over!");
			System.exit(0);
		}
	}
}