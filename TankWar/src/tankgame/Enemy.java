package tankgame;

import java.util.Vector;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class Enemy extends Tank implements Runnable {
    Vector<Shot> shot = new Vector<>();
    boolean isAlive = true;

    public Enemy(int x, int y) {
        super(x, y);
        setDirect(2);
    }

    @Override
    public void run() {
        while (true) {
            if (isAlive && shot.size() == 0) {
                Shot s = null;
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 50, getY() + 30, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX() - 10, getY() + 30, 3);
                        break;
                }
                shot.add(s);
                new Thread(s).start();
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (this.getY() <= 0) {
                            this.setY(0);
                            break;
                        }
                        moveUP();
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (this.getX() + 60 >= 1000) {
                            this.setX(940);
                            break;
                        }
                        moveRIGHT();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (this.getY() + 60 >= 750) {
                            this.setY(690);
                            break;
                        }
                        moveDOWN();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (this.getX() - 10 <= 0) {
                            this.setX(0);
                            break;
                        }
                        moveLEFT();
                    }
                    break;
            }
            setDirect((int) (Math.random() * 4));
            if (!isAlive) {
                break;
            }
        }
    }
}
