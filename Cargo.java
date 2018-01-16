public class Cargo extends Thing {

	private int height;
	private int weight;
	
	public Cargo(String c, int w, int h) {
		
		super(c);
		height = h;
		weight = w;
	}
	
	public void print() {
		System.out.println("	" + getID() + ":	Weight: " + weight + "	Height: " + height);
	}
}
