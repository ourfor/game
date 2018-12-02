import java.awt.*;
import java.util.Random;

/**
 * 炸弹类（炸弹类，可以清除场上的所有敌人）
 */

public class SuperBullets {

    public static final int width = 27;
    public static final int length = 27;

    private int x, y;
    GameFrame tc;
    private static Random r = new Random();

    int step = 0;
    private boolean live = false;

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    private Image[] bloodImags = new Image[] { tk.getImage(BrickWall.class.getResource("Images/boom.png")), };

    private int[][] poition = { { 340,480 } };

    public void draw(Graphics g) {
        if (r.nextInt(100) > 98) {
            this.live = true;
            move();
        }
        if (!live)
            return;
        g.drawImage(bloodImags[0], x, y, null);

    }

    private void move() {
        step++;
        if (step == poition.length) {
            step = 0;
        }
        x = poition[step][0];
        y = poition[step][1];

    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, length);
    }

    public boolean isLive() {// 判断是否还活着
        return live;
    }

    public void setLive(boolean live) { // 设置生命
        this.live = live;
    }
}
