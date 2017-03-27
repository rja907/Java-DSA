package classDemos;

public class ClientDynamicArray {

	public static void main(String[] args) {
		DynamicArray da = new DynamicArray(4);
		da.add(1);
		da.add(3);
		da.add(6);
		da.addAt(45, 2);
		da.add(34);
		da.display();
		da.removeAt(4);
		da.add(56);
		da.display();
		da.set(34, 5);
		da.display();
		System.out.println(da.getSize());
	}

}
