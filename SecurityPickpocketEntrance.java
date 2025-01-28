import java.util.*;
import HackerGame.*;

public class SecurityPickpocketEntrance {
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String reset = "\u001B[0m";

    public static void securityPickpocketEntrance() {
        try {
            System.out.println(redText + "A Security Guard Has Found You, Hide? [Y/N]" + reset);
            String input = StdIn.readString().trim().toUpperCase();

            if (input.equals("Y")) {
                System.out.println("He is distracted. Press E to pickpocket.");
                String secInput = StdIn.readString().trim().toUpperCase();
                if (secInput.equals("E")) {
                    System.out.println(greenText + "Successfully pickpocketed the guard!" + reset);
                    Player.addItem("Keycard");
                } else {
                    System.out.println(redText + "Missed the opportunity to pickpocket." + reset);
                }
            } else if (input.equals("N")) {
                System.out.println(redText + "INTEGRITY COMPROMISED. " + reset + "You have been thrown out of the building.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Must be Y or N.");
            }
        } catch (NoSuchElementException e) {
            System.out.println(redText + "Error reading input. Please try again." + reset);
        }
    }
}