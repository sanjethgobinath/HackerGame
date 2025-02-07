package HackerGame;
import java.io.IOException;
public class VideoPlayer {
    public static void playVideo(String videoPath) {
        try {
            ProcessBuilder pb = new ProcessBuilder();
            
            // Different commands based on operating system
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                // Windows command
                pb.command("cmd.exe", "/c", "start", "/wait", videoPath);
            } else {
                // Linux/Mac command
                pb.command("xdg-open", videoPath);
            }
            
            Process process = pb.start();
            
            // Wait for the video to finish
            process.waitFor();
            
            // Kill the process to ensure cleanup
            process.destroyForcibly();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
    THIS IS HOW TO USE IT IN THE MAIN CLASS
    
 * public class YourMainProgram {
    public static void main(String[] args) {
        System.out.println("Program starting...");
        
        // Your code before video
        
        // Play video in a separate thread so it doesn't block your program
        Thread videoThread = new Thread(() -> {
            VideoPlayer.playVideo("path/to/your/video.mp4");
            // This code will run after video finishes
            System.out.println("Video finished!");
        });
        videoThread.start();
        
        // If you need to wait for the video to finish before continuing
        try {
            videoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Your code after video
        System.out.println("Program continuing after video...");
    }
}
 * 
 * 
 */