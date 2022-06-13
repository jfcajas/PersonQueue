import java.util.Comparator;

public class CompareName implements Comparator<Person>{
	
	@Override
	public int compare(Person a, Person b) {
		
		return a.lastName.compareTo(b.lastName);
	}
}
