package HackerGame;

import java.io.File;
import java.io.IOException;

public class Game {
        public static void main(String[] args){
        
        Thread videoThread = new Thread(() -> {
            VideoPlayer.playVideo("HackerGame/introVid.mp4");
        });
        videoThread.start();
        try {
            videoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        GameManager.sleepThread(97500); //waiting for 97000 second video with 500ms buffer
        
        String filepath = "MusicFiles/backgroundmusic1.wav";
        SoundPlayer.PlayMusic(filepath);
        // this is a test from somwhere online
        //Instructions
        //new test
        System.out.println(Char.sMods.magentaText + Char.sMods.italicsStart + 
            "\nIn order to enter the building you need to guess the password." +
            "\nThe password starts with the word " + Char.sMods.redText + "red"+
            Char.sMods.reset + Char.sMods.magentaText +
            ", has a common animal that starts with F, and a number from 1-5." + 
            "\nGood Luck, Comrade." +
            Char.sMods.italicsEnd + Char.sMods.reset);
        System.out.println();
        
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
        String intro = Char.sMods.greenText + "Hello. Welcome to Y-Systems."  + 
            "\nPlease enter your password." + Char.sMods.reset;
        
        //Typewriter effect
        for(int i = 0; i < intro.length(); i++){
            System.out.print(intro.charAt(i));
            GameManager.sleepThread(50);
        }
        
        System.out.println(); //Enter next line        
        
        
        GameManager.findPassword();
        GameManager.sleepThread(1000);
        GameManager.securityPickpocketEntrance();
        GameManager.interactionOne();
        GameManager.narrationOne();
        GameManager.interactionTwo();
        Pickups.pickupScrewdriver();
        GameManager.dexterityPuzzle();
        GameManager.narrationTwo();
    } 
}



