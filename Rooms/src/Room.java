public abstract class Room {
	Person occupant;
	int xLoc,yLoc;
	
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}
	public void enterRoom(Person x)
	{
		System.out.println("You are moving around.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	public void leaveRoom(Person p) {
		// TODO Auto-generated method stub
		
	}
	public abstract void print();
	
}
