import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Student {
	
	private int idNum, classYear;
	private HashSet<Class> classes;
	private Random rand;
	
	public Student(int idNum, int classYear) {
		this.classYear = classYear;
		this.idNum = idNum;
		// decide if in advanced track or not
		rand = new Random();
		classes = new HashSet<Class>();
		classes.add(new Class(rand.nextBoolean(), this.classYear, "math"));
		classes.add(new Class(rand.nextBoolean(), this.classYear, "english"));
		classes.add(new Class(rand.nextBoolean(), this.classYear, "history"));
		// add three random classes
		ArrayList<Integer> classIDs = new ArrayList<Integer>();
		while (classIDs.size() < 3) {
			int attempt = rand.nextInt(47);
			if (!classIDs.contains(attempt)) {
				classIDs.add(attempt);
			}
		}
		for (int i : classIDs) {
			classes.add(new Class(i));
		}
		
	}
	
	public int getID() {
		return idNum;
	}
	
	public int getYear() {
		return classYear;
	}
	
	public HashSet<Class> getClasses() {
		return classes;
	}
	
	public static void main(String[] args) {
		Student s1, s2, s3, s4;
		s1 = new Student(23, 9);
		s2 = new Student(45, 10);
		s3 = new Student(1, 11);
		s4 = new Student(601, 12);
		System.out.println(s1.getClasses());
		System.out.println(s2.getClasses());
		System.out.println(s3.getClasses());
		System.out.println(s4.getClasses());
	}

}
