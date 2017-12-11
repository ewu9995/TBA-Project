
public class MyRoom extends Room{
	
	public MyRoom(int x, int y)
	{
		super(x, y);
		
	}
	public void enterRoom(Person x)
	{
		System.out.println("HEY YOU GET OUT! THIS IS MY ROOM!!!!!!!!");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
	
}
