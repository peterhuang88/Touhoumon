import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapPanel extends JPanel implements KeyListener {
    public MapHandler h;

    public MapPanel(MapHandler handler) {
        h = handler;
        initPanel();
    }
    public void initPanel() {
        setPreferredSize(new Dimension(220, 180));
        this.setLayout(null);
        //super.addKeyListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                Chunk c = h.displayArea[i][j];
                if (c == null) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(c.getColor());
                }
                g.fillRect(j*20, i*20, 20, 20);
                g.setColor(Color.BLACK);
                g.drawRect(j*20, i*20, 20, 20);
            }
        }
        g.setColor(Color.RED);
        int dir = h.player.getDir();
        g.drawOval(100, 80, 20, 20);
        switch(dir) {
            case 0:
                g.fillOval(108,88,1,1);
                g.fillOval(112,88,1,1);
                break;
            case 1:
                g.fillOval(112,88,1,1);
                g.fillOval(112,92,1,1);
                break;
            case 2:
                g.fillOval(108,92,1,1);
                g.fillOval(112,92,1,1);
                break;
            case 3:
                g.fillOval(108,88,1,1);
                g.fillOval(108,92,1,1);
                break;
        }

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            h.resolveMove(0);
        } else if (code == KeyEvent.VK_RIGHT) {
            h.resolveMove(1);
        } else if (code == KeyEvent.VK_DOWN) {
            h.resolveMove(2);
        } else if (code == KeyEvent.VK_LEFT) {
            h.resolveMove(3);
        }
        repaint();
    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
}
