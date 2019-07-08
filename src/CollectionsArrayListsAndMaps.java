import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CollectionsArrayListsAndMaps {
	

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userContinue = "";
		ArrayList<String> orderedItems = new ArrayList<>();
		ArrayList<Double> orderedPrices = new ArrayList<>();
		
		Map<String, Double> trackMenuItems = new HashMap<>();
			trackMenuItems.put("Apple", 0.99);
			trackMenuItems.put("Banana", 0.59);
			trackMenuItems.put("Cauliflower", 1.59);
			trackMenuItems.put("Dragonfruit", 2.19);
			trackMenuItems.put("Elderberry", 1.79);
			trackMenuItems.put("Figs", 2.09);
			trackMenuItems.put("Grapefruit", 1.99);
			trackMenuItems.put("Honeydew", 3.49);
		
		
		System.out.println("Welcome to Guenther's Market!\n");
		
		
		menuMap();
		ArrayList<String> menuItems = new ArrayList<>();
			menuItems.add("1. Apple");
			menuItems.add("2. Banana");
			menuItems.add("3. Cauliflower");
			menuItems.add("4. Dragonfruit");
			menuItems.add("5. Elderberry");
			menuItems.add("6. Figs");
			menuItems.add("7. Grapefruit");
			menuItems.add("8. Honeydew");
	
		ArrayList<Double> menuPrices = new ArrayList<>();
			menuPrices.add(0.99);
			menuPrices.add(0.59);
			menuPrices.add(1.59);
			menuPrices.add(2.19);
			menuPrices.add(1.79);
			menuPrices.add(2.09);
			menuPrices.add(1.99);
			menuPrices.add(3.49);
		
		do {
			displayMenu();
			System.out.println("What would you like to order? \n(enter a number: 1-8)");
			System.out.println("\nPlease enter a number: ");
			int userOrdered = (scnr.nextInt() - 1);
			scnr.nextLine();
			try {
			System.out.println("Adding " + menuItems.get(userOrdered) + 
							" to cart at $" + menuPrices.get(userOrdered) + ".");
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Sorry, we don't have those. Please try again.\n");
				continue;
			}
			orderedItems.add(menuItems.get(userOrdered));
			orderedPrices.add(menuPrices.get(userOrdered));
			
			System.out.println("\nWould you like to order anything else? (y/n)?");
			userContinue = scnr.nextLine();
		} while (userContinue.equalsIgnoreCase("y"));
	
		
		//display customer order
		System.out.println("Thanks for your order! \nHere's what you got:");
		System.out.println("============================");
			for (int i = 0; i < orderedItems.size(); ++i) {
				System.out.printf("%-20s $%-6.2f\n", orderedItems.get(i), orderedPrices.get(i));
			}
		
		System.out.println("Average price per item in order was $" + averageItemCost(orderedPrices, orderedItems.size()));
		System.out.println("Highest priced item is $" + maxPrice(orderedPrices, orderedItems.size())); //these display the price. 
		System.out.println("Lowest priced item is $" +  minPrice(orderedPrices, orderedItems.size())); //would rather display the item name...
			
			
			
			scnr.close();
		

	}
	
	
	public static double averageItemCost(ArrayList<Double> orderPrices, int arraySize) {
		
		double averageCost = 0.0;
		for (int i = 0; i < arraySize; i++) {
			averageCost += orderPrices.get(i) / arraySize;
		}
		
		return averageCost;
	}

	public static double maxPrice(ArrayList<Double> orderPrices, int arraySize) {
		double maxPrice = orderPrices.get(0);
		for (int i = 0; i < arraySize; i++) {
			
			if(maxPrice < orderPrices.get(i)) {
				maxPrice = orderPrices.get(i);
			}
		}
		
		return maxPrice;
	}
	
	
		public static double minPrice(ArrayList<Double> orderPrices, int arraySize) {
			double minPrice = orderPrices.get(0);
			for (int i = 0; i < arraySize; i++) {
				
				if(minPrice > orderPrices.get(i)) {
					minPrice = orderPrices.get(i);
				}
			}
			
			return minPrice;
		}
	
	
		
	public static boolean validOrder() {
		return true;
		
	}
	
	
	public static Map<String, Double> menuMap(){
		
		Map<String, Double> trackMenuItems = new HashMap<>();
			trackMenuItems.put("Apple", 0.99);
			trackMenuItems.put("Banana", 0.59);
			trackMenuItems.put("Cauliflower", 1.59);
			trackMenuItems.put("Dragonfruit", 2.19);
			trackMenuItems.put("Elderberry", 1.79);
			trackMenuItems.put("Figs", 2.09);
			trackMenuItems.put("Grapefruit", 1.99);
			trackMenuItems.put("Honeydew", 3.49);
		
		
		return trackMenuItems;
		
	}
	
	public static void displayMenu() {
		ArrayList<String> menuItems = new ArrayList<>();
			menuItems.add("1. Apple");
			menuItems.add("2. Banana");
			menuItems.add("3. Cauliflower");
			menuItems.add("4. Dragonfruit");
			menuItems.add("5. Elderberry");
			menuItems.add("6. Figs");
			menuItems.add("7. Grapefruit");
			menuItems.add("8. Honeydew");
		
		ArrayList<Double> menuPrices = new ArrayList<>();
			menuPrices.add(0.99);
			menuPrices.add(0.59);
			menuPrices.add(1.59);
			menuPrices.add(2.19);
			menuPrices.add(1.79);
			menuPrices.add(2.09);
			menuPrices.add(1.99);
			menuPrices.add(3.49);
		
		System.out.printf("%-20s %-6s\n", "Item", "Price");
		System.out.println("============================");
		
		for (int i = 0; i < menuItems.size(); ++i) {
			System.out.printf("%-20s $%-6.2f\n", menuItems.get(i), menuPrices.get(i));
		}
		
		
	}

}
