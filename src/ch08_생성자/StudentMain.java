package ch08_생성자;

public class StudentMain {

	public static void main(String[] args) {
			
		Student s1 = new Student("김해원");
		System.out.println(s1);
		s1.name = "김해원";
		s1.age = 30;
		s1.address="부산진구";
		
		System.out.println(s1.name);
		System.out.println(s1.age);
		System.out.println(s1.address);
		
		Student s2 = new Student("김해원", 33, "부산시진구");
		System.out.println(s2.name);
		System.out.println(s2);

	}

}
