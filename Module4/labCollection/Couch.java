package labCollection;

import java.awt.Color;
import java.util.Objects;

/**
 * Couch Class that initializes a Couch with the given parameters, and provides
 * functionality such as getters, equals, and toString. 
 * 
 * @author Chad Z
 */
public class Couch {
	private Color color;
	private Material material;
	
	/**
	 * Initializes Couch object with a given color and material.
	 * 
	 * @param color		Color of the couch.
	 * @param material	Material of the couch.
	 */
	public Couch(Color color, Material material) {
		this.color = color;
		this.material = material;
	}

	/**
	 * Returns the color of the Couch.
	 * 
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the material of the Couch.
	 * 
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, material);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Couch))
			return false;
		Couch other = (Couch) obj;
		return Objects.equals(color, other.color) && material == other.material;
	}

	@Override
	public String toString() {
		return String.format("Couch: #%02x%02x%02x %s", color.getRed(),color.getGreen(),color.getBlue(),material);
	}
}
