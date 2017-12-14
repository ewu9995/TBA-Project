
public class Board {
	private Room [][] rooms;
	public Board (Room [][] rooms) {
		this.rooms = rooms;
	}
	
	public void printBoard() {
		for (Room[]i : rooms) {
			for(Room x:i) {
				x.print();
			} System.out.println();
		}
	}
	
	
}
