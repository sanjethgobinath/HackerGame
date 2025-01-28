import java.util.Scanner;

public class PasswordPuzzle {
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String reset = "\u001B[0m";

    public static void findPassword() {
        String[] animalChoice = {"fox", "frog", "fish"};
        int animalRandInt = (int)(Math.random() * 3); // Random number from 0 to 2 (chooses random animal from arr)
        int randomInt = (int)(Math.random() * 5) + 1; // Chooses random integer for password
        String rand = Integer.toString(randomInt);
        String animal = animalChoice[animalRandInt];
        String password = "red" + animal + rand;
        Scanner scanner = new Scanner(System.in);
        boolean hintGiven = false;

        // Loop until the correct password is guessed
        while (true) {
            System.out.println("Enter Password:");
            String guess = scanner.nextLine(); // Get user input

            // Check if the guess is correct
            if (guess.equals(password)) {
                System.out.println(greenText + "Correct Password. You may proceed." + reset);
                System.out.println("*Entering Y-Systems Headquarters...*");
                break; // Exit the loop if the guess is correct
            } else {
                System.out.println(redText + "Wrong Password. Try again." + reset);
                Player.subtractHealth();
                System.out.println("You have " + Player.getHealth() + " health left.");
                Player.checkHealth();
                System.out.println(); // Spacing

                // Provide a hint if health is low
                if (Player.getHealth() < 8 && !hintGiven) {
                    System.out.println("Hint: animal starts with " + greenText + password.substring(3, 5) + reset
                    + " is " + animal.length() + " letters long" + " and number is " + greenText + randomInt + reset);
                    hintGiven = true;
                    
                }
            }
        }

        // Close the scanner only after the method is completely done
        scanner.close();
    }
}
