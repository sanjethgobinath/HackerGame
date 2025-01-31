import HackerGame.*;


public class Dialogue {
    
    private static final String redText = "\u001B[31m";
    private static final String greenText = "\u001B[32m";
    private static final String italicsStart = "\033[3m";
    private static final String italicsEnd = "\033[0m";
    private static final String reset = "\u001B[0m";
    private static final String yellowText = "\u001B[33m";
    private static final String magentaText = "\u001B[35m";

    public static void interactionOne(){
        StdOut.println(magentaText + "An employee is approaching you. Talk to her? [Y/N]" + reset);
        while(true){
            String d1 = StdIn.readString().trim().toUpperCase();
            if (d1.equals("Y")){
                StdOut.println(yellowText + "Employee: "+ reset + "Hey, do you work here?");
                StdOut.println("Lie? [Y/N]");
                String d1a = StdIn.readString().trim().toUpperCase();
                
                if (d1a.equals("Y")){
                    StdOut.println(greenText + "You: " + reset + "Yes, I work here. I'm just here to do maintainance.");
                    sleepThread(1500);
                    StdOut.println(yellowText + "Employee: " + reset + "Oh, okay. *walks away*");
                    break;
                }else if (d1a.equals("N")){
                    StdOut.println(greenText + "You: " + reset + "No, I don't.");
                    sleepThread(1500);
                    StdOut.println(yellowText + "Employee: " + reset + "Why are you here?");
                    sleepThread(1500);
                    StdOut.println(greenText + "You: " + reset + "I'm here to meet someone.");
                    sleepThread(1500);
                    StdOut.println(yellowText + "Employee: " + reset + "Oh. Okay.");
                    Player.addSus();
                    Player.checkSus();
                    break;
                }else{
                    StdOut.println("invalid input.");
                }

            } else if(d1.equals("N")){
                StdOut.println(yellowText + "Employee: " + reset + "Hey, what's the rush?");
                sleepThread(1500);
                StdOut.println(magentaText + italicsStart + "*walks away*" + italicsEnd + reset);
                Player.addSus();
                Player.checkSus();
                break;
            } else{
                interactionOne();
            }
        }
    }
    
    public static void narrationOne(){
        StdOut.println(magentaText + italicsStart + "You walk to the elevator headed up and walk inside." + italicsEnd + reset);
        sleepThread(1500);
        StdOut.println(magentaText + italicsStart + "There is a businessman already inside. He holds the door for you." + italicsEnd + reset);
        sleepThread(1500);
        StdOut.println(yellowText + "Businessman: " + reset + "What floor are you headed to?");
        sleepThread(1500);
        StdOut.println(greenText + "You: " + reset + "Floor 9, please.");
        sleepThread(1500);
    }
    
    public static void interactionTwo(){
        StdOut.println(yellowText + "Businessman: " + reset + "So, I haven't seen you here before. Are you that new intern?");
        sleepThread(1500);
        StdOut.println("Lie? [Y/N]");
        while(true){    
            String d2a = StdIn.readString().trim().toUpperCase();
            if (d2a.equals("Y")){
                sleepThread(1500);
                StdOut.println(greenText + "You: " + reset + "Yeah, that's me, its only my first day here.");
                sleepThread(1500);
                StdOut.println(yellowText + "Businessman: " + reset + "Good to see you around!");
                sleepThread(1500);
                StdOut.println(yellowText + "Businessman: " + reset + "If you don't mind, I have a favor to ask of you.");
                sleepThread(1500);
                StdOut.println(yellowText + "Businessman: " + reset + "Can you tell Amy that we had a potential data leak while you are up there?");
                sleepThread(1500);
                StdOut.println("Do the favor for the businessman? [Y/N]");
                String d2b = StdIn.readString().trim().toUpperCase();
                if (d2b.equals("Y")){
                    StdOut.println(greenText + "You: " + reset + "No problem, I'll make sure to mention it.");
                    sleepThread(1500);
                    break;
                }else if(d2b.equals("N")){
                    StdOut.println(greenText + "You: " + reset + "Sorry, I'm already working on something David assigned me.");
                    sleepThread(1500);
                    StdOut.println(yellowText + "Employee: " + reset + "*David? Who's David?*");
                    Player.addSus();
                    Player.checkSus();
                    break;
                }else{
                    StdOut.println("invalid input.");
                }
            } else if(d2a.equals("N")){
                sleepThread(1500);
                StdOut.println(yellowText + "Businessman: " + reset + "Oh. So, why are you here?");
                sleepThread(1500);
                StdOut.println(greenText + "You: " + reset +
                "I'm just here to fix the... uh.. A/C. Yeah, I'm here to fix the A/C.");
                sleepThread(1500);
                StdOut.println(yellowText + "Businessman: " + reset + "*Eduardo is our HVAC tech... Something's off.*");
                Player.addSus();
                Player.checkSus();
                break;
            }
        }
    }   
    
    public static void interactionThree(){

    }
    
    public static void sleepThread(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
