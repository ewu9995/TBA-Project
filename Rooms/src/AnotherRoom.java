
public class AnotherRoom extends Room{

	public AnotherRoom(int x, int y)
	{
		super(x, y);
		
	}
	public void enterRoom(Person x)
	{
		System.out.println("This room is called another room. It is the other room. Find the other rooms and please GET OUT now.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
}
