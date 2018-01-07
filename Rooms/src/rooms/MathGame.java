package rooms;

import java.util.Scanner;

import person.Person;

//Evan Wu TBA Project

public class MathGame extends Room{
	
	private boolean explored = false;
	private boolean math = true;
	
	public MathGame(int x, int y) {
		super(x,y);
	}

	public MathGame() {
		
	}
	
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		System.out.println("You enter this room");
		System.out.println("You see a bunch of symbols that look like this: X - +");
		System.out.println("There is a machine on the wall with a sign that reads: Solve a math problem and get a key or get teleported back to the beginning");
		System.out.println("Would you like to solve a problem? (Respond with yes or no)");
		explored=true;
		while (math) {
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine(); 
		//user choose b/w yes or no
		if (findKeyword(statement, "Yes", 0) >= 0) {
			int a = (int) (Math.random()*100);//random numbers generated
			int b = (int) (Math.random()*100); //random numbers generated
			System.out.println("You chose yes. Would you like to add, subtract, or multiply?");
			Scanner m = new Scanner (System.in);
			String statement1 = m.nextLine(); 
		//user chooses which type of math they want to solve (no division because of rounding issues)	
		if (findKeyword(statement1, "add", 0) >= 0)
			{	
				int c = a+b;
				System.out.println("What is: " + a + " + " + b + "?");
				int d = in.nextInt();
				if(d==c) {
					System.out.println("Correct! You get a key!");
            		x.keyTotal(); //adds keys
            		x.getKeys();
            		math = false;
            		}
				else { //if user gets the question wrong they get teleported back to the beginning
					x.setxLoc(0);
            		x.setyLoc(0);
					System.out.println("You got teleported back to the beginning!");
					math = false;
				}   
			}
		
		 else if (findKeyword(statement1, "subtract", 0) >= 0)
			{
			 int a1 = (int) (Math.random()*100);
			int b1 = (int) (Math.random()*100); 
			 int c = a1-b1;
			 System.out.println("What is: " + a1 + " - " + b1 + "?");
				int d = in.nextInt();
				if(d==c) {
				System.out.println("Correct! You get a key!");
         		x.keyTotal(); //adds keys
         		x.getKeys();
         		math = false;
				}
         		else {
         			x.setxLoc(0);
            		x.setyLoc(0);
					System.out.println("You got teleported back to the beginning!");
					math = false;
         			}
				}	
		
				else if (findKeyword(statement1, "multiply", 0) >= 0)
				{
					int a1 = (int) (Math.random()*100);
					int b1 = (int) (Math.random()*100); 
					int e = a1*b1;
					System.out.println("What is: " + a1 + " * " + b1 + "?");
					int f = in.nextInt();
					if(e==f) {
						System.out.println("Correct! You get a key!");
	         		x.keyTotal(); //adds keys
	         		x.getKeys();
	         		math = false;
					}
					else {
						x.setxLoc(0);
	            		x.setyLoc(0);
						System.out.println("You got teleported back to the beginning!");
						math = false;
						}
					}
				}
		
			//user leaves if if they respond with no
			if (findKeyword(statement, "no", 0) >= 0) {
				MathGame x3 = new MathGame();
				x3.leaveRoom(x);
				math = false;
			}
			}	
		}
	
	
	//first findKeyword statement used for yes/no
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
	
	//used because the first method does not work on a second question choice within a question
	private int findKeyword1(String statement1, String goal, int startPos)
	{
		String phrase = statement1.trim().toLowerCase();
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


//see rooms.DarkRoom.print() for comments
	public void print()
	{
		if(explored  == false && occupant == null)
		{
			System.out.print("[ ]");
		}
		
		else if(explored == true)
		{
			System.out.print("[+]");
		}
		
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
	}
	
}
