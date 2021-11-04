package s11;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * კანვასზე დახატეთ 1000 შემთხვევითი რადიუსის მქონე შემთხვევითი ფერით გაფერადებული წრე, შემთხვევით კოორდინატებზე.
 */
public class Ex34 extends GraphicsProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int MAX_COUNT = 1000;
	
	@Override
	public void run() {
		// Random Generator
		for (int i = 0; i < MAX_COUNT; i++) {
			drawRandomCircle();
		}
	}

	private void drawRandomCircle() {
		Color color = rgen.nextColor();

		double minDiameter = Math.min(getWidth(), getHeight());
		double diameter = rgen.nextDouble(0, minDiameter);

		double x = rgen.nextDouble(0, getWidth() - diameter);
		double y = rgen.nextDouble(0, getHeight() - diameter);

		GOval oval = new GOval(x, y, diameter, diameter);
		oval.setFilled(true);
		oval.setFillColor(color);
		add(oval);
	}
}
