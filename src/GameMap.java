import java.io.File;
import java.util.Scanner;

public class GameMap {
    private Chunk[][] mapData;
    private int maxX; // VERTICAL POSITION
    private int maxY; // HORIZ POSITION

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
                    switch(dat) {
                        case 0:
                            mapData[i][j] = new Grass();
                            break;
                        case 1:
                            mapData[i][j] = new Wall();
                            break;
                    }
                }
            }
            maxX = x;
            maxY = y;
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
