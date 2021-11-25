package exams.m2019;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*-
 * დაწერეთ გრაფიკული პროგრამა, რომელიც აკმაყოფილებს შემდეგ მოთხოვნებს:
 * 1. მაუსით ცარიელ ადგილზე კლიკის დროს უნდა გაჩნდეს CIRCLE_D დიამეტრის მქონე წრე ცენტრით კლიკის წერტილში,
 * 	  რომელიც გაფერადებულია ნებისმიერი შემთხვევითი ფერით. ფერის შემთხვევითობა აუცილებელია რათა თამაში ფერადი გამოვიდეს.
 * 
 * 2. მაუსით რომელიმე წრეზე კლიკის დროს წრე უნდა აციმციმდეს ფერებით მწვანე, წითელი, ლურჯი, შავი და ყვითელი. 
 * 	  ფერის შერჩევა უნდა ხდებოდეს შემთხვევით, მხოლოდ ამ 5 ფერიდან, ყოველ DELAY მილიწამში ერთხელ. 
 *
 * ციმციმი უნდა გაგრძელდეს მანამ სანამ წრე არ გაფერადდება მწვანედ.
 */
public class M2019Ex03 extends GraphicsProgram {

	private final int CIRCLE_D = 100;
	private final int DELAY = 100;
	private RandomGenerator rgen;
	private GObject selectedObject = null;

	@Override
	public void init() {
		addMouseListeners();
		rgen = RandomGenerator.getInstance();
	}

	public void run() {
		while (true) {
			if (selectedObject != null) {
				while (selectedObject.getColor() != Color.GREEN) {
					Color color = myRandomColor();
					selectedObject.setColor(color);
					println(selectedObject);
					pause(DELAY);
				}
				selectedObject = null;
			}
			println("E");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();

		GObject object = getElementAt(x, y);
		println(object);
		if (object == null) {
			GOval oval = new GOval(CIRCLE_D, CIRCLE_D);
			add(oval, x - CIRCLE_D / 2, y - CIRCLE_D / 2);
			oval.setFilled(true);
			oval.setColor(myRandomColor());
		} else {
			selectedObject = object;
		}
	}

	private Color myRandomColor() {
		int randomNum = rgen.nextInt(5);
		if (randomNum == 0)
			return Color.GREEN;
		if (randomNum == 1)
			return Color.RED;
		if (randomNum == 2)
			return Color.BLUE;
		if (randomNum == 3)
			return Color.BLACK;
		return Color.YELLOW;
	}
}
