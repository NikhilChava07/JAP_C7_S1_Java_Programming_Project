package SimpleAudioPlayer;

import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
public class SimpleAudioPlayer {
    public static void Ncjukebox(String audio, String type) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        String filepath="";
        Scanner scanner = new Scanner(System.in);
        if(type.equalsIgnoreCase("song")) {
             filepath = "src/main/java/Resources/SongResources/" +audio;
        }
        else
            filepath = "src/main/java/Resources/PodcastResources/" +audio;
        File file = new File(filepath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = "";


        while(!response.equals("4")) {
            System.out.println("Enter 1 to play\n2 to Pause\n3 to Restart\n4 to Quit");
            System.out.print("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch(response) {
                case ("1"): clip.start();
                    break;
                case ("2"): clip.stop();
                    break;
                case ("3"): clip.setMicrosecondPosition(0);
                    break;
                case ("4"): clip.close();
                    break;
                default: System.out.println("Not a valid choice");
            }
        }
    }
}