package s25;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი.
 * 
 * ფანჯარაზე, SOUTH რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით
 * Enter. ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
 * იწერებოდეს(იხატებოდეს) კანვასზე, ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს.
 * ხელახლა ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოჩნდეს
 * (როგორც ჩატში ხდება ხოლმე). თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.
 */
public class Ex68 extends GraphicsProgram {

	private final int X_OFFSET = 10;
	private int y;
	private JTextField textField;
	private JButton submitButton;

	public void init() {
		y = 10;
		textField = new JTextField(20);
		submitButton = new JButton("Enter");
		add(textField, SOUTH);
		add(submitButton, SOUTH);
		textField.addActionListener(this);
		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String messagePath = textField.getText();
		if(messagePath.length() >= 1) {
			GLabel label = new GLabel(messagePath);
			add(label, X_OFFSET, y);
			y += label.getHeight();
			textField.setText("");	
		}
	}
}