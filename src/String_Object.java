
public class String_Object {

	public static void main(String[] args) {
		
		//Definition: String is a Object that hold sequence of characters
		
		// String Literal (Type1)
		String s = "SMS ZUnaidul Khan Anthony";
		System.out.println("My name is (Literal): "+ s);
		
		System.out.println("********************************************");
		
		// String "New" (Type2)
		String s1 = new String("SMS ZUnaidul Khan Anthony");
		System.out.println("My name is (New): "+ s1);
		
		System.out.println("********************************************");
		
		// Split method
		String a = "ZUnaidul Khan Anthony";
		String[] splittedString = a.split(" ");
		System.out.println("Split String by space: "+ splittedString[0]);
		System.out.println("Split String by space: "+ splittedString[1]);
		System.out.println("Split String by space: "+ splittedString[2]);
		
		System.out.println("********************************************");
		
		// Trim method
		String b = "Anthony SMS Khan";
		String[] trimmedString = b.split("SMS");
		System.out.println("Split String by SMS: "+ trimmedString[0]);
		System.out.println("Split String by SMS: "+ trimmedString[1]);
		//Trim
		System.out.println("Split String by SMS: "+ trimmedString[1].trim() + " is trimmed");
		
		System.out.println("********************************************");
		
		//to print each character of the string
		for (int i = 0; i<s.length(); i++)
		{
			System.out.println("Printing each character: " + s.charAt(i));
		}
		
		System.out.println("********************************************");
		
		// **to print characters in reverse
		for (int i = s.length()-1 ; i > 0 ; i--)
		{
			System.out.println("Printing each character in reverse: " + s.charAt(i));
		}
		
	}

}
