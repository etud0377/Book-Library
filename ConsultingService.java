

 

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
