package rooms;

import person.Person;

//Evan Wu TBA Project
public class StaffRoom extends Room{

	public StaffRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void enterRoom(Person x)
	{
		System.out.println("You try to open the door.");
		System.out.println("It's locked.");
		System.out.println("You bang on it.");
		System.out.println("Someone opens the door -- it's an escape room staff member.");
		System.out.println("You think to yourself: Wow I'm so stupid, how did I not see the sign that reads STAFF ROOM.");
		System.out.println("You sadly leave after begging for a key and not getting one.");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}
	
}
