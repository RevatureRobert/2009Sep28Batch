
public class Constructors {
	
	int age;
	String name;
	
	Constructors(int x, String na){
		age = x;
		name = na;
	}
	Constructors() {
		System.out.println("This is the constructors class");
	}
	
	public static void main(String[] args) {
//		Constructors c = new Constructors(7, "go");
//		System.out.println(c.age);
		
		C2 c = new C2();
		System.out.println(c.age);
	}
}
