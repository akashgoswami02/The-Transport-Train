import java.util.*;

public class Boxcar<T extends Thing> {

	private int maxLoad;
	private ArrayList<Thing> load;
	private int ID;
	
	public Boxcar(int mL, int id) {
		maxLoad = mL;
		load = new ArrayList<Thing>();
		ID = id;
	}
	
	public void setID(int newID) {
		ID = newID;
	}
	
	public boolean isEmpty() {
		return load.size() == 0;
	}
	
	public boolean isFull() {
		return load.size() == maxLoad;
	}
	
	public void print() {
		
		for (int i = 0; i < load.size(); i++) 
			load.get(i).print();
	}
	
	public void add(T toAdd) {
	
		//checks if boxcar is full
		if (load.size() == maxLoad)
			System.out.println("	ERROR: Not enough room for the given item.");
		
		//checks if this has already been loaded
		else {

			boolean loaded = false;
	
			
			
			for (int i = 0; i < load.size(); i++) {
				
				/*System.out.println("***********");
				System.out.println(load.get(i).getID());
				System.out.println(toAdd.getID());
				System.out.println("***********");*/
				
				if (load.get(i).getID().equals(toAdd.getID()))
					loaded = true;
			}
			
			if (loaded == false)
				load.add(toAdd);
			else
				System.out.println("	ERROR:  Invalid item, item with id " + toAdd.getID() + " already exists.");
		}
	}
	
	public void remove(String ID) {
		
		//checks if boxcar is empty
		if (load.size() == 0)
			System.out.println("	ERROR: Boxcar is empty");
		else {
			
			//searches load for correct id
			for (int i = 0; i < load.size(); i++) {
				
				if (load.get(i).getID().equals(ID)) {
					
					load.remove(i);
					return;
				}
			}
			
			System.out.println("	ERROR: Invalid item id, item not found");
		}
	}
}
