
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
	
	
	 public Room[][] getMap(Room[][] Map, Room[][] map) {
	        return getMap(map, map);
	    }

	    public void setMap(Room[][] Map, Room[][] map) {
	        this.map = map;
	    }

		public Room[][] getMap() {
			return map;
		}

		public void setMap(Room[][] map) {
			this.map = map;
		}

	
}
