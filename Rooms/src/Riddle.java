import java.util.Scanner;

public class Riddle extends Room{

	public Riddle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void enterRoom(Person x)
	{
		
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("Solve this riddle for a key or start over again:");
		System.out.println("I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody.");
		Scanner in = new Scanner(System.in);
		while(in.nextLine() == "Pencil Lead") {
			System.out.println("Correct!");
			
		}
		while(in.nextLine() != "Pencil Lead") {
			System.out.println("   _____          __  __ ______    ______      ________ _____  \r\n" + 
					"  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \r\n" + 
					" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\r\n" + 
					" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \r\n" + 
					" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \r\n" + 
					"  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
			System.out.println(" Looks like you've failed! Start over again!");
			Runner.gameOff();	
		}
	}
	public void leaveRoom(Person p) {
		System.out.println("You have successfully obtained a key!");
		
	}
}
