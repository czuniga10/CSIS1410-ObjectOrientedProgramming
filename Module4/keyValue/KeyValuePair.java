package keyValue;

import java.util.Objects;

/**
 * Similar to a Dictionary, the KeyValuePair class allows one to store data
 * where a Key of (mostly) any Type is matched with a Value of (mostly) any Type
 * and extends the Comparable Interface for easy comparability. 
 * 
 * @author Chad Z
 * @param <K>		Key
 * @param <V>		Value
 */
public class KeyValuePair<K extends Comparable<K>, V> implements Comparable<KeyValuePair<K,V>>{
	private K key;
	private V value;
	
	/**
	 * Initializes the KeyValuePair class with a key and value of (mostly) any
	 * type.
	 * 
	 * @param key		Key of KeyValuePair.
	 * @param value		Value of KeyValuePair.
	 */
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Returns the Key.
	 * 
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Returns the Value.
	 * 
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

	@Override
	public int compareTo(KeyValuePair<K, V> o) {
		if(this.key.hashCode() < o.getKey().hashCode()) {
			return -1;
		} else if(this.key.hashCode() > o.getKey().hashCode()) {
			return 1;
		} else {
			return 0;
		}
	}
}
