public class Room {
	Person occupant;
	int xLoc,yLoc;
	int keys;
	boolean key;
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
		x.setKeys(this.keys);
	}
	public void leaveRoom(Person p) {
		// TODO Auto-generated method stub
		
	}
	public void print()
	{
		if(explored == false && occupant == null)
		{
			System.out.print("[ ]");
		}
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
		else if(explored == true)
		{
			System.out.print("[X]");
		}
	}
}
