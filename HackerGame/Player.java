package HackerGame;
import java.util.ArrayList;

public class Player {
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";


    
    public static final int defaultHealth = 5;
    public static int health = defaultHealth;
    public static ArrayList<String> inventory = new ArrayList<>();
    public static ArrayList<String> garage = new ArrayList<>();
    public static ArrayList<String> guns = new ArrayList<>();
    public static int sus = 0;
    
    //  HEALTH INFORMATION
    public static int getHealth(){
        return health;
    }

    public static void isDead(){
        System.out.println("You have died.");
        GameManager.gameOver();
    }

    public static void resetHealth(){
        health = defaultHealth;
    }

    public static void checkHealth(){
        System.out.println("You have " + Player.getHealth() + " health left.");
        if (health <= 0) {
            System.out.println("Health is 0. You have been killed.");
            GameManager.gameOver();
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
        System.out.println(greenText + item + RESET + " has been added to your inventory.");
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
            for(int i = 0; i < inventory.size(); i++){
                System.out.println("- " + CYAN + inventory.get(i) + RESET);
            }
            
        }
    }

    public static ArrayList<String> finalInventory(){
        ArrayList<String> empty = new ArrayList<>();
        empty.add("uh oh");
        try {
            if(inventory.size() == 0){
                return null;
            }else{
                return inventory;
            }
        } catch (Exception e) {
            return empty;
        }
    }

    public static void useItem(String item) {
        if (inventory.contains(item)) {
            // Logic for using the item
            System.out.println("You used " + item + ".");
            // Example: Remove the item after use
            if(item != "Keycard"){
                removeItem(item);
            }

            // Add specific effects for known items
            if (item.equalsIgnoreCase("Health Pack")) {
                health = Math.min(health + 5, defaultHealth); // Heal player
                System.out.println("Your health has been restored to " + health + ".");
            }
            
        } else {
            System.out.println(item + " is not in your inventory. You cannot use it.");
        }
    }

    public static boolean hasItem(String item){
        if(inventory.contains(item)){
            return true;
        }else{
            return false;
        }
    }

    // ARSENAL MANAGEMENT
    public static void addGun(String gun){
        guns.add(gun);
        System.out.println(greenText + gun + RESET + " has been added to your arsenal.");
    }
    
    public static void viewArsenal(){
        if (guns.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for(int i = 0; i < guns.size(); i++){
                System.out.println(CYAN + guns.get(i) + RESET);
            }
            
        }
    }

    public static ArrayList<String> finalArsenal(){
        ArrayList<String> empty = new ArrayList<>();
        empty.add("uh oh");
        try {
            if(guns.size() == 0){
                return null;
            }else{
                return guns;
            }
        } catch (Exception e) {
            return empty;
        }
    }

    // GARAGE MANAGEMENT
    public static ArrayList<String> finalGarage(){
        ArrayList<String> empty = new ArrayList<>();
        empty.add("uh oh");
        try {
            if(garage.size() == 0){
                return null;
            }else{
                return garage;
            }
        } catch (Exception e) {
            return empty;
        }
    }
    
    // SOCIAL INTERACTIONS
    public static void addSus(){
        sus++;
        if(sus == 1){
            System.out.println(sus + " person has gained suspicion");
        }else{
            System.out.println(sus + " people have gained suspicion");
        }

    }

    public static void checkSus(){
        if(sus == 3){
            System.out.println(redText + "Be cautious. Multiple people are suspicious of you." + RESET);
        }else if(sus == 5){
            System.out.println(redText + "Police have been called." + RESET);
            GameManager.sleepThread(1000);
            System.out.println(redText + "Police are here. Get ready to run." + RESET);
            GameManager.sleepThread(500);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            GameManager.policeChase();
        }
    }

    public static int getSus(){
        return sus;
    }
    
}
