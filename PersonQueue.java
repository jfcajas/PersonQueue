

import java.util.LinkedList;
import java.util.Scanner;

public class PersonQueue {


	public static Person addNewPerson(Scanner scnr) {

		String firstName;
		String lastName;
		int age;
		
		System.out.println("Enter the person's first name: ");
		firstName = scnr.nextLine();
		System.out.println("Enter their last name: ");
		lastName = scnr.nextLine();
		System.out.println("Enter their age: ");
		age = Integer.parseInt(scnr.nextLine());
		Person person = new Person(firstName, lastName, age);
		System.out.println("Person added to queue\n");
		return person;
	}
	
	public static QueueClass<Person> viewQ(QueueClass<Person> q) {
		
		QueueClass<Person> copy = q.copy(q);
		
		for(Person p : copy) {
			System.out.println(p.info());
			q.enqueue(p);
		}
		return q;
	}
	
	public static LinkedList<Person> qToLL(QueueClass<Person> q){
		
		LinkedList<Person> sorter = new LinkedList<>();
		QueueClass<Person> copy = q.copy(q);
		
		for(Person p : copy) {
			sorter.add(p);
			q.enqueue(p);
		}
		
		return sorter;
		
	}
	
	public static QueueClass<Person> reQ(LinkedList<Person> ll){
		
		QueueClass<Person> sorted = new QueueClass<Person>();
		for (Person p : ll) {
			sorted.enqueue(p);
		}
		
		return sorted;
	}
	
	public static String emptyCheck(QueueClass<Person> q) {
		if (q.isEmpty()) {
			return "Yes";
		}
		else {
			return "No";
		}
	}
	
	public static void main(String[] args) {
		
		QueueClass<Person> myQ = new QueueClass<>();
			
		Scanner scnr = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter person #" + (i+1));
			myQ.enqueue(addNewPerson(scnr));
		}
		scnr.close();
		
		System.out.println("The queue is currently: ");
		viewQ(myQ);
		System.out.println();
		
		LinkedList<Person> ll = qToLL(myQ);
		SortingAlgorithms.quickSortName(ll, 0, ll.size() - 1);
		System.out.println("Name sort complete...");
		
		myQ = reQ(ll);
		System.out.println("The descending order name-sorted queue is: \n");
		viewQ(myQ);
		System.out.println();
		
		SortingAlgorithms.quickSortAge(ll, 0, ll.size()-1);
		System.out.println("Age sort complete...");
		
		myQ = reQ(ll);
		System.out.println("The descending order age-sorted queue is: \n");
		viewQ(myQ);
		System.out.println();
		
		System.out.println("Who is at the front of the queue?");
		System.out.println(myQ.getFront().info());
		System.out.println("Queue is moving... ");
		System.out.println("Up next... " + myQ.dequeue().info());
		System.out.println("Up next... " + myQ.dequeue().info());
		System.out.println("Up next... " + myQ.dequeue().info());
		System.out.println("Is the queue empty?" + " " + emptyCheck(myQ));
		System.out.println("Up next... " + myQ.dequeue().info());
		System.out.println("Up next... " + myQ.dequeue().info());
		System.out.println("Is the queue empty?" + " " + emptyCheck(myQ));
		
		}
		

	}


