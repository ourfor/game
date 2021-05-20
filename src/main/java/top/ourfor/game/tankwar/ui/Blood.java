package top.ourfor.game.tankwar.ui;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;

/**
 * 血包类（医疗箱，可加血）
 */

public class Blood {

	public static final int width = 36;
	public static final int length = 36;

	private int x, y;
	private static final Random random = new Random();

	private int step = 0;
	@Getter @Setter
	private boolean live = false;

	private static final Toolkit tk = Toolkit.getDefaultToolkit();
	private final Image[] bloodImages = new Image[] { tk.getImage(BrickWall.class.getResource("/images/hp.png")), };

	private final int[][] position = { { 155, 196 }, { 500, 58 }, { 80, 340 }, { 99, 199 }, { 345, 456 }, { 123, 321 },
			{ 258, 413 } };

	public void draw(Graphics g) {
		if (random.nextInt(100) > 98) {
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
}