package exams.m2021.s2;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

/*-
 * დაწერეთ გრაფიკული პროგრამა, რომელსაც აქვს ორი რეჟიმი: ამატებს ან კვადრატს, ან წრეს.
 * 
 * 1. მაუსის კლიკზე ან კვადრატი ემატება ფანჯარაზე, ან წრე (იმ წერტილზე სადაც კლიკი მოხდა)
 * 2. რეჟიმის ცვლილება ხდება მაუსის დრაგის მეშვეობით. თუ მომხმარებელმა გააკეთა დრაგი:
 *    - მარჯვნიდან->მარცხნივ: შემდეგ კლიკზე ემატება ოვალი  
 *    - მარცხნიდან->მარჯვნივ: შემდეგ კლიკზე ემატება კვადრატი
 * 3. თავიდან სანამ დრეგი არ მოხდება (default-ად) ემატება ოვალი
 */
public class M2021S2Ex03 extends GraphicsProgram {

	private static final double GOB_D = 50;
	private boolean isOval;
	private int xs;

	@Override
	public void init() {
		isOval = true;
		addMouseListeners();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xs = e.getX();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		isOval = (xs - e.getX() > 0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GObject obj;
		if (isOval) {
			obj = new GOval(GOB_D, GOB_D);
		} else {
			obj = new GRect(GOB_D, GOB_D);
		}
		double x = e.getX() - GOB_D / 2;
		double y = e.getY() - GOB_D / 2;
		add(obj, x, y);
	}
}
