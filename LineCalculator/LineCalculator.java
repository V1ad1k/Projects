
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class LineCalculator extends BasicCalculator{
	BasicCalculator k = new BasicCalculator();
	
	public static void main(String[] args) {
		LineCalculator l = new LineCalculator();
		
		System.out.println(l.calculate("mleko+chleb"));
	}
		
	public String calculate(String argument) {
		argument=argument.replaceAll("\\s","");
		String result=argument;
		System.out.println("u wrote: "+result);
		Pattern pat= Pattern.compile("\\d+[*]\\d+");
		Matcher m= pat.matcher(result);
		m.find();
		for(int i=1; i<99; i++) {
			try {
			result = result.replace(m.group(), k.calculate(m.group()));
			pat=Pattern.compile("\\d+[*]\\d+");
			m=pat.matcher(result);
			m.find();}
			catch(IllegalStateException e) {break;}
		}
		pat= Pattern.compile("\\d+[-]\\d+");
		m= pat.matcher(result);
		m.find();
		for(int i=1; i<99; i++) {
			try {
			result = result.replace(m.group(), k.calculate(m.group()));
			pat=Pattern.compile("\\d+[-]\\d+");
			m=pat.matcher(result);
			m.find();}
			catch(IllegalStateException e) {break;}
		}
		pat= Pattern.compile("\\d+[+]\\d+");
		m= pat.matcher(result);
		m.find();
		for(int i=1; i<99; i++) {
			try {
			result = result.replace(m.group(), k.calculate(m.group()));
			pat=Pattern.compile("\\d+[+]\\d+");
			m=pat.matcher(result);
			m.find();}
			catch(IllegalStateException e) {break;}
		}
		return result;
	}
	
}
