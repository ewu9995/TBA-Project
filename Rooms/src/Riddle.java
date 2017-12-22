import java.util.Scanner;

public class Riddle extends Room{

public boolean key = false;	
	
	public Riddle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void enterRoom(Person x)
	{
		
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You've found a riddle room...");
		System.out.println("A text reads: Solve this riddle for a key or start over again:");
		System.out.println("I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody.");
		
	}
	
		Scanner in = new Scanner(System.in);
		private boolean explored = false;
		public void getResponse(String statement) throws Exception
		{
			String response = "";
			if (findKeyword(statement, "Pencil Lead", 0) >= 0)
		{
			response = "Correct";
			boolean key = true;
		}
			else
				response = "\"   _____          __  __ ______    ______      ________ _____  \\r\\n\" + \r\n" + 
						"					\"  / ____|   /\\\\   |  \\\\/  |  ____|  / __ \\\\ \\\\    / /  ____|  __ \\\\ \\r\\n\" + \r\n" + 
						"					\" | |  __   /  \\\\  | \\\\  / | |__    | |  | \\\\ \\\\  / /| |__  | |__) |\\r\\n\" + \r\n" + 
						"					\" | | |_ | / /\\\\ \\\\ | |\\\\/| |  __|   | |  | |\\\\ \\\\/ / |  __| |  _  / \\r\\n\" + \r\n" + 
						"					\" | |__| |/ ____ \\\\| |  | | |____  | |__| | \\\\  /  | |____| | \\\\ \\\\ \\r\\n\" + \r\n" + 
						"					\"  \\\\_____/_/    \\\\_\\\\_|  |_|______|  \\\\____/   \\\\/   |______|_|  \\\\_\\\\\"";
				System.out.println(" Looks like you've failed! Start over again!");
				Runner.gameOff();	
		
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
		if (key == true) {
			Riddle x = new Riddle(xLoc, xLoc);
			x.leaveRoom(p);
		}
		System.out.println("You have successfully obtained a key!");
		
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
