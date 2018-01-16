
public abstract class Thing {

	private String ID;

	public Thing(String id) {
		ID = id;
	}
	
	public String getID() {
		return ID;
	}
	
	public abstract void print();
}
