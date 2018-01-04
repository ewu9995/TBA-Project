package rooms;

import person.Person;

//Evan Wu TBA Project
public class EmptyRoom extends Room{

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
	}
	
}
