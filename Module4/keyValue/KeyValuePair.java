package keyValue;

import java.util.Objects;

/**
 * @author Chad Z
 * @param <K>
 * @param <V>
 */
public class KeyValuePair<K, V> {
	private K key;
	private V value;
	
	/**
	 * @param key
	 * @param value
	 */
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof KeyValuePair))
			return false;
		KeyValuePair<?, ?> other = (KeyValuePair<?, ?>) obj;
		return Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
