
public class ARoom extends Room{

	
		public ARoom(int x, int y)
		{
			super(int x, int y);
			
			
		}
		public void enterRoom(Person x)
		{
			System.out.println("You enter the room");
			occupant = x;
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
		}
		
		public void leaveRoom(Person x)
		{
			occupant = null;
		}
		public void leaveARoom(Person p) {
			// TODO Auto-generated method stub
			
		}
		
	}



