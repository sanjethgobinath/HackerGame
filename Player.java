import java.util.ArrayList;

public class Player {
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";
    
    public static final int defaultHealth = 10;
    public static int health = defaultHealth;
    public static ArrayList<String> inventory = new ArrayList<>();
    
    public static int sus = 0;
    //  HEALTH INFORMATION
    public static int getHealth(){
        return health;
    }

    public static void resetHealth(){
        health = defaultHealth;
    }

    public static void checkHealth(){
        System.out.println("You have " + Player.getHealth() + " health left.");
        if (health <= 0) {
            System.out.println("Health is 0. You have been killed.");
            System.exit(0);  // Terminate the program if health is 0
        }
    }

    public static void subtractHealth(){
        health--;
        if(health <= 0){
            health = 0;
        }
    }

    //  INVENTORY MANAGEMENT

    public static void addItem(String item) {
        inventory.add(item);
        System.out.println(item + " has been added to your inventory.");
    }

    public static void removeItem(String item) {
        if (inventory.remove(item)) {
            System.out.println(item + " has been removed from your inventory.");
        } else {
            System.out.println(item + " is not in your inventory.");
        }
    }
   
    public static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (String item : inventory) {
                System.out.println("- " + CYAN + item + RESET);
            }
        }
    }

    public static void useItem(String item) {
        if (inventory.contains(item)) {
            // Logic for using the item
            System.out.println("You used " + item + ".");
            // Example: Remove the item after use
            removeItem(item);

            // Add specific effects for known items
            if (item.equalsIgnoreCase("Health Potion")) {
                health = Math.min(health + 5, defaultHealth); // Heal player
                System.out.println("Your health has been restored to " + health + ".");
            }
        } else {
            System.out.println(item + " is not in your inventory. You cannot use it.");
        }
    }

    public static void getSus(){
        sus++;
        if(sus == 1){
            System.out.println(sus + " guard has gained suspicion");
        }else{
            System.out.println(sus + " guards have gained suspicion");
        }

    }
    
}
