import java.util.Scanner;
import java.security.SecureRandom;

public class CrusadersStoryline {
	private static final SecureRandom RNG = new SecureRandom();
	private static final Scanner input = new Scanner(System.in);
	private static int gameOver = 0;
	private static int armorType = 0;
	private static int weaponType = 0;
	private static int pcHealth = 200; // player health
	private static int cultistLead = 100; // cult leader health
	private static int cultist = 50; // high priest health
	private static int pcHit;
	private static int npclHit = 15; // cult leader hit damage
	private static int npcHit = 13; // high priest hit damage
	private static int pcAttack;
	private static int pcStrongAttack;
	private static int battleResult = 0;
	
	public static void theCrusadeDustSettles() {
		System.out.printf("You help the Crusaders and defeat the Cultists. You are confused from "
				+ "what happened but pumped from the battle.\n");
		System.out.println("You choose to...");
		System.out.println("1 - Loot the dead");
		System.out.println("2 - Gain some insight");
		String playerInput = input.nextLine();
			
		if (playerInput.equals("1")){
			System.out.println("You loot the dead corpses of the weaklings you have slaughtered.\n");
			theCrusadeTrainingRewards();
		}
		else if (playerInput.equals("2")) {
			System.out.printf("Unsure what to do, you stand there trying to reflect on the chaos, "
					+ "but eager to shed more blood.\n");
			theCrusadeTrainingRewards();
		}
		else {
		    System.out.println("That's not a valid answer. Try again.\n");
		    theCrusadeDustSettles();
		}
	}
		
	public static void theCrusadeTrainingRewards() {
		System.out.printf("After, you follow the Crusaders and learn how to dominate and control. "
				+ "You train with the Crusaders and as a result you get stronger, faster, and more "
				+ "vicious. After training you are awarded armor and weapon choices.\n");
		System.out.printf("Which weapon do you choose to use?"
				+ "%n1 - Steel sword %n2 - Steel Battleaxe%n");
		int weapon = input.nextInt();
			
		if (weapon == 1) {
			weaponType = 1;
			System.out.printf("You are granted a well-polished and huge, jeweled sword of silver "
					+ "and gold nearly the length of your body.\n");
		}
		else {
			weaponType = 2;
			System.out.printf("You are granted a light, one-handed battleaxe complete with gold "
					+ "trimming and holy symbols engraved upon the blade edges.\n");
		}
			
		System.out.printf("Which armor do you choose to wear?"
				+ "%n1 - Steel Plate armor %n2 - Leather armor%n");
		int armor = input.nextInt();
			
		if (armor == 1) {
			armorType = 1;
			System.out.printf("You are granted a bright silver, holy-looking, jewel-encrusted suit "
					+ "of gold-trimmed platemail armor.\n");
			meetingWithCrusaderLeader();
		}
		else {
			armorType = 2;
			System.out.printf("You are granted a full set of light-brown leather armour, with fine "
					+ "silk threading and holy symbols branded throughout and into the hood atop.\n");
			meetingWithCrusaderLeader();
		}
	}
		
	public static void meetingWithCrusaderLeader() {
		Scanner scan = new Scanner(System.in);
			
		System.out.printf("You go with the Crusaders and meet the Crusaders' Leader, and he tells "
				+ "you of this great threat to them, their way of life and even to the entire world "
				+ "as they see it. They ask you to help them and defeat the Cultists.\n");
		System.out.println("1 - Accept");
		System.out.println("2 - Betray");
		String playerInput = scan.nextLine();
			
		if (playerInput.equals("1")){
	        crusaderLoyalty();
		}
		else if (playerInput.equals("2")) {
			if (MainStory.cultStart == 1) {
				betrayedCultistsAndCrusaders();
			}
			if (MainStory.cultStart == 0) {
				comeToTheCultSide();
				MainStory.cultStart = 1;
				CultistsStoryline.theCultDustSettles();
			}
		}
		else {
	        System.out.println("That's not a valid answer. Try again.\n");
	        meetingWithCrusaderLeader();
	    }
	}
		
