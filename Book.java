//*********************************************************

/*
 * In this file, do the following things:
 * 1) Modify the class so that it inherits from Product
 * 2) Create a constructor that takes in a book title and book cost
 */
 

public class Book extends Product {
   public Book(String title, double cost){
      super(title, cost);
   }

}

//*********************************************************

/*
 * In this file, do the following things:
 * 1) Modify the class so that all ConsultingService objects must use the Sellable interface
 * 2) Create a constructor that takes in a consulting service name, consulting service cost per hour,
 *    and a consulting service number of hours
 * 3) Override the getCost() method and return the result of multiplying the consulting service cost per hour by
 *    the consulting service number of hours
 */
 

public class ConsultingService implements Sellable {
   private String name;
   private double costPerHour;
   private double numHours;
   
   
   public ConsultingService (String name, double costPerHour, double numHours){
      this.name = name;
      this.costPerHour = costPerHour;
      this.numHours = numHours;
   }
   public String getName() { return this.name; }
   public double getCostPerHour() { return this.costPerHour; }
   public double getNumHours() { return this.numHours; }
   
   public double getCost(){
      return this.costPerHour * this.numHours;
   }


   public String toString() {
      return "Consulting Service: " + getName() + "\n"
           + "Cost Per Hour: " + String.format("$%.2f", getCostPerHour()) + "\n"
           + "Number of Hours: " + getNumHours() + " hours";     
   }
}
//*********************************************************

/*
 * In this file, do the following things:
 * 1) Modify the class so that it inherits from Product
 * 2) Create a constructor that takes in a DVD title, DVD cost, and DVD genre
 * 3) Override the getCost() method by adding the DVD handling fee to the cost calculated for a Product
 */
 

public class DVD extends Product {
   public static final double HANDLING_FEE = 1.00;
   private String genre;
   
   public DVD(String title, double cost,String genre){
      super(title, cost);
       this.genre = genre;
   }
   public String getGenre() {
      return this.genre;
   }
   public double getCost(){
      return HANDLING_FEE + super.getCost();
   }
   public String toString() {
      return "Genre: " + getGenre();
   }   
}

//*********************************************************

/*
 * In this file, do the following things:
 * 1) Modify the class so that a Product object cannot be created. Instead, only subclass objects of
 *    Product can be created
 * 2) Modify the class so that all Product objects must use the Sellable interface
 */
 

public abstract class Product implements Sellable {
   private String title;
   private double cost;
  
   public Product(String title, double cost) {
      this.title = title;
      this.cost = cost;
   }
  
   public String getTitle() { return this.title; }
  
   public double getCost() {
      return this.cost;
   }

   public String toString() {
      return "Title: " + getTitle();
   }  
}
//*********************************************************

/*
 * In this file, complete tasks as identified below, only inside of the commented areas
 */

import javax.swing.JOptionPane;
public class Purchase {
   public static void main(String[] args) {
      final int MAX_ITEMS = 3;
     
      // BEGIN: Create an array of type Sellable, called items
      Sellable[] items = new Sellable[MAX_ITEMS]; 
      
     
      // END

      populateItems(items);
      displayReceipt(items);
   }
  
   private static void populateItems(Sellable[] items) {
  
      // BEGIN: In the items array, hardcode the creation of one book, one DVD, and one consulting service
        items[0] = new Book("Under the Dome by Stephen King" , 9.95);
        items[1] = new DVD("Casablanca" , 14.99 + 1.00 , " Drama Section");
        items[2] = new ConsultingService("DVD Repair" , 100.00, 1);
     // END
   }
  
   private static void displayReceipt(Sellable[] items) {
      String receipt = "***Bob's Retail Store***\n\n";
      double total = 0;
  
      // BEGIN: Loop through all of the items in the array of type Sellable to calculate the total, and print out the item's cost
      //        and a String representation of the item for each item
         for(int i = 0; i < items.length; i ++){
            receipt +=  items[i] + "\n";
            total += items[i].getCost();
         }
      // END
     
      // BEGIN: Create one line that will calculate the sales tax based on the total (Hint: Remember SALES_TAX is stored in the interface)
      double salesTax = total * Sellable.SALES_TAX;
      // END
     
      receipt += "Total: " + String.format("$%.2f", total) + "\n";
      receipt += "Sales Tax: " + String.format("$%.2f", salesTax) + "\n";
      receipt += "Grand Total: " + String.format("$%.2f", total + salesTax) + "\n";     
      JOptionPane.showMessageDialog(null, receipt);
   }
}
//*********************************************************

/*
 * In this file, do the following things:
 * 1) Create a constant called SALES_TAX set for a rate of 6%
 * 2) Create a getCost() method that returns a double
 */

public interface Sellable {
   double SALES_TAX = 0.06;
   
   double getCost();
 

}

//*********************************************************

