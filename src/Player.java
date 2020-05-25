public class Player {
    private int xPos;   // VERTICAL; TOP = 0
    private int yPos;   // HORIZONTAL; LEFT = 0
    private int facing; // UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3
    private String name;
    private Character main;
    private Character[] support;

    public Player(String name, int xPos, int yPos, int dir) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        this.facing = dir;
        main = null;
        support = new Character[2];
        support[0] = null;
        support[1] = null;
    }
    public void step() {
        switch(facing) {
            case 0:
                xPos--;
                break;
            case 1:
                yPos++;
                break;
            case 2:
                xPos++;
                break;
            case 3:
                yPos--;
                break;
        }
    }
    public void turn(int dir) {
        this.facing = dir;
    }
    public int getXPos() {
        return xPos;
    }
    public int getYPos() {
        return yPos;
    }
    public int getDir() {
        return facing;
    }
    public void setPos(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
