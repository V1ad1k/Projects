package lab9;
import java.util.Comparator;
import java.util.Locale;
import java.text.Collator;

public class SortByEyeColor implements Comparator<Student>{
	Collator col;
	 SortByEyeColor(){
		col = Collator.getInstance(new Locale("p1","PL"));
		col.setStrength(Collator.PRIMARY);
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getEyeColor().equals(o2.getEyeColor())) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
		else return o1.getEyeColor().compareTo(o2.getEyeColor());
	}

}
