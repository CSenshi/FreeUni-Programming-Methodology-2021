package exams.m2021.s1;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import acm.graphics.GLine;
import acm.program.*;

/*-
 * პროგრამა, რომელიც საშუალებას აძლევს მომხმარებელს დახატოს ტეხილი
 * 
 * 1. ტეხილის სათავე დაფიქსირებულია და მდებარეობს (0, 0) წერტილში
 * 2. მაუსის კლიკზე დაფაზე უნდა დაემატოს ახალი GLine, რომლის ერთი წვერო არის ტეხილის ბოლო წერტილი,
 * 	  ხოლო მეორე წვერო კი, წერტილი სადაც მოხდა მაუსის კლიკი
 * 3. ყოველი მაუსის გაჩოჩებაზე (mouseDragged) პროგრამა უნდა ხატავდეს მონაკვეთის მოძრაობას, 
 *    რომლის ერთი ბოლო დაფიქსირებულია ტეხილის ბოლო წერტილში, ხოლო მეორე ბოლო დაყვება მაუსის ისარს.
 */
public class M2021S1Ex03 extends GraphicsProgram {

	private int xs, ys;
	private GLine line;

	@Override
	public void init() {
		xs = ys = 0;
		addMouseListeners();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		line = new GLine(xs, ys, e.getX(), e.getY());
		add(line);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		xs = e.getX();
		ys = e.getY();
	}
}
