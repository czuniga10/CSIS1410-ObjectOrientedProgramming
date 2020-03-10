package phones;

/**
 * Dimension class that gives the Phones Dimensions more functionality
 * and provides a template for its size attributes
 * 
 * @author Chad Z
 */
public class Dimension {
	private double height;
	private double width;
	private double depth;
	
	/**
	 * Initializes Dimensions class with the needed attributes
	 * 
	 * @param height		height of phone
	 * @param width			width of phone
	 * @param depth			depth of phone
	 */
	public Dimension(double height, double width, double depth) {
		if(height <= 0 || width <= 0 || depth <= 0) {
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		} else {
			this.height = height;
			this.width = width;
			this.depth = depth;
		}
	}
	
	/**
	 * Returns height of the phone
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Returns the width of the phone
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Returns the depth of the phone
	 * 
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}
	
	@Override
	public String toString() {
		return String.format("(%.1f x %.1f x %.1f)",height, width, depth);
	}
}
