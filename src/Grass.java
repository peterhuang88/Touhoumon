import java.awt.Color;

public class Grass implements Chunk {

    public boolean checkCollision() {
        return false;
    }
    public boolean checkInteract() {
        return false;
    }
    public int checkStep() {
        return 0;
    }
    public int getNum() {
        return 0;
    }
    public Color getColor() {
        return Color.GREEN;
    }
}
