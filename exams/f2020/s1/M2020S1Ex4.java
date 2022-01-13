package exams.f2020.s1;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ComponentListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

/*-
 * თქვენი ამოცანაა დაწეროთ პროგრამა, რომელიც სატელეფონო წიგნის მაგივრობას გაგვიწევს.
 * ამისათვის ფანჯრის სამხრეთ რეგიონზე განლაგებულია 5 კომპონენტი შემდეგი მიმდევრობით:
 * ლეიბლი “name”, შემავალი ველი, ლეიბლი “phone”, შემავალი ველი და ღილაკი Add.
 * 
 * მომხმარებელს შეუძლია პირველ ველში ადამიანის სახელი ჩაწეროს ხოლო მეორე ველში კი ტელეფონის ნომერი.
 * ჩათვალეთ, რომ ადამიანის სახელი სტრინგია, ხოლო ტელეფონის ნომერი მთელი რიცხვი. 
 * რომელიმე შემავალ ველში Enter-ზე დაჭერისას ან Add ღილაკზე დაჭერის შემთხვევაში 
 * ველებში არსებული სახელი და ტელეფონის ნომერი უნდა დაემატოს ეკრანზე(სფეისით გამოყოფილი, ჯერ სახელი მერე ტელეფონის ნომერი).
 *  
 * მომხმარებლის მიერ პირველად შეყვანილი სახელი და ტელეფონის ნომერი უნდა დაიხატოს კოორდინატებზე MARGIN_X, MARGIN_Y.
 * თუკი მომხმარებელს ახალი ადამიანის ნომერი შეჰყავს(ანუ სახელი რომელიც ჯერ არ შეუყვანია) 
 * ის უნდა დაიხატოს ბოლოს დახატული ნომრიდან MARGIN_Y პიქსელით ქვემოთ. 
 * ხოლო თუკი დახატული ადამიანის ნომერი შემოდის მაშინ ძველ ნომერს უნდა გადაეწეროს ახალი ნომერი,
 * სიაში მდებარობა არ უნდა შეიცვალოს.
 * 
 * თუკი მომხმარებელი ფანჯრის ზომებს შეცვლის, მაშინ არსებული სია უნდა წაშალოთ და უნდა დახატოთ ზუსტად იგივე სია, 
 * ოღონდ რანდომ მიმდევრობით. ყურადღება მიაქციეთ იმას, რომ აუცილებელია შემთხვევითი მიმდევრობით დაიხატოს სია.
 * შემთხვევითია მიმდევრობა თუ მისი ამოსვლის ალბათობა ყველა სხვა მიმდევრობასთან შედარებით თანაბარ ალბათურია ანუ ალბათობა არის 1/(n!)
 */
public class M2020S1Ex4 extends GraphicsProgram implements ComponentListener {

	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JButton addButton;
	private List<List<String>> phoneBook;
	private final int MARGIN_X = 10;
	private final int MARGIN_Y = 10;
	private RandomGenerator rgen;

	@Override
	public void init() {
		nameLabel = new JLabel("Name");
		phoneLabel = new JLabel("Phone");
		nameTextField = new JTextField(15);
		phoneTextField = new JTextField(15);
		addButton = new JButton("Add");
		phoneBook = new ArrayList<>();
		rgen = RandomGenerator.getInstance();

		add(nameLabel, SOUTH);
		add(nameTextField, SOUTH);
		add(phoneLabel, SOUTH);
		add(phoneTextField, SOUTH);
		add(addButton, SOUTH);

		addActionListeners();
		addComponentListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			String name = nameTextField.getText();
			String phone = phoneTextField.getText();

			updatePhoneBook(name, phone);
			drawPhoneBook();
		}
	}

	private void drawPhoneBook() {
		removeAll();
		for (int i = 0; i < phoneBook.size(); i++) {
			List<String> currentEntry = phoneBook.get(i);
			String name = currentEntry.get(0);
			String phone = currentEntry.get(1);
			String labelString = name + " " + phone;
			GLabel label = new GLabel(labelString);
			add(label, MARGIN_X, MARGIN_Y + (i + 1) * label.getHeight());
		}
	}

	private void updatePhoneBook(String name, String phone) {
		for (int i = 0; i < phoneBook.size(); i++) {
			List<String> currentEntry = phoneBook.get(i);
			String currentName = currentEntry.get(0);
			String currentPhone = currentEntry.get(1);

			if (currentName.equals(name)) {
				currentEntry.set(1, phone);
				return;
			}
		}

		List<String> newEntry = new ArrayList<>();
		newEntry.add(name);
		newEntry.add(phone);
		phoneBook.add(newEntry);
	}

	private void shufflePhoneBoook() {
		List<List<String>> newPhoneBook = new ArrayList<>();
		while (true) {
			if (phoneBook.size() == 0) {
				break;
			}
			int randomIndex = rgen.nextInt(phoneBook.size());
			List<String> randomElement = phoneBook.get(randomIndex);
			newPhoneBook.add(randomElement);
			phoneBook.remove(randomIndex);
		}
		phoneBook = newPhoneBook;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		shufflePhoneBoook();
		drawPhoneBook();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}
}
