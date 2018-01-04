import java.util.Scanner;
public class DarkRoom extends Room {

	private boolean explored = false;
	private boolean darkroom = true;
	
	Scanner input = new Scanner(System.in);
	private boolean key;
	private Person x1;
	
	public DarkRoom(int x, int y) {
		super(x,y);
	}
	
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You've found this dark room...");
		System.out.println("Would you like to open it?");
		while(darkroom)
		{		
			Scanner in = new Scanner (System.in);
			String statement = in.nextLine();
			 do{
				 if (findKeyword(statement, "Yes", 0) >= 0)
			 
				{
					System.out.println( "The door suddenly locks behind you... You feel your way around the dark room... You find a sharp object -- it's a key!") ;
					int keys = 1;
	        		x.keyTotal(x.getKeys() +1);
	        		boolean key = true;
	        		darkroom = false;
		           
				}
			 else if (findKeyword(statement, "No", 0) >= 0)
				{
					System.out.println("Are you sure?");
					DarkRoom x3 = new DarkRoom(xLoc, xLoc);
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
	
	
	
	public void leaveRoom(Person p) {
		if (key) {
			DarkRoom x = new DarkRoom(xLoc, xLoc);
			x.leaveRoom(p);
			System.out.println("You have successfully obtained a key!");
		}
		else {
			Runner.gameOff();
		}
		
	}
	public void print()
	{
		if(explored  == false && occupant == null)
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
			System.out.print("[D]");
		}
	}

	
}
