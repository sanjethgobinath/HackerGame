package HackerGame;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import HackerGame.Char.sMods;

public class GameManager {
    //POLICE CHASE
    static boolean isHighway;
    public static boolean inGarage = false;
    public static boolean stopLoop = false;
    public static boolean seqOver = false;

    //DIALOGUE
    public static boolean janitorHelp = false;

    public static void gameOver(){
        System.out.println("Game Over");
        System.exit(0);
    }
    
    public static void winGame(){
        SoundPlayer.stopMusic();
        String filepath = "MusicFiles/endcredits.wav";
        SoundPlayer.PlayOnce(filepath);
        String outro = Char.sMods.magentaText + " A Game by: " + Char.sMods.reset + 
        "Sanjeth, Wyelin, Jeffery, Yash" + Char.sMods.magentaText + "\nMusic by: " + Char.sMods.reset + 
        "Sanjeth Gobinath" + "\n100 please Mr. Fagella";
        for(int i = 0; i < outro.length(); i++){
            System.out.print(outro.charAt(i));
            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void escapeScene(){
        StdOut.println(Char.sMods.magentaText + "You have stolen all of the data. You need to escape the building." + Char.sMods.reset);
        StdOut.println(Char.sMods.magentaText + "There is security all around the first and second floor. Choose an escape route." + Char.sMods.reset);
        sleepThread(500);
        StdOut.println("1. HVAC System");
        StdOut.println("2. Elevator");
        StdOut.println("3. Stairs");
        StdOut.println("4. Helicopter");
        int choice = StdIn.readInt();

        switch (choice) {
            case 1:
                StdOut.println("You've chosen the HVAC system.");
                hvacEscape();
                break;
            case 2:
                StdOut.println("You've chosen the elevator, however SWAT was waiting for you.");
                gameOver();
                break;
            case 3:
                StdOut.println("You've chosen the stairs.");
                stairsEscape();
                break;
            case 4:
                StdOut.println("You've chosen the helicopter.");
                helicopterEscape();
                break;
            default:
                StdOut.println("Invalid choice. You've been caught.");
                GameManager.gameOver();
                Player.subtractHealth();
                Player.checkHealth();
                break;
        }
    }

    public static void hvacEscape(){
        StdOut.println(Char.sMods.magentaText + "You have chosen the HVAC system." + Char.sMods.reset);
        StdOut.println(Char.sMods.magentaText + "You need to navigate through the ducts to avoid detection." + Char.sMods.reset);
        sleepThread(500);
        StdOut.println("1. Go straight");
        StdOut.println("2. Turn left");
        StdOut.println("3. Turn right");
        int hvacChoice = StdIn.readInt();

        switch (hvacChoice) {
            case 1:
                StdOut.println("You go straight and encounter a dead end. You run out of oxygen and die.");
                Player.isDead();
                break;
            case 2:
                StdOut.println("You turn left and find an exit. Congrats, you've successfully escaped.");
                winGame();
                break;
            case 3:
                StdOut.println("You turn right and find an exit. You've successfully escaped.");
                GameManager.seqOver = true;
                winGame();
                break;
            default:
                StdOut.println("Invalid choice. You've been caught.");
                GameManager.gameOver();
                Player.subtractHealth();
                Player.checkHealth();
                break;
        }
    }

    public static void stairsEscape(){
        StdOut.println(Char.sMods.magentaText + "You have chosen the stairs." + Char.sMods.reset);
        StdOut.println(Char.sMods.magentaText + "You need to navigate through the stairwell to reach the ground floor." + Char.sMods.reset);
        sleepThread(500);
        StdOut.println("1. Move quietly");
        StdOut.println("2. Move quickly");
        int stairsChoice = StdIn.readInt();

        switch (stairsChoice) {
            case 1:
                StdOut.println("You move quietly, avoiding detection.");
                sleepThread(500);
                StdOut.println("1. Continue moving quietly");
                StdOut.println("2. Move quickly now");
                int quietChoice = StdIn.readInt();
                if (quietChoice == 1) {
                    StdOut.println("You continue moving quietly and reach the ground floor safely.");
                    winGame();
                } else {
                    StdOut.println("You start moving quickly and make noise. Security hears you.");
                    gameOver();
                }
                break;
            case 2:
                StdOut.println("You move quickly, making noise.");
                sleepThread(500);
                StdOut.println("1. Hide in a nearby room");
                StdOut.println("2. Keep moving quickly");
                int quickChoice = StdIn.readInt();
                if (quickChoice == 1) {
                    StdOut.println("You hide in a nearby room and wait for security to pass.");
                    sleepThread(500);
                    StdOut.println("You continue moving quietly and reach the ground floor safely.");
                    winGame();
                } else {
                    StdOut.println("You keep moving quickly and security catches you.");
                    gameOver();
                }
                break;
            default:
                StdOut.println("Invalid choice. You've been caught.");
                gameOver();
                Player.subtractHealth();
                Player.checkHealth();
                break;
        }
    }

    public static void helicopterEscape(){
        StdOut.println(Char.sMods.magentaText + "You have chosen the helicopter." + Char.sMods.reset);
        StdOut.println(Char.sMods.magentaText + "You need to reach the rooftop to board the helicopter." + Char.sMods.reset);
        sleepThread(500);
        StdOut.println("1. Take the stairs");
        StdOut.println("2. Use the elevator");
        int heliChoice = StdIn.readInt();

        switch (heliChoice) {
            case 1:
                StdOut.println(Char.sMods.magentaText + "You take the stairs, but security is patrolling the stairwell." + Char.sMods.reset);
                sleepThread(500);
                StdOut.println("1. Sneak past them");
                StdOut.println("2. Confront them");
                int stairChoice = StdIn.readInt();
                if (stairChoice == 1) {
                    StdOut.println(Char.sMods.magentaText + "You successfully sneak past the security and reach the rooftop." + Char.sMods.reset);
                    winGame();
                } else {
                    StdOut.println(Char.sMods.magentaText + "You confront the security and a fight ensues." + Char.sMods.reset);
                    Player.subtractHealth();
                    Player.checkHealth();
                    if (Player.getHealth() > 0) {
                        StdOut.println(Char.sMods.magentaText + "You manage to defeat the security and reach the rooftop. You get into the helicopter and escape." + Char.sMods.reset);
                        winGame();
                    } else {
                        gameOver();
                    }
                }
                break;
            case 2:
                StdOut.println(Char.sMods.magentaText + "You use the elevator, but it gets stuck halfway." + Char.sMods.reset);
                sleepThread(500);
                StdOut.println("1. Climb through the hatch");
                StdOut.println("2. Wait for help");
                int elevatorChoice = StdIn.readInt();
                if (elevatorChoice == 1) {
                    StdOut.println(Char.sMods.magentaText + "You climb through the hatch and make your way to the rooftop. You escape with $2 million worth of data." + Char.sMods.reset);
                    winGame();
                } else {
                    StdOut.println(Char.sMods.magentaText + "You wait for help, but security arrives and catches you." + Char.sMods.reset);
                    gameOver();
                }
                break;
            default:
                StdOut.println("Invalid choice. You've been caught.");
                gameOver();
                Player.subtractHealth();
                Player.checkHealth();
                break;
        }
    }

    public static void securityPickpocketEntrance() {
        try {
            System.out.println(Char.sMods.redText + "A Security Guard Has Found You, Hide? [Y/N]" + Char.sMods.reset);
            while(true){
                String input = StdIn.readString().trim().toUpperCase();
                if (input.equals("Y")) {
                    System.out.println("He is distracted. Press E to pickpocket.");
                    String secInput = StdIn.readString().trim().toUpperCase();
                    if (secInput.equals("E")) {
                        System.out.println(Char.sMods.greenText + "Pickpocket Successful. Keycard Obtained." + Char.sMods.reset);
                        Player.addItem("Keycard");
                        System.out.println("Picked up keys for a " + Char.sMods.greenText + "Honda Civic Type-R." + Char.sMods.reset);
                        Player.garage.add("Honda Civic Type-R (2022)");
                        System.out.println("Obtained a Glock 19.");
                        Player.addGun("Glock 19");
                        break;
                    } else {
                        System.out.println(Char.sMods.redText + "Missed the opportunity to pickpocket." + Char.sMods.reset);
                        break;
                    }
                } else if (input.equals("N")) {
                    System.out.println(Char.sMods.redText + "INTEGRITY COMPROMISED. " + Char.sMods.reset + "You have lost 2 health");
                    Player.subtractHealth();
                    Player.subtractHealth();
                    break;
                } else {
                    System.out.println("invalid input. try again.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(Char.sMods.redText + "Error reading input. Please try again." + Char.sMods.reset);
        }
    }

    public static void findPassword() {
        String[] animalChoice = {"fox", "frog", "fish"};
        int animalRandInt = (int)(Math.random() * 3); // Random number from 0 to 2 (chooses random animal from arr)
        int randomInt = (int)(Math.random() * 5) + 1; // Chooses random integer for password
        String rand = Integer.toString(randomInt);
        String animal = animalChoice[animalRandInt];
        String password = "red" + animal + rand;
        //Scanner scanner = new Scanner(System.in);
        boolean hintGiven = false;
        int attempts = 0;

        // Loop until the correct password is guessed
        while (true) {
            System.out.println("Enter Password:");
            String guess = StdIn.readString(); // Get user input
            

            // Check if the guess is correct
            if (guess.equals(password)) {
                System.out.println(Char.sMods.greenText + "Correct Password. You may proceed." + Char.sMods.reset);
                System.out.println("*Entering Y-Systems Headquarters...*");
                break; // Exit the loop if the guess is correct
            } else {
                System.out.println(Char.sMods.redText + "Wrong Password. Try again." + Char.sMods.reset);
                attempts++;
                if(attempts % 2 == 0){
                    Player.addSus();
                    Player.checkSus();
                }
                System.out.println(); // Spacing

                // Provide a hint if health is low
                if (attempts >= 5 && !hintGiven) {
                    System.out.println("Hint: animal starts with " + Char.sMods.greenText + password.substring(3, 5) + Char.sMods.reset
                    + " is " + animal.length() + " letters long" + " and number is " + Char.sMods.greenText + randomInt + Char.sMods.reset);
                    hintGiven = true;
                    
                }
            }
        }

        // Close the scanner only after the method is completely done
        //scanner.close();
    }

    public static void dexterityPuzzle() {
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

        sleepThread(500);
        StdOut.println("A janitor has noticed that you're an imposter. Hide the contrabands before he catches you.");
        StdOut.println("Items on the cart: " + Char.sMods.redText + contrabands + Char.sMods.reset);

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

        StdOut.println("Hidden items: " + Char.sMods.greenText + hiddenItems + Char.sMods.reset);
    }

    //POLICE CHASE
    public static void policeChase(){
        SoundPlayer.stopMusic();
        String filepath = "MusicFiles/policeChase.wav";
        SoundPlayer.PlayMusic(filepath);
        int count = 1;
        StdOut.println("Choose a car: ");
        System.out.println();
        if(Player.garage.isEmpty()){
            StdOut.println("Garage is empty. You need to escape on foot.");
            onFoot();
        }else{
            for(int i = 0; i < Player.garage.size(); i++){
                System.out.print(count + ". ");
                count++;
                for(int j = 0; j < Player.garage.get(i).length(); j++){
                    System.out.print(Player.garage.get(i).charAt(j));
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }

            System.out.println();
            StdOut.println("Which car do you want to use? [1, 2, 3]");
            while(true){
                int choice = StdIn.readInt();
                try {
                    if(choice == 1){  
                        StdOut.println("You've chosen: " + Player.garage.get(0));
                        StdOut.println(Char.sMods.greenText + "HP: " + Char.sMods.reset + "315");
                        hondaCivic();
                    }else if(choice == 2){
                        StdOut.println("You've chosen: " + Player.garage.get(1));
                        StdOut.println(Char.sMods.greenText + "HP: " + Char.sMods.reset + "271");
                        subiWrx();
                    }else if(choice == 3){
                        StdOut.println("You've chosen: " + Player.garage.get(2));
                        StdOut.println(Char.sMods.greenText + "HP: " + Char.sMods.reset + "400");
                        toyoSupra();
                        
                    }else{
                        StdOut.println("Such a car does not exist.");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Car not unlocked yet.");
                }
            }
        }
    }

    public static void hondaCivic(){
        int gunChoice = 1;
        StdOut.println("Take the highway? [Y/N]");
        String option = StdIn.readString().trim().toUpperCase();
        if(option.equals("Y")){
            StdOut.println("Okay. Taking I-95...");
            isHighway = true;
        }else if(option.equals("N")){
            StdOut.println("Okay. Staying on Route 69.");
            isHighway = false;
        }
        
        if(isHighway){
            while(true){
                StdOut.println("You've been spotted by a police helicopter.");
                StdOut.println("You need to lose them.");
                StdOut.println("Do you want to take the next exit? [Y/N]");
                String exit = StdIn.readString().trim().toUpperCase();
                if(exit.equals("Y")){
                    StdOut.println("You've taken the exit.");
                    StdOut.println("You've lost the helicopter.");
                    seqOver = true;
                        if (seqOver) {
                            StdOut.println("You've successfully escaped the police.");
                            SoundPlayer.stopMusic();
                            String filepath = "MusicFiles/backgroundmusic1.wav";
                            SoundPlayer.PlayMusic(filepath);
                        }
                    break;
                }else if(exit.equals("N")){
                    StdOut.println("A police car is now following you.");
                    StdOut.println("You need to lose them.");
                    StdOut.println("Do you want to take the next exit? [Y/N]");
                    String exit2 = StdIn.readString().trim().toUpperCase();
                    if(exit2.equals("Y")){
                        StdOut.println("You've taken the exit.");
                        StdOut.println("You've lost the police car.");
                        seqOver = true;
                        if (seqOver) {
                            StdOut.println("You've successfully escaped the police.");
                            SoundPlayer.stopMusic();
                            String filepath = "MusicFiles/backgroundmusic1.wav";
                            SoundPlayer.PlayMusic(filepath);
                        }
                        break;
                    }else if(exit2.equals("N")){
                        StdOut.println("Four police cars and a SWAT truck has joined the chase.");
                        StdOut.println("Your car is struggling to keep up, but you don't have a laptop to add more power.");
                        StdOut.println("Do you want to take the next exit? [Y/N]");
                        String exit3 = StdIn.readString().trim().toUpperCase();
                        if(exit3.equals("Y")){
                            StdOut.println("You've taken the exit.");
                            StdOut.println("You've lost them.");
                            seqOver = true;
                            if (seqOver) {
                                StdOut.println("You've successfully escaped the police.");
                                SoundPlayer.stopMusic();
                                String filepath = "MusicFiles/backgroundmusic1.wav";
                                SoundPlayer.PlayMusic(filepath);
                            }
                            break;
                        }else if(exit3.equals("N")){
                            StdOut.println("12 police cars, 5 SWAT trucks, and a helicopter have joined the chase.");
                            StdOut.println("You need to lose them.");
                            StdOut.println("EXIT NOW. [Y/N]");
                            String exit4 = StdIn.readString().trim().toUpperCase();
                            if(exit4.equals("Y")){
                                StdOut.println("You've taken the exit.");
                                StdOut.println("You've lost them.");
                                seqOver = true;
                            if (seqOver) {
                                StdOut.println("You've successfully escaped the police.");
                                SoundPlayer.stopMusic();
                                String filepath = "MusicFiles/backgroundmusic1.wav";
                                SoundPlayer.PlayMusic(filepath);
                            }
                            break;  
                            }else if(exit4.equals("N")){
                                StdOut.println("You've been caught.");
                                GameManager.gameOver();
                                Player.subtractHealth();
                                Player.checkHealth();
                                break;
                            }
                        }
                    }
                }
            }
        }else{
            StdOut.println("There are going to be hidden police cars on the route.");
            StdOut.println("You must be careful...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StdOut.println("You've been spotted by a police car. What do you want to do?");
            StdOut.println("1. Speed up");
            StdOut.println("2. Take a detour");
            StdOut.println("3. Hide in a nearby alley");

            int choice = StdIn.readInt();
            switch (choice) {
                case 1:
                    StdOut.println("You speed up, but there was an oil spill, leading you to spin out.");
                    Player.subtractHealth();
                    Player.subtractHealth();
                    Player.checkHealth();
                    StdOut.println("You have crashed.");
                    StdOut.println("You see an AR-15 on the ground from a previous robbery.");
                    StdOut.println("Do you want to pick it up? [Y/N]");
                    String ar15 = StdIn.readString().trim().toUpperCase();
                    if(ar15.equals("Y")){
                        StdOut.println("You've picked up the AR-15.");
                        Player.addGun("AR-15");
                    }else if(ar15.equals("N")){
                        StdOut.println("You've left the AR-15.");
                    }
                    
                    break;
                case 2:
                    StdOut.println("You take a detour and manage to lose the police car.");
                    seqOver = true;
                    if (seqOver) {
                        StdOut.println("You've successfully escaped the police.");
                        SoundPlayer.stopMusic();
                        String filepath = "MusicFiles/backgroundmusic1.wav";
                        SoundPlayer.PlayMusic(filepath);
                    }
                    break;
                case 3:
                    StdOut.println("You hide in a nearby alley and the police car passes by.");
                    seqOver = true;
                    if (seqOver) {
                        StdOut.println("You've successfully escaped the police.");
                        SoundPlayer.stopMusic();
                        String filepath = "MusicFiles/backgroundmusic1.wav";
                        SoundPlayer.PlayMusic(filepath);
                    }
                    break;
                default:
                    StdOut.println("Invalid choice. You've been caught.");
                    GameManager.gameOver();
                    Player.subtractHealth();
                    Player.checkHealth();
                    break;
            }

            if(choice == 1){
                StdOut.println("Police are shooting at you. Choose a weapon.");
                for(int i = 0; i < Player.guns.size(); i++){
                    System.out.print(gunChoice + ". ");
                    gunChoice++;
                    for(int j = 0; j < Player.guns.get(i).length(); j++){
                        System.out.print(Player.guns.get(i).charAt(j));
                        try{
                            Thread.sleep(50);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                }

                int gunOption = StdIn.readInt();
                try {
                    StdOut.println("You have chosen: " + Player.guns.get(gunOption - 1));
                } catch (IndexOutOfBoundsException e) {
                    StdOut.println("Gun doesn't exist");
                }

                if(Player.guns.get(gunOption - 1).equals("AR-15")){
                    int magSize = 10;
                    int chance = (int)(Math.random()*25) + 1;
                    boolean hasAmmo = true;
                    StdOut.println("You have " + magSize + "ammo left.");

                    StdOut.println("Press E to shoot.");
                    while(true){
                        String isShooting = StdIn.readString().trim().toUpperCase();
                        if(isShooting.equals("E")){
                            if(magSize < 0){
                                StdOut.println("You have run out of ammo.");
                                StdOut.println("You hide behind a building.");
                                hasAmmo = false;
                                break;
                            }else{
                                magSize--;
                                StdOut.println("You have " + magSize + "ammo left.");
                                try {
                                    Thread.sleep(50);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if(chance % 5 == 0){
                                StdOut.println("You've eliminated the police.");
                                break;
                            }
                        }

                        if(!hasAmmo){
                            StdOut.println("You decide to test your fate and roll a pair of dice.");
                            StdOut.println("If you roll a number that is divisible by 3, you make a run for it.");
                            StdOut.println("Otherwise, you will surrender.");
                            int dice1 = (int)(Math.random()*6) + 1;
                            int dice2 = (int)(Math.random()*6) + 1;
                            int total = dice1 + dice2;
                            StdOut.println("You rolled a " + total + ".");
                            if(total % 3 == 0){
                                StdOut.println("You make a run for it and escape.");
                                seqOver = true;
                                if (seqOver) {
                                    StdOut.println("You've successfully escaped the police.");
                                    SoundPlayer.stopMusic();
                                    String filepath = "MusicFiles/backgroundmusic1.wav";
                                    SoundPlayer.PlayMusic(filepath);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void toyoSupra(){
        StdOut.println("Take the highway?");
        String option = StdIn.readString().trim().toUpperCase();
        if(option.equals("Y")){
            StdOut.println("Okay. Taking I-95...");
            isHighway = true;
        }else if(option.equals("N")){
            StdOut.println("Okay. Staying on Route 69.");
            isHighway = false;
        }

        
        if(isHighway){
            while(true){
                StdOut.println("You've been spotted by a police helicopter.");
                StdOut.println("You need to lose them.");
                StdOut.println("Do you want to take the next exit? [Y/N]");
                String exit = StdIn.readString().trim().toUpperCase();
                if(exit.equals("Y")){
                    StdOut.println("You've taken the exit.");
                    StdOut.println("You've lost the helicopter.");
                    seqOver = true;
                        if (seqOver) {
                            StdOut.println("You've successfully escaped the police.");
                            SoundPlayer.stopMusic();
                            String filepath = "MusicFiles/backgroundmusic1.wav";
                            SoundPlayer.PlayMusic(filepath);
                        }
                    break;
                }else if(exit.equals("N")){
                    StdOut.println("A police car is now following you.");
                    StdOut.println("You need to lose them.");
                    StdOut.println("Do you want to take the next exit? [Y/N]");
                    String exit2 = StdIn.readString().trim().toUpperCase();
                    if(exit2.equals("Y")){
                        StdOut.println("You've taken the exit.");
                        StdOut.println("You've lost the police car.");
                        seqOver = true;
                        if (seqOver) {
                            StdOut.println("You've successfully escaped the police.");
                            SoundPlayer.stopMusic();
                            String filepath = "MusicFiles/backgroundmusic1.wav";
                            SoundPlayer.PlayMusic(filepath);
                        }
                        break;
                    }else if(exit2.equals("N")){
                        StdOut.println("Four police cars and two SWAT trucks have joined the chase.");
                        StdOut.println("You need to lose them.");
                        StdOut.println("Do you want to take the next exit? [Y/N]");
                        String exit3 = StdIn.readString().trim().toUpperCase();
                        if(exit3.equals("Y")){
                            StdOut.println("You've taken the exit.");
                            StdOut.println("You've lost them.");
                            seqOver = true;
                            if (seqOver) {
                                StdOut.println("You've successfully escaped the police.");
                                SoundPlayer.stopMusic();
                                String filepath = "MusicFiles/backgroundmusic1.wav";
                                SoundPlayer.PlayMusic(filepath);
                            }
                            break;
                        }else if(exit3.equals("N")){
                            StdOut.println("12 police cars, 5 SWAT trucks, and a helicopter have joined the chase.");
                            StdOut.println("You need to lose them.");
                            StdOut.println("EXIT NOW. [Y/N]");
                            String exit4 = StdIn.readString().trim().toUpperCase();
                            if(exit4.equals("Y")){
                                StdOut.println("You've taken the exit.");
                                StdOut.println("You've lost them.");
                                seqOver = true;
                                if (seqOver) {
                                    StdOut.println("You've successfully escaped the police.");
                                    SoundPlayer.stopMusic();
                                    String filepath = "MusicFiles/backgroundmusic1.wav";
                                    SoundPlayer.PlayMusic(filepath);
                                }
                                break;  
                            }else if(exit4.equals("N")){
                                StdOut.println("You've been caught.");
                                GameManager.gameOver();
                                Player.subtractHealth();
                                Player.checkHealth();
                                break;
                            }
                        }
                    }
                }
            }
        } else{
            StdOut.println("There are going to be hidden police cars on the route.");
            StdOut.println("You must be careful.");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StdOut.println("You've been spotted by a police car. What do you want to do?");
            StdOut.println("1. Activate nitrous");
            StdOut.println("2. Take a detour");
            StdOut.println("3. Hide in a nearby alley");

            int choice = StdIn.readInt();
            switch (choice) {
                case 1:
                    StdOut.println("You activate nitrous and gain 150HP.");
                    StdOut.println("Burned some rubber but lost the police.");
                    seqOver = true;
                    if (seqOver) {
                        StdOut.println("You've successfully escaped the police.");
                        SoundPlayer.stopMusic();
                        String filepath = "MusicFiles/backgroundmusic1.wav";
                        SoundPlayer.PlayMusic(filepath);
                    }
                    break;
                case 2:
                    StdOut.println("You take a detour, however, you fell for the police's trap.");
                    StdOut.println("More police cars have joined the chase.");
                    break;
                case 3:
                    StdOut.println("You hide in a nearby alley and the police car passes by.");
                    seqOver = true;
                    if (seqOver) {
                        StdOut.println("You've successfully escaped the police.");
                        SoundPlayer.stopMusic();
                        String filepath = "MusicFiles/backgroundmusic1.wav";
                        SoundPlayer.PlayMusic(filepath);
                    }
                    break;
                default:
                    StdOut.println("Invalid choice. You've been caught.");
                    GameManager.gameOver();
                    Player.subtractHealth();
                    Player.checkHealth();
                    break;
            }
        }
    }

    public static void subiWrx(){
        StdOut.println("Uh oh. Your engine is broken" +
        " and there are vape fumes causing second hand lung damage");
        Player.subtractHealth();
        Player.subtractHealth();
        Player.checkHealth();
        StdOut.println("You need to escape on foot.");
        inGarage = true;
        onFoot();
    }

    public static void onFoot() {
        if (inGarage) {
            StdOut.println("Escape via the HVAC system. Find a vent.");
            StdOut.println("Available Vents: Garage, Elevator. [G, E]");
            StdOut.println("Hint: The garage vent will be a faster escape.");

        } else {
            StdOut.println("Escape via the HVAC system. Find a vent.");
            StdOut.println("Available Vents: Storage, North, Elevator. [S, N, E]");
        }

        if (Player.hasItem("Screwdriver")) {
            String option = StdIn.readString().trim().toUpperCase();
            while(true){
                if (option.equals("G") && inGarage) {
                    StdOut.println("You've escaped through the garage.");
                    break;
                } else if (option.equals("G")) {
                    StdOut.println("Vent is too far away. Try again.");
                } else if (option.equals("N") && inGarage) {
                    StdOut.println("Vent is too far away. Try again.");
                } else if (option.equals("N")) {
                    StdOut.println("You've chosen the north vent.");
                    break;
                } else if (option.equals("S") && inGarage) {
                    StdOut.println("Vent is too far away. Try again.");
                } else if (option.equals("S")) {
                    StdOut.println("You've chosen the south vent.");
                    break;
                } else if (option.equals("E") && inGarage) {
                    StdOut.println("You've chosen the elevator vent.");
                    break;
                } else if (option.equals("E")) {
                    StdOut.println("You've chosen the elevator vent.");
                    break;
                }else {
                    StdOut.println("Invalid option chosen.");
                }
            }

            StdOut.println("Vent successful.");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            Thread loopThread = new Thread(() -> {
                for (int i = 1000; i > 0; i -= 100) {
                    if(stopLoop){
                        break;
                    }
                    StdOut.print("\rPolice is " + i + " feet away.");
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                StdOut.println();
            });
            loopThread.start();
            
            StdOut.println("Quick. Take cover. [C]");
            String input = StdIn.readString().trim().toUpperCase();
            if (input.equals("C")) {
                StdOut.println("You took cover. Police has passed.");
            } else {
                StdOut.println("Invalid input.");
            }

            stopLoop = true;

            try {
                loopThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            StdOut.println("You need a screwdriver to open the vent. Find another escape.");
        }
        
        seqOver = true;
        if (seqOver) {
            StdOut.println("You've successfully escaped the police.");
            SoundPlayer.stopMusic();
            String filepath = "MusicFiles/backgroundmusic1.wav";
            SoundPlayer.PlayMusic(filepath);
        }
    }

    //DIALOGUE
    public static void interactionOne(){
        StdOut.println(Char.sMods.magentaText + "An employee is approaching you. Talk to her? [Y/N]" + Char.sMods.reset);
        while(true){
            String d1 = StdIn.readString().trim().toUpperCase();
            if (d1.equals("Y")){
                StdOut.println(Char.sMods.yellowText + "Employee: "+ Char.sMods.reset + "Hey, do you work here?");
                StdOut.println("Lie? [Y/N]");
                String d1a = StdIn.readString().trim().toUpperCase();
                
                if (d1a.equals("Y")){
                    StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Yes, I work here. I'm just here to do maintainance.");
                    sleepThread(1500);
                    StdOut.println(Char.sMods.yellowText + "Employee: " + Char.sMods.reset + "Oh, okay. *walks away*");
                    break;
                }else if (d1a.equals("N")){
                    StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "No, I don't.");
                    sleepThread(1500);
                    StdOut.println(Char.sMods.yellowText + "Employee: " + Char.sMods.reset + "Why are you here?");
                    sleepThread(1500);
                    StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "I'm here to meet someone.");
                    sleepThread(1500);
                    StdOut.println(Char.sMods.yellowText + "Employee: " + Char.sMods.reset + "Oh. Okay.");
                    Player.addSus();
                    Player.checkSus();
                    break;
                }else{
                    StdOut.println("invalid input.");
                }

            } else if(d1.equals("N")){
                StdOut.println(Char.sMods.yellowText + "Employee: " + Char.sMods.reset + "Hey, what's the rush?");
                sleepThread(1500);
                StdOut.println(Char.sMods.magentaText + Char.sMods.italicsStart + "*walks away*" + Char.sMods.italicsEnd + Char.sMods.reset);
                Player.addSus();
                Player.checkSus();
                break;
            } else{
                interactionOne();
            }
        }
    }
    
    public static void narrationOne(){
        StdOut.println(Char.sMods.magentaText + Char.sMods.italicsStart + "You walk to the elevator headed up and walk inside." + Char.sMods.italicsEnd + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.magentaText + Char.sMods.italicsStart + "There is a businessman already inside. He holds the door for you." + Char.sMods.italicsEnd + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "What floor are you headed to?");
        sleepThread(1500);
        StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Floor 9, please.");
        sleepThread(1500);
    }
    
    public static void interactionTwo(){
        StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "So, I haven't seen you here before. Are you that new intern?");
        sleepThread(1500);
        StdOut.println("Lie? [Y/N]");
        while(true){    
            String d2a = StdIn.readString().trim().toUpperCase();
            if (d2a.equals("Y")){
                sleepThread(1500);
                StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Yeah, that's me, its only my first day here.");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "Good to see you around!");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "If you don't mind, I have a favor to ask of you.");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "Can you tell Amy that we had a potential data leak while you are up there?");
                sleepThread(1500);
                StdOut.println("Do the favor for the businessman? [Y/N]");
                String d2b = StdIn.readString().trim().toUpperCase();
                if (d2b.equals("Y")){
                    StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "No problem, I'll make sure to mention it.");
                    sleepThread(1500);
                    StdOut.println("He dropped his keys to a Toyota Supra. Do you pick them up? [Y/N]");
                    String d2c = StdIn.readString().trim().toUpperCase();
                    if (d2c.equals("Y")){
                        StdOut.println(Char.sMods.magentaText + "You pick up the keys and put them in your pocket." + Char.sMods.reset);
                        Player.garage.add("Toyota Supra");
                        StdOut.println();
                        sleepThread(1500);
                        StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "Thanks, I appreciate it.");
                        sleepThread(1500);
                        StdOut.println(Char.sMods.magentaText + Char.sMods.italicsStart + "*walks away*" + Char.sMods.italicsEnd + Char.sMods.reset);
                        break;
                    }
                }else if(d2b.equals("N")){
                    StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Sorry, I'm already working on something David assigned me.");
                    sleepThread(1500);
                    StdOut.println(Char.sMods.yellowText + "Employee: " + Char.sMods.reset + "*David? Who's David?*");
                    Player.addSus();
                    Player.checkSus();
                    break;
                }else{
                    StdOut.println("invalid input.");
                }
            } else if(d2a.equals("N")){
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "Oh. So, why are you here?");
                sleepThread(1500);
                StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset +
                "I'm just here to fix the... uh.. A/C. Yeah, I'm here to fix the A/C.");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Businessman: " + Char.sMods.reset + "*Eduardo is our HVAC tech... Something's off.*");
                Player.addSus();
                Player.checkSus();
                break;
            }
        }
    }   
    
    public static void narrationTwo(){
        StdOut.println(Char.sMods.magentaText + "The entrance to the server are requires a keycard and a retinal scan." + Char.sMods.reset);
        sleepThread(1000);
        if(Player.hasItem("Keycard")){
            StdOut.println(Char.sMods.magentaText + "You have a keycard. You need to find a way to spoof the retinal scan." + Char.sMods.reset);
            sleepThread(1000);
            interactionThreeA();
        }else if(Player.hasItem("Screwdriver")){
            StdOut.println(Char.sMods.magentaText + "You don't have a keycard, but you may be able to use a screwdriver bypass it" + Char.sMods.reset);
            sleepThread(1000);
            interactionThreeB();
        }else{
            StdOut.println(Char.sMods.magentaText + "You don't have a keycard or a screwdriver. You need to find a way to get past the entrance." + Char.sMods.reset);
            sleepThread(1000);
            interactionThreeC();
        }

    }

    public static void interactionThreeA() {
        StdOut.println();
        StdOut.println(Char.sMods.magentaText + "You approach the retinal scanner with the keycard in hand." + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.magentaText + "You swipe the keycard and the scanner prompts you for a retinal scan." + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.magentaText + "You need to find a way to spoof the retinal scan. What do you do?" + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println("1. Use a photo of an authorized person");
        StdOut.println("2. Hack the scanner");
        StdOut.println("3. Look for another way in");
    
        int choice = StdIn.readInt();
        switch (choice) {
            case 1:
                StdOut.println(Char.sMods.magentaText + "You use a photo of an authorized person, but the scanner detects the forgery." + Char.sMods.reset);
                Player.addSus();
                Player.checkSus();
                break;
            case 2:
                StdOut.println(Char.sMods.magentaText + "You attempt to hack the scanner. It's a difficult task, but you manage to bypass the retinal scan." + Char.sMods.reset);
                sleepThread(1500);
                StdOut.println(Char.sMods.magentaText + "The door unlocks and you gain access to the server room." + Char.sMods.reset);
                // Proceed to the next part of the game
                break;
            case 3:
                StdOut.println(Char.sMods.magentaText + "You decide to look for another way in. You find a ventilation shaft that might lead to the server room." + Char.sMods.reset);
                sleepThread(1500);
                StdOut.println(Char.sMods.magentaText + "You need a screwdriver to open the vent." + Char.sMods.reset);
                if (Player.hasItem("Screwdriver")) {
                    StdOut.println(Char.sMods.magentaText + "You use the screwdriver to open the vent and crawl through." + Char.sMods.reset);
                    // Proceed to the next part of the game
                } else {
                    StdOut.println(Char.sMods.magentaText + "You don't have a screwdriver. You need to find one to proceed." + Char.sMods.reset);
                    // Go back to searching for items
                }
                break;
            default:
                StdOut.println(Char.sMods.magentaText + "Invalid choice. Try again." + Char.sMods.reset);
                interactionThreeA(); // Retry the interaction
                break;
        }
    }

    public static void interactionThreeB() {
        StdOut.println(Char.sMods.magentaText + "You approach the entrance with the screwdriver in hand." + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.magentaText + "You start working on the panel next to the door, trying to bypass the keycard system." + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println(Char.sMods.magentaText + "It's a delicate task. What do you do?" + Char.sMods.reset);
        sleepThread(1500);
        StdOut.println("1. Cut the red wire");
        StdOut.println("2. Cut the green wire");
        StdOut.println("3. Try to short-circuit the system");
    
        int choice = StdIn.readInt();
    
        switch (choice) {
            case 1:
                StdOut.println(Char.sMods.magentaText + "You cut the red wire. The door remains locked, and an alarm starts blaring. Authorities have been notified." + Char.sMods.reset);
                GameManager.policeChase();
                Player.addSus();
                Player.checkSus();
                break;
            case 2:
                StdOut.println(Char.sMods.magentaText + "You cut the green wire. The door unlocks, and you gain access to the server room." + Char.sMods.reset);
                sleepThread(1500);
                StdOut.println(Char.sMods.magentaText + "You quickly enter the server room before anyone notices." + Char.sMods.reset);
                enterServerRoom();
                break;
            case 3:
                StdOut.println(Char.sMods.magentaText + "You try to short-circuit the system. Sparks fly, and the door unlocks, but you get a minor shock." + Char.sMods.reset);
                Player.subtractHealth();
                Player.checkHealth();
                sleepThread(1500);
                StdOut.println(Char.sMods.magentaText + "You quickly enter the server room before anyone notices." + Char.sMods.reset);
                enterServerRoom();
                break;
            default:
                StdOut.println(Char.sMods.magentaText + "Invalid choice. Try again." + Char.sMods.reset);
                interactionThreeB(); // Retry the interaction
                break;
        }
    }

    public static void interactionThreeC(){
        StdOut.println("A janitor is walking towards you. He asks if you're new. You might be able to get into the server room with his help.");
        StdOut.println("Do you want to talk to him? [Y/N]");
        while(true){
            String option = StdIn.readString().trim().toUpperCase();
            if (option.equals("Y")){
                StdOut.println(Char.sMods.yellowText + "Janitor: " + Char.sMods.reset + "Hey, where is your uniform? You have a cart but no uniform.");
                sleepThread(1500);
                StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Oh, management never gave me one. I'll get one after I finish cleaning the server room.");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Janitor: " + Char.sMods.reset + "Oh, okay. I can help you out. Follow me.");
                sleepThread(1500);
                StdOut.println("The janitor leads you to the server room. He opens the door for you.");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Janitor: " + Char.sMods.reset + "Don't get spooked when security sneaks up on you. They're always watching... for security.");
                sleepThread(1500);
                StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "How often do they check the server room?");
                sleepThread(1500);
                StdOut.println(Char.sMods.yellowText + "Janitor: " + Char.sMods.reset + "Uhhhhhh... about every 20 minutes.");
                janitorHelp = true;
                Player.addSus();
                Player.checkSus();
                sleepThread(1500);
                StdOut.println(Char.sMods.greenText + "You: " + Char.sMods.reset + "Great, thanks!");
                enterServerRoom();            
            } else if(option.equals("N")){
                StdOut.println(Char.sMods.yellowText + "Janitor: " + Char.sMods.reset + "What are you doing here? You don't have a uniform but you have a cart.");
                StdOut.println(Char.sMods.magentaText + "You walk away without saying anything. The janitor radios in about the suspicious activity." + Char.sMods.reset);
                StdOut.println(Char.sMods.magentaText + "As a result, you beat him up. He is dead." + Char.sMods.reset);
                StdOut.println("His keys to a Subaru WRX are on the ground.");
                StdOut.println("You take the keys.");
                Player.garage.add("Subaru WRX");
                Player.addSus();
                Player.addSus();
                Player.addSus();
                Player.checkSus();
                StdOut.println("You use his face and key card to get in.");
                enterServerRoom();
                break;
            } else{
                interactionThreeC();
            }
        }
    }

    public static void enterServerRoom() {
        Random random = new Random();
        int correctServer = random.nextInt(3) + 1; // Randomly select the correct server (1, 2, or 3)
        int attempts = 3; // Number of attempts allowed
        boolean caught = false;
        int timesSeen = 0;

        StdOut.println("You have entered the server room. There are 3 target servers.");
        StdOut.println("Find the correct server with confidential information. You have " + attempts + " attempts.");

        while (attempts > 0 && !caught) {
            // Memory puzzle
            String memorySequence = generateMemorySequence(5);
            StdOut.println("Memory Puzzle: Remember this sequence: " + memorySequence);
            sleepThread(5000); // Give the player 5 seconds to memorize the sequence
            clearConsole();

            StdOut.println("Enter the sequence you just saw:");
            String userSequence = StdIn.readString().trim();

            if (!userSequence.equals(memorySequence)) {
                StdOut.println("Incorrect sequence. You lose an attempt.");
                attempts--;
                if (attempts > 0) {
                    StdOut.println("You have " + attempts + " attempts left.");
                }
                continue;
            }

            StdOut.println("Memory puzzle passed. Proceed to choose a server to hack (1, 2, or 3):");

            if(timesSeen == 5){
                GameManager.policeChase();
            }

            CountDownLatch latch = new CountDownLatch(1);
            String[] userInput = new String[1];

            Thread inputThread = new Thread(() -> {
                userInput[0] = StdIn.readString().trim();
                latch.countDown();
            });

            inputThread.start();

            Thread countdownThread = new Thread(() -> {
                for (int i = 10; i > 0; i--) {
                    if (latch.getCount() == 0) {
                        break;
                    }
                    StdOut.print("\rYou have " + i + " seconds left.");
                    sleepThread(1000);
                }
                StdOut.println();
            });

            countdownThread.start();

            try {
                if (!latch.await(10, TimeUnit.SECONDS)) {
                    caught = true;
                    StdOut.println("Time's up. Security has come to check on you.");
                    Player.addSus();
                    Player.checkSus();
                    timesSeen++;
                    StdOut.println("Security has left. The timer restarts.");
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int chosenServer;
            try {
                chosenServer = Integer.parseInt(userInput[0]);
            } catch (NumberFormatException e) {
                StdOut.println("Invalid input. Try again.");
                continue;
            }

            if (chosenServer < 1 || chosenServer > 3) {
                StdOut.println("Invalid server number. Try again.");
                continue;
            }

            if (chosenServer == correctServer) {
                StdOut.println("You have successfully hacked the correct server and stolen the confidential information!");
                // Proceed to the next part of the game
                
                return;
            } else {
                StdOut.println("This server does not contain the confidential information.");
                attempts--;
                if (attempts > 0) {
                    StdOut.println("You have " + attempts + " attempts left.");
                }
            }
        }

        if (attempts == 0) {
            StdOut.println("You have used all your attempts and failed to find the correct server.");
            Player.addSus();
            Player.checkSus();
            if (Player.getSus() >= 3) {
                StdOut.println("You've been caught by security!");
                GameManager.gameOver();
            }
        }
    }

    private static String generateMemorySequence(int length) {
        Random random = new Random();
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sequence.append((char) ('A' + random.nextInt(26))); // Generate random uppercase letters
        }
        return sequence.toString();
    }

    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            StdOut.println();
        }
    }

    
    //THREAD SLEEPING
    public static void sleepThread(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
