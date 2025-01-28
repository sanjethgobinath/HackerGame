import java.io.File;
//import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import HackerGame.StdIn;
import HackerGame.StdOut;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
public class Main {
    
    //special text thingies
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String italicsStart = "\033[3m";
    private static final String italicsEnd = "\033[0m";
    private static final String reset = "\u001B[0m";
    private static final String yellowText = "\u001B[33m";
    
    private static final char[][] map = ReaderClass.getTxt("map");
    private static Clip clip;
    private static boolean timeExpired = false;
    private static final int TIME_LIMIT_MS = 3000; 
   
   
    public static void main(String[] args){
        String filepath = "backgroundmusic.wav";
        PlayMusic(filepath);
        // this is a test from somwhere online
        //Instructions
        //new test
        StdOut.println(yellowText + "Music by Sanjeth Gobinath" + reset);
        System.out.println(redText + italicsStart + 
            "Welcome player." + "\n" + 
            "\nYou are an experienced hacker working for HAKSYS Corp." + 
            "\nYour job is to infiltrate the server room of Y-Systems Corp and steal all their data." +
            "\nYou will encounter several obstacles; First you need to guess the password" +
            "\nThe password starts with the word red, has a common animal that starts with F, and a number from 1-5." + 
            "\nGood Luck, Comrade." +
            italicsEnd + reset);
        System.out.println();
        
        String intro = greenText + "Hello. Welcome to Y-Systems."  + 
            "\nPlease enter your password." + reset;
        
        //Typewriter effect
        for(int i = 0; i < intro.length(); i++){
            System.out.print(intro.charAt(i));
            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
        System.out.println(); //Enter next line
        //ReaderClass.print2DArr(map);
        

        PasswordPuzzle.findPassword();
       
        try{
            Thread.sleep(1200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("RUNNING");
        
        SecurityPickpocketEntrance.securityPickpocketEntrance();
        
       
        /* 
        System.out.println(redText + "\nA Security Guard Has Found You." + reset);
        StdOut.println("Hide? [Y/N]");
        String input = StdIn.readString();
        input = input.trim().toUpperCase();
        if (input.equals("Y")) {
        System.out.println("Security is distracted. Press E to pickpocket.");
        String secondInput = StdIn.readString();
        secondInput = secondInput.trim().toUpperCase();
        
        if (input.equals("E")) {
            System.out.println("Obtained Keycard.");
            Player.addItem("Keycard");
        }else{
        
        }
        } else if (input.equals("N")) {
        System.out.println(redText + "INTEGRITY COMPROMISED. " + reset + "You have been thrown out of the building.");
        System.out.println("");
        System.exit(0);
        } else {
        System.out.println("Invalid input. Type Y or N.");
        
        }
        */
 
    }
    
    public static void testing(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter something: ");
        
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } else {
            System.out.println("No input available.");
        }
        
        scanner.close();
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



