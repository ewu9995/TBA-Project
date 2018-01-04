package rooms;

import person.Person;

public class MysteryRoom extends Room{

	public MysteryRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void enterRoom(Person x)
	{
		System.out.println("You found a mysterious room.");
		System.out.println("There is a bright light inside -- you go check it out");
		occupant = x;
		//sets player position to row = 0 and col = 0
		x.setxLoc(0);
		x.setyLoc(0);
		System.out.println("The bright light teleported you back to the start!");
	}

}
