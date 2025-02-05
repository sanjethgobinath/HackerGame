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
    
    public static void narrationTwo(){
        StdOut.println(C.sMods.magentaText + "The entrance to the server are requires a keycard and a retinal scan." + C.sMods.reset);
        if(Player.hasItem("Keycard")){
            StdOut.println(C.sMods.magentaText + "You have a keycard. You need to find a way to spoof the retinal scan." + C.sMods.reset);
            interactionThreeA();
        }else if(Player.hasItem("Screwdriver")){
            StdOut.println(C.sMods.magentaText + "You don't have a keycard, but you may be able to use a screwdriver bypass it" + C.sMods.reset);
            interactionThreeB();
        }else{
            StdOut.println(C.sMods.magentaText + "You don't have a keycard or a screwdriver. You need to find a way to get past the entrance." + C.sMods.reset);
            interactionThreeC();
        }

    }

    public static void interactionThreeA() {
        StdOut.println(C.sMods.magentaText + "You approach the retinal scanner with the keycard in hand." + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "You swipe the keycard and the scanner prompts you for a retinal scan." + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "You need to find a way to spoof the retinal scan. What do you do?" + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "1. Use a photo of an authorized person" + C.sMods.reset);
        StdOut.println(C.sMods.magentaText + "2. Hack the scanner" + C.sMods.reset);
        StdOut.println(C.sMods.magentaText + "3. Look for another way in" + C.sMods.reset);
    
        String choice = StdIn.readString().trim();
    
        switch (choice) {
            case "1":
                StdOut.println(C.sMods.magentaText + "You use a photo of an authorized person, but the scanner detects the forgery." + C.sMods.reset);
                Player.addSus();
                Player.checkSus();
                break;
            case "2":
                StdOut.println(C.sMods.magentaText + "You attempt to hack the scanner. It's a difficult task, but you manage to bypass the retinal scan." + C.sMods.reset);
                sleepThread(1500);
                StdOut.println(C.sMods.magentaText + "The door unlocks and you gain access to the server room." + C.sMods.reset);
                // Proceed to the next part of the game
                break;
            case "3":
                StdOut.println(C.sMods.magentaText + "You decide to look for another way in. You find a ventilation shaft that might lead to the server room." + C.sMods.reset);
                sleepThread(1500);
                StdOut.println(C.sMods.magentaText + "You need a screwdriver to open the vent." + C.sMods.reset);
                if (Player.hasItem("Screwdriver")) {
                    StdOut.println(C.sMods.magentaText + "You use the screwdriver to open the vent and crawl through." + C.sMods.reset);
                    // Proceed to the next part of the game
                } else {
                    StdOut.println(C.sMods.magentaText + "You don't have a screwdriver. You need to find one to proceed." + C.sMods.reset);
                    // Go back to searching for items
                }
                break;
            default:
                StdOut.println(C.sMods.magentaText + "Invalid choice. Try again." + C.sMods.reset);
                interactionThreeA(); // Retry the interaction
                break;
        }
    }

    public static void interactionThreeB() {
        StdOut.println(C.sMods.magentaText + "You approach the entrance with the screwdriver in hand." + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "You start working on the panel next to the door, trying to bypass the keycard system." + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "It's a delicate task. What do you do?" + C.sMods.reset);
        sleepThread(1500);
        StdOut.println(C.sMods.magentaText + "1. Cut the red wire" + C.sMods.reset);
        StdOut.println(C.sMods.magentaText + "2. Cut the green wire" + C.sMods.reset);
        StdOut.println(C.sMods.magentaText + "3. Try to short-circuit the system" + C.sMods.reset);
    
        String choice = StdIn.readString().trim();
    
        switch (choice) {
            case "1":
                StdOut.println(C.sMods.magentaText + "You cut the red wire. The door remains locked, and an alarm starts blaring! Authorities have been notified." + C.sMods.reset);
                PoliceChase.policeChase();
                Player.addSus();
                Player.checkSus();
                break;
            case "2":
                StdOut.println(C.sMods.magentaText + "You cut the green wire. The door unlocks, and you gain access to the server room." + C.sMods.reset);
                sleepThread(1500);
                StdOut.println(C.sMods.magentaText + "You quickly enter the server room before anyone notices." + C.sMods.reset);
                // Proceed to the next part of the game
                break;
            case "3":
                StdOut.println(C.sMods.magentaText + "You try to short-circuit the system. Sparks fly, and the door unlocks, but you get a minor shock." + C.sMods.reset);
                Player.subtractHealth();
                Player.checkHealth();
                sleepThread(1500);
                StdOut.println(C.sMods.magentaText + "You quickly enter the server room before anyone notices." + C.sMods.reset);
                // Proceed to the next part of the game
                break;
            default:
                StdOut.println(C.sMods.magentaText + "Invalid choice. Try again." + C.sMods.reset);
                interactionThreeB(); // Retry the interaction
                break;
        }
    }

    public static void interactionThreeC(){
        StdOut.println("A janitor is walking towards you. He asks if you're new. You might be able to get into the server room with his help.");
        StdOut.println("Do you want to talk to him? [Y/N]");
        while(true){
            String option = StdIn.readString().trim().toUpperCase();
            if (option.equals("Y")){
                StdOut.println(C.sMods.yellowText + "Janitor: " + C.sMods.reset + "Hey, where is your uniform? You have a cart but no uniform.");
                sleepThread(1500);
                StdOut.println(C.sMods.greenText + "You: " + C.sMods.reset + "Oh, management never gave me one. I'll get one after I finish cleaning the server room.");
                sleepThread(1500);
                StdOut.println(C.sMods.yellowText + "Janitor: " + C.sMods.reset + "Oh, okay. I can help you out. Follow me.");
                sleepThread(1500);
                StdOut.println("The janitor leads you to the server room. He opens the door for you.");
                sleepThread(1500);
                StdOut.println(C.sMods.yellowText + "Janitor: " + C.sMods.reset + "Don't get spooked when security sneaks up on you. They're always watching... for security.");
                sleepThread(1500);
                StdOut.println(C.sMods.greenText + "You: " + C.sMods.reset + "How often do they check the server room?");
                sleepThread(1500);
                StdOut.println(C.sMods.yellowText + "Janitor: " + C.sMods.reset + "Uhhhhhh... about every 20 minutes.");
                Player.addSus();
                Player.checkSus();
                sleepThread(1500);
                StdOut.println(C.sMods.greenText + "You: " + C.sMods.reset + "Great, thanks!");                
            } else if(option.equals("N")){
                StdOut.println(C.sMods.yellowText + "Janitor: " + C.sMods.reset + "What are you doing here? You don't have a uniform but you have a cart.");
                StdOut.println(C.sMods.magentaText + "You walk away without saying anything. The janitor radios in about the suspicious activity." + C.sMods.reset);
                Player.addSus();
                Player.addSus();
                Player.addSus();
                Player.checkSus();
                break;
            } else{
                interactionThreeC();
            }
        }
    }
    
    public static void sleepThread(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
