package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {
	Checkout checkout;

	// initialise test obj
	@Before
	public void setUp() {
		checkout = new Discount();
	}

	// make test obj null
	@After
	public void tearDown() {
		checkout = null;
	}

	@Test
	public void addOneItemOneRestuarant() {
		checkout.addItem("Tiramisu", 8.00, 1, 4, false, false);
		assertEquals(8.00, checkout.getTotal(), 0.0);
		
	}

	@Test
	public void addOneItemMultipleRestaurants() {
		checkout.addItem("Beef Rendang", 12.90, 1, 5, false, false);
		checkout.addItem("Ice Tea", 3.00, 1, 5.50, true, false);
		checkout.addItem("Veggie Paradise", 12.00, 1, 6, true, false);
		assertEquals(27.90, checkout.getTotal(), 0.0);
	}

	@Test
	public void addMultipleItemsOneRestaurant() {
		checkout.addItem("Grilled Fish", 15.00, 2, 5, false, false);
		checkout.addItem("Iced Lemon Tea", 3.50, 3, 5, false, true);
		assertEquals(40.5, checkout.getTotal(), 0.0);
	}
	
	@Test
	public void addMultipleItemsMultipleRestuarants() {
		checkout.addItem("Satay Beef Burger", 13.00, 2, 5.50, false, false);
		checkout.addItem("Magic", 4.00, 3, 3, true, false);
		assertEquals(38, checkout.getTotal(), 0.0);
	}
}
