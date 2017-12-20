public class Board {
	private static Room [][] rooms;
	
	public Board (Room [][] rooms) {
		Board.rooms = rooms;
	}
	

	
	public Board(int size)	{
		Board.rooms=new Room[size][size];
	}
	
	public void printBoard() {
		for (Room[]i : rooms) {
			for(Room x : i) {
				x.print();
			} System.out.println();
		}
	}

		public Room[][] getBoard() {
			return rooms;
		}


		public void  setBoard(Room[][] rooms) {
			Board.rooms=rooms;
		}
		public String toString() {
			return "[ ]";
		}
	
}