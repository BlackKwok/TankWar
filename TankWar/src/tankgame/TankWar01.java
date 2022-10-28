package tankgame;

import jdk.nashorn.internal.ir.CallNode;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class TankWar01 extends JFrame {
    MyPanel mp =null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TankWar01 tankWar01 = new TankWar01();
    }

    public TankWar01() {
        System.out.println("输入 1.新游戏  2.继续上局游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Recorder.saveRecord();
                System.exit(0);
            }
        });
    }
}
