import java.util.Scanner;


public class Exercise10_09 {
  public static void main(String[] args) {
    
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("请输入要创建课程的门数:");
	    int coursenumber=input.nextInt();
	    CourseNew[] course1=new CourseNew[coursenumber+1];
	    
	    
	    for (int i=1; i<=coursenumber;i++) {
	    	System.out.print("请输入要创建的第"+i+"门课程的名称:");
			String b = input.next(); 
			course1[i] = new CourseNew(b); 
	    }
		
			//String c = input.next();
			//CourseNew course2 = new CourseNew(c); 
	    	
	
	    
	  
	//CourseNew course1 = new CourseNew("Data Structures");
    //CourseNew course2 = new CourseNew("Database Systems");

    /*
     
    course1.addStudent("Peter Jones");
   
    course1.addStudent("Brian Smith");
    course1.addStudent("Anne Kennedy");
    course1.addStudent("Susan Kennedy");
    course1.addStudent("John Kennedy");
    course1.addStudent("Kim Johnson");
    course1.addStudent("S1");
    course1.addStudent("S2");
    course1.addStudent("S3");
    course1.addStudent("S4");
    course1.addStudent("S5");
    course1.addStudent("S6");
    course1.addStudent("S7");
      
    course2.addStudent("Peter Jones");
    course2.addStudent("Steve Smith");
    
      */

	
	    
	    for (int i=1; i<=coursenumber;i++) {
	    	System.out.print("请输入选修第"+i+"门课程的学生数:");
			int k = input.nextInt();
		    System.out.print("请输入选修第"+i+"门课程的学生姓名:");
			for(int j=0;j<k;j++) {
		    String studentname=input.next();
		    course1[i].addStudent(studentname);
			}
		    
	    } 
	    
	    
	    
    System.out.println("Number of students in course1: "
      + course1[1].getNumberOfStudents());
    String[] students = course1[1].getStudents();
    for (int i = 0; i < course1[1].getNumberOfStudents(); i++)
      System.out.print(students[i] + ", ");
    
    System.out.println();
    System.out.println("Number of students in course2: "
      + course1[2].getNumberOfStudents());
    for (int i = 0; i < course1[2].getNumberOfStudents(); i++)
        System.out.print((course1[2].getStudents())[i] + ", ");
    
    System.out.println();
    
    course1[1].dropStudent("S1");
    System.out.println("Number of students in course1: "
      + course1[1].getNumberOfStudents());
    students = course1[1].getStudents();
    for (int i = 0; i < course1[1].getNumberOfStudents(); i++)
      System.out.print(students[i] + ", ");
    
    course1[1].clear();
    
    //System.out.println("\nNumber of students in course1: ")
    //  + course1.getNumberOfStudents());
  }
}

class CourseNew {
  private String name;
  private String[] students = new String[2];
  private int numberOfStudents;

  public CourseNew(String name) {
    this.name = name;
  }

  public void addStudent(String student) {
    if (numberOfStudents == students.length) {
      increaseSize();
    }

    students[numberOfStudents] = student;
    numberOfStudents++;
  }
  
  private void increaseSize() {
    String[] temp = new String[students.length * 2];
    System.arraycopy(students, 0, temp, 0, students.length);
    students = temp;
  }

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }
  
  /** Clear the course */
  public void clear() {
    for (int i = 0; i < numberOfStudents; i++) 
      students[i] = null;
    numberOfStudents = 0;
  }
  
  /** Remove a student from the course */
  public void dropStudent(String student) {
    for (int i = 0; i < numberOfStudents; i++) {
      if (students[i].equals(student)) {
        // Move students[i + 1] to students[i], etc.
        for (int k = i + 1; k < numberOfStudents; k++) {
          students[k - 1] = students[k];
        }
        
        numberOfStudents--;
        break;
      }
    }
  }
}
