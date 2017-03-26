package classDemos;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abc");
		al.add("rtyu");
		al.add("swf");
		al.add("ghjk");
		al.add("cvbn");
		al.add("qwerty");
		
		System.out.println(al.get(3));
		al.add(3, "changedValue");
		System.out.println(al.get(3));
		
		System.out.println("My Size is : "+ al.size());
 	}

}
