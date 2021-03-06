package s25;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

/*-
 * გააკეთეთ ფოტოების აპლიკაცია.
 * 
 * აპლიკაციას უნდა ჰქონდეს ტექსფილდი სადაც შეიძლება ფოტოს(ფაილის) მისამართის
 * ჩაწერა. ენტერზე დაჭერის შემდეგ ეს ფოტო უნდა გამოჩნდეს ფანჯრის ცენტრში.
 * 
 * image inputs:
 * 	1. s25/naruto.png
 * 	2. s25/bleach.png
 */
public class Ex67 extends GraphicsProgram {

	private JTextField imageInput;
	private GImage image;

	@Override
	public void init() {
		imageInput = new JTextField(20);
		add(imageInput, SOUTH);
		imageInput.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == imageInput) {
			String imagePath = imageInput.getText();
			try {
				addImage(imagePath);
			} catch (Exception ex) {
				showError(imagePath);
			}
		}
	}

	private void addImage(String imagePath) {
		// 1. Delete old image
		if (image != null) {
			remove(image);
		}

		// 2. Add new image
		image = new GImage(imagePath);
		int x = (int) ((getWidth() - image.getWidth()) / 2);
		int y = (int) ((getHeight() - image.getHeight()) / 2);
		add(image, x, y);
	}

	private void showError(String imagePath) {
		IODialog dial = getDialog();
		dial.showErrorMessage("Image \"" + imagePath + "\" does not exist!");
	}

}