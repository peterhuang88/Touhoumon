import java.awt.Color;

public interface Chunk {
    boolean checkCollision();
    boolean checkInteract();
    int checkStep();
    int getNum();
    Color getColor();
}
