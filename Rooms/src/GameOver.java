
public class GameOver extends Room{

	public GameOver(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You enter a room," + 
				   "\nsuddenly metal bars come out from the entrance," + 
				   "\nlocking you in, slowly the lights start to dim out " +
				   "You reached the end of your adventure... Better luck next time!");
		System.out.println("   _____          __  __ ______    ______      ________ _____  \r\n" + 
				"  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \r\n" + 
				" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\r\n" + 
				" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \r\n" + 
				" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \r\n" + 
				"  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
		System.out.println("  Uh-oh, you've fell into a trap and have died. Maybe start over?");
		Runner.gameOff();
	}
	
}
