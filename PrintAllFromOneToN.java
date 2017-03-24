package classDemos;
import java.util.Scanner; 

public class PrintAllFromOneToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = s.nextInt();
		
		int i = 1;
		while(i <= n)
		{
			System.out.print(i+ " ");
			i = i + 1;
		}
	}

}
