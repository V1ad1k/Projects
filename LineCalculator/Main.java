

import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		LineCalculator data=new LineCalculator();
		Scanner input= new Scanner(System.in);
		System.out.println("Input data :");
		String smth = input.nextLine();
		input.close();
		System.out.println("Final reuslt is = " +data.calculate(smth));
	}
}
