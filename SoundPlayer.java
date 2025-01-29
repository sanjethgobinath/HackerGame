import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
    private static Clip clip;
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
            String filepath = "MusicFiles/backgroundmusic1.wav";
            PlayMusic(filepath);
        }
    }
}
