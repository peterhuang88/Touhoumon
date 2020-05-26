import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapHandler {
    GameMap map;
    Player player;
    Chunk[][] displayArea;
    WarpTable wt;

    public MapHandler(GameMap m, Player p) {
        map = m;
        player = p;
        displayArea = new Chunk[9][11];
        wt = new WarpTable("testwarps.txt");
        updateDisplayArea();
    }
    public boolean resolveMove(int dir) {
        if (dir != player.getDir()) {
            player.turn(dir);
            return false;
        } else {
            Chunk front = null;
            switch(dir) {
                case 0:
                    front = map.getChunk(player.getXPos() - 1, player.getYPos());
                    break;
                case 1:
                    front = map.getChunk(player.getXPos(), player.getYPos() + 1);
                    break;
                case 2:
                    front = map.getChunk(player.getXPos() + 1, player.getYPos());
                    break;
                case 3:
                    front = map.getChunk(player.getXPos(), player.getYPos() - 1);
                    break;

            }

            // TODO: DEBUG
            System.out.println("Current player pos: (" + player.getXPos() + ", " + player.getYPos() + ")");

            if (front == null || front.checkCollision()) {
                return false;
            } else {
                player.step();
                updateDisplayArea();
                return true;
            }
        }
    }
    public boolean resolveStep() {
        Chunk c = map.getChunk(player.getXPos(), player.getYPos());
        int stepval = c.checkStep();
        if (stepval >= 100) {
            String dest = wt.getName(stepval%100);
            int destx = wt.getDestX(stepval%100);
            int desty = wt.getDestY(stepval%100);
            map = new GameMap(dest);
            player.setPos(destx, desty);
            updateDisplayArea();
            return true;
        }
        return false;
    }
    public boolean resolveInteract() {
        Chunk front = null;
        switch(player.getDir()) {
            case 0:
                front = map.getChunk(player.getXPos() - 1, player.getYPos());
                break;
            case 1:
                front = map.getChunk(player.getXPos(), player.getYPos() + 1);
                break;
            case 2:
                front = map.getChunk(player.getXPos() + 1, player.getYPos());
                break;
            case 3:
                front = map.getChunk(player.getXPos(), player.getYPos() - 1);
                break;

        }
        return front.checkInteract();
    }
    public void updateDisplayArea() {
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 11; n++) {
                Chunk c = map.getChunk(m + player.getXPos() - 4, n + player.getYPos() - 5);
                displayArea[m][n] = c;
            }
        }
    }
}
