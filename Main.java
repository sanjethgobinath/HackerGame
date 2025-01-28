import java.io.File;
//import java.util.Scanner;
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
    
    //private static final char[][] map = ReaderClass.getTxt("map");
    private static Clip clip;
   
   
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
        
        SecurityPickpocketEntrance.securityPickpocketEntrance();

        StdOut.println("An employee is approaching you. Talk to her? [Y/N]");
        String d1 = StdIn.readString();
        if(d1.equals("Y")){
            StdOut.println(yellowText + "Employee: "+ reset + "Hey, do you work here?");
            StdOut.println("Lie? [Y/N]");
            String d1a = StdIn.readString();
            if(d1a.equals("Y")){
                StdOut.println(greenText + "You: " + reset + "Yes, I work here. I'm just here to do maintainance.");
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                StdOut.println(yellowText + "Employee: " + reset + "Oh, okay. *walks away*");
            }else if(d1a.equals("N")){
                StdOut.println(greenText + "You: " + reset + "No, I don't.");
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                StdOut.println(yellowText + "Employee: " + reset + "Why are you here?");
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                StdOut.println(greenText + "You: " + reset + "I'm here to meet someone.");
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                StdOut.println(yellowText + "Employee: " + reset + "Oh. Okay.");
                Player.addSus();
                Player.checkSus();

            }
        }else if(d1.equals("N")){

        }else{

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



