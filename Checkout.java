package assignment1;
import java.util.*;

public  abstract class Checkout {
    // stores the total (excluding discounts)
    protected double total, deliveryf;
    protected ArrayList<String> names;
    protected ArrayList<Double> prices;
    protected ArrayList<Integer> amounts;
    protected boolean restTypes;
    protected boolean multipleRest;
    

    public Checkout() {
        // initialising variables
        total = 0;
        restTypes = false;
        names = new ArrayList<String>();
        prices = new ArrayList<Double>();
        amounts = new ArrayList<Integer>();
    }

    // adds purchased items to arraylist for printing
    public void addItem(String itemName, double itemPrice, int itemAmt, double delivery, boolean multipleRest, boolean orderedBfr) {
        // calculates total price based on amount ordered
        double newPrice = itemAmt*itemPrice;

        names.add(itemName);
        prices.add(newPrice);
        amounts.add(itemAmt);
        this.multipleRest = multipleRest;

        // delivery fee doesn't increase if delivery fee from restaurant already applies
        if (!orderedBfr) {
            deliveryf += delivery;
        }
        
        total += newPrice;     
    }

    // prints the receipt
    public abstract void print();

    // allows access to private variable total
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
    	this.total = total;
    }
    
    public boolean getMultipleRest() {
    	return multipleRest;
    }
    
    public void setMultipleRest(boolean multipleRest) {
    	this.multipleRest = multipleRest;
    }
    
    public double getDeliveryF() {
		return deliveryf;
	}
    
    public void setDeliveryF(double deliveryf) {
    	this.deliveryf = deliveryf;
    }
}
