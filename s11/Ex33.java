package s11;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * დაწერეთ პროგრამა რომელიც კანვასზე დახატავს შემთხვევითი ფერის მქონე წრეწირს, 
 * რაიდიუსიც შემთხვევით აირჩეით შეზღუდული რეინჯიდან.
 */
public class Ex33 extends GraphicsProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();

	@Override
	public void run() {
		drawRandomCircle();
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
