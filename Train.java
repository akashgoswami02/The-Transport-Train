import java.util.*;

public class Train {

	private String originCity;
	private String destination;
	private int minSpeed;
	private int maxSpeed;
	private int currSpeed;
	private int boxcarLimit;
	private boolean isMoving;
	ArrayList<Boxcar<Thing>> boxcars;
	
	public Train(String oC, int min, int max, int bL) {
		
		originCity = oC;
		destination = null;
		minSpeed = min;
		maxSpeed = max;
		currSpeed = 0;
		isMoving = false;
		boxcars = new ArrayList<Boxcar<Thing>>();
		boxcarLimit = bL;
	}
	
	public void print() {
		
		System.out.println("	Train Status");
		System.out.println("	------------");
		System.out.println("	Current Speed: " + currSpeed);
		System.out.println("	Minimum Speed: " + minSpeed);
		System.out.println("	Maximum Speed: " + maxSpeed);
		System.out.print("	Current Position: ");
		if (isMoving)
			System.out.println("	Travelling from " + originCity + " to " + destination);
		else
			System.out.println("Train stopped in " + originCity);
		System.out.println("	Current Number of Boxcars: " + boxcars.size());
		System.out.println("	Maximum Number of Boxcars: " + boxcarLimit);
	
		for (int i = 0; i < boxcars.size(); i++) {
		
			System.out.println("Boxcar " + i);
			System.out.println("-----------");
			System.out.println("Contents:");
			boxcars.get(i).print();
		}
	}
	
	public void arrive() {
		
		//train stops moving and has reached destination
		currSpeed = 0;
		isMoving = false;
		originCity = destination;
		destination = null;
	}
	
	public void depart(String d) {
		
		//trains starts moving, has new origin, and gains destination
		isMoving = true;
		destination = d;
		currSpeed = minSpeed;
	}
	
	public void speedUp(int toAdd) {
		
		//checks if train is in motion
		if (isMoving) {
		
			//checks if speed goes over limit
			if (currSpeed + toAdd > maxSpeed)
				System.out.println("	ERROR: Speed can not be increased, it would exceed it's maximum speed.");
			else
				currSpeed += toAdd;
		}
		else
			System.out.println("	ERROR: The Train has not departed yet.");
	}
	
	public void slowDown(int toSubtract) {
		
		//checks if train is in motion
		if (isMoving) {
			
			//checks if speed goes below minimum
			if (currSpeed - toSubtract < 0)
				System.out.println("	ERROR: Speed can not be decreased, it would be less than it's minimum speed.");
			else
				currSpeed -= toSubtract;
		}
		else
			System.out.println("	ERROR: The Train has not departed yet.");
	}
	
	public void addBoxcar(String type, int cap) {
		
		//checks if boxcar limit is reached or if train is in motion
		if (boxcars.size()-1 > boxcarLimit || isMoving)
			System.out.println("	ERROR: Can't add boxcars");
		else {
			
			Boxcar toAppend ;
			
			if (type.equals("CARGO"))
				toAppend = new Boxcar<Cargo>(cap, boxcars.size()-1);
			else
				toAppend = new Boxcar<Person>(cap, boxcars.size()-1);
			
			boxcars.add(toAppend);
		}
	}
	
	public void removeBoxcar(int id) {
		
		//checks if size is 0 or if train is in motion
		if (boxcars.size() == 0 || id >= boxcars.size())
			System.out.println("	ERROR: Can't remove boxcars");
		else if (isMoving)
			System.out.println("	Error: The train has not arrived in " + destination + " yet");
		else {
			
			if (boxcars.get(id).isEmpty()) {
			
				boxcars.remove(id);
			
				//updates id for the other boxcars
				for (int i = id; i < boxcars.size(); i++)
					boxcars.get(i).setID(i);
			}
			else
				System.out.println("	ERROR: Boxcar " + id + ", is not empty");
		}
	}
	
	public void load(int id, Thing toLoad) {
	
		//checks if train is in motion
		if (isMoving)
			System.out.println("	ERROR: Can't load while moving");
		else {
			
			//checks if id is valid
			if (id >= boxcars.size())
				System.out.println("	ERROR: No such Boxcar");
			//checks if this boxcar is full
			else if (boxcars.get(id).isFull())
				System.out.println("	ERROR: Not enough room for the given item.");
			else
				boxcars.get(id).add(toLoad);
		}
	}
	
	public void unload(int boxcarID, String ID) {
		
		//checks if train is in motion
		if (isMoving)
			System.out.println("	ERROR: Can't unload while moving");
		else {
			
			//checks if boxcarID is valid
			if (boxcarID >= boxcars.size())
				System.out.println("	ERROR: Not a valid boxcar ID");
			
			else {
				boxcars.get(boxcarID).remove(ID);
			}
		}
	}
}
