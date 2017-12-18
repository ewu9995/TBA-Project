public class Room {
	Person occupant;
	int xLoc,yLoc;
	private boolean explored = false;
	
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
	public void print() {
	if (!explored && occupant == null)
		{
		System.out.print("[ ]");
		}
	
		else if (occupant != null)
			{
		System.out.print("[");
		occupant.print();
	
		System.out.println("]");}
		if (explored) {
		System.out.println("X");
			}
	}
}
