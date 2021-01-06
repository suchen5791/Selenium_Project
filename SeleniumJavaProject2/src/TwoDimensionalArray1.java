
public class TwoDimensionalArray1 {

	public static void main(String[] args) {
		
		//int[] a = {10,20,30,40};
		int [][] p = 
			{
				{1,2,3,4},
				{5,6,},
				{9,10,11}
				
		    };
		//for Loop
		for(int i=0;i<p.length;i++)
		{
			for(int j=0;j<p[i].length;j++)
			{
				System.out.print(p[i][j]+ "  " );
			}
			System.out.println();
			}
		
		//for each loop
		for(int k[] :p)
		{
			for(int l :k)
			{
				System.out.print(l+"  ");
			}
			    System.out.println();
		}
		

	}

}
