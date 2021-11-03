package s10;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator;

public class ExRandomRect extends GraphicsProgram {

	private final int DOT_NUM = 200000;
	private final double SLEEP_MS = 0.0;
	private final double RAND_PROP = 0.9;

	public void run() {
		this.setSize(800, 600);
		int x = 100;
		int y = 100;
		int height = 400;
		int width = 400;

		drawRectWithRandomDots(x, y, height, width);
	}

	private void drawRectWithRandomDots(int x, int y, int height, int width) {
		// Label to keep track of dots
		GLabel dotLabel = new GLabel("Total Dots", 50, 50);
		add(dotLabel);

		RandomGenerator rgen = RandomGenerator.getInstance();

		for (int i = 1; i <= DOT_NUM; i++) {
			int curX, curY;

			// generate x based on RAND_PROP
			if (rgen.nextBoolean(RAND_PROP))
				curX = rgen.nextInt(x, x + width / 2);
			else
				curX = rgen.nextInt(x + width / 2, x + width);


			// generate y based on RAND_PROP
			if (rgen.nextBoolean(RAND_PROP))
				curY = rgen.nextInt(y, y + height / 2);
			else
				curY = rgen.nextInt(y + height / 2, y + height);


			GRect rect = new GRect(curX, curY, 1, 1);
			add(rect);
			dotLabel.setLabel("Total Dots: " + i);
			pause(SLEEP_MS); // pause execution for SLEEP_MS miliseconds (for visualization purpose)
		}
	}

}
