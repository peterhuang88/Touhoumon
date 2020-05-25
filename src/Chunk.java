import java.awt.Color;

public interface Chunk {
    boolean checkCollision();
    boolean checkInteract();
    boolean checkStep();
    int getNum();
    Color getColor();
}
