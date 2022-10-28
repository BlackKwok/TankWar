package tankgame;

import java.util.Vector;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class Enemy extends Tank implements Runnable {
    Vector<Shot> shot = new Vector<>();
    boolean isAlive = true;
    Vector<Enemy> enemyTank = new Vector<>();

    public void setEnemyTank(Vector<Enemy> enemyTank) {
        this.enemyTank = enemyTank;
    }

    public boolean isTouchTank() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTank.size(); i++) {
                    Enemy enemy = enemyTank.get(i);
                    if (enemy != this) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            if (this.getX() >= enemy.getX()
                                    && this.getX() <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY()
                                    && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX()
                                    && this.getX() + 40 <= enemy.getX() + 40
                                    && this.getY() >= enemy.getY()
                                    && this.getY() <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (this.getX() >= enemy.getX() - 10
                                    && this.getX() <= enemy.getX() + 50
                                    && this.getY() >= enemy.getY() + 10
                                    && this.getY() <= enemy.getY() + 50) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() - 10
                                    && this.getX() + 40 <= enemy.getX() + 50
                                    && this.getY() >= enemy.getY() + 10
                                    && this.getY() <= enemy.getY() + 50) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTank.size(); i++) {
                    Enemy enemy = enemyTank.get(i);
                    if (enemy != this) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            if (this.getX() + 50 >= enemy.getX()
                                    && this.getX() + 50 <= enemy.getX() + 40
                                    && this.getY() + 10 >= enemy.getY()
                                    && this.getY() + 10 <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 50 >= enemy.getX()
                                    && this.getX() + 50 <= enemy.getX() + 40
                                    && this.getY() + 50 >= enemy.getY()
                                    && this.getY() + 50 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (this.getX() + 50 >= enemy.getX() - 10
                                    && this.getX() + 50 <= enemy.getX() + 50
                                    && this.getY() + 10 >= enemy.getY() + 10
                                    && this.getY() + 10 <= enemy.getY() + 50) {
                                return true;
                            }
                            if (this.getX() + 50 >= enemy.getX() - 10
                                    && this.getX() + 50 <= enemy.getX() + 50
                                    && this.getY() + 50 >= enemy.getY() + 10
                                    && this.getY() + 50 <= enemy.getY() + 50) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTank.size(); i++) {
                    Enemy enemy = enemyTank.get(i);
                    if (enemy != this) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            if (this.getX() >= enemy.getX()
                                    && this.getX() <= enemy.getX() + 40
                                    && this.getY() + 60 >= enemy.getY()
                                    && this.getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX()
                                    && this.getX() + 40 <= enemy.getX() + 40
                                    && this.getY() + 60 >= enemy.getY()
                                    && this.getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (this.getX() >= enemy.getX() - 10
                                    && this.getX() <= enemy.getX() + 50
                                    && this.getY() + 60 >= enemy.getY() + 10
                                    && this.getY() + 60 <= enemy.getY() + 50) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemy.getX() - 10
                                    && this.getX() + 40 <= enemy.getX() + 50
                                    && this.getY() + 60 >= enemy.getY() + 10
                                    && this.getY() + 60 <= enemy.getY() + 50) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTank.size(); i++) {
                    Enemy enemy = enemyTank.get(i);
                    if (enemy != this) {
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            if (this.getX() - 10 >= enemy.getX()
                                    && this.getX() - 10 <= enemy.getX() + 40
                                    && this.getY() + 10 >= enemy.getY()
                                    && this.getY() + 10 <= enemy.getY() + 60) {
                                return true;
                            }
                            if (this.getX() - 10 >= enemy.getX()
                                    && this.getX() - 10 <= enemy.getX() + 40
                                    && this.getY() + 50 >= enemy.getY()
                                    && this.getY() + 50 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            if (this.getX() - 10 >= enemy.getX() - 10
                                    && this.getX() - 10 <= enemy.getX() + 50
                                    && this.getY() + 10 >= enemy.getY() + 10
                                    && this.getY() + 10 <= enemy.getY() + 50) {
                                return true;
                            }
                            if (this.getX() - 10 >= enemy.getX() - 10
                                    && this.getX() - 10 <= enemy.getX() + 50
                                    && this.getY() + 50 >= enemy.getY() + 10
                                    && this.getY() + 50 <= enemy.getY() + 50) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

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
                        if (isTouchTank()){
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
                        if (isTouchTank()){
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
                        if (isTouchTank()){
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
                        if (isTouchTank()){
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
