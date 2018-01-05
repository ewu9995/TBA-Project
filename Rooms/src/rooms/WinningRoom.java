package rooms;
import person.Person;
import runner.Runner;

//Evan Wu TBA Project
public class WinningRoom extends Room {

private boolean winning = true;
private boolean explored = false;

	public WinningRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		explored = true;
		boolean i = (x.getKeys() >= 3); //three keys needed to escape; couldnt convert int to boolean so created a new boolean 
		while (winning) {
		if(i) {
		System.out.println("You have the needed amount of keys to open the door with: " + x.getKeys());
		System.out.println("You open the door");
		System.out.println("You see the light of day.");
		System.out.println("Congratulations! You have escaped! ヽ(´ー｀)ノ");
		Runner.gameOff();
		winning = false;
		}
		//error message if user does not have enough keys
		else {
			System.out.println("You don't have enough keys, try again! (3 or more keys needed!)");
			Room r = new Room(keys, keys);
			r.enterRoom(x);
			winning = false;
			}	
		}
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
			System.out.print("[W]");
		}
		
		else if(occupant != null )
		{
			System.out.print("[");
			occupant.print();
			System.out.print("]");
		}
	}
	
}
