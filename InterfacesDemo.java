package classDemos;

interface I1
{
	int d = 1;
	int d1 = 11;
	
	void f1();
	void f();
}
interface I2
{
	int d = 2;
	int d2 = 22;
	
	void f2();
	void f();
}

interface I3 extends I2, I1
{
	int d = 3;
	int d3 = 33;
	
	void f();
	void f3();
}

class A implements I1, I2
{

	@Override
	public void f2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void f1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}
	
}
class B implements I3
{
	int d = 4;

	@Override
	public void f2() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}

	@Override
	public void f1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void f3() {
		// TODO Auto-generated method stub
		
	}
	
	
}


public class InterfacesDemo{

	public static void main(String[] args) {
			B obj = new B();
			System.out.println(obj.d);
			
			A objA = new A();
			System.out.println(I1.d);
	}
}
