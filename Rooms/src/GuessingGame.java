import java.util.Scanner;

public class GuessingGame extends Room{
	public boolean key = false;	
	
	public GuessingGame(int x, int y) {
		super(x,y);
	}
	
	public void enterRoom(Person x)
	{
		
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("Solve this number guesssing game for a key.");
		guessingGame();
	}
	
	public void guessingGame() {

	            int number;

	            number = (int) (Math.random() * 999 + 1);           

	            Scanner x = new Scanner(System.in);

	            int guess;

	            do {

	                  System.out.print("Enter a guess (1-1000): ");

	                  guess = x.nextInt();

	                  if (guess == number) {

	                        System.out.println("Correct!");
	                        boolean key = true;
	                  }

	                  else if (guess < number) {

	                        System.out.println("Guess is larger.");}

	                  else if (guess > number) {

	                        System.out.println("Guess is samller.");}

	            } while (guess != number);

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

	}



