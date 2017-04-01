package classDemos;

public interface PriorityQueue<K extends Comparable<K>, V> {
	void add(K key, V value);
	V remove(); 
	V get(); 
	int size();
	boolean isEmpty();
}
