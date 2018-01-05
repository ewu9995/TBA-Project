package rooms;

import person.Person;

//Evan Wu TBA Project
public class EmptyRoom extends Room{
	
	private boolean explored = false ;
	

	public EmptyRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	public void enterRoom(Person x)
	{
		System.out.println("Just a empty room; Nothing to see here.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		explored = true;
	}
	
	//see rooms.DarkRoom.print() for comments
	public void print()
	{
		if(explored  == false && occupant == null)
		{
			System.out.print("[ ]");
		}
		else if(explored == true)
		{
			System.out.print("[E]");
		}
		
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
		
	}
	
}
