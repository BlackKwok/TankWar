package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import java.util.Vector;

/**
 * @author 郭润达
 * @version 1.0
 * 坦克大战的绘图区域
 **/
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    Vector<Enemy> enemyTank = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<Node_> nodes = new Vector<>();
    int enemyTankSize = 3;
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) {
        File file = new File(Recorder.getRecordFile());
        if (file.exists()) {
            nodes = Recorder.getNodesAndEnemyTankRec();
        }else{
            System.out.println("文件不存在，开启新游戏");
            key = "1";
        }
        hero = new Hero(310, 500); //初始化自己的坦克
        switch(key) {
            case "1":
                for (int i = 0; i < enemyTankSize; i++) {
                    Enemy enemy = new Enemy(10 + 300 * i, 10);
                    enemy.setEnemyTank(enemyTank);
                    enemy.setDirect(2);
                    enemy.setSpeed(6);
                    new Thread(enemy).start();
                    enemyTank.add(enemy);
                }
                break;
            case "2":
                for (int i = 0; i < nodes.size(); i++) {
                    Node_ node_ = nodes.get(i);
                    Enemy enemy = new Enemy(node_.getX(),node_.getY());
                    enemy.setEnemyTank(enemyTank);
                    enemy.setDirect(node_.getDirect());
                    enemy.setSpeed(6);
                    new Thread(enemy).start();
                    enemyTank.add(enemy);
                }
                break;
            default:
                System.out.println("输入有误...");
                break;
        }
        hero.setSpeed(10);
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));
    }
    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累计击毁敌方坦克：",1020,30);
        drawTank(1020,60,g,0,0); //画出一个敌方坦克
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTanNum()+"",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Recorder.setEnemys(enemyTank);
        g.fillRect(0, 0, 1000, 750); //填充矩形，默认黑色
        showInfo(g);
        if (hero != null && hero.isAlive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isAlive() == true) {
                g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
            } else {
                hero.shots.remove(shot);
            }
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
        for (int i = 0; i < enemyTank.size(); i++) {
            Enemy enemy = enemyTank.get(i);
            if (enemy.isAlive) {
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
                for (int j = 0; j < enemy.shot.size(); j++) {
                    Shot shot = enemy.shot.get(j);
                    if (shot.isAlive()) {
                        g.draw3DRect(shot.getX(), shot.getY(), 1, 1, true);
                    } else {
                        enemy.shot.remove(j);
                    }
                }
            }
        }
    }

    /**
     * @param x      坦克左上角坐标
     * @param y      坦克左上角的坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch (direct) {
            case 0:  //向上W
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: //向右D
                g.fill3DRect(x - 10, y + 10, 60, 10, false);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.fill3DRect(x, y + 20, 40, 20, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 50, y + 30);
                break;
            case 2: //向下S
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: //向左A
                g.fill3DRect(x - 10, y + 10, 60, 10, false);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.fill3DRect(x, y + 20, 40, 20, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x - 10, y + 30);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //判断坦克是否集中敌人坦克
    public void hitTank(Shot s, Tank enemy) {
        switch (enemy.getDirect()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (s.getX() > enemy.getX() && s.getX() < enemy.getX() + 40
                        && s.getY() > enemy.getY() && s.getY() < enemy.getY() + 60) {
                    s.setAlive(false);
                    enemy.isAlive = false;
                    if (enemy instanceof Enemy) {
                        Recorder.addAllEnemyTanNum();
                    }
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                    enemyTank.remove(enemy);
                }
                break;
            case 3: //坦克向左
            case 4: //坦克向右
                if (s.getX() > enemy.getX() && s.getX() < enemy.getX() + 60
                        && s.getY() > enemy.getY() && s.getY() < enemy.getY() + 40) {
                    s.setAlive(false);
                    enemy.isAlive = false;
                    if (enemy instanceof Enemy) {
                        Recorder.addAllEnemyTanNum();
                    }
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                    enemyTank.remove(enemy);
                }
                break;
        }
    }

    public void hitEnemy() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isAlive()) {
                for (int i = 0; i < enemyTank.size(); i++) {
                    Enemy enemy = enemyTank.get(i);
                    hitTank(shot, enemy);
                }
            }
        }
    }

    public void hitHero() {
        for (int i = 0; i < enemyTank.size(); i++) {
            Enemy enemy = enemyTank.get(i);
            for (int j = 0; j < enemy.shot.size(); j++) {
                Shot shot = enemy.shot.get(j);
                if (hero.isAlive && shot.isAlive()) {
                    hitTank(shot, hero);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理WASD事件
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDOWN();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveUP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() - 10 > 0) {
                hero.moveLEFT();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRIGHT();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("射击");
            hero.shotEnemy();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemy();
            hitHero();
            this.repaint();
        }

    }
}
