package change; 

import java.math.BigDecimal; 
import java.math.RoundingMode; 
import java.util.*; 
import javax.swing.*; 
import java.util.Scanner; 
import java.util.regex.Pattern; 
public class coinn
{ 
public static double round(double value, int places) { 
if (places < 0) throw new IllegalArgumentException(); 

BigDecimal bd = new BigDecimal(value); 
bd = bd.setScale(places, RoundingMode.HALF_UP); 
return bd.doubleValue(); 
} 
public static void main(String[] args) 
{ 
String input; //Input buffer 
//Prompt the user to enter the cost of an item 
// Scanner price = new Scanner(System.in); 
input = JOptionPane.showInputDialog("Enter the $-cost of an item"); 
double cost = Double.parseDouble(input); 
// final String regex = "(\\.?\\d$)?$"; 
//if 1.23 
int temp = (int) (cost/0.05); // 24 
double mult = round(temp * 0.05,2);//1,2 
double diff = round(cost - mult,2);//0.03 
int check = (int) (diff*2/0.05); 
double next = check*0.05; 
cost =next + mult; 


//Prompt the user to enter the amount tendered for payment 
// Scanner till = new Scanner(System.in); 
input = JOptionPane.showInputDialog("Enter the $-amount tendered"); 
double paid = Double.parseDouble(input); 



//Calculate the amount of change due in real $, e.g. 6.73 
double change = paid-cost; 
// double change2=paid-cost2; 
int change1=(int)(change); 
// int change3=(int)(change2) 

//Convert the change due to whole dollars and whole cents 
// For Example: change of 6.73 gives 6 Dollars & 73 Cents 

int dollars = (int) round((change1)/1,2); 
double cents = round(change%1,2); 

//Construct and Display a sales receipt 
String receipt = "Cost of Item $" + round(cost,2) + "\n" + 
"Amount Paid $" + paid + "\n" + 
"Change Due $" + round(change,2) + " : " + 
dollars + " Dollars & " + round(cents,2) + " Cents"; 
JOptionPane.showMessageDialog(null, receipt); 

//Determine the composition of the change 
//Bills: $20, $10, $5, $1 bills 
int twenties = dollars/20; 
dollars=dollars%20; 
int tens= dollars/10; 
dollars=dollars%10; 
int fives= dollars/5; 
dollars=dollars%5; 
int two = dollars/2; 
dollars = dollars%2; 
int ones= dollars/1; 


//Coins: Fifty(50c) Twenty(20c.), Dimes(10c.), Nickels(5c.), 
int fifty =(int) (cents/.50); 
cents=cents%.50; 
int twenty =(int) (cents/.20); 
cents=cents%.20; 
int dimes=(int) (cents/.10); 
cents=cents%.10; 
double nickels= round(cents/.05,0); 
int resnickels = (int) nickels; 



// switch statement with int data type 

if (cost>paid) 
System.out.println("Not enough money offered."); 
if(cost==paid) 
System.out.println("Exact amount."); 
if(cost<paid) { 
String record = "Change Amount $" + round(change,2) + "\n" + 
twenties + " $20 bills" + "\n" + 
tens + " $10 bills" + "\n" + 
fives + " $5 bills" + "\n" + 
two + " $2 bills" + "\n" + 
ones + " $1 bills" + "\n" + 
fifty+ " 50c" + "\n" + 
twenty + " 20c" + "\n" + 
dimes + " Dimes" + "\n" + 
resnickels + " Nickels" + "\n" ; 

JOptionPane.showMessageDialog(null, record); 
} 
} 
}