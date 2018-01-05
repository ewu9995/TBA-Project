package rooms;

import person.Person;

//Evan Wu TBA Project

public class StaffRoom extends Room{

	private boolean explored = false;
	
	public StaffRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void enterRoom(Person x)
	{
		System.out.println("You see a door with the words STAFF ROOM written on it, but you ignore it.");
		System.out.println("You try to open the door.");
		System.out.println("It's locked.");
		System.out.println("You bang on it.");
		System.out.println("BANG");
		System.out.println("Someone opens the door -- it's an escape room staff member.");
		System.out.println("You think to yourself: Wow I'm so stupid, how did I not see the sign that reads STAFF ROOM.");
		System.out.println("You sadly leave after begging for a key and not getting one.");
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
			System.out.print("[S]");
		}
		
		else if(occupant != null)
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
	}
	
}
