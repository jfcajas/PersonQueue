
public class Person {
		protected String firstName;
		protected String lastName;
		protected int age;
		
		public String info() {
			return firstName + " " + lastName + ", age " + age;
		}
		
		public String getName() {
			return firstName + " " + lastName;
		}
		
		public String getFirstName() {
			return firstName;			
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public int getAge() {
			return age;
		}
		
		public int setAge(int age) {
			this.age = age;
			return age;
		}
		
		public String setFirstName(String firstName) {
			this.firstName = firstName;
			return firstName;
		}
		
		public String setLastName(String lastName) {
			this.lastName = lastName;
			return lastName;
		}
		
		public String setName(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			return firstName + " " + lastName;
		}
		
		Person(){
			firstName = "Default";
			lastName = "Name";
			age = 0;
		}
		
		Person(String firstName, String lastName, int age){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
}
