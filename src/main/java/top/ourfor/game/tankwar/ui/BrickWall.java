package top.ourfor.game.tankwar.ui;

import java.awt.*;

/**
 * 砖墙类（子弹可打穿）
 */
public class BrickWall {
	public static final int width = 20; // 设置墙的固定参数
	public static final int length = 20;
	int x, y;

	GameFrame tc;
	private static final Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] wallImages = null;
	static {
		wallImages = new Image[] { // 储存commonWall的图片
				tk.getImage(BrickWall.class.getResource("/images/commonWall.gif")), };
	}

	public BrickWall(int x, int y, GameFrame tc) { // 构造函数
		this.x = x;
		this.y = y;
		this.tc = tc; // 获得界面控制
	}

	public void draw(Graphics g) {// 画commonWall
		g.drawImage(wallImages[0], x, y, null);
	}

	public Rectangle getRect() { // 构造指定参数的长方形实例
		return new Rectangle(x, y, width, length);
	}
}