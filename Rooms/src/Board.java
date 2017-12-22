import java.util.Scanner;

public class Board {
	private static Room [][] rooms;
	
	public Board (Room [][] rooms) {
		Board.rooms = rooms;
	}
	

	
	public Board(int size)	{
		 	Board.rooms=new Room[size][size];
	}
	
	
	public static Room[][] chooseBoard(String statement){
		Scanner in = new Scanner(System.in);
		System.out.println("What size would you want your room to be? Large, medium, or small?");
		String response = "";
		if (findKeyword(statement, "large", 0) >= 0)
		{
			return Board.rooms= new Room[20][20];
		}
		if (findKeyword(statement, "medium", 0) >= 0)
		{
			return Board.rooms= new Room[14][14];
		}
		if (findKeyword(statement, "small", 0) >= 0)
		{
			return Board.rooms= new Room[8][8];
		}
		return null;	
		
	}
	
	private static int findKeyword(String statement, String goal, int startPos)
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
	
	
	public void printBoard() {
		for (Room[]i : rooms) {
			for(Room x : i) {
				x.print();
			} System.out.println();
		}
	}

		public Room[][] getBoard() {
			return rooms;
		}


		public void  setBoard(Room[][] rooms) {
			Board.rooms=rooms;
		}
		public String toString() {
			return "[ ]";
		}
	
}