package draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{ //JFrame窗口
    private MyPanel mp= null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //图形显示
    }
}

class MyPanel extends JPanel { //窗口游戏面板

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(10,10,100,100);
        g.drawRect(20,20,100,200);
    }
}