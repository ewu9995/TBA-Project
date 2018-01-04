//Evan Wu TBA Project
import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;

	public static void main(String[] args)
	{
		
		System.out.println("Welcome to Escape Room: Apartment Edition. In this game you will explore random rooms."
				+ "\nThe objective of this game is to find the correct rooms and play games to collect the keys to escape or it's game over!");
		System.out.println("To begin, choose your board size.");
		System.out.println("\n");
		Room [][] building = chooseBoard();
		System.out.println("Good luck!");
		System.out.println("\n");
			
		//Fill the building with normal rooms
		for (int x = 0; x < building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new  Room(x,y);
			}
		}
		

		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		
		//game over room
		int x1 = (int)(Math.random()*building.length);
		int y1 = (int)(Math.random()*building.length);
		building[x1][y1] = new GameOver(x1, y1);
		
		int x2 = (int)(Math.random()*building.length);
		int y2 = (int)(Math.random()*building.length);
		building[x2][y2] = new Hallway(x2, y2);
		
	
		int x3 = (int)(Math.random()*building.length);
		int y3 = (int)(Math.random()*building.length);
		building[2][0] = new Riddle(x3, y3);
		
		int x4 = (int)(Math.random()*building.length);
		int y4 = (int)(Math.random()*building.length);
		building[0][1] = new DarkRoom(x4, y4);
		
		int x5 = (int)(Math.random()*building.length);
		int y5 = (int)(Math.random()*building.length);
		building[1][1] = new GuessingGame(x5, y5);
		
		
	
		Board map = new Board(building);
	
		 //Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0, 0);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
		
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc() + " keys = " + player1.getKeys());
				map.printBoard();
			}
			else {
				System.out.println("Please choose a valid move.");
			}
			
			
		}
		in.close();
	}
	

	
	public static Room[][] chooseBoard(){
	
		System.out.println("What size would you want your room to be? Large, medium, or small?(Please enter the choice word as it as)");
		Scanner x = new Scanner (System.in);
		String statement1 = x.nextLine();
		if (findKeyword(statement1, "large", 0) >= 0)
		{
			  Room[][] building = new Room[10][10];
			  return building;
		}
		if (findKeyword(statement1, "medium", 0) >= 0)
		{
			Room[][] building = new Room[8][8];
			return building;
		}
		if (findKeyword(statement1, "small", 0) >= 0)
		{
			Room[][] building = new Room[6][6];
			return building;
		}
		return null;	
		
		
	}
	private static int findKeyword(String statement, String goal,
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
	
	
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}
		
		
		
	public static void gameOff()
	{
		gameOn = false;
	}




}