import java.io.File;
import java.util.Scanner;

public class GameMap {
    private Chunk[][] mapData;
    private int maxX; // VERTICAL POSITION
    private int maxY; // HORIZ POSITION
    private NPC[] npcs;

    public GameMap(String fname) {
        try {
            File f = new File("maps/" + fname);
            Scanner s = new Scanner(f);
            int x = s.nextInt();
            int y = s.nextInt();
            mapData = new Chunk[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int dat = s.nextInt();
                    if (dat == 0) {
                        mapData[i][j] = new Grass();
                    } else if (dat == 1) {
                        mapData[i][j] = new Wall();
                    } else if (dat >= 100) {
                        mapData[i][j] = new Warp(dat);
                    }
                }
            }
            maxX = x;
            maxY = y;
            f = new File("NPCs/" + fname);
            s = new Scanner(f);
            int n = Integer.parseInt(s.nextLine());
            npcs = new NPC[n];
            for (int i = 0; i < n; i++) {
                npcs[i] = new NPC(s.nextLine());
                mapData[npcs[i].xPos][npcs[i].yPos] = npcs[i];
            }
        } catch(Exception e) {
            System.out.println("Error when reading map file.");
        }
    }
    public void printMap() {
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                Chunk c = mapData[i][j];
                System.out.print(c.getNum() + "  ");
            }
            System.out.println();
        }
    }
    public Chunk getChunk(int x, int y) {
        try {
            return mapData[x][y];
        } catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
