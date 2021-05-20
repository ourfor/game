package top.ourfor.game.tankwar.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * 坦克类（适用敌方坦克和玩家坦克）
 */

@Slf4j
public class Tank {
	public static int speedX = 6, speedY = 6; // 静态全局变量速度
	public static int count = 0;
	public static final int width = 35, length = 35; // 坦克的全局大小，具有不可改变性
	private Direction direction = Direction.STOP; // 初始化状态为静止
	private Direction Kdirection = Direction.U; // 初始化方向为向上
	private GameFrame gameFrame;

	private boolean good;
	private int x, y;
	private int oldX, oldY;
	@Getter @Setter
	private boolean live = true; // 初始化为活着
	private int life = 200; // 初始生命值

	private static Random r = new Random();
	private int step = r.nextInt(10) + 5; // 产生一个随机数,随机模拟坦克的移动路径

	private boolean bL = false, bU = false, bR = false, bD = false, bLU = false, bRU = false , bLD = false, bRD = false ;

	private static Toolkit tk = Toolkit.getDefaultToolkit();// 控制面板
	private static Image[] tankImages = null; // 存储全局静态
	static {
		tankImages = new Image[] {
				tk.getImage(BombTank.class.getResource("/images/tankD.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankU.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankL.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankR.gif")),
		  		tk.getImage(BombTank.class.getResource("/images/tankRU.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankLU.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankRD.gif")),
				tk.getImage(BombTank.class.getResource("/images/tankLD.gif")),
		};
	}

	public Tank(int x, int y, boolean good) {// Tank的构造函数1
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.good = good;
	}

	public Tank(int x, int y, boolean good, Direction dir, GameFrame tc) {// Tank的构造函数2
		this(x, y, good);
		this.direction = dir;
		this.gameFrame = tc;
	}

	public void draw(Graphics g) {
		if (!live) {
			if (!good) {
				gameFrame.tanks.remove(this); // 删除无效的
			}
			return;
		}

		if (good)
			new DrawBloodBar().draw(g); // 玩家坦克的血量条

		switch (Kdirection) {
		// 根据方向选择坦克的图片
		case D:
			g.drawImage(tankImages[0], x, y, null);
			break;

		case U:
			g.drawImage(tankImages[1], x, y, null);
			break;
		case L:
			g.drawImage(tankImages[2], x, y, null);
			break;

        case R:
			g.drawImage(tankImages[3], x, y, null);
			break;

		case RU:
			g.drawImage(tankImages[4], x, y, null);
			break;

		case LU:
			g.drawImage(tankImages[5], x, y, null);
			break;

        case RD:
			g.drawImage(tankImages[6], x, y, null);
			break;

        case LD:
			g.drawImage(tankImages[7], x, y, null);
			break;


		}

		move(); // 调用move函数
	}

	void move() {

		this.oldX = x;
		this.oldY = y;

		switch (direction) { // 选择移动方向
		case L:
			x -= speedX;
			break;
		case U:
			y -= speedY;
			break;
		case R:
			x += speedX;
			break;
		case D:
			y += speedY;
			break;
        case LU:
            x -= 0.707*speedX;
			y -= 0.707*speedY;
			break;
        case RU:
			x += 0.707*speedX;
            y -= 0.707*speedY;
			break;
        case LD:
            x -= 0.707*speedX;
			y += 0.707*speedY;
			break;
        case RD:
			x += 0.707*speedX;
            y += 0.707*speedY;
			break;

		case STOP:
			break;
		}

		if (this.direction != Direction.STOP) {
			this.Kdirection = this.direction;
		}

		if (x < 0)
			x = 0;
		if (y < 40) // 防止走出规定区域
			y = 40;
		if (x + Tank.width > GameFrame.Frame_width) // 超过区域则恢复到边界
			x = GameFrame.Frame_width - Tank.width;
		if (y + Tank.length > GameFrame.Frame_length)
			y = GameFrame.Frame_length - Tank.length;

		if (!good) {
			Direction[] directons = Direction.values();
			if (step == 0) {
				step = r.nextInt(12) + 3; // 产生随机路径
				int rn = r.nextInt(directons.length);
				direction = directons[rn]; // 产生随机方向
			}
			step--;

			if (r.nextInt(40) > 38)// 产生随机数，控制敌人开火
				this.fire();
		}
	}

