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
		System.out.println("The door locks behind you.... Is this is trap?");
		System.out.println("Someone's voice: You found the winning room. Here's an imaginary reward. *gives reward* ");
		Runner.gameOff();
	}
	

}
