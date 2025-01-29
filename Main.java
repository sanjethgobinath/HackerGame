import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import HackerGame.*;
public class Main {
    
    //special text thingies
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String italicsStart = "\033[3m";
    private static final String italicsEnd = "\033[0m";
    private static final String reset = "\u001B[0m";
    private static final String yellowText = "\u001B[33m";
    private static final String magentaText = "\u001B[35m";
    
    private static Clip clip;
   
    public static void main(String[] args){
        String filepath = "backgroundmusic.wav";
        PlayMusic(filepath);
        // this is a test from somwhere online
        //Instructions
        //new test
        StdOut.println(yellowText + "Music by Sanjeth Gobinath" + reset);
        System.out.println(magentaText + italicsStart + 
            "Welcome player." + "\n" + 
            "\nYou are an experienced hacker working for HAKSYS Corp." + 
            "\nYour job is to infiltrate the server room of Y-Systems Corp and steal all their data." +
            "\nYou will encounter several obstacles; First you need to guess the password" +
            "\n\nThe password starts with the word red, has a common animal that starts with F, and a number from 1-5." + 
            "\nGood Luck, Comrade." +
            italicsEnd + reset);
        System.out.println();
        
        String intro = greenText + "Hello. Welcome to Y-Systems."  + 
            "\nPlease enter your password." + reset;
        
        //Typewriter effect
        for(int i = 0; i < intro.length(); i++){
            System.out.print(intro.charAt(i));
            sleepThread(50);
        }
        
        System.out.println(); //Enter next line        
        PasswordPuzzle.findPassword();
        sleepThread(1000);
    
        SecurityPickpocketEntrance.securityPickpocketEntrance();
        Dialogue.interactionOne();
        Dialogue.narrationOne();
    }

    public static void sleepThread(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public static void PlayMusic(String location) {
        new Thread(() -> {
            try {
                File musicPath = new File(location);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.loop(Clip.LOOP_CONTINUOUSLY); // Enable continuous looping
                    Thread.sleep(Long.MAX_VALUE); // Keep thread alive to play music
                } else {
                    System.out.println("Cannot find file: " + location);
                }
            } catch (Exception e) {
                System.out.println("Error playing music: " + e.getMessage());
            }
        }).start();
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public static void startMusic(){
        if (clip == null && !clip.isRunning()){
            String filepath = "testmusic.wav";
            PlayMusic(filepath);
        }
    }
    
}



