package lab9;

import java.util.Comparator;

public class SortByID implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getIdNumber() - o2.getIdNumber();
	}

}
