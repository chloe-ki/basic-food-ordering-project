package assignment1;

import java.util.*;

public class Main {
	// scanner declared
	Scanner sc;
	// arraylists for each restaurant type to make iteration easier
	ArrayList<Restaurants> fflist, clist, rlist, arlist;
	Checkout checkout = new Discount();

	// hashmaps for storing food and price combinations
	HashMap<String, Double> bk, ck, hc, sk, pnbm, mr, jsr, ks, mb, kk, th, wc;
	ArrayList<Integer> matches;

	public Main() {
		matches = new ArrayList<Integer>();
		String ff = "Fast Food";
		String rnt = "Restaurant";
		String cf = "Cafe";

		// initialising arraylists
		fflist = new ArrayList<Restaurants>();
		clist = new ArrayList<Restaurants>();
		rlist = new ArrayList<Restaurants>();
		arlist = new ArrayList<Restaurants>();
		// initialising hashmaps
		bk = new HashMap<String, Double>();
		ck = new HashMap<String, Double>();
		hc = new HashMap<String, Double>();
		sk = new HashMap<String, Double>();
		pnbm = new HashMap<String, Double>();
		mr = new HashMap<String, Double>();
		jsr = new HashMap<String, Double>();
		ks = new HashMap<String, Double>();
		mb = new HashMap<String, Double>();
		kk = new HashMap<String, Double>();
		th = new HashMap<String, Double>();
		wc = new HashMap<String, Double>();
		// scanner initialised
		sc = new Scanner(System.in);

		// add food names and prices to hashmaps
		bk.put("Funky Burger", 12.00);
		bk.put("French Fries", 7.50);
		bk.put("Coca Cola", 2.00);

		ck.put("Chicken Wing", 4.50);
		ck.put("Chicken Burger", 11.00);
		ck.put("Orange Juice", 3.00);
		ck.put("Tomato Juice", 3.50);

		hc.put("Big Cheese Burger", 14.00);
		hc.put("Satay Beef Burger", 13.00);
		hc.put("Ice Tea", 3.00);

		mr.put("Lobster Soup", 25.00);
		mr.put("Fish of the Day", 22.00);
		mr.put("Mommy' Apple Pie", 8.00);
		mr.put("Irish Coffee", 4.50);

		jsr.put("Ceasar Salad", 11.00);
		jsr.put("Veggie Paradise", 12.00);
		jsr.put("Chick Peas Wrap", 10.00);
		jsr.put("Coconut Water", 2.50);

		th.put("Tiramisu", 8.00);
		th.put("Chocolate Mousse", 7.50);
		th.put("Bubble Tea", 4.50);
		th.put("Green Tea", 3.50);

		ks.put("Grilled Beef Ribs", 12.50);
		ks.put("Satay Chicken", 11.50);
		ks.put("Orange Juice", 3.50);

		mb.put("Batagor Bandung", 12.00);
		mb.put("Smashed Chicken", 14.00);
		mb.put("Iced Lemon Tea", 3.00);
		mb.put("Teh Kotak", 3.00);

		wc.put("Idomie Toastie", 8.00);
		wc.put("Beef Yellow Rice", 11.00);
		wc.put("Latte", 4.20);
		wc.put("Magic", 4.00);

		sk.put("Ayam Pop on Rice", 14.00);
		sk.put("Ox Tail on Rice", 15.00);
		sk.put("Teh Botol", 3.00);

		kk.put("Slow Cooked Madura duck", 20.00);
		kk.put("Javanese Fried Rice", 15.00);
		kk.put("Rolled Balinese Chicken", 14.00);
		kk.put("Iced Coffee", 5.00);

		pnbm.put("Beef Rendang", 12.90);
		pnbm.put("Grilled Fish", 15.00);
		pnbm.put("Smashed Grilled Beef Ribs", 15.00);
		pnbm.put("Iced Lemon Tea", 3.50);

		// initialise objects within lists
		fflist.add(new FastFood("Burger King", ff, 5, bk));
		fflist.add(new FastFood("Chicken King", ff, 5, ck));
		fflist.add(new FastFood("Holly Cow", ff, 5.50, hc));
		fflist.add(new FastFood("Salero Kito", ff, 6, sk));
		fflist.add(new FastFood("Pondok Nasi Bakar Melbourne", ff, 5, pnbm));

		rlist.add(new Restaurant("Moeders R.", rnt, 10, mr));
		rlist.add(new Restaurant("Just Salads R.", rnt, 6, jsr));
		rlist.add(new Restaurant("Kadai Satay", rnt, 5.50, ks));
		rlist.add(new Restaurant("Meetbowl", rnt, 6, mb));
		rlist.add(new Restaurant("Kata Kita", rnt, 8, kk));

		clist.add(new Cafe("Tea House", cf, 4, th));
		clist.add(new Cafe("Warung Coffee", cf, 3, wc));

		arlist.addAll(fflist);
		arlist.addAll(clist);
		arlist.addAll(rlist);

		// call main menu method
		mainMenuPrint();
		System.out.println("Welcome to Melbourne Eats!");
	}

	public void mainMenuPrint() {
		// variable for storing user choice initialised
		int choice;

		// main menu text
		System.out.println("------------------------------------------------");
		System.out.println("> Select from main menu: ");
		System.out.println("------------------------------------------------");
		System.out.printf("%25s %n", "1) Browse by category");
		System.out.printf("%27s %n", "2) Search by restaurant");
		System.out.printf("%15s %n", "3) Checkout");
		System.out.printf("%11s %n", "4) Exit");
		System.out.print("Please select: ");
		// storing user input
		choice = sc.nextInt();

		mainMenuSelection(choice);
	}

	public void mainMenuSelection(int choice) {
		// calls methods depending on user input
		switch (choice) {
		case 1:
			categoryBrowse();
			break;
		case 2:
			restaurantSearch();
			break;
		case 3:
			checkout();
			break;
		case 4:
			// terminates program
			System.exit(0);
			// if user input is not valid
		default:
			System.out.println("Please make a valid selection.");
			mainMenuPrint();
			break;
		}
	}

	// allows user to browse restaurants by category
	public void categoryBrowse() {
		// local variable to store user input
		int choice;
		// text to prompt user input
		System.out.println("------------------------------------------------");
		System.out.println("Choose category:");
		System.out.println("------------------------------------------------");
		System.out.printf("%16s %n", "1) Fast food");
		System.out.printf("%17s %n", "2) Restaurant");
		System.out.printf("%11s %n", "3) Cafe");
		System.out.print("Please select: ");
		// variable initialised with user input
		choice = sc.nextInt();
		// output depending on what user chose
		switch (choice) {
		case 1:
			browse(fflist);
			break;
		case 2:
			browse(rlist);
			break;
		case 3:
			browse(clist);
			break;
		// if user input is not valid
		default:
			System.out.println("Please make a valid selection.");
			categoryBrowse();
		}
	}

	// method to display restaurants based on user input, restaurant type is
	// parameter
	public void browse(ArrayList<Restaurants> type) {
		// declaring and initialising iterator
		Iterator<Restaurants> i = type.iterator();
		// declaring variable to store user input
		int choice, choiceMenu, choiceAmt;
		// counter to use as numeric bullet points for display
		int counter = 1;

		System.out.println("------------------------------------------------");
		System.out.println("Choose restaurant:");
		System.out.println("------------------------------------------------");
		// while loop to iterate through and display available restaurants
		while (i.hasNext()) {
			System.out.printf("%6s %s %n", counter + ")", i.next());
			counter++;
		}

		System.out.print("\nPlease make a selection: ");

		try {
			choice = sc.nextInt();

			// displays menu of chosen restaurant
			type.get(choice - 1).menu();

			System.out.print("\nPlease make a selection: ");
			choiceMenu = sc.nextInt();

			System.out.print("Order amount: ");
			choiceAmt = sc.nextInt();

			// calls method to find chosen item (-1 is to account for menu index starting at
			// 0)
			findItem(type, choice - 1, choiceMenu - 1, choiceAmt);

			mainMenuPrint();
			// catches exception if user inputs invalid choice
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please make a valid selection!");
			browse(type);
		}
	}

	// allows users to search (partial or full)
	public void restaurantSearch() {
		matches.removeAll(matches);
		String search;
		// for display, numeric bullet points
		int counter = 1;
		
		// boolean to determine whether search was successful or not
		boolean results = false;
		// add successful search result indexes

		System.out.print("Enter restaurant name: ");
		search = sc.next();

		// contains() is case sensitive
		search.toLowerCase();

		System.out.println("------------------------------------------------");
		System.out.println("Search Results:");
		System.out.println("------------------------------------------------");

		// iterate through list, for loop to get index
		for (int i = 0; i < arlist.size(); i++) {
			if (arlist.get(i).getName().toLowerCase().contains(search)) {
				System.out.printf("%6s %s %n", counter + ")", arlist.get(i));
				counter++;
				// search successful
				results = true;
				// add successful search result to arraylist
				matches.add(i);
			}
		}
		restaurantSearchResult(results);
	}

	public void restaurantSearchResult(boolean results) {
		int choice, choiceMenu, choiceAmt;
		// displays is search is unsuccessful
		if (results == false) {
			System.out.println("\nNo search results");
			mainMenuPrint();
		}

		try {
			System.out.print("\nPlease make a selection: ");
			choice = sc.nextInt();

			// displays menu of chosen restaurant
			arlist.get(matches.get(choice - 1)).menu();

			System.out.print("\nPlease make a selection: ");
			choiceMenu = sc.nextInt();

			System.out.print("Order amount: ");
			choiceAmt = sc.nextInt();

			findItem(arlist, choice - 1, choiceMenu - 1, choiceAmt);
			mainMenuPrint();
		} catch (IndexOutOfBoundsException i) {
			System.out.println("Please make a valid selection!");
			restaurantSearchResult(results);
		}
	}

	// finds relevant item info from restaurants class
	public void findItem(ArrayList<Restaurants> type, int restChoice, int itemChoice, int itemAmt) {
		String itemName;
		double itemPrice, delivery;
		boolean multipleRest = false;
		boolean ordered;
		int counter = 0;

		if (type == arlist) {
			// idk why this works but it does so
			// only iterates through displayed search results via matches arraylist
			ordered = arlist.get(matches.get(restChoice)).getOrdered();
			itemName = arlist.get(matches.get(restChoice)).getItem(itemChoice);
			itemPrice = arlist.get(matches.get(restChoice)).getPrice(itemChoice);
			delivery = arlist.get(matches.get(restChoice)).getDelivery();

		}

		else {
			ordered = type.get(restChoice).getOrdered();
			itemName = type.get(restChoice).getItem(itemChoice);
			itemPrice = type.get(restChoice).getPrice(itemChoice);
			delivery = type.get(restChoice).getDelivery();

		}

		for (int i = 0; i < arlist.size(); i++) {
			if (arlist.get(i).getOrdered()) {
				counter++;
			}

			if (counter >= 2) {
				multipleRest = true;
			}
		}

		// calls Checkout/Discount class
		checkout.addItem(itemName, itemPrice, itemAmt, delivery, multipleRest, ordered);
	}

	// applies discounts and order summary
	public void checkout() {
		checkout.print();
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}

}
