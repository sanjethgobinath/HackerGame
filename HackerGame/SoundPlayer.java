package HackerGame;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
    private static Clip clip;
    private static Clip clip2;
    public static boolean isOver = false;
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

    public static void PlayOnce(String location2) {
        new Thread(() -> {
            
            try {
                File audioFile = new File(location2);
                if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip2 = AudioSystem.getClip();
                clip2.open(audioStream);
                clip2.start();
                
                // Wait for the clip to finish playing
                while (clip.isRunning()) {
                    Thread.sleep(100);
                }
                clip.close();
                audioStream.close();
                isOver = true;
                }else{
                    System.out.println("Cannot find file: " + location2);
                }
                
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                System.err.println("Error playing the audio file: " + e.getMessage());
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
            String filepath = "MusicFiles/backgroundmusic1.wav";
            PlayMusic(filepath);
        }
    }
}
