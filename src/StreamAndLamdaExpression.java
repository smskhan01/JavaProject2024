import java.util.ArrayList;
import java.util.stream.Stream;
import org.testng.annotations.Test;

public class StreamAndLamdaExpression {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Snow");
		names.add("Anthony");
		names.add("Khan");
		names.add("Zunaidul");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				count++;
			}
		}
		System.out.println("The total names starts with 'A' from LOOP = " + count);

	}

	// Streams can only be declared as method
	// **To run a specific file use "@Test"
	// #1
	// @Test
	public void streamFilter() {
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Jane");
		names1.add("Snow");
		names1.add("Hello");
		names1.add("Earth");
		names1.add("World");

		ArrayList<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Snow");
		names.add("Anthony");
		names.add("Khan");
		names.add("Zunaidul");

		// Convert arraylist to stream names.stream()
		// Lamda expression left size parameter, right side action: s -> s.
		Long c = names1.stream().filter(s -> s.startsWith("A")).count();
		// data type of count is "Long"
		System.out.println(c);

		// create ArrayList which are Steams compatible
		Long d = Stream.of("John", "Snow", "Anthony", "Khan", "Zunaidul").filter(s -> s.startsWith("A")).count();
		System.out.println(d);

		// Length check names which has more than 4 letters use .length then story those
		// next sets of name using forEach final action
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// To limit results use .limit()
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

		// Merge 2 arrays to 1 array string --> Then sort and print out all names
		Stream<String> newNames = Stream.concat(names.stream(), names1.stream());
		newNames.sorted().forEach(s -> System.out.println(s));
	}

	public void streamMap() {
		// find the names that ends with letter "a" then convert those names to upper
		// case
		Stream.of("John", "Snow", "Anthony", "Khan", "Zunaidul").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Print name that has first letter with a and then sort them and then convert
		// those names to upper
		Stream.of("John", "Snow", "Anthony", "Khan", "Zunaidul").filter(s -> s.endsWith("A")).sorted()
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}
}
