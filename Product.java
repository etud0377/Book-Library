
 

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