	private void changToOldDir() {
		x = oldX;
		y = oldY;
	}

	public void keyPressed(KeyEvent e) { // 接受键盘事件
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_B: // 当按下B时，重新开始游戏
			log.info("当按下B时，重新开始游戏");
			gameFrame.tanks.clear(); // 清理
			gameFrame.bullets.clear();
			gameFrame.trees.clear();
			gameFrame.otherWall.clear();
			gameFrame.homeWall.clear();
			gameFrame.metalWall.clear();
			gameFrame.homeTank.setLive(false);
			if (gameFrame.tanks.size() == 0) { // 当在区域中没有坦克时，就出来坦克
				for (int i = 0; i < 20; i++) {
					if (i < 9) // 设置坦克出现的位置
						gameFrame.tanks.add(new Tank(150 + 70 * i, 40, false, Direction.R, gameFrame));
					else if (i < 15)
						gameFrame.tanks.add(new Tank(700, 140 + 50 * (i - 6), false, Direction.D, gameFrame));
					else
						gameFrame.tanks.add(new Tank(10, 50 * (i - 12), false, Direction.L, gameFrame));
				}
			}

			gameFrame.homeTank = new Tank(300, 560, true, Direction.STOP, gameFrame);// 设置自己出现的位置

			if (!gameFrame.home.isLive()) // 将home重置生命
				gameFrame.home.setLive(true);
			gameFrame.start();
			break;
		case KeyEvent.VK_D: // 监听向右键
			bR = true;
			break;

		case KeyEvent.VK_A:// 监听向左键
			bL = true;
			break;

		case KeyEvent.VK_W: // 监听向上键
			bU = true;
			break;

		case KeyEvent.VK_S:// 监听向下键
			bD = true;
			break;

        case KeyEvent.VK_E: // 监听向右上键
			bRU = true;
			break;

        case KeyEvent.VK_Z:// 监听向左下键
			bLD = true;
			break;

        case KeyEvent.VK_Q: // 监听向左上键
			bLU = true;
			break;

        case KeyEvent.VK_C:// 监听向右下键
			bRD = true;
			break;
		}
		decideDirection();// 调用函数确定移动方向
	}

	void decideDirection() {
		if (!bL && !bU && bR && !bD && !bLD && !bLU && !bRU && !bRD) // 向右移动
			direction = Direction.R;

		else if (bL && !bU && !bR && !bD && !bLD && !bLU && !bRU && !bRD) // 向左移
			direction = Direction.L;

		else if (!bL && bU && !bR && !bD && !bLD && !bLU && !bRU && !bRD) // 向上移动
			direction = Direction.U;

		else if (!bL && !bU && !bR && bD && !bLD && !bLU && !bRU && !bRD) // 向下移动
			direction = Direction.D;

		else if (!bL && !bU && !bR && !bD && !bLD && bLU && !bRU && !bRD) // 向左上移动
			direction = Direction.LU;

		else if (!bL && !bU && !bR && !bD && !bLD && !bLU && bRU && !bRD) // 向右上移动
			direction = Direction.RU;

		else if (!bL && !bU && !bR && !bD && bLD && !bLU && !bRU && !bRD) // 向左下移动
			direction = Direction.LD;

		else if (!bL && !bU && !bR && !bD && !bLD && !bLU && !bRU && bRD) // 向右下移动
			direction = Direction.RD;

		else if (!bL && !bU && !bR && !bD && !bLD && !bLU && !bRU && !bRD)
			direction = Direction.STOP; // 没有按键，就保持不动
	}

	public void keyReleased(KeyEvent e) { // 键盘释放监听
		int key = e.getKeyCode();
		switch (key) {

		case KeyEvent.VK_J:
			fire();
			break;

		case KeyEvent.VK_D:
			bR = false;
			break;

		case KeyEvent.VK_A:
			bL = false;
			break;

		case KeyEvent.VK_W:
			bU = false;
			break;

		case KeyEvent.VK_S:
			bD = false;
			break;

        case KeyEvent.VK_E:
			bRU = false;
			break;

        case KeyEvent.VK_Z:
			bLD = false;
			break;

        case KeyEvent.VK_Q:
			bLU = false;
			break;

        case KeyEvent.VK_C:
			bRD = false;
			break;

		}
		decideDirection(); // 释放键盘后确定移动方向
	}

	public Bullets fire() { // 开火方法
		if (!live)
			return null;
		int x = this.x + Tank.width / 2 - Bullets.width / 2; // 开火位置
		int y = this.y + Tank.length / 2 - Bullets.length / 2;
		Bullets m = new Bullets(x, y + 2, good, Kdirection, this.gameFrame); // 没有给定方向时，向原来的方向发火
		gameFrame.bullets.add(m);
		return m;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, length);
	}

	public boolean isGood() {
		return good;
	}

	public boolean collideWithWall(BrickWall w) { // 碰撞到普通墙时
		if (this.live && this.getRect().intersects(w.getRect())) {
			this.changToOldDir(); // 转换到原来的方向上去
			return true;
		}
		return false;
	}

	public boolean collideWithWall(MetalWall w) { // 撞到金属墙
		if (this.live && this.getRect().intersects(w.getRect())) {
			this.changToOldDir();
			return true;
		}
		return false;
	}

	public boolean collideRiver(River r) { // 撞到河流的时候
		if (this.live && this.getRect().intersects(r.getRect())) {
			this.changToOldDir();
			return true;
		}
		return false;
	}

	public boolean collideHome(Home h) { // 撞到家的时候
		if (this.live && this.getRect().intersects(h.getRect())) {
			this.changToOldDir();
			return true;
		}
		return false;
	}

	public boolean collideWithTanks(java.util.List<Tank> tanks) {// 撞到坦克时
		for (int i = 0; i < tanks.size(); i++) {
			Tank t = tanks.get(i);
			if (this != t) {
				if (this.live && t.isLive() && this.getRect().intersects(t.getRect())) {
					this.changToOldDir();
					t.changToOldDir();
					return true;
				}
			}
		}
		return false;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	private class DrawBloodBar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(375, 585, width, 10);// 显示玩家坦克的血量条
			int w = width * life / 200;
			g.fillRect(375, 585, w, 10);// 显示玩家坦克的血量条
			g.setColor(c);
		}
	}

	public boolean eat(Blood b) {
		if (this.live && b.isLive() && this.getRect().intersects(b.getRect())) {
			if (this.life <= 100)
				this.life = this.life + 100; // 每吃一个，增加100生命点
			else
				this.life = 200;
			b.setLive(false);
			return true;
		}
		return false;
	}

	public boolean eat(SuperBullets b, List<Tank> tanks) {

		if (this.live && b.isLive() && this.getRect().intersects(b.getRect())) {
			if (this.isLive())
				for (int i = 0; i < tanks.size(); i++) {
					Tank t = tanks.get(i);
					BombTank e = new BombTank(t.getX(), t.getY(), gameFrame);
					gameFrame.bombTanks.add(e);
					if(!t.isGood()) {
						t.setLife(0);
						t.setLive(false);
					}  // 吃一个炸弹，清除场上所有坦克

				}
			else
				this.life = 200;
			b.setLive(false);

			return true;// 每吃一个，清除场上所有敌方坦克
		}
		return false;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}