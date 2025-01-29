import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import HackerGame.*;

public class PoliceChase {
    private static Clip clip;
    
        public static void policeChase(){
            Main.stopMusic();
            String filepath = "policeChase.wav";
            PlayMusic(filepath);
    
            StdOut.println("Choose a car: ");
            if(Player.garage.isEmpty()){
                StdOut.println("Garage is empty. You need to escape on foot.");
            }else{
                for(int i = 0; i < Player.garage.size(); i++){
                    for(int j = 0; j < Player.garage.get(i).length(); j++){
                        System.out.print("- " + Player.garage.get(i).charAt(j));
                        try{
                            Thread.sleep(50);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            
            System.out.println();
            StdOut.println("Type the full make and model you want to use: ");
            String choice = StdIn.readString().trim().toUpperCase();
            
            


        }
    
    public static void PlayMusic(String location) {
        new Thread(() -> {
            try {
                File musicPath = new File(location);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput); 
                    Thread.sleep(Long.MAX_VALUE); // Keep thread alive to play music
                } else {
                    System.out.println("Cannot find file: " + location);
                }
            } catch (Exception e) {
                System.out.println("Error playing music: " + e.getMessage());
            }
        }).start();
    }
}
