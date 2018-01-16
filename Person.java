public class Person extends Thing {

	private String name;
	private int age;
	
	Person(String g, String n, int a) {
		
		super(g);
		name = n;
		age = a;
	}
	
	public void print() {
		System.out.println("	" + getID() + ":	Name: " + name + "	Age: " + age);
	}
}
