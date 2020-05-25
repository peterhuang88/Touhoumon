public class Game {
    private int i;
    private GameMap gameMap;
    private Player reimu;
    MapHandler h;
    MapPanel p;
    GameFrame f;

    // constructor
    public Game(String mapfile) {
        // create new GameMap and player
        this.gameMap = new GameMap(mapfile);
        this.reimu = new Player("Reimu", 3, 12, 0);

        // create instances of GUI
        this.h = new MapHandler(gameMap, reimu);
        this.p = new MapPanel(h);
        GameFrame f = new GameFrame(p);

    }

    public void printMap() {
        this.gameMap.printMap();
    }
}
