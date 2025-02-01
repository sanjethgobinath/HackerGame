import HackerGame.*;

public class PoliceChase {
    static boolean isHighway;
    public static boolean inGarage = false;

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
        StdOut.println("Take the highway? [Y/N]");
        String option = StdIn.readString().trim().toUpperCase();
        if(option.equals("Y")){
            StdOut.println("Okay. Taking I-95...");
            isHighway = true;
        }else if(option.equals("N")){
            StdOut.println("Okay. Staying on Route 69.");
            isHighway = false;
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

    public static void onFoot(){
        StdOut.println("Escape via the HVAC system. Find a vent.");
        StdOut.println("Available Vents: Garage, North, Elevator, Storage. [G, N, E, S]");
        String option = StdIn.readString().trim().toUpperCase();
        if(option.equals("G") && inGarage){
            StdOut.println("You've escaped through the garage.");
            
        }else if(option.equals("G")){

        }else if(option.equals("N")){

        }else if(option.equals("E")){

        }else if(option.equals("S")){

        }
    }
}
