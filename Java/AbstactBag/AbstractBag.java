package lab7;

public abstract class AbstractBag {
	  protected Product[] content;
	  protected double maxWeight;
	  public AbstractBag(int size, double maxWeight) {
	    content = new Product[size];
	    this.maxWeight = maxWeight;
	  }
	  public abstract String toString();
	  
	  public boolean putIn(Product it) {
		  boolean result = false;
	    for (int i=0;i<content.length;i++) {
	    	double currentWeight = getTotalWeight();
            double addedWeight = currentWeight + it.weight;
            if (content[i] == null && addedWeight <= maxWeight) {
	        content[i] = it;
	        result = true;
	        break;
	    }
	  }
	    return result;
	 }
	    
	  public int putIn(Product[] its) {
		  int result = 0;
	        for (int i = 0; i < its.length; i++) {
	            double currentWeight = getTotalWeight();
	            double addedWeight = currentWeight + its[i].weight;
	            for (int j = 0; j < content.length; j++) {
	                if (content[j] == null && addedWeight <= maxWeight) {
	                    content[j] = its[i];
	                    result++;
	                    break;
	                }
	            }
	        }
	        return result;
	    }
	  public double getTotalWeight() {
	    double result = -0.0;
	    for (Product item : content)
	      if (item!=null)
	        result+=item.weight;
	    return result;
	  }
	  public double getTotalWeight(Products product) {
		  double result = 0.0;
	        for (int i = 0; i < content.length; i++) {
	            if (content[i] != null) {
	                result += content[i].weight;
	            }
	        }
	    return result;
	  }
	  public abstract void removeProduct(Products toRemove);
	}