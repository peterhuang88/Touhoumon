import java.awt.*;

public class Warp implements Chunk{
    private int dest;
    public Warp(int dest) {
        this.dest = dest;
    }
    public boolean checkCollision() {
        return false;
    }
    public boolean checkInteract() {
        return false;
    }
    public int checkStep() {
        return dest;
    }
    public int getNum() {
        return dest;
    }
    public Color getColor() {
        return Color.RED;
    }
}
