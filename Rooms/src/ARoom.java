
public class ARoom extends Room{

	
		public ARoom(int x, int y)
		{
			super(x, y);
			
		}
		public void enterRoom(Person x)
		{
			System.out.println("You enter a room. Get out.");
			occupant = x;
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
		}
		
		
	}



