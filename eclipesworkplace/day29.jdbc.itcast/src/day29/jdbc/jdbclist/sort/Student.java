package day29.jdbc.jdbclist.sort;

public class Student {
	private int id;
	private String studentname;
	private int grade;
	public Student(int id, String studentname, int grade) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.grade = grade;
	}
	public Student(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", grade=" + grade + "]";
	}
	

}
