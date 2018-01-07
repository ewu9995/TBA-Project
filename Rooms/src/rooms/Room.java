package rooms;
import person.Person;

//Evan Wu TBA Project

//This room is used as empty space (things like hallways)
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
	
	//overloaded constructor
	public Room()
	{
		
	}
	
	public void enterRoom(Person x)
	{
		System.out.println("You are moving around.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		explored = true;
	}
	public void leaveRoom(Person p) {
		// TODO Auto-generated method stub
		
	}
	
	//prints out the room (taken from class discussion)
	//see rooms.DarkRoom.print() for detailed comments
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
			System.out.print("[ ]");
		}
		
		
	}
}
