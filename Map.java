package shared;

public interface Map<K, V> {
	int size();
	boolean isEmpty();
	void put(K key, V value);
	V getValue(K key);
	V remove(K key);
}
