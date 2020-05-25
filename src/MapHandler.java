public class MapHandler {
    GameMap map;
    Player player;
    Chunk[][] displayArea;

    public MapHandler(GameMap m, Player p) {
        map = m;
        player = p;
        displayArea = new Chunk[9][11];
        updateDisplayArea();
    }
    public boolean resolveMove(int dir) {
        if (dir != player.getDir()) {
            player.turn(dir);
            return true;
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
                resolveStep(front);
                return true;
            }
        }
    }
    public boolean resolveStep(Chunk c) {
        if (c.checkStep()) {
            System.out.println("Resolve Step Action");
            return true;
        }
        return false;
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
