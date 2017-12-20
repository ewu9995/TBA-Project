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
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
	
	public void print() {
		if (!explored && occupant == null)
			{
			System.out.print("[ ]");
			}
		
			else if (occupant != null)
				{
			System.out.print("[X]");
		;}
			if (explored) {
			System.out.print("X");
				}
		}
}