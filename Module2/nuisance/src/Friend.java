package nuisance;

/**
 * Class that instantiates a Person as a Friend and gives the following 
 * functionality:
 * 		chill
 * 		play
 * 		toString
 * 
 * @author Chad Z
 */
public class Friend extends Person {
	private Hobby hobby;

	/**
	 * Creates instance of Friend object with the following params.
	 * 
	 * @param name		Name of Friend.
	 * @param age		Age of Friend.
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		this.hobby = hobby;
	}
	
	/**
	 * Returns String of who is chilling.
	 * 
	 * @return		Returns String 
	 */
	public String chill() {
		return String.format("%s is chilling", super.getName());
	}

	/**
	 * Returns String of the hobby being played along with the Friends
	 * who are playing as well.
	 * 
	 * @param friends	Array of Friend Objects
	 * @return			Returns String
	 */
	public String play(Friend[] friends) {
		String result = "playing " + hobby;
		if(friends.length == 0) {
			return result;
		}
		result += " with " + friends[0].getName();
		if(friends.length > 1) {
			for(int i = 1; i < friends.length; i++) {
				if(i == friends.length - 1 && friends.length <= 2) {
					result += " and ";
				} else if(i == friends.length - 1 && friends.length > 2) {
					result += ", and ";
				} else {
					result += ", ";
				}
				result += friends[i].getName() + "";
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + hobby;
	}

	
	
}