	public static void betrayedCultistsAndCrusaders() {
		System.out.printf("You betray the Crusaders and do your best at killing the Crusaders' "
				+ "Leader but ultimately fail and are beaten to near-death and tossed into a "
				+ "nearby river. You wake up at a river bank by a group of Cultists who found "
				+ "you. They recognize you as the one who had betrayed them and kill you where "
				+ "you stand.\n");
		System.out.println("End Game.");
	}
		
	public static void comeToTheCultSide() {
		System.out.printf("You betray the Crusaders and do your best at killing the Crusaders' "
				+ "Leader but ultimately fail and are beaten to near-death and tossed into a "
				+ "nearby river. You wake up at a river bank by a group of Cultists who found "
				+ "you. They recognize you as the chosen one they had been looking for. "
				+ "Suddenly you and the Cultists are attacked by a roaming band of Crusaders.\n");
	}
		
	public static void crusaderLoyalty() {
		Scanner scan = new Scanner(System.in);
			
		System.out.printf("You eagerly take on the challenge and the chance to ravage more "
				+ "enemies and spill more blood. To prepare, you venture into the woods to rough "
				+ "up some lone travelers for their coin. While harassing a traveler you notice "
				+ "something out of the corner of your eye. You spot some stranded "
				+ "villagers with a wagon full of food and other valuables.\n");
		System.out.println("You choose to...");
		System.out.println("1 - Finish what you started");
		System.out.println("2 - Follow the gold");
		String playerInput = scan.nextLine();
			
		if (playerInput.equals("1")){
			System.out.println("You’re too busy beating on and torturing the traveler to be "
					+ "bothered with a wagon full of nobodies.\n");
		    cultistsCaves();
		    }
		else if (playerInput.equals("2")) {
			System.out.printf("You see the traveler as a small fry and decide to murder the "
					+ "group and raid their wagon for gold.\n");
			cultistsCaves();
			}
		else {
			System.out.println("That's not a valid answer. Try again.\n");
		    crusaderLoyalty();
		    }
	}
		
