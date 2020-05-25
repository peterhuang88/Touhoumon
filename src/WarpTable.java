import java.io.File;
import java.util.Scanner;

public class WarpTable {
    private String[] mapnames;
    private int[] destX;
    private int[] destY;
    public WarpTable(String fname) {
        try {
            File f = new File("maps/" + fname);
            Scanner s = new Scanner(f);
            int n = Integer.parseInt(s.nextLine());
            mapnames = new String[n];
            destX = new int[n];
            destY = new int[n];
            for (int i = 0; i < n; i++) {
                String line  = s.nextLine();
                String[] params = line.split(";");
                int ind = Integer.parseInt(params[0]);
                mapnames[ind] = params[1];
                destX[ind] = Integer.parseInt(params[2]);
                destY[ind] = Integer.parseInt(params[3]);
            }
        } catch(Exception e) {
            System.out.println("Error when reading warp file.");
        }
    }
    public String getName(int code) {
        return mapnames[code];
    }
    public int getDestX(int code) {
        return destX[code];
    }
    public int getDestY(int code) {
        return destY[code];
    }
}
