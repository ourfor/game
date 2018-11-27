import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 河流类
 */
public class River {
	public static final int riverWidth = 55;
	public static final int riverLength = 154;// 静态全局变量
	private int x, y;
	GameFrame tc;

	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] riverImags = null;

	static { // 存储图片
		riverImags = new Image[] { tk.getImage(BrickWall.class.getResource("Images/river.jpg")), };
	}

	public River(int x, int y, GameFrame tc) { // River的构造方法
		this.x = x;
		this.y = y;
		this.tc = tc; // 获得控制
	}

	public void draw(Graphics g) {
		g.drawImage(riverImags[0], x, y, null); // 在对应X，Y出画河
	}

	public static int getRiverWidth() {
		return riverWidth;
	}

	public static int getRiverLength() {
		return riverLength;
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

	public Rectangle getRect() {
		return new Rectangle(x, y, riverWidth, riverLength);
	}

}
