import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class MusicJavaSimple {

    public static void main(String[] args){

        String filepath = "testmusic.wav";
        PlayMusic(filepath);
        JOptionPane.showMessageDialog(null, "press ok to stop playing");
    }

    public static void PlayMusic(String location){
        try{

            File musicPath = new File(location);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("cant find file");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }//i love sanjeth



}