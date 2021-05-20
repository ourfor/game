package top.ourfor.game.tankwar.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * 树（丛林）类
 */

public class Tree {
	public static final int width = 30;
	public static final int length = 30;
	int x, y;
	GameFrame tc;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] treeImages = null;
	static {
		treeImages = new Image[] { tk.getImage(BrickWall.class.getResource("/images/tree.gif")), };
	}

	public Tree(int x, int y, GameFrame tc) { // Tree的构造方法，传递x，y和tc对象
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public void draw(Graphics g) { // 画出树
		g.drawImage(treeImages[0], x, y, null);
	}

}