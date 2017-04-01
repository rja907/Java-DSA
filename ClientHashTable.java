package classDemos;


public class ClientHashTable {

	public static void main(String[] args) {
		String[] arr = new String[] {"this","is","coding","world","this","is","this","world","is", "this"};
		HashTable<String, Integer> hashTable = new HashTable<String, Integer>(5);
		for(int i = 0; i < arr.length; i++)
		{
			if(hashTable.getValue(arr[i]) == null)
			{
				hashTable.put(arr[i],1);
			}
			else
			{
				hashTable.put(arr[i],hashTable.getValue(arr[i]) + 1);
			}
		}
		System.out.println(hashTable);
	}

}
