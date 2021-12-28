package s26;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * 68 ამოცანის გაგრძელება.
 * 
 * დაამატეთ სქროლი.
 * 
 * თუკი ტექსტი ჩაცდება ეკრანს მაშინ ახალი ტექსტი მაინც უნდა გამოჩნდეს ეკრანის
 * ბოლოში, შესაბამისად სულ პირველად შეყვანილი ტექსტი გაქრება ეკრანიდან.
 */
public class Ex69 extends GraphicsProgram {

	private JTextField messageInput;
	private JButton addButton;
	private int y;
	private int X_OFF = 10;
	private List<GLabel> messages;

	@Override
	public void init() {
		// Initialize messages list
		y = 0;
		messages = new ArrayList<GLabel>();

		// Initialize text field
		messageInput = new JTextField(20);
		add(messageInput, SOUTH);
		messageInput.addActionListener(this);

		// Initialize button
		addButton = new JButton("Add");
		add(addButton, SOUTH);

		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. Get message
		String message = messageInput.getText();

		// 2. Add message on canvas
		GLabel messageLabel = new GLabel(message);
		add(messageLabel, X_OFF, y);

		// 3. Increment message count
		messages.add(messageLabel);

		// 4. Check if last label is visible
		double labelSize = messageLabel.getAscent();
		if (messageLabel.getY() > getHeight()) {
			// 4.1 if not move all labels up by one label's size
			for (GLabel label : messages) {
				label.move(0, -labelSize);
			}
			// 4.2 remove first label
			messages.remove(0);
		} else {
			y += labelSize;
		}
	}
}
