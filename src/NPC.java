import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NPC implements Chunk {
    int dir;
    int xPos;
    int yPos;
    private String name;
    private String dispMsg;
    private String mapname;

    public NPC(String fname) {
        try {
            File f = new File("NPCs/" + fname);
            Scanner s = new Scanner(f);
            name = s.nextLine();
            String line2 = s.nextLine();
            dispMsg = s.nextLine();
            String[] pos = line2.split(";");
            mapname = pos[0];
            xPos = Integer.parseInt(pos[1]);
            yPos = Integer.parseInt(pos[2]);
            dir = Integer.parseInt(pos[3]);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean checkCollision() {
        return true;
    }
    public boolean checkInteract() {
        System.out.println(name + ": " + dispMsg);
        return true;
    }
    public int checkStep() {
        return 0;
    }
    public int getNum() {
        return 9;
    }
    public Color getColor() {
        return Color.YELLOW;
    }
}
