package lab9;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
public class sortByName implements Comparator<Student>{
	
Collator col;
sortByName(){
	col=Collator.getInstance(new Locale("pl","PL"));
	col.setStrength(Collator.PRIMARY);
}
@Override
public int compare(Student s1, Student s2) {
	if(s1.getEyeColor().equals(s1.getEyeColor())) { 
		return col.compare(s1.getLastName(),  s2.getLastName());
	}
	return s1.getEyeColor().compareTo(s2.getEyeColor());
}

}
