import HackerGame.*;
public class Pickups {
    
    public static void pickupScrewdriver(){
        StdOut.println("You notice a screwdriver on the floor. Pick it up? [Y/N]");
        while(true){
            String choice = StdIn.readString().trim().toUpperCase();
            if(choice.equals("Y")){
                StdOut.println(C.sMods.greenText + "Screwdriver " + C.sMods.reset + "Obtained.");
                Player.addItem("Screwdriver");
                break;
            }else if(choice.equals("N")){
                StdOut.println("You ignored the screwdriver.");
                break;
            }else{
                StdOut.println("invalid input.");
            }
        }
    }
}
