package exams.f2020.s2;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

/*-
 * თქვენი ამოცანაა დაწეროთ პროგრამა, რომელიც დახატავს ფერად მართკუთხედებს. 
 * 
 * ამისათვის ფანჯრის სამხრეთ რეგიონზე განლაგებულია 11 კომპონენტი შემდეგი მიმდევრობით: 
 * 01. ლეიბლი “name”
 * 02. შემავალი ველი 
 * 03. ლეიბლი “x” 
 * 04. შემავალი ველი
 * 05. ლეიბლი “y” 
 * 06. შემავალი ველი 
 * 07. ლეიბლი “width” 
 * 08. შემავალი ველი 
 * 09. ლეიბლი “height”
 * 10. შემავალი ველი 
 * 11. ღილაკი Add
 * 
 * მომხმარებელს შეუძლია შესაბამის შემავალ ველებში ჩაწერო მართკუთხედის x,y კოორდინატები, სიგრძე და სიგანე. 
 * 
 * ჩათვალეთ, რომ სახელის გარდა სხვაგან ყველგან მომხმარებელს მხოლოდ მთელი რიცხვები შეჰყავს.
 * რომელიმე შემავალ ველში Enter-ზე დაჭერისას ან Add ღილაკზე დაჭერის შემთხვევაში პროგრამამ კანვასზე უნდა დაამატოს მითითებული თვისებების მქონე მართკუთხედი
 * 
 * მომხმარებელს “name” ტექსტფილდში მართკუთხედის სახელი შეჰყავს, რომელიც უნიკალური იდენტიფიკატორია, 
 * რაც იმას ნიშნავს, რომ ერთიდაიმავე სახელის მქონე მართკუთხედი კანვასზე არ უნდა იყოს(ძველი უნდა წაიშალოს და ახალი დაემატოს). 
 * 
 * მაუსით ქლიქისას მომხარებელს შეუძლია წყვილ-წყვილად მართკუთხედების წაშლა. 
 * თუკი იგი მიმდევრობით დააკლიკებს ორ მართკუთხედს, რომელთა სახელის პირველი ასოები ერთმანეთს ემთხვევა, მაშინ ეს მართკუთხედები უნდა წაიშალოს.Ï
 */
public class M2020S2Ex4 extends GraphicsProgram {

	private JLabel nameLabel;
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel widthLabel;
	private JLabel heightLabel;

	private JTextField nameTextField;
	private JTextField xTextField;
	private JTextField yTextField;
	private JTextField widthTextField;
	private JTextField heightTextField;

	private JButton addButton;
	private GRect oldRect;

	private Map<String, GRect> mp;

	@Override
	public void init() {
		nameLabel = new JLabel("name");
		xLabel = new JLabel("x");
		yLabel = new JLabel("y");
		widthLabel = new JLabel("width");
		heightLabel = new JLabel("height");

		nameTextField = new JTextField(5);
		xTextField = new JTextField(5);
		yTextField = new JTextField(5);
		widthTextField = new JTextField(5);
		heightTextField = new JTextField(5);

		addButton = new JButton("Add");

		mp = new HashMap<>();

		add(nameLabel, SOUTH);
		add(nameTextField, SOUTH);
		add(xLabel, SOUTH);
		add(xTextField, SOUTH);
		add(yLabel, SOUTH);
		add(yTextField, SOUTH);
		add(widthLabel, SOUTH);
		add(widthTextField, SOUTH);
		add(heightLabel, SOUTH);
		add(heightTextField, SOUTH);
		add(addButton, SOUTH);

		nameTextField.addActionListener(this);
		xTextField.addActionListener(this);
		yTextField.addActionListener(this);
		widthTextField.addActionListener(this);
		heightTextField.addActionListener(this);
		addActionListeners();
		addMouseListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameTextField.getText();
		int x = Integer.parseInt(xTextField.getText());
		int y = Integer.parseInt(yTextField.getText());
		int width = Integer.parseInt(widthTextField.getText());
		int height = Integer.parseInt(heightTextField.getText());

		GRect rect = new GRect(x, y, width, height);
		GRect oldRect = mp.get(name);
		if (oldRect != null) {
			remove(oldRect);
		}
		mp.put(name, rect);
		add(rect);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		GRect obj = (GRect) getElementAt(x, y);
		if (oldRect == null) {
			// 1st click
			oldRect = obj;
		} else {
			// 2nd click
			String name1 = retrieveName(oldRect);
			String name2 = retrieveName(obj);

			if (!name1.equals(name2) && name1.charAt(0) == name2.charAt(0)) {
				remove(oldRect);
				remove(obj);
				mp.remove(name1);
				mp.remove(name2);
			}
			oldRect = null;
		}
	}

	private String retrieveName(GRect rect) {
		for (Entry<String, GRect> entry : mp.entrySet()) {
			if (entry.getValue().equals(rect)) {
				return entry.getKey();
			}
		}
		return null;
	}
}
