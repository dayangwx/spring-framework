package tech.xiu.pojo;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Person {

//	@Autowired
	private Cat cat;

//	public void setCat(Cat cat) {
//		this.cat = cat;
//	}


	@Lookup
	public Cat getCat() {
		return null; // Spring will override this method to return a new Cat instance
	}

	private String name;

	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.name + "----" + this.age;
	}
}
