
public class Hallway extends Room{

	public Hallway(int x, int y) {
		super(x,y);
	}
	public void enterRoom(Person x)
	{
		System.out.println("You are moving around the hallway.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
	public void print() {

		System.out.print("[H]");
		}

}
