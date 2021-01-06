
public class DebugClass2 extends DebugClass1
{

	public static void main(String[] args) {
		
		//if we want use the class1 methods in class 2 then that methods should be 
		//not inside the main method
		
		DebugClass2 c2 = new DebugClass2();
		c2.m1();
		
		
	}

}
