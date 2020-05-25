import javax.swing.*;

public class GraphicsTester {
    public static void main(String args[]) {
        MapHandler h = new MapHandler(new GameMap("testmap.txt"), new Player("Reimu", 3, 12, 0));
        MapPanel p = new MapPanel(h);
        GameFrame f = new GameFrame(p);
    }
}
