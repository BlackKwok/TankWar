package tankgame;

import javax.swing.*;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class TankWar01 extends JFrame {
    MyPanel mp =null;
    public static void main(String[] args) {
        TankWar01 tankWar01 = new TankWar01();
    }

    public TankWar01() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1050,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
