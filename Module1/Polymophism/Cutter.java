package polymorphism;

public abstract class Cutter {
	private int size;

	/**
	 * Cutter represents a tool that cuts. Different Cutters cut differently
	 * 
	 * @param size
	 */
	public Cutter(int size) {
		this.size = size;
	}

	/**
	 * Initializes value of field size
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * returns a String that describes how the instantiated object cuts
	 * 
	 * @return		returns how this object cuts
	 */
	public abstract String cut();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " size= " + size;
	}
}
