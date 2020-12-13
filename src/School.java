import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class School {
	
	public static HashSet<Class> sameClasses(Student s1, Student s2) {
		HashSet<Class> foo = (HashSet<Class>) s1.getClasses().clone();
		foo.retainAll(s2.getClasses());
		return foo;
		
	}
	
	public static void main(String[] args) {
		
		// create students
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 9; i < 13; i++) {
			for (int j = 0; j < 678; j++) {
				students.add(new Student(j, i));
			}
		}
		
		ArrayList<ArrayList<Student>> cohortList = new ArrayList<ArrayList<Student>>();
		
		// create collections
		while (students.size() > 20) {
			// init a new cohort
			ArrayList<Student> cohort = new ArrayList<Student>();
			
			// find the classes for the cohort
			HashSet<Class> sharedClasses = new HashSet<Class>();
			Student lead = students.get(0);
			int secondStudentIndex = 0;
			foundClasses:
			for (int i = 1; i < students.size(); i++) {
				HashSet<Class> foo = sameClasses(lead, students.get(i));
				// if they share 3 or more classes
				if (foo.size() >= 3) {
					secondStudentIndex = i;
					// get 3 shared classes and break
					Iterator<Class> it = foo.iterator();
					for (int j = 0; j < 3; j++) {
						sharedClasses.add(it.next());
					}
					break foundClasses;
				}
			}
			
			// create cohort
			cohort.add(lead);
			cohort.add(students.get(secondStudentIndex));
			for (int i = secondStudentIndex + 1; i < students.size(); i++) {
				// cohort full
				if (cohort.size() == 16) {
					break;
				}
				// check for same classes
				Student focusStudent = students.get(i);
				HashSet<Class> foo = sameClasses(lead, focusStudent);
				if (foo.containsAll(sharedClasses)) {
					cohort.add(focusStudent);
				}
			}
			
			// remove cohorted students and add cohort to cohorts list
			cohortList.add(cohort);
			for (Student s : cohort) {
				students.remove(s);
			}
			
		}
		System.out.println("SUCCESS: you have made it through the cohort phase.");
		for (ArrayList<Student> cohort : cohortList) {
			System.out.println(cohort);
		}
		System.out.println(cohortList.size());
		
		
		
		
	}

}
