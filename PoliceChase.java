import HackerGame.*;

public class PoliceChase {
        public static void policeChase(){
            SoundPlayer.stopMusic();
            String filepath = "policeChase.wav";
            SoundPlayer.PlayMusic(filepath);
    
            StdOut.println("Choose a car: ");
            System.out.println();
            if(Player.garage.isEmpty()){
                StdOut.println("Garage is empty. You need to escape on foot.");
            }else{
                for(int i = 0; i < Player.garage.size(); i++){
                    System.out.println("-");
                    for(int j = 0; j < Player.garage.get(i).length(); j++){
                        System.out.print(Player.garage.get(i).charAt(j));
                        try{
                            Thread.sleep(50);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println();
                    }
                }
            }
            
            System.out.println();
            StdOut.println("Type the full make and model you want to use: ");
            String choice = StdIn.readString().trim().toUpperCase();
            
            


        }
}
