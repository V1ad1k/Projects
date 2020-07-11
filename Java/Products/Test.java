import java.util.ArrayList;
import java.util.Deque;
import java.lang.*;
public class Test {
  public static void main(String[] args) {
    Item first= new Item(Products.TEA, 0.5, 12.3, "my personal choice");
    first.add(5);
    System.out.println("adding, should be 5 is: " +first.getQuantity());
    System.out.println("removing 2, should be true, is: "+first.remove(2));
    System.out.println("printing "  +first);
    
    System.out.println();
    Item second= new Item(Products.MILK, 80.0, 320.5, "to prepare cereals");
    second.add(3);
    System.out.println("adding, should be 3 is: " +second.getQuantity());
    System.out.println("removing (-2), should be false, is: "+second.remove(-2));
    
    System.out.println();
    Item third= new Item(Products.fromString("pancake"), 76.3, 1999.9, "special occasion");
    System.out.println("removing 0, should be true, is: "+third.remove(0));
    System.out.println("printing: " +third);
    Item fourth = new Item(Products.BUTTER, 1, 1, "");
     ArrayList<Item> a = new ArrayList<Item>();
     long start = System.nanoTime();
     for (int i=0; i<1000000;i++)
     a.add(fourth);
  long end = System.nanoTime();
  long timeElapsed=end-start;
  System.out.println(timeElapsed);
  }
}
    
  
//item[] array  = new Item[1000000];
//for (int i=0;i<Item;i++)

