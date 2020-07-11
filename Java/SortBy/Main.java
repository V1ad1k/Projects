package lab9;
import java.util.ArrayList;
//import java.util.*;
import java.util.Collections;
import java.util.Locale;
import java.util.Vector;

import lab9.Student.eyeColor;

public class Main {
	public static void main(String[] args) {

		    Locale.setDefault(new Locale("pl","PL"));
		    Locale[] locales = Locale.getAvailableLocales();
		    ArrayList<String> langs = new ArrayList<String>();
		    for(Locale loc: locales) {
		      String  lng = loc.getDisplayLanguage();
		      if(!lng.trim().equals("") && ! langs.contains(lng)){
		        langs.add(lng);
		      }
		    }
		    Collections.sort(langs);
		    for(String str: langs){
		      System.out.println(str);
		    }
		Vector<Student> collection = new Vector<Student>();
		Student.add(new Student(20, "óvryliuk", eyeColor.black, 188), collection);
		Student.add(new Student(13, "zluev", eyeColor.black, 185), collection);
		Student.add(new Student(19, "Boichuk", eyeColor.brown, 180), collection);
		Student.add(new Student(1, "Klein", eyeColor.blue, 169), collection);
		Student.add(new Student(3, "Ploy", eyeColor.black, 130), collection);
		Student.add(new Student(2, "Kolt", eyeColor.blue, 300), collection);
		Student.toString(collection);
		System.out.println();
		//Sorting by ID
		Collections.sort(collection, new SortByID());
		Student.toString(collection);
		System.out.println();
		//Sorting by height
		Collections.sort(collection, new SortByHeight());
		Student.toString(collection);
		System.out.println();
		//Sorting by EyeColor and LastName
		Collections.sort(collection, new SortByEyeColor());
		Student.toString(collection);
		System.out.println();
		
		
	
		}
}
