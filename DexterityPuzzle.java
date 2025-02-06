import HackerGame.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DexterityPuzzle {

    public static void dexPuzzle() {
        ArrayList<String> contrabands = new ArrayList<>();
        contrabands.add("screwdriver");
        contrabands.add("flashlight");
        contrabands.add("wrench");
        contrabands.add("pliers");
        contrabands.add("hammer");
        contrabands.add("wire cutters");
        contrabands.add("tape");
        contrabands.add("gloves");

        ArrayList<String> hiddenItems = new ArrayList<>();
        Random random = new Random();
        boolean caught = false;

        StdOut.println("A janitor has noticed that you're an imposter. Hide the contrabands before he catches you.");
        StdOut.println("Items on the cart: " + contrabands);

        while (!contrabands.isEmpty() && !caught) {
            StdOut.println("Enter the name of the item you want to hide (you have 10 seconds):");

            CountDownLatch latch = new CountDownLatch(1);
            String[] userInput = new String[1];

            Thread inputThread = new Thread(() -> {
                userInput[0] = StdIn.readString().trim().toLowerCase();
                latch.countDown();
            });

            inputThread.start();

            try {
                if (!latch.await(10, TimeUnit.SECONDS)) {
                    caught = true;
                    StdOut.println("Time's up. The janitor has caught you with contrabands.");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Thread countdownThread = new Thread(() -> {
                for (int i = 10; i > 0; i--) {
                    if (latch.getCount() == 0) {
                        break;
                    }
                    StdOut.print("\rYou have " + i + " seconds left.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                StdOut.println();
            });

            countdownThread.start();

            try {
                if (!latch.await(10, TimeUnit.SECONDS)) {
                    caught = true;
                    StdOut.println("Time's up. The janitor has caught you with contrabands.");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String item = userInput[0];

            if (contrabands.contains(item)) {
                hiddenItems.add(item);
                contrabands.remove(item);
                StdOut.println("You have hidden: " + item);
            } else {
                StdOut.println("Item not found on the cart. Try again.");
            }

            // Randomly determine if the janitor catches the user
            if (random.nextInt(10) < 2) { // 20% chance of getting caught each round
                caught = true;
                StdOut.println("The janitor has caught you with contrabands.");
            } else {
                StdOut.println("Items left on the cart: " + contrabands);
            }
        }

        if (!caught && contrabands.isEmpty()) {
            StdOut.println("You have successfully hidden all the items.");
        }

        StdOut.println("Hidden items: " + hiddenItems);
    }
}
