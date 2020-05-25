import java.awt.Color;

public class Wall implements Chunk {

    public boolean checkCollision() {
        return true;
    }
    public boolean checkInteract() {
        return false;
    }
    public int checkStep() {
        return 0;
    }
    public int getNum() {
        return 1;
    }
    public Color getColor() {
        return Color.BLUE;
    }
}
