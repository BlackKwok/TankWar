package tankgame;

/**
 * @author 郭润达
 * @version 1.0
 **/
public class Bomb {
    int x,y;
    int life = 9;
    boolean isAlive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if(life >0) {
            life--;
        }else {
            isAlive = false;
        }
    }
}
