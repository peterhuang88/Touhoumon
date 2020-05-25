import java.awt.Color;

public class Wall implements Chunk {

    public boolean checkCollision() {
        return true;
    }
    public boolean checkInteract() {
        return false;
    }
    public boolean checkStep() {
        return false;
    }
    public int getNum() {
        return 1;
    }
    public Color getColor() {
        return Color.BLUE;
    }
}