	public static void cultistsCaves() {
		System.out.printf("At long last it is time to take on your destiny and topple the enemy at "
				+ "their source. As you go towards the location of the Cultists' caves, freshly lit "
				+ "torch in-hand, you see that the main entrance must be deep beyond a labyrinth "
				+ "full of small and large winding tunnels. Upon further inspection, you see that "
				+ "there is a quicker way in but it seems to be shrouded by cave traps and "
				+ "potentially deadly ends.\n"
				+ "Which way do you go?");
			
		System.out.printf("%n1 - Decide to avoid the danger of the traps and venture through the "
				+ "labyrinth"
				+ "%n2 - Brave your way through the traps and enter the deep caves faster%n");
		int caves = input.nextInt();
		
		if (caves == 1) {
			int labyrinth = RNG.nextInt(20);
			System.out.printf("Roll was %d.%n", labyrinth);
			switch (labyrinth) {
			case 20:
				System.out.printf("You become completely lost inside the trappings of the labyrinth, "
						+ "never escaping and dying from starvation.");
				gameOver = 1;
				OtherCauseOfDeathCheck(gameOver);
				break;
			case 19:
				System.out.printf("You lose your way at first, afterwards deciding to wait until "
						+ "having a rest to then make a fire and use a larger, brighter burning "
						+ "torch to lead your way through the maze.");
				gameOver = 0;
				OtherCauseOfDeathCheck(gameOver);
				break;
			default:
				System.out.printf("You quickly find your way through the labyrinth, not "
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
					System.out.printf("As you are walking through a tunnel, you hear a faint "
							+ "shifting sound and feel the ground beneath your feet give in.%n"
							+ "A pit opens up, reavealing a long drop and long wooden spikes beneath "
							+ "you. You fall in and are impaled to death.");
					gameOver = 1;
					OtherCauseOfDeathCheck(gameOver);
					break;
				default:
					System.out.printf("The tunnel ahead is filled with giant swinging axeblades and "
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
						+ "tunnelway, "
						+ "making your way past them in record speed!");
				gameOver = 0;
				OtherCauseOfDeathCheck(gameOver);
			}
		}
			
		System.out.printf("%nAs you approach the door to the Cultists' throne room, you notice that "
				+ "the door is slightly open.\n"
				+ "You choose to...");
		System.out.printf("%n1 - Try to sneak through the crack in the door and surpise [Cultist "
				+ "Leader] %n2 - Barge through the door and charge towards Movis, The Cultist Leader%n");
		int throneRoom = input.nextInt();
		
		if (throneRoom == 1) {
			if (armorType == 1) {
				System.out.printf("%nAs you try to sneak through the door, your armor clunks around "
						+ "and gives you away.\n"
						+ "Prepare for battle!");
				crusadeThroneBattle(caves, armorType, weaponType);
			}
			else {
				System.out.printf("%nYou quickly sneak through the door and get the element of "
						+ "surprise. Time for battle!");
				crusadeThroneBattle(caves, armorType, weaponType);
			}
		}
		else {
			//Barge through option to be made
			System.out.printf("You barge through the room and prepare yourself for the incoming "
					+ "fight!");
			crusadeThroneBattle(caves, armorType, weaponType);
		}
	}
	
	public static int crusadeThroneBattle(int caves, int armorType, int weaponType) {
		if (armorType == 1) {
			pcHit = 18;
		}
		else {
			pcHit = 13;
		}
		if (caves == 1) {
			System.out.printf("%nAs you approach Movis, The Cultist Leader, you see one of his high priests "
					+ "appear from behind him. Looks like you'll be fighting both of them.%n ");
			 if (armorType == 1) {
				 while (pcHealth > 0 && cultist > 0) {
					 System.out.printf("%nYour AC is %d. ", pcHit);
					 System.out.printf("%nThe High Priest takes a swing at you! ");
					 int npcToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npcToHit);
					 if (npcToHit >= pcHit) {
						 int npcAttack = 6 + RNG.nextInt(8);
						 pcHealth = pcHealth - npcAttack;
						 System.out.printf("%nThe High Priest slices into you! You take %d "
						 		+ "damage. ", npcAttack);
					 }
					 else {
						 System.out.printf("%nThe High Priest misses as you dodge out of the "
						 		+ "way. ");
					 }
					 System.out.printf("You see the High Priest in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at The High Priest."
						 		+ "%n2: Take a swing at The High Priest."
						 		+ "%n3: Guard against The High Priest's attacks.\n");
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
							cultist = cultist - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at The High "
									+ "Priest, dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "The High Priest that you miss. ");
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
								cultist = cultist - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at The High "
										+ "Priest, dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at The High Priest, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (cultist <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Priest cries "
						 		+ "out, \"It doesn't matter! My Master will defeat you!\""
						 		+ "%nYou defeated the High Priest!");
						 battleResult = 1;
						 FinalBattle(caves, armorType, weaponType);
						 break;
					 }
				 }
			 }
			 else {
				 while (pcHealth > 0 && cultist > 0) {
					 System.out.printf("Your AC is %d. ", pcHit);
					 System.out.printf("You see the High Priest in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at The High Priest."
						 		+ "%n2: Take a swing at The High Priest."
						 		+ "%n3: Guard against The High Priest's attacks.\n");
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
							cultist = cultist - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at The High "
									+ "Priest, dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "The High Priest that you miss. ");
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
								cultist = cultist - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at The High "
										+ "Priest, dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at The High Priest, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (cultist <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Priest cries "
						 		+ "out, \"It doesn't matter! My Master will defeat you!\""
						 		+ "%nYou defeated the High Priest!");
						 battleResult = 1;
						 FinalBattle(caves, armorType, weaponType);
						 break;
					 }
						 
