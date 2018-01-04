package rooms;
import java.util.Scanner;

import person.Person;
import runner.Runner;

//Evan Wu TBA Project
public class GameOver extends Room {

	private boolean choice = true;
	private String[] args;
	public GameOver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("...");
		System.out.println("   _____          __  __ ______    ______      ________ _____  \r\n" + 
				"  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \r\n" + 
				" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\r\n" + 
				" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \r\n" + 
				" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \r\n" + 
				"  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
		System.out.println("  Uh-oh, you've fell into a trap! Start over? (Respond with yes or no.)");
		
	//user is given choice to restart the game or rage quit
	while (choice) {
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		 do{
			 if (findKeyword(statement, "Yes", 0) >= 0)
			{
				Runner.main(args);
	           
			}
		 else if (findKeyword(statement, "No", 0) >= 0)
			{
			System.out.println("Hope to see you again!");
			 Runner.gameOff();
			}
		 } while(choice);
		}
	}
	
	
	
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
}
