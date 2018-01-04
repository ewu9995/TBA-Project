public class Person {
	String firstName;
	String familyName;
	int xLoc, yLoc;
	public int keys = 0;
	
	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public Person (String firstName, String familyName, int xLoc, int yLoc, int keys)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.keys = keys;
	}


	public void print() {
		System.out.print("O");
		
	}
	
	public int getKeys() {
		return keys;
	}
	
	
	public void keyTotal()
	{
		this.keys = this.keys + 1;
	}

	public void leaveRoom() {
		// TODO Auto-generated method stub
		
	}
	
}
