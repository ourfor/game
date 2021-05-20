package top.ourfor.game.tankwar.ui;

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
    private Image[] bloodImages = new Image[] { tk.getImage(BrickWall.class.getResource("/images/boom.png")), };

    private int[][] position = { { 340,480 } };

    public void draw(Graphics g) {
        if (r.nextInt(100) > 98) {
            this.live = true;
            move();
        }
        if (!live)
            return;
        g.drawImage(bloodImages[0], x, y, null);

    }

    private void move() {
        step++;
        if (step == position.length) {
            step = 0;
        }
        x = position[step][0];
        y = position[step][1];

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
