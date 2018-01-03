public class WinningRoom extends Room {



	public WinningRoom(int x, int y, int keys) {
		super(x, y, keys);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		x.setKeys(this.keys);
		System.out.println("You open the door");
		System.out.println("You see the light of day.");
		System.out.println("Congratulations! You have escaped!");
		Runner.gameOff();
	}
	

}
