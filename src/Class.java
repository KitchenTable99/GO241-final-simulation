
public class Class {
	
	private String id;
	
	public Class(boolean adv, int gradeYear, String subject) {
		id = "";
		id += gradeYear;
		id += subject;
		id += adv ? "1" : "0";
	}
	
	public Class(int randNum) {
		id = "" + randNum;
	}
	
	public String getID() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return this.getID().hashCode();
	}
	
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Class)) { 
            return false; 
        } 
          
        // typecast o to Class so that we can compare data members  
        Class c = (Class) o; 
          
        // Compare the data members and return accordingly  
        return c.getID().equals(this.getID()); 
    } 
	
	public String toString() {
		return id;
	}
	
	public static void main(String[] args) {
		Class descriptiveClass, basicClass;
		descriptiveClass = new Class(true, 9, "math");
		System.out.println("Descriptive: " + descriptiveClass.getID());
		basicClass = new Class(8);
		System.out.println("Basic: " + basicClass.getID());
	}

}
