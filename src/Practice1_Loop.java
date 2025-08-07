
public class Practice1_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = {"SMS","Zunaidul","Khan","Anthony", "Anto"};
		
		for (int i = 0; i < names.length ; i++) 
		{
			System.out.println(names[i]);
		}
		
		int[] randomNumbers = {1, 3, 5, 7, 9, 11};
		System.out.println(randomNumbers[3] + " is the selected No.");
		
		for (int b : randomNumbers)
		{
			System.out.println(b);
		}
	}

}
