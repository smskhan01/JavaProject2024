
public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] aray = new int[5];
		aray[0] = 1;
		aray[1] = 3;
		aray[2] = 5;
		aray[3] = 7;
		aray[4] = 9;
		//System.out.println(aray[3]);
		
		
		//For Loop
		for(int i = 0; i<aray.length; i++)
		{
			System.out.println(aray[i]);
		}
		
		String[] name = {"Shorif","Mohammed","Sultanul","Zunaidul","Khan"};
		
		for(int i = 0; i < 3; i++) 
		{
			System.out.println(name[i]);
		}
		
		for(String n : name)
		{
			System.out.println(n);
		}
		
	}

}
