
public class StringDemo {
	public static void main(String[] args) 
	{
		String s1 = "Suchendra";
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf('c'));
		System.out.println(s1.hashCode());
		System.out.println(s1.startsWith("such"));
		System.out.println(s1.endsWith("cra"));
		System.out.println(s1.substring(2,6));
		System.out.println(s1);
		
		String s2 = new String("shaganti");
		System.out.println(s2);
		
		String s3 = "Suchendra";
		System.out.println(s1.equals(s3));
		System.out.println(s1.equalsIgnoreCase(s3));
		System.out.println(s1.contains(s3));
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.toLowerCase().contains(s3));
		
		s1 = s1 + s2;
		System.out.println(s1);
		System.out.println(s1.concat(s3));
		System.out.println(s1.isEmpty());
		System.out.println(s1.replace('S', 'J'));
		
		String s4 = " Suchendra";
		System.out.println(s3.equals(s4));
		System.out.println(s4);
		System.out.println(s4.trim());
		System.out.println(s3.equals(s4.trim()));
		
		System.out.println(s3.equalsIgnoreCase(s4.trim()));
		System.out.println(s3.toLowerCase().equals(s4.trim()));
		
		String s5 = "suchen dra shaganti";
		System.out.println(s5);
		 String [] str= s5.split(" ");
		 for(int i=0;i<str.length;i++)
		 {
			 System.out.println(str[i]);
		 }
		 System.out.println("_____________");
		 for(String s: str)
		 {
			 System.out.println(s);
		 }
	}

}
