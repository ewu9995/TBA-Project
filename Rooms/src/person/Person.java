package person;

//Evan Wu TBA Project
public class Person {
	
	String name;
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

	public Person (String name, int yLoc, int keys, int xLoc)
	{

		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.keys = keys;
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print() {
		System.out.print("O"); //user will appear as [O] sometimes
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
