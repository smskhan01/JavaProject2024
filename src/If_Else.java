
public class If_Else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ranNum = {1,2,3,4,5,6,7,8,9,0,10};
		
		for (int i = 0; i < ranNum.length; i++)
		{
			if(ranNum[i] % 2 == 0) {
			System.out.println(ranNum[i] + " is even number");
			break;
			}
			else {
				System.out.println(ranNum[i] + " is not an even number");
			}
		}
	}
}
