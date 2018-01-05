package rooms;

import person.Person;

public class MysteryRoom extends Room{
	
	private boolean explored = false;

	public MysteryRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void enterRoom(Person x)
	{
		System.out.println("You found a mysterious room.");
		System.out.println("There is a bright light inside -- you go check it out");
		occupant = x;
		explored = true;
		//sets player position to row = 0 and col = 0
		x.setxLoc(0);
		x.setyLoc(0);
		System.out.println("The bright light teleported you back to the start!");
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
			System.out.print("[M]");
		}
		
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
		
	}

}
