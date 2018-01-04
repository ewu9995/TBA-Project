public class WinningRoom extends Room {

private boolean winning = true;

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
		boolean i = (x.getKeys() >= 2);
		while (winning) {
		if(i) {
		System.out.println("You open the door");
		System.out.println("You see the light of day.");
		System.out.println("Congratulations! You have escaped!");
		Runner.gameOff();
	}
		else {
			System.out.println("You don't have enough keys, try again!");
			Room r = new Room(keys, keys);
			r.enterRoom(x);
		}
			
	}

}
}
