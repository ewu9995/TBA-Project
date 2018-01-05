package rooms;
import java.util.Scanner;

import person.Person;
import runner.Runner;

//Evan Wu TBA Project
public class DarkRoom extends Room {

	private boolean explored = false;
	private boolean darkroom = true;
	
	Scanner input = new Scanner(System.in);

	
	public DarkRoom(int x, int y) {
		super(x,y);
	}
	
	//overloaded constructor
	public DarkRoom() {
	}
	
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		explored = true;
		System.out.println("You've found this mysterious room...");
		System.out.println("Would you like to open it? (Respond with yes or no)");
		while(darkroom)
		{		
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			 do{
				 if (findKeyword(statement, "Yes", 0) >= 0)
			 
				{
					System.out.println( "The door suddenly locks behind you... You feel your way around this dark room... You find a sharp object -- it's a key!") ;
	        		x.getKeys(); //adds keys
	        		x.keyTotal(); 
	        		darkroom = false;
	        		
		           
				}
			 else if (findKeyword(statement, "No", 0) >= 0)
				{
					System.out.println("You leave the room.");
					DarkRoom x3 = new DarkRoom();
					x3.leaveRoom(x);
					darkroom = false;

				}
			 } while(darkroom);
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
	

	//checks conditions to see how the room should be printed on the board
	public void print()
	{
		if(explored  == false && occupant == null) //explored and occupant is false
		{
			System.out.print("[ ]");
		}
		else if(explored == true) //explored is true; has to be before the condition after as if-else statements prints out first case that condition meets
		{
			System.out.print("[D]");
		}
		
		else if(occupant != null ) //occupant is true
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
	}
	
}
