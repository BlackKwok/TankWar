package tankgame;

import java.util.Vector;

public class Hero extends Tank {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemy() {
        if (shots.size() == 5) {
            return;
        }

        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 50, getY() + 30, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX() - 10, getY() + 30, 3);
                break;
        }
        //启动shot线程
        shots.add(shot);
        new Thread(shot).start();
    }
}
