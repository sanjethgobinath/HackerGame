import HackerGame.*;

public class Dialogue {
    
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String italicsStart = "\033[3m";
    private static final String italicsEnd = "\033[0m";
    private static final String reset = "\u001B[0m";
    private static final String yellowText = "\u001B[33m";'
'
    public static void dialogue1(){
        StdOut.println("An employee is approaching you. Talk to her? [Y/N]");
        String d1 = StdIn.readString().trim().toUpperCase();
        if (d1.equals("Y")){
            StdOut.println(yellowText + "Employee: "+ reset + "Hey, do you work here?");
            StdOut.println("Lie? [Y/N]");
            String d1a = StdIn.readString().trim().toUpperCase();
            if (d1a.equals("Y")){
                StdOut.println(greenText + "You: " + reset + "Yes, I work here. I'm just here to do maintainance.");
                sleepThread(1000);
                StdOut.println(yellowText + "Employee: " + reset + "Oh, okay. *walks away*");
            } else if (d1a.equals("N")){
                StdOut.println(greenText + "You: " + reset + "No, I don't.");
                sleepThread(1000);
                StdOut.println(yellowText + "Employee: " + reset + "Why are you here?");
                sleepThread(1000);
                StdOut.println(greenText + "You: " + reset + "I'm here to meet someone.");
                sleepThread(1000);
                StdOut.println(yellowText + "Employee: " + reset + "Oh. Okay.");
                Player.addSus();
                Player.checkSus();
            }
        } else if(d1.equals("N")){
            StdOut.println(yellowText + "Employee: " + reset + "Hey, what's the rush?");
            sleepThread(1000);
            StdOut.println(greenText + "You: " + reset + "*walks away*");
            Player.addSus();
            Player.checkSus();
        } else{
            dialogue1();
        }
    }
    public static void dialogue2(){

    }
    public static void dialogue3(){

    }
    public static void sleepThread(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
