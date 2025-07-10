package assignment1;
public class Discount extends Checkout {
	// stores amount saved from discounts applied
	private double amtSaved, totalDiscount, newTotal;
	// private int dis10, dis15, dis20;

	public Discount() {
		amtSaved = 0;
	}

	// overrides abstract method from Checkout class
	@Override
	public void print() {
		// check for any eligible discounts
		discounts();

		System.out.println("\n------------------------------------------------");
		System.out.println("Your Order:");
		System.out.println("------------------------------------------------\n");
		for (int i = 0; i < names.size(); i++) {
			System.out.printf("%-30s $%.2f %n", amounts.get(i)+" "+names.get(i), prices.get(i));
		}
		System.out.println("\n");
		System.out.println("------------------------------------------------");
		System.out.printf("%-30s $%.2f %n", "Delivery fee:", deliveryf);
		System.out.printf("%-30s $%.2f %n", "Total:", newTotal + deliveryf);
		// only displays amount saved if user has saved more than $0.00
		if (amtSaved > 0) {
			System.out.printf("%-30s $%.2f %n", "Amount Saved:", amtSaved);
		}
		System.out.println("\nThank you for dining with us!");
		System.exit(0);
	}

	// calculates the discounts to be applied at checkout
	public void discounts() {
		if (total >= 10 && total < 20) {
			totalDiscount += 0.1;
		}

		if (total >= 20 && total < 30) {
			totalDiscount += 0.15;
		}

		if (total >= 30) {
			totalDiscount += 0.2;
		}

		if (multipleRest) {
			deliveryf = deliveryf - (deliveryf * 0.5);
		}

		newTotal = total - (total * totalDiscount);
		amtSaved = total - newTotal;
	}
	
	public double getAmtSaved() {
		return amtSaved;
	}
	
	public double getTotalDiscount() {
		return totalDiscount;
	}
	
	public double getNewTotal() {
		return newTotal;
	}
	
	
}
