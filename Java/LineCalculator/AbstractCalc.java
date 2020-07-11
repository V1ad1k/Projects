
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCalc {
  public abstract String calculate(String argument);

  {

    /*
     * the format of the argument: operand operator operand possible operators are:
     * + for sum * for product - for difference
     */

  }

  protected boolean isInteger(String s) {
    Pattern pat = Pattern.compile("^\\d+$");
    Matcher m = pat.matcher(s);
    return (m.find());
  }

  protected boolean isFoatingPoint(String s) {
    Pattern pat = Pattern.compile("^\\d+.\\d+$");
    Matcher m = pat.matcher(s);
    return (m.find());
  }

  public abstract int sum(int k1, int k2);

  // returns k1 + k2

  public abstract double sum(double k1, double k2);

  // returns k1 + k2

  public abstract String sum(String k1, String k2);

  // returns strings with all words in k1 or k2 or in both of them

  public abstract int product(int k1, int k2);

  // returns k1 * k2

  public abstract double product(double k1, double k2);

  // returns k1 * k2

  public abstract String product(String k1, String k2);

  // returns string with all words in k1 AND k2 or in both of them

  public abstract int difference(int k1, int k2);

  // return int abs;

  public abstract double difference(double k1, double k2);

  // return double abs;

  public abstract String difference(String k1, String k2);
  // returns string with all words in k1 but not k2
}

class BasicCalculator extends AbstractCalc {

	public String calculate(String argument) {
		String result = argument;
		argument=argument.replaceAll("\\s","");
		System.out.println("stage: " + argument);
		Pattern pat= Pattern.compile("[*]");
		Matcher m= pat.matcher(argument);
		if(m.find()) {
			String[] ar1 = argument.split("[*]");
			if(isInteger(ar1[0]) && isInteger(ar1[1])) {
				int result1 = ((product(Integer.valueOf(ar1[0]), Integer.valueOf(ar1[1]))));
				return Integer.toString(result1);
			}
			if(isFoatingPoint(ar1[0]) || isFoatingPoint(ar1[1])) {
				double result2 =(product(Double.valueOf(ar1[0]),Double.valueOf(ar1[1])));
				return Double.toString(result2);
			}
			else return argument;
		}
		pat= Pattern.compile("[+]");
		m= pat.matcher(argument);
		if(m.find()) {
			String[] ar1 = argument.split("[+]");
			if(isInteger(ar1[0]) && isInteger(ar1[1])) {
				int result1 = ((sum(Integer.valueOf(ar1[0]), Integer.valueOf(ar1[1]))));
				return Integer.toString(result1);
			}
			if(isFoatingPoint(ar1[0]) || isFoatingPoint(ar1[1])) {
				BigDecimal result2 =(sum2(ar1[0],ar1[1]));
				return ""+ result2;
			}
			else return argument;
		}
		pat= Pattern.compile("[-]");
		m= pat.matcher(argument);
		if(m.find()) {
			String[] ar1 = argument.split("[-]");
			if(isInteger(ar1[0]) && isInteger(ar1[1])) {
				int result1 = difference(Integer.valueOf(ar1[0]), Integer.valueOf(ar1[1]));
				return Integer.toString(result1);
			}
			if(isFoatingPoint(ar1[0]) || isFoatingPoint(ar1[1])) {
				double result2 =difference(Double.valueOf(ar1[0]),Double.valueOf(ar1[1]));
				return Double.toString(result2);
			}
			else return argument;
		}
		
		return result;
}

  public static String[] parse(String argument) {
    return argument.split(" ");
  }

  public int sum(int k1, int k2) {
    return k1 + k2;
  }

  public double sum(double k1, double k2) {
    return k1 + k2;
  }

  public String sum(String k1, String k2) {
    return k1 + " " + k2;
  }
	BigDecimal k3 = BigDecimal.valueOf(k1);
	BigDecimal k4 = BigDecimal.valueOf(k2);
	BigDecimal k5 = k3.subtract(k4);
	System.out.println(k5.toString());
}
  public int product(int k1, int k2) {
    return k1*k2;
  }

  public double product(double k1, double k2) {
    return k1*k2;
  }

  public String product(String k1, String k2) {
    String[] s1 = parse(k1);
    String[] s2 = parse(k2);
    String result = "";
    for (int i = 0; i < s1.length; i++) {
      for (int j = 0; j < s2.length; j++) {
        if (s1[i].equals(s2[j])) {
          result += s1[i] + " ";

        }
      }
    }
    return (result);
  }

  public int difference(int k1, int k2) {
    return (Math.abs(k1 - k2));
  }

  public double difference(double k1, double k2) {
    return (Math.abs(k1 - k2));
  }

  public String difference(String k1, String k2) {
    String[] s1 = parse(k1);
    String[] s2 = parse(k2);
    String result = "";
    boolean redflag;
    for (int i = 0; i < s1.length; i++) {
      redflag = false;
      for (int j = 0; j < s2.length; j++) {
        if (s1[i].equals(s2[j])) {
          redflag = true;
        }
      }
      if (!redflag)
        result += s1[i] + " ";
    }
    return (result);
  }
}