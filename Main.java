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
        //VIDEO PLAYER - UNCOMMENT BEFORE SUBMITTING
        /* 
        Thread videoThread = new Thread(() -> {
            VideoPlayer.playVideo("introVid.mp4");
        });
        videoThread.start();
        try {
            videoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleepThread(97000);
        */

        String filepath = "MusicFiles/backgroundmusic1.wav";
        SoundPlayer.PlayMusic(filepath);
        // this is a test from somwhere online
        //Instructions
        //new test
        StdOut.println(yellowText + "Music by Sanjeth Gobinath" + reset);
        System.out.println(magentaText + italicsStart + 
            "\nIn order to enter the building you need to guess the password." +
            "\nThe password starts with the word red, has a common animal that starts with F, and a number from 1-5." + 
            "\nGood Luck, Comrade." +
            italicsEnd + reset);
        System.out.println();
        
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
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
        Dialogue.interactionTwo();

    }

    public static void sleepThread(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    
    
    
}



