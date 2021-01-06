import java.util.Scanner;

public class DebugClass1 {
	
	
	public int m1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size : ");
		int aSize = sc.nextInt();
		
		int [] a = new int[aSize];
		int sum = 0;
		
		System.out.println("Enter the array Elements :");
		for(int i=0; i<a.length; i++) {
			
			 a[i] = sc.nextInt();
			System.out.println("a[" +i+ "]=" + a[i]);
			sum = sum + a[i];
			
		}
		System.out.println("Sum of the array is : " + sum);
		return sum;
	}

	public static void main(String[] args) {
		
		DebugClass1 c1 = new DebugClass1();
		 int count= c1.m1();
		 
		 System.out.println("count is array is : " + count);

	}

}
