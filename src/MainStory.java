import java.util.Scanner;

public class MainStory {
	public static int cultStart = 0;
	public static int crusaderStart = 0;
	private static int gameOver = 0;
	
	public static void main(String[] args) {
		gameStart();
	}
	
	public static void gameStart() {
		Scanner input = new Scanner(System.in);

		System.out.printf("It's modern day, you're waking up in your room.\n"
				+"You wander into the kitchen to make breakfast.\n" 
				+"Out of nowhere you are teleported into a fantasy land!\n"
				+"You meet a group of cultists and crusaders. \n"
				+"They are both armed and after a war of words, they break into a massive brawl! \n");
		
		System.out.println ("Who do you choose to help?\n"
				+ "1: Help the cultists\n"
				+ "2: Help the crusaders\n"
				+ "3: Do nothing");
		int answer = input.nextInt();
		
		switch (answer) {
			case 1:
				cultStart = 1;
				CultistsStoryline.theCultDustSettles();
				break;
			
			case 2: 
				crusaderStart = 1;
				CrusadersStoryline.theCrusadeDustSettles();
				break;
			
			case 3:
				System.out.println("You get caught in between the two groups fighting and are cut down.");
				gameOver = 1;
				DeathCheck(gameOver);
				break;
			
			default:
				System.out.println("That wasn't a choice.");
				break;
		}
	}
	public static void DeathCheck(int gameOver) {
		if (gameOver == 1) {
			System.out.printf("%nGame over!");
			System.exit(0);
		}
	}
	
	public static void EndStory() {
		System.out.printf("%n%n\n...but out of nowhere...\n"
				+ "You find your body suddenly covered in a strange glow.\n "
				+ "You are then teleported back into your kitchen in the clothes you woke up in.\n\n "
				+ "...to be continued.");
	}
}	