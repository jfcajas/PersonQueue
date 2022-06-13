import java.util.Comparator;

public class CompareAge implements Comparator<Person>{
	
	@Override
	public int compare(Person a, Person b) {
		
		return a.age - b.age;
	}
}
