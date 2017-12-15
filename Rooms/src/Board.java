
public class Board {
	private Room [][] rooms;
	private Room[][] map;
	public Board (Room [][] rooms) {
		this.rooms = rooms;
	}
	
	public Board(int size)	{
		this.rooms=new Room[size][size];
	}
	
	public void printBoard() {
		for (Room[]i : rooms) {
			for(Room x:i) {
				x.print();
			} System.out.println();
		}
	}
	
	
	 public Room[][] getMap() {
	        return getMap();
	    }

	    public void setMap(Room[][] Map) {
	        this.map = map;
	    }
	
}