					 System.out.printf("%nThe High Priest takes a swing at you! ");
					 int npcToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npcToHit);
					 if (npcToHit >= pcHit) {
						 int npcAttack = 10 + RNG.nextInt(10);
						 pcHealth = pcHealth - npcAttack;
						 System.out.printf("%nThe High Priest slices into you! You take %d damage. "
								 , npcAttack);
					 }
					 else {
						 System.out.printf("%nThe High Priest misses as you dodge out of the way. ");
					 }
					 if (cultist <= 0) {
						 System.out.printf("%nAs you stike the last blow, The High Priest cries "
							 		+ "out, \"It doesn't matter! My Master will defeat you!\""
							 		+ "%nYou defeated the High Priest!");
						 battleResult = 1;
						 FinalBattle(caves, armorType, weaponType);
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
			System.out.printf("%n%nYou see that Movis, The Cultist Leader sits on his throne, sword "
					+ "at his side. He stands up,"
					+ "%n grabs his sword, and sneers at you. prepare for battle! ");
			 if (armorType == 1) {
				 while (pcHealth > 0 && cultistLead > 0) {
					 System.out.printf("%nYour AC is %d. ", pcHit);
					 System.out.printf("%nMovis, The Cultist Leader takes a swing at you! ");
					 int npclToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npclToHit);
					 if (npclToHit >= pcHit) {
						 int npclAttack = 6 + RNG.nextInt(8);
						 pcHealth = pcHealth - npclAttack;
						 System.out.printf("%nMovis, The Cultist Leader slices into you! You take %d "
						 		+ "damage. ", npclAttack);
					 }
					 else {
						 System.out.printf("%nMovis, The Cultist Leader misses as you dodge out of the "
						 		+ "way. ");
					 }
					 System.out.printf("You see Movis, The Cultist Leader in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at Movis, The Cultist Leader."
						 		+ "%n2: Take a swing at Movis, The Cultist Leader."
						 		+ "%n3: Guard against Movis, The Cultist Leader's attacks.\n");
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
							cultistLead = cultistLead - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at Movis, The Cultist Leader "
									+ ", dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "Movis, The Cultist Leader that you miss. ");
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
								cultistLead = cultistLead - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at Movis, The Cultist Leader "
										+ ", dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at Movis, The Cultist Leader, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (cultistLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Movis, The Cultist Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Cult!"
						 		+ "%nYou win!");
						 MainStory.EndStory();
						 break;
					 }
				 }
			 }
			 else {
				 while (pcHealth > 0 && cultistLead > 0) {
					 System.out.printf("Your AC is %d. ", pcHit);
					 System.out.printf("You see Movis, The Cultist Leader in front of you. \n");
					 System.out.printf("You choose to..."
						 		+ "%n1: Muster all your strength and swing at Movis, The Cultist Leader."
						 		+ "%n2: Take a swing at Movis, The Cultist Leader."
						 		+ "%n3: Guard against Movis, The Cultist Leader's attacks.\n");
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
							cultistLead = cultistLead - pcStrongAttack;
							System.out.printf("%nYou make purchase on your swing at Movis, The Cultist Leader "
									+ ", dealing %d damage. ", pcStrongAttack);
						}
						else {
							System.out.printf("%nYou swing with such uncontrollable power at "
									+ "Movis, The Cultist Leader that you miss. ");
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
								cultistLead = cultistLead - pcAttack;
								System.out.printf("%nYou make purchase on your swipe at Movis, The Cultist Leader "
										+ ", dealing %d damage. ", pcAttack);
							}
							else {
								System.out.printf("%nYou take a slash at Movis, The Cultist Leader, but you "
										+ "miss. ");
							}
							break;
					 case 3:
						 pcHit = pcHit + 3;
						 break;
					 }
					 if (cultistLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Movis, The Cultist Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Cult!"
						 		+ "%nYou win!");
						 MainStory.EndStory();
						 break;
					 }
						 
					 System.out.printf("%nMovis, The Cultist Leader takes a swing at you! ");
					 int npclToHit = 4 + RNG.nextInt(20);
					 System.out.printf("Roll was %d.%n", npclToHit);
					 if (npclToHit >= pcHit) {
						 int npclAttack = 10 + RNG.nextInt(10);
						 pcHealth = pcHealth - npclAttack;
						 System.out.printf("%nMovis, The Cultist Leader slices into you! You take %d damage. "
								 , npclAttack);
					 }
					 else {
						 System.out.printf("%nMovis, The Cultist Leader misses as you dodge out of the way. ");
					 }
					 if (cultistLead <= 0) {
						 System.out.printf("%nAs you stike the last blow, Movis, The Cultist Leader cries "
						 		+ "out, \"This isn't over! There will be others!\""
						 		+ "%nCongatulations!"
						 		+ "%nYou have defeated the Leader of the Cult!"
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