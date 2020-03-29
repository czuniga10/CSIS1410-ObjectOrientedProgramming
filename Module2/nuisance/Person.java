package nuisance;

/**
 * Class that instantiates a Person with the following functionality:
 * 		getName
 * 		getAge
 * 		toString
 * 
 * @author Chad Z
 */
public class Person {
	private String name;
	private int age;
	
	/**
	 * Creates instance of Person object between the ages of 1 > 150 with the
	 * following params.
	 * 
	 * @param name		Name of Person
	 * @param age		Age of Person
	 */
	public Person(String name, int age) {
		this.name = name;
		if(age >= 1 && age <= 150) {
			this.age = age;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the name of the Person.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the age of the Person.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + "("+ age + ")";
	}
}
