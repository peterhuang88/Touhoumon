import javax.swing.*;

public class GameFrame extends JFrame {
    JPanel p;
    public GameFrame(JPanel p) {
        this.p = p;
        init();
    }
    public void init() {
        add(p);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //addKeyListener(p);
    }
}
