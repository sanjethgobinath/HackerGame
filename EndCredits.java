public class EndCredits {
    
    public static void endCredits(){
        SoundPlayer.stopMusic();
        String filepath = "MusicFiles/endcredits.wav";
        SoundPlayer.PlayOnce(filepath);
        String outro = C.sMods.magentaText + " A Game by: " + C.sMods.reset + 
        "Sanjeth, Wyelin, Jeffery, Yash" + C.sMods.magentaText + "\nMusic by: " + C.sMods.reset + 
        "Sanjeth Gobinath" + "\n100 please Mr. Fagella";
        for(int i = 0; i < outro.length(); i++){
            System.out.print(outro.charAt(i));
            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
