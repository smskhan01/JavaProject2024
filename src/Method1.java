
public class Method1 {

	public static void main(String[] args) {
		
		// Need to declare Object first if its NOT "static void"
		Method1 a = new Method1();
		a.getData();
				
		System.out.println("********************************************");		
		
		// To call "static" no need to declare object
		getData1();
		
		System.out.println("********************************************");
		
		// To call method from different class, need to declare object
		Method2 b = new Method2();
		b.getData3();

		System.out.println("********************************************");
		
		// to get String return values:
		Method1 d = new Method1();
		String name = d.myName();
			System.out.println("4. I am calling an Sring return method within this class: " + name);
		
		System.out.println("********************************************");
		
		// to call int return values:
		Method1 c = new Method1();
		int age = c.myAge();
			System.out.println("5. I am calling an int return method within this class: " + age);		

	}
	 // This can be called outside this class
	// Void without int or String will only executes piece of code
	public void getData()
	{
		System.out.println("1. This VOID text is returned from within same class. This requires object creation");
	}
	
	public String myName()
	{
		return "Anthony Khan";
	}
	
	//Need to declare int if method is returning number (for string declare "String")
	public int myAge()
	{
		return 21;
	}
	
	//When Static is used, this can only be called in this class
	public static void getData1()
	{
		System.out.println("2. This text is just 'static void' returned from with in this class, this does not require object creation");
	}

}