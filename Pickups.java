import HackerGame.*;
public class Pickups {
    
    public static void pickupScrewdriver(){
        StdOut.println("You notice a screwdriver on the floor. Pick it up? [Y/N]");
        while(true){
            String choice = StdIn.readString().trim().toUpperCase();
            if(choice.equals("Y")){
                StdOut.println(Char.sMods.greenText + "Screwdriver " + Char.sMods.reset + "Obtained.");
                Player.addItem("Screwdriver");
                break;
            }else if(choice.equals("N")){
                StdOut.println("You ignored the screwdriver.");
                break;
            }else{
                StdOut.println("invalid input.");
            }
        }

        StdOut.println("Do you want to view your inventory? [Y/N]");
        while(true){
            String choice = StdIn.readString().trim().toUpperCase();
            if(choice.equals("Y")){
                Player.viewInventory();
                break;
            }else if(choice.equals("N")){
                break;
            }else{
                StdOut.println("invalid input.");
            }
        }
    }

    public static void pickupHealth(){
        StdOut.println("You notice a health pack on the floor. Pick it up? [Y/N]");
        while(true){
            String choice = StdIn.readString().trim().toUpperCase();
            if(choice.equals("Y")){
                StdOut.println(Char.sMods.greenText + "Health Pack " + Char.sMods.reset + "Obtained.");
                Player.addItem("Health Pack");
                break;
            }else if(choice.equals("N")){
                StdOut.println("You ignored the health pack.");
                break;
            }else{
                StdOut.println("invalid input.");
            }
        }

        StdOut.println("Do you want to view your inventory? [Y/N]");
        while(true){
            String choice = StdIn.readString().trim().toUpperCase();
            if(choice.equals("Y")){
                Player.viewInventory();
                break;
            }else if(choice.equals("N")){
                break;
            }else{
                StdOut.println("invalid input.");
            }
        }
    }
}
