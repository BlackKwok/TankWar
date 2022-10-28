package tankgame;

public class Tank {
    private int x; //坦克横坐标
    private int y; //坦克纵坐标
    private int direct; //坦克朝向
    private int speed = 1; //坦克速度
    boolean isAlive = true;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUP() {
        y -= speed;
    }

    public void moveDOWN() {
        y += speed;
    }

    public void moveLEFT() {
        x -= speed;
    }

    public void moveRIGHT() {
        x += speed;
    }
}
