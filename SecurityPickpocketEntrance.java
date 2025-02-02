import java.util.*;
import HackerGame.*;

public class SecurityPickpocketEntrance {
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String reset = "\u001B[0m";

    public static void securityPickpocketEntrance() {
        try {
            System.out.println(redText + "A Security Guard Has Found You, Hide? [Y/N]" + reset);
            while(true){
                String input = StdIn.readString().trim().toUpperCase();
                if (input.equals("Y")) {
                    System.out.println("He is distracted. Press E to pickpocket.");
                    String secInput = StdIn.readString().trim().toUpperCase();
                    if (secInput.equals("E")) {
                        System.out.println(greenText + "Pickpocket Successful. Keycard Obtained." + reset);
                        Player.addItem("Keycard");
                        System.out.println("Picked up keys for a " + greenText + "Honda Civic Type-R." + reset);
                        Player.garage.add("Honda Civic Type-R (2022)");
                        System.out.println("Obtained a Glock 19.");
                        Player.addItem("Glock 19");
                        break;
                    } else {
                        System.out.println(redText + "Missed the opportunity to pickpocket." + reset);
                        break;
                    }
                } else if (input.equals("N")) {
                    System.out.println(redText + "INTEGRITY COMPROMISED. " + reset + "You have lost 2 health");
                    Player.subtractHealth();
                    Player.subtractHealth();
                    break;
                } else {
                    System.out.println("invalid input. try again.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(redText + "Error reading input. Please try again." + reset);
        }
    }
}