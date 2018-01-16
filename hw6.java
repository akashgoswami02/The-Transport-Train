import java.util.* ;
import java.io.* ;

public class hw6 {

	public static void main(String[] args) {
	
		//creates new Train
		Train t = new Train("New York", 10, 50, 3);
		
		Scanner input = null;
		
		//reads in input from file
		try {
			
			input = new Scanner( new FileInputStream("train_commands.txt"));
			String line;
		
			while(input.hasNextLine()) {
				
				line = input.nextLine();
				
				//determines what input says to do
				if (line.equals("PRINT")) {
					System.out.println(line);
					t.print();
				}
				else if (line.equals("ARRIVE")) {
					System.out.println(line);
					t.arrive();
				}
				else if (line.equals("DEPART")) {
					
					String destination = input.nextLine();
					System.out.println(line + " " + destination);
					t.depart(destination);
				}
				else if (line.equals("SPEEDUP")) {
					
					int toAdd = input.nextInt();
					System.out.println(line + " " + toAdd);
					t.speedUp(toAdd);
				}
				else if (line.equals("SLOWDOWN")) {
					
					int toSubtract = input.nextInt();
					System.out.println(line + " " + toSubtract);
					t.slowDown(toSubtract);
				}
				else if (line.equals("ADDCAR")) {
					
					String type = input.nextLine();
					int mcap = input.nextInt();
					
					System.out.println(line + " " + type + " " + mcap);
					
					t.addBoxcar(type, mcap);
				}
				else if (line.equals("REMOVECAR")) {
					
					int toRemove = input.nextInt();
					System.out.println(line + " " + toRemove);
					t.removeBoxcar(toRemove);
				}
				else if (line.equals("LOAD")) {
					
					String type = input.nextLine();
					int id = input.nextInt();
					
					if (type.equals("CARGO")) {
						
						String i = input.nextLine();
						i = input.nextLine();
						int h = input.nextInt();
						int w = input.nextInt();
						
						//System.out.println("i: " + i);
						//System.out.println("h: " + h);
						//System.out.println("w: " + w);
						
						System.out.println(line + " " + i + " " + h + " " + w);
						
						Cargo c =  new Cargo(i, h, w);
						t.load(id, c);
					}
					else {
						
						String g = input.nextLine();
						g = input.nextLine();
						String n = input.nextLine();
						int a = input.nextInt();
						
						System.out.println(line + " " + id + " " + g + " " + n + " " + a);
						
						Person p = new Person(g, n, a);
						t.load(id, p);
					}
				}
				else if (line.equals("UNLOAD")) {
					
					int bcID = input.nextInt();
					String ID = input.nextLine();
					ID = input.nextLine();
					
					System.out.println(line + " " + bcID + " " + ID);
					
					t.unload(bcID, ID);
				}
				else if (line.equals("QUIT"))
					System.out.println(line + '\n' + "Quitting...");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not open file train_commands.txt");
		}
	}
}
