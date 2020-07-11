package lab9;

import java.util.Comparator;

public class SortByHeight implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getHeight() - o1.getHeight();
	}

}
