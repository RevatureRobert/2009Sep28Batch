import com.rev.animal.Animal;
import com.rev.animal.Cat;
import com.rev.animal.Dog;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat a = new Cat(3,"Kitty");
		Dog b = new Dog("Puppy", 3);
		Person p1 = new Person("Tim", 20, 232422233, a);

		Person p2 = new Person("Nina", 20, 232424553, b);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(a);
		System.out.println(b);
		a.meow();
		b.bark();
	}

}
