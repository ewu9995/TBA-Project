import java.util.Scanner;

public class GuessingGame extends Room {
	public boolean key = false;
	private boolean explored = false;
	private boolean guess1 = true;
	
	public GuessingGame(int x, int y) {
		super(x,y);
	}
	
	public void enterRoom(Person x)
	{
		
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		x.setKeys(this.keys);
		System.out.println("You've found a room filled with numbers...");
		System.out.println("You think to yourself: Math!?!!!");
		System.out.println("You look around for clues on how to escape....");
		System.out.println("You find a machine that reads: Solve this number guesssing game for a key.");
		while (guess1) {
			int number;
            number = (int) (Math.random() * 10 + 1);           
            Scanner a = new Scanner(System.in);
            int guess;
            do {
                  System.out.print("Enter a number from 1-1000 ");
                  guess = a.nextInt();
                  if (guess == number) {
                		System.out.println("Correct!");
    					int keys = 1;
                		x.keyTotal(x.getKeys()+1);
                		boolean key = true;
                		guess1 = false;
    					
                  }
                  else if (guess < number) {
                        System.out.println("Guess is larger.");}
                  else if (guess > number) {
                        System.out.println("Guess is smaller.");}
            } while (guess != number);
      }
		
	}

	

	public void leaveRoom(Person p) {
		if (key == true) {
			GuessingGame x = new GuessingGame(xLoc, xLoc);
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
		else if(explored  == true)
		{
			System.out.print("[G]");
		}
	}

	
	}



