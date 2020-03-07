package polymorphism;

public class Pliers extends Cutter {
	private PliersType type;

	/**
	 * 
	 * @param size
	 * @param type
	 */
	public Pliers(int size, PliersType type) {
		super(size);
		this.type = type;
	}

	@Override
	public String cut() {
		return type + " cutting";
	}
}
