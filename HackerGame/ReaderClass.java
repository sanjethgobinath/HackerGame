package HackerGame;
import java.io.*;
//import java.nio.file.*;
import java.util.*;
//import java.util.stream.*;

public class ReaderClass {
    public static List<String> parseTxt(String name) {
        try {
            List<String> output = new ArrayList<>();
            Scanner fileIn = new Scanner(new File(name));
            while (fileIn.hasNext()){
                String lineIn = fileIn.nextLine(); 
                output.add(lineIn);
            }
            fileIn.close();
            return output;
            
        } catch (Exception e) {
            throw new RuntimeException(name + " isn't a file");
        }
    }
    
    public static void print2DArr(char[][] array) {
        for (char[] row : array) {
            System.out.println(row);
        }
    }
    
    public static char[][] getTxt(String name){
        List<String> list = parseTxt(name);

        char[][] x = new char[list.size()][list.get(0).length()];

        for (int r = 0; r < x.length; r++){
            for (int c = 0; c < x[0].length; c++){
                x[r][c] = list.get(r).charAt(c);
            }
        }
        return x;
    }
}