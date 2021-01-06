import java.util.Scanner;

public class ArrayDemo3 {

	public static void main(String[] args) {
		
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
				

	}

}