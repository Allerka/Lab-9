package co.grandcircus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {
		// initial setup
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Alfred's Outfitters!\n");
		Map<String, Double> items = new HashMap<>();
		ArrayList<String> cartItems = new ArrayList<String>();
		ArrayList<Double> cartPrices = new ArrayList<Double>();
		ArrayList<Integer> cartQuantity = new ArrayList<Integer>();
		int cartPosition = 0;
		int orderQuantity = 1;
		double average = 0;
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {
			buildList(items);
			displayList(items);
			System.out.println();
			String selection = Validator.getStringMatchingRegex(scan, "What would you like to buy? (first letter) ",
					"[BbEeFfGgHhPpRrSsTt]");
			selection.toLowerCase();
			// orderQuantity = Validator.getInt(scan, "How many? (1-10) ", 1, 10);
			switch (selection.charAt(0)) {
			case 's':
				System.out.println("Adding stimulant for $3.75.");
				cartItems.add(cartPosition, "Stimulant");
				cartPrices.add(cartPosition, 3.75);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'r':
				System.out.println("Adding remedy injector for $19.99.");
				cartItems.add(cartPosition, "Remedy");
				cartPrices.add(cartPosition, 19.99);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'g':
				System.out.println("Adding goggles for $20.75.");
				cartItems.add(cartPosition, "Goggles");
				cartPrices.add(cartPosition, 20.75);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'e':
				System.out.println("Adding energy drink for $6.50.");
				cartItems.add(cartPosition, "Energy Drink");
				cartPrices.add(cartPosition, 6.50);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'b':
				System.out.println("Adding bio-etheric purifier for $24.99.");
				cartItems.add(cartPosition, "Bio-Etheric Purifier");
				cartPrices.add(cartPosition, 24.99);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'h':
				System.out.println("Adding health potion for $4.99.");
				cartItems.add(cartPosition, "Health Potion");
				cartPrices.add(cartPosition, 4.99);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'f':
				System.out.println("Adding fish oil for $7.99.");
				cartItems.add(cartPosition, "Fish Oil");
				cartPrices.add(cartPosition, 7.99);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 't':
				System.out.println("Adding temporal corrector for $9.99.");
				cartItems.add(cartPosition, "Temporal Corrector");
				cartPrices.add(cartPosition, 9.99);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			case 'p':
				System.out.println("Adding probability adjustor for $12.50.");
				cartItems.add(cartPosition, "Probability Adjustor");
				cartPrices.add(cartPosition, 12.50);
				// cartQuantity.add(cartPosition, orderQuantity);
				cartPosition += 1;
				break;
			}
			cont = Validator.getStringMatchingRegex(scan, "Continue shopping? (y/n) ", "[YyNn]");
		}
		// show the cart
		System.out.println("\nHere's your final list:");
		// System.out.println(cartQuantity);
		for (int i = 0; i < cartPosition; i++) {
			System.out.printf("%-22s %2s%2.2f\n", cartItems.get(i), "$", cartPrices.get(i));
			average += cartPrices.get(i);
		}
		System.out.printf("\n%-22s %2s%2.2f\n", "Average cost of items:", "$", (average / cartPrices.size()));

		Collections.sort(cartPrices);
		lowestCost(cartPrices);
		highestCost(cartPrices);
	}

	// build the item list
	public static Map<String, Double> buildList(Map<String, Double> items) {
		items.put("Health Potion", 4.99);
		items.put("Energy Drink", 6.50);
		items.put("Fish Oil", 7.99);
		items.put("Stimulant", 3.75);
		items.put("Temporal Corrector", 9.99);
		items.put("Probability Adjustor", 12.50);
		items.put("Remedy Injector", 19.99);
		items.put("Bio-Etheric Purifier", 24.99);
		items.put("Goggles", 20.75);
		return items;
	}

	// display the list
	public static void displayList(Map<String, Double> items) {
		System.out.printf("%-14s %14s\n", "Item", "Price");
		System.out.println("=================================");
		for (String key : items.keySet()) {
			System.out.printf("%-22s %2s%2.2f\n", key, " $", items.get(key));
		}
		return;
	}

	// finds lowest cost item
	public static ArrayList<Double> lowestCost(ArrayList<Double> cartPrices) {
		System.out.printf("%-22s %2s%2.2f\n", "Lowest cost item:", "$", (cartPrices.get(0)));
		return cartPrices;
	}

	// finds highest cost item
	public static ArrayList<Double> highestCost(ArrayList<Double> cartPrices) {
		System.out.printf("%-22s %2s%2.2f\n", "Highest cost item:", "$", (cartPrices.get(cartPrices.size() - 1)));
		return cartPrices;
	}
}
