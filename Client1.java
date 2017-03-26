package classDemos;

class GP
{
	public GP()
	{
		System.out.println("Ctor : GP");
	}
}
class P extends GP
{
	int d1 = 100;
	int d = 0;
	public P()
	{
		System.out.println("Ctor : P");
	}
	
	public void f1()
	{
		System.out.println("P : f1");
	}
	public void f()
	{
		System.out.println("P : f");
	}
}

class C extends P
{
	int d2 = 34;
	int d = -1;
	public C()
	{
		System.out.println("Ctor : C");
	}
	
	public void f2()
	{
		System.out.println("C : f2");
	}
	public void f()
	{
		System.out.println("C : f");
	}
	
}
public class Client1 {

	public static void main(String[] args) {
		System.out.println("---------CASE 1----------");
		P obj = new P();
		obj.f1();
		obj.f();
		System.out.println(obj.d);
		System.out.println(obj.d1);
		
		System.out.println("---------CASE 2----------");
		P obj2 = new C();
		obj2.f1();
		obj2.f();
		System.out.println(obj2.d);
		System.out.println(obj2.d1);
		
		
		//System.out.println("---------CASE 3----------");
		//C obj3 = new P();
		
		System.out.println("---------CASE 4----------");
		C obj3 = new C();
		obj3.f1();
		obj3.f();
		obj3.f2();
		System.out.println(obj3.d);
		System.out.println(obj3.d1);
		System.out.println(obj3.d2);
	}

}
