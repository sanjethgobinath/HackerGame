import HackerGame.*;

public class PoliceChase {
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
                System.out.println(count + ". ");
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
            int choice = StdIn.readInt();
            if(choice == 1){
                StdOut.println("You've chosen: " + Player.garage.get(0));
                hondaCivic();
            }else if(choice == 2){
                StdOut.println("You've chosen: " + Player.garage.get(1));
                subiWrx();
            }else if(choice == 3){
                StdOut.println("You've chosen: " + Player.garage.get(2));
                toyoSupra();
                
            }
        }
    }

    public static void hondaCivic(){
        StdOut.println("Take the highway?");
    }

    public static void toyoSupra(){
        StdOut.println("Take the highway?");

    }

    public static void subiWrx(){
        StdOut.println("Uh oh. Your engine is broken" +
        " and there are vape fumes causing second hand lung damage");
        Player.subtractHealth();
        Player.subtractHealth();
        StdOut.println("You need to esacpe on foot.");
        onFoot();
    }

    public static void onFoot(){
        StdOut.println("Escape via the HVAC system. Find a vent.");
    }
}
