package assignment1;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest {
	Discount discount;
	Checkout checkout;

	// create temp obj for testing
	@Before
	public void setUp() {
		discount = new Discount();
	}

	// remove changes made during testing

	@After
	public void tearDown() {
		discount.setMultipleRest(false);
		discount.setTotal(0.0);
		discount = null;

	}

	@Test
	public void discount_totalLess10_oneRestaurant() {
		discount.setMultipleRest(false);
		discount.setTotal(9.50);
		discount.discounts();
		assertEquals(9.50, discount.getNewTotal(), 0.0);
	}
	
	@Test
	public void discount_totalLess20Greater10_oneRestaurant() {
		discount.setMultipleRest(false);
		discount.setTotal(15.00);
		discount.discounts();
		assertEquals(13.5, discount.getNewTotal(), 0.0);
	}
	
	@Test
	public void discount_totalLess30Greater20_oneRestaurant() {
		discount.setMultipleRest(false);
		discount.setTotal(23.50);
		discount.discounts();
		// variance allowed due to triple decimal point
		assertEquals(19.975, discount.getNewTotal(), 0.01);
	}
	
	@Test
	public void discount_totalGreater30_oneRestaurant() {
		discount.setMultipleRest(false);
		discount.setTotal(42.00);
		discount.discounts();
		assertEquals(33.6, discount.getNewTotal(), 0.0);
	}
	
	@Test
	public void discount_multipleRestaurant() {
		discount.setMultipleRest(true);
		discount.setDeliveryF(10);
		discount.discounts();
		assertEquals(5, discount.getDeliveryF(), 0.0);
	}


}
