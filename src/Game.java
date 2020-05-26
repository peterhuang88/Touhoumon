import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private int i;
    private GameMap gameMap;
    private Player reimu;
    private boolean inputtable;
    MapHandler h;
    MapPanel p;
    GameFrame f;
    Timer timer;

    // constructor
    public Game(String mapfile)

    {
        // create new GameMap and player
        this.gameMap = new GameMap(mapfile);
        this.reimu = new Player("Reimu", 3, 12, 0);
        inputtable = false;
        // create instances of GUI
        this.h = new MapHandler(gameMap, reimu);
        this.p = new MapPanel(h);
        GameFrame f = new GameFrame(p);
        f.addKeyListener(this);
        ActionListener painter = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (!inputtable) {
                    h.resolveStep();
                    p.repaint();
                    inputtable = true;
                }
            }
        };
        timer = new Timer(100 ,painter);
        timer.setRepeats(false);
    }

    public void printMap() {
        this.gameMap.printMap();
    }

    public void keyPressed(KeyEvent e) {
        inputtable = false;
        int code = e.getKeyCode();
        boolean moveresult = false;
        if (code == KeyEvent.VK_UP) {
            moveresult = h.resolveMove(0);
        } else if (code == KeyEvent.VK_RIGHT) {
            moveresult = h.resolveMove(1);
        } else if (code == KeyEvent.VK_DOWN) {
            moveresult = h.resolveMove(2);
        } else if (code == KeyEvent.VK_LEFT) {
            moveresult = h.resolveMove(3);
        } else if (code == KeyEvent.VK_Z) {
            h.resolveInteract();
        }
        p.repaint();
        if (moveresult) {
            timer.start();
        }
    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
}
