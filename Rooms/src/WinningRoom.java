public class WinningRoom extends Room {



	public WinningRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You turn the key and open the door");
		System.out.println("You see the light of day.");
		System.out.println("Congratulations! You have escaped!");
		Runner.gameOff();
	}
	
	

}
