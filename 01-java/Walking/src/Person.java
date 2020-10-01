import com.rev.animal.*;

public class Person {
	private String name;
	private int age;
	private int ssn;
	private Animal p;

	public Person(String name, int age, int ssn, Animal p) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
		this.p = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Animal getP() {
		return p;
	}

	public void setP(Animal p) {
		this.p = p;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "Name is : " + name + "Age is : " + age + " Pets name is: ";
		return s;
	}

}
