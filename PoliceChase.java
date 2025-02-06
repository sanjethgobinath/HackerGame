import HackerGame.*;

public class PoliceChase {
    static boolean isHighway;
    public static boolean inGarage = false;
    public static boolean stopLoop = false;
    public static boolean seqOver = false;

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
                        StdOut.println(C.sMods.greenText + "HP: " + C.sMods.reset + "315");
                        hondaCivic();
                }else if(choice == 2){
                    StdOut.println("You've chosen: " + Player.garage.get(1));
                    StdOut.println(C.sMods.greenText + "HP: " + C.sMods.reset + "271");
                    subiWrx();
                }else if(choice == 3){
                    StdOut.println("You've chosen: " + Player.garage.get(2));
                    StdOut.println(C.sMods.greenText + "HP: " + C.sMods.reset + "400");
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
                        StdOut.println("Four police cars and a SWAT truck has joined the chase.");
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
}
