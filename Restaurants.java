package assignment1;
import java.util.*;

// abstract parent class for restaurant types to build upon
public abstract class Restaurants {
    private String name, type;
    private double delivery;
    private int counter;
    private HashMap<String,Double> food;
    // arraylist to accommodate user input 
    private ArrayList<String> display;
    private boolean ordered;

    public Restaurants(String name, String type, double delivery, HashMap<String,Double> food) {
        // all restaurants have originally not been ordered from
        ordered = false;

        this.name = name;
        this.type = type;
        this.delivery = delivery;
        this.food = food;
        // initialising new arraylist
        display = new ArrayList<String>();

        // adding the key from food hashmap as a value to display arraylist
        for (String key : food.keySet()) {
            display.add(key);
        }
    }
    
    // get method for name variable
    public String getName() {
        return name;
    }

    // get method for delivery variable
    public Double getDelivery() {
        return delivery;
    }

    // returns restaurant type
    public String getType() {
        return type;
    }

    // returns whether a restaurant has been ordered from or not
    public boolean getOrdered() {
        return ordered;
    }

    // displays food items as bulleted menu
    public void menu() {
        counter = 1;
        System.out.println("------------------------------------------------");
        System.out.println("Menu:");
        System.out.println("------------------------------------------------");

        // to iterate through arraylist of food items
       for (String string : display) {
           System.out.printf("%6s %s %n", counter+")", string);
           counter++;
       }
    }

    // returns specified food item
    public String getItem(int item) {
        ordered = true;
        return display.get(item);
    }

    // returns price of a specified food item
    public double getPrice(int item) {
        String itemName = display.get(item);
        double price = food.get(itemName);
        return price;
    }

    // overrides default toString method
    @Override
    public String toString() {
        return this.name;
    }
}
