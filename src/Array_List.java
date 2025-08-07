import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_List {

	public static void main(String[] args) {
		
		//Regular
		//String[] nameList = {"Shorif","Mohammed","Sultanul","Zunaidul","Khan"};
		// *OR*
		//int[] aray = new int[1];
		//aray[0] = 1;
		
		//ArrayList -- Use this when you dont know how many indexes are needed to create
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("SMS");
		a.add("Zunaidul");
		a.add("Khan");
		a.add("Anthony");
		a.add("Anto");
		a.remove(4);
		a.add("Selenium");
		
		for(String i : a);
		{
			System.out.println(a);
		}
		
		System.out.println("***********");
		
		for(int i = 0; i < a.size(); i++) 
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("***********");
		
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i) == "Selenium") {
			System.out.println("This name is with if statement " + "'" + a.get(i) + "'");
			}
		}
		
		System.out.println("***********");
		
		//Contains
		System.out.println(a.contains("Selenium")); // True
		
		//---------------------------------------------------------
		
		//Convert regular Array to ArrayList
		String[] nameList = {"Shorif","Mohammed","Sultanul","Zunaidul","Khan"};
		//****
		List<String> newName = Arrays.asList(nameList);
		System.out.println(newName.contains("Zunaid")); // False
	}
}
