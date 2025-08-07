import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice2_Arrays {

	public static void main(String[] args) {
		
		int[] num = new int[3];
		num[0] =3;
		num[1] =6;
		num[2] =9;
		
		for(int i = 0; i<num.length; i++ )
		{
			System.out.println(num[i]);
		}
		
		System.out.println("********************************************");
		//This did not work
		for(int i = 0; i<num.length; i++ )
		{
			if(num[i] % 2 == 0);
			{
				System.out.println(num[i]);
			}
		}
		
		System.out.println("********************************************");
		
		String[] nameList = {"Zunaidul","Khan","Anthony"};
		List<String> newNameList = Arrays.asList(nameList);
		System.out.println(newNameList);
		System.out.println(newNameList.contains("Anthony"));
		
		System.out.println("********************************************");
		
		ArrayList<String> newlist = new ArrayList<String>();
		newlist.add("SMS");
		newlist.add("Anto");
		newlist.add("Hoque");
		
		 for(String a :newlist)
		 {
			 System.out.println(a);
		 }

	}

}
