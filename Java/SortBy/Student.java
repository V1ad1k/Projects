package lab9;

import java.util.HashSet;
import java.util.Vector;

public class Student{
	private int height = 180;
	private String lastName = "Student";
	private int idNumber = 99999;
	private static boolean isOk = true;
	private eyeColor ecolor;
	public enum eyeColor{
		blue, black, brown;
	}
	
	public Student(int i, String lastName, eyeColor ecolor, int height) {
		if(i>0 && i<1000000) {
			idNumber=i;
		}else isOk=false;
		if(lastName.contains("^[a-zA-Z]")) {
			isOk=false;
		}else this.lastName=lastName;
		if(height<100 || height>220) {
			isOk=false;
		}else this.height=height;
		this.ecolor=ecolor;
	}
	 public String getLastName() {
         return lastName;
    }
    public void setLastName(String studentname) {
    	this.lastName = studentname;
    }
    public int getIdNumber() {
    	return idNumber;
    }
    public void setIdNumber(int idNumber) {
    	this.idNumber = idNumber;
    }
    public int getHeight() {
    	return height;
    }
    public void setHeight(int height) {
    	this.height = height;
    }
    public void setEyeColor(eyeColor ecolor) {
    	this.ecolor=ecolor;
    }
    public eyeColor getEyeColor() {
    	return ecolor;
    }
	public static void toString(Student student) {
		System.out.println(student.idNumber+" "
				+student.lastName+" "
				+student.ecolor+" "
				+student.height);
	}
	public static void toString(Vector<Student> collection) {
		for(Student student: collection) {
			System.out.println(student.idNumber+" "
					+student.lastName+" "
					+student.ecolor+" "
					+student.height);
		}
	}
	public static void toString(HashSet<Student> collection) {
		for(Student student: collection) {
			System.out.println(student.idNumber+" "
					+student.lastName+" "
					+student.ecolor+" "
					+student.height);
		}
	}
	public static Vector<Student> add(Student student, Vector<Student> collection){
		boolean canAdd = true;
		for(Student s:collection) {
			if(s.idNumber == student.idNumber) {
				canAdd=false;
			}
		}
		if(isOk && canAdd) {
		collection.add(student);
		}
		return collection;
	}
	public static Vector<Student> add(Vector<Student> subCollection, Vector<Student> collection){
		for(Student student:subCollection) {
			if(Student.isOk == true) {
				add(student, collection);
				}
			}
		return collection;
	}
	public static HashSet<Student> add(Student student, HashSet<Student> collection){
		boolean canAdd = true;
		for(Student s:collection) {
			if(s.idNumber == student.idNumber) {
				canAdd=false;
			}
		}
		if(isOk && canAdd) {
		collection.add(student);
		}
		return collection;
	}
	public static HashSet<Student> add(HashSet<Student> subCollection, HashSet<Student> collection){
		for(Student student:subCollection) {
			if(Student.isOk == true) {
				add(student, collection);
				}
			}
		return collection;
	}
	
	
	
}
