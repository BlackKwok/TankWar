package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输出时
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键被按下
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被按下。。。");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
            this.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
            this.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
            this.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
            this.repaint();
        }
    }
    //当某个键（松开），该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "松开。。");
    }
}

