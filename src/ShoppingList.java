import java.util.Scanner;

//Laura Burt

public class ShoppingList {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String[] products = { "apple", "banana", "cauliflower", "dragonfruit", "elderberry", "figs", "grapefruit",
	                "honeydew" };
	        double[] prices = { 0.99, 0.59, 1.59, 2.19, 1.79, 2.09, 1.99, 3.49 };
	        String[] itemord = new String[20];
	        double[] priceord = new double[20];
	        int count = 0;
	        int index;
	        // starting the program
	        
	        System.out.println("Welcome to Guenther's Market!");
	        System.out.println();
	        System.out.println();
	        // System.out.printf("%-8 Item %tPrice");
	        //printing the menu from a method
	        
	        printMenu(products,prices);
	        
	        String flag = "y";
	        double price = 0.0;
	        String itemordered ;
	        // asking for the products that the customer wants to buy
	        
	        while (flag.equalsIgnoreCase("y")) {
	            itemordered = Validator.getString(scan, "What item would you like to order? ");
	            index = findItem(itemordered, products);
	            if (index >= 0) {
	                itemord[count] = itemordered;
	                priceord[count] = prices [index];
	                count ++;  // counting the items ordered
	                System.out.println("Adding " + itemordered + " to cart at $" + prices[index]);
	                System.out.println("Would you like to order anything else (y/n)? ");
	                flag = scan.next();
	                scan.nextLine();
	                if (flag.equalsIgnoreCase("y")) {
	                   printMenu(products,prices);
	                }
	                continue;
	            } else {
	                 System.out.println("Sorry, we don't have those. Please try again.");
	                 printMenu(products,prices);
	                 continue;
	            }
	            
	        }
	        System.out.println("Thanks for your order!");
	        System.out.println("Here's what you got:");
	        for (int i = 0; i < count; i++) {
	            
	            System.out.printf("%-8s \t$%.2f%n", itemord[i], priceord[i]);
	        }
	        averOfPrices(priceord,count);
	        
	        scan.close();
	    }
	    public static void printMenu(String[] arr,double[] arr2) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.printf("%-8s \t$%.2f%n", arr[i], arr2[i]);
	        }
	        
	        System.out.println();
	    }
	    public static int findItem(String item, String[] arr) {
	        int count = -1;
	        for (int i = 0; i < arr.length; i++) {
	            
	            if (arr[i].equals(item)) {
	                count = i;
	                return count;
	            }
	        }
	        return -1;
	    }
	    public static void averOfPrices(double[] arr3, int counter) {
	           double sum = 0;
	           for (int i = 0; i < counter; i++) {
	               sum += arr3[i];
	           }
	           System.out.println("Average price per item in order was "+ sum/counter);
	        }
	    
	}

