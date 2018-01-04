package rooms;
import java.util.Random;
import java.util.Scanner;

import person.Person;
import runner.Runner;

//Evan Wu TBA Project
public class Riddle extends Room {

private boolean riddle = true;
private boolean explored = false;
private Person x1;
	
	public Riddle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void enterRoom(Person x)
	{
		
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You've found a room...");
		System.out.println("There are pictures and words all over the place...");
		System.out.println("A text reads: Solve this riddle for a key:");
		System.out.println(getRandomRiddle());
		while(riddle) {
			Scanner in = new Scanner(System.in);
			String statement = in.nextLine();
			
			do { 
				//correct answers
				if (findKeyword(statement, "Pencil Lead",0) >=0 
						|| findKeyword(statement, "A Watermelon", 0) >= 0 
						|| findKeyword(statement, "A cloud",0) >=0 
						|| findKeyword(statement, "A tennis ball",0) >=0 
						|| findKeyword(statement, "An iPad",0) >=0 
						|| findKeyword(statement, "1461",0) >=0 
						|| findKeyword(statement, "Ground beef",0) >=0 
						|| findKeyword(statement, "True friendship",0) >=0 
						|| findKeyword(statement, "Lobster",0) >=0)
				{
				System.out.println("Correct!");
				occupant = x;
        		x.keyTotal();
        		x.getKeys();
        		boolean key = true;
        		riddle = false;
				}
			else {
				//correct answers
				System.out.println("Try again!(Another riddle this time)");
				System.out.println(getRandomRiddle());
				String statement1 = in.nextLine();
				if (findKeyword(statement1, "Pencil Lead",0) >=0 
						|| findKeyword(statement1, "A Watermelon", 0) >= 0 
						|| findKeyword(statement1, "A cloud",0) >=0 
						|| findKeyword(statement1, "A tennis ball",0) >=0 
						|| findKeyword(statement1, "An iPad",0) >=0 
						|| findKeyword(statement1, "1461",0) >=0 
						|| findKeyword(statement1, "Ground beef",0) >=0 
						|| findKeyword(statement1, "True friendship",0) >=0 
						|| findKeyword(statement1, "Lobster",0) >=0)
				{
				System.out.println("Correct!");
				occupant = x;
				x.keyTotal();
        		x.getKeys();
        		boolean key = true;
        		riddle = false;
					}
				}
				} while(riddle);
		}
		}
	
	private String getRandomRiddle()
	{
		Random r = new Random ();
		{	
			return riddles [r.nextInt(riddles.length)];
		}
	
	}
	
	//random riddles taken from a website
	private String [] riddles = {"I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody.",
									"You go at red and stop at green. What am I?", "What is easy to spot but hard to find?",
									"I fly without wings and cry without eyes. What am I?", "What can you serve but not eat?",
									"What is a frog’s favorite electronic device?","How many days are there in 4 years?",
									"What do you call a cow with no legs?",
									"What costs nothing but is very hard to find and can easily be lost?",
									"What goes into the water black and comes out red?"};
	
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
	
	//user can only leave if they have a key
	public void leaveRoom(Person p) {
		if (key == true) {
			Riddle x = new Riddle(xLoc, xLoc);
			x.leaveRoom(p);
			System.out.println("You have successfully obtained a key!");
		}
		else {
			Runner.gameOff();
		}
	}

	
	public void print()
	{
		if(explored == false && occupant == null)
		{
			System.out.print("[ ]");
		}
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
		else if(explored == true)
		{
			System.out.print("[R]");
		}
	}

	
}
