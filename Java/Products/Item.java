

	import java.text.DecimalFormat;

	public class Item {
	  protected Products type;
	  protected double weight = 1.00, price = 100.00;
	  protected int quantity = 0;
	  protected String comment = "";
	  protected DecimalFormat costFormat = new DecimalFormat("#.##");
	  
	  public Item(Products product, double weight, double price, String com) {
	    type = product;
	    if (weight>0.01 && weight<100.00) this.weight = weight;
	    if (price>1.00 && price<10000.00) this.price = price;
	    if (com!=null) comment = com;
	  }
	  public void add(int quantity) {
	    if (quantity>=0)
	      this.quantity += quantity;
	  }
	  public boolean remove(int number) {
	    if (quantity-number>=0 && number>=0) {
	      quantity -= number;
	      return true;
	    } else return false;
	  }
	  public int getQuantity() {
	    return quantity;
	  }
	  public String toString() {
	    String res = quantity+" x "+type+", weight: "+weight;
	    if (quantity>0)
	      res+=", cost: "+costFormat.format(price*quantity);
	    if (comment!="")
	      res+=" ("+comment+")";
	    return res;
	  }
	}
