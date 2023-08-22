//Author: Arbel Askayo 208642868
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.NegativeInputException;
import exceptions.PersonAlreadyExistException;
import model.*;
import utils.Area;
import utils.Gender;
import utils.RoomTypes;
import utils.YN;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class GetRealEmployee extends JPanel {
	private static GetRealEmployee instance=null;
	private static Menu menu=Menu.getInstance();
	private static Hotel hotel=Hotel.getInstance();
	private Image backImg = new ImageIcon(LoginFrame.class.getResource("/view/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/clicked.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverTxtImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(800, 250, Image.SCALE_SMOOTH);
	private Image reguTxtlarImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(800, 250, Image.SCALE_SMOOTH);
	ImageIcon back;
	ImageIcon press;
	ImageIcon hover;
	ImageIcon regular;
	ImageIcon hoverTxt;
	ImageIcon regularTxt;
	private JTextField idTxtField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneField;
	private JTextField birthField;
	private JTextField salaryField;
	private JTextField bonusField;
	private JTextField startWorkField;
	private JComboBox depBox;
	/**
	 * Create the panel.
	 */
	private GetRealEmployee() {
		setBounds(0,0, 996, 772);
		back = new ImageIcon(backImg);
		press = new ImageIcon(pressImg);
		hover = new ImageIcon(hoverImg);
		regular = new ImageIcon(regularImg);
		regularTxt= new ImageIcon(reguTxtlarImg);
		hoverTxt = new ImageIcon(hoverTxtImg);
		setLayout(null);

		JPanel headlinePane = new JPanel();
		headlinePane.setLayout(null);
		headlinePane.setBackground(new Color(78, 153, 114));
		headlinePane.setBounds(0, 0, 996, 76);
		add(headlinePane);

		JLabel lblAddEmployeePanel = new JLabel("Filter Employee by all or some of the fields\n");
		lblAddEmployeePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployeePanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddEmployeePanel.setBounds(6, 6, 984, 64);
		headlinePane.add(lblAddEmployeePanel);

		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelGR.getInstance());
			}
		});

		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(0, 681, 102, 91);
		lblback.setIcon(back);
		add(lblback);

		JLabel txtId = new JLabel("ID:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId.setBounds(0, 384, 69, 55);
		add(txtId);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(72, 395, 392, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JLabel lblFirst = new JLabel("First Name:");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFirst.setBounds(16, 124, 150, 55);
		add(lblFirst);

		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		firstNameField.setColumns(10);
		firstNameField.setBounds(196, 135, 268, 35);
		add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lastNameField.setColumns(10);
		lastNameField.setBounds(689, 135, 290, 35);
		add(lastNameField);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblLastName.setBounds(527, 124, 150, 55);
		add(lblLastName);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPhone.setBounds(10, 171, 102, 55);
		add(lblPhone);

		phoneField = new JTextField();
		phoneField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		phoneField.setColumns(10);
		phoneField.setBounds(196, 182, 268, 35);
		add(phoneField);

		JLabel lblArea = new JLabel("Area:");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblArea.setBounds(527, 270, 102, 55);
		add(lblArea);

		JComboBox <Area> areaBox = new JComboBox<>(Area.values());
		areaBox.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		areaBox.setBounds(645, 273, 334, 55);
		add(areaBox);

		JLabel areaBack = new JLabel("");
		areaBack.setHorizontalAlignment(SwingConstants.CENTER);
		areaBack.setIcon(regularTxt);
		areaBack.setBounds(515, 270, 481, 55);
		add(areaBack);


		JComboBox <Gender>genderBox = new JComboBox<>(Gender.values());
		genderBox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		genderBox.setBounds(645, 174, 334, 52);
		add(genderBox);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGender.setBounds(515, 174, 150, 55);
		add(lblGender);

		depBox = new JComboBox<>();
		depBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		depBox.setBounds(187, 76, 277, 55);
		add(depBox);

		JLabel lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearOfBirth.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblYearOfBirth.setBounds(10, 223, 179, 55);
		add(lblYearOfBirth);

		birthField = new JTextField();
		birthField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		birthField.setColumns(10);
		birthField.setBounds(196, 229, 268, 35);
		add(birthField);

		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSalary.setBounds(525, 223, 114, 55);
		add(lblSalary);

		salaryField = new JTextField();
		salaryField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		salaryField.setColumns(10);
		salaryField.setBounds(689, 234, 290, 35);
		add(salaryField);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDepartment.setBounds(0, 75, 181, 55);
		add(lblDepartment);

		JLabel lblManger = new JLabel("Manager ?:");
		lblManger.setHorizontalAlignment(SwingConstants.CENTER);
		lblManger.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblManger.setBounds(16, 270, 150, 55);
		add(lblManger);

		JComboBox<YN> managerBox = new JComboBox<>(YN.values());

		managerBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		managerBox.setBounds(187, 271, 277, 55);
		add(managerBox);

		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonus.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblBonus.setBounds(515, 320, 150, 55);
		lblBonus.setVisible(false);
		add(lblBonus);

		bonusField = new JTextField();
		bonusField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		bonusField.setColumns(10);
		bonusField.setBounds(689, 329, 290, 35);
		bonusField.setVisible(false);
		add(bonusField);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(0, 387, 481, 55);
		add(idBack);

		JLabel firstNameBack = new JLabel("");
		firstNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameBack.setIcon(regularTxt);
		firstNameBack.setBounds(0, 124, 481, 55);
		add(firstNameBack);

		JLabel lastNameBack = new JLabel("");
		lastNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack.setIcon(regularTxt);
		lastNameBack.setBounds(515, 124, 481, 55);
		add(lastNameBack);

		JLabel phoneBack = new JLabel("");
		phoneBack.setHorizontalAlignment(SwingConstants.CENTER);
		phoneBack.setIcon(regularTxt);
		phoneBack.setBounds(0, 174, 481, 55);
		add(phoneBack);

		JLabel genderBack = new JLabel("");
		genderBack.setHorizontalAlignment(SwingConstants.CENTER);
		genderBack.setIcon(regularTxt);
		genderBack.setBounds(515, 174, 481, 55);
		add(genderBack);

		JLabel birthBack = new JLabel("");
		birthBack.setHorizontalAlignment(SwingConstants.CENTER);
		birthBack.setIcon(regularTxt);
		birthBack.setBounds(0, 223, 481, 55);
		add(birthBack);

		JLabel salaryBack = new JLabel("");
		salaryBack.setHorizontalAlignment(SwingConstants.CENTER);
		salaryBack.setIcon(regularTxt);
		salaryBack.setBounds(515, 223, 481, 55);
		add(salaryBack);

		JLabel depBack = new JLabel("");
		depBack.setHorizontalAlignment(SwingConstants.CENTER);
		depBack.setIcon(regularTxt);
		depBack.setBounds(0, 75, 481, 55);
		add(depBack);

		JLabel mangerBack = new JLabel("");
		mangerBack.setHorizontalAlignment(SwingConstants.CENTER);
		mangerBack.setIcon(regularTxt);
		mangerBack.setBounds(0, 273, 481, 55);
		add(mangerBack);

		JLabel bounosBack = new JLabel("");
		bounosBack.setHorizontalAlignment(SwingConstants.CENTER);
		bounosBack.setIcon(regularTxt);
		bounosBack.setBounds(515, 317, 481, 55);
		bounosBack.setVisible(false);
		add(bounosBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(759, 384, 167, 55);
		add(lblSubmit);

		JTextArea answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		JScrollPane textPane = new JScrollPane(answer);
		textPane.setBounds(99, 455, 847, 275);
		// Set vertical and horizontal scroll policies
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(textPane);

		managerBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YN selectedMange= (YN) managerBox.getSelectedItem();
				if (selectedMange == YN.Yes) {
					lblBonus.setVisible(true);
					bonusField.setVisible(true);
					bounosBack.setVisible(true);

				} else if (selectedMange == YN.No) {
					lblBonus.setVisible(false);
					bonusField.setVisible(false);
					bounosBack.setVisible(false);
				} 
			}}
				);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Long id = 0L;
				String firstName = null;
				String lastName = null;
				Double phoneNumber = 0.0;
				Area area = null;
				Gender gender = null;
				Department dep = null;
				Integer yearOfBirth = 0;
				Integer startOfWork = null;
				Double salary = 0.0;
				Double bonus = 0.0;

				// Create a HashMap to store relevant rooms
				HashMap<String, Employee> relevantEmployees = new HashMap<>();

				if(!idTxtField.getText().trim().isEmpty()) {
					answer.setText("");
					answer.setText(hotel.getAllEmployees().get(idTxtField.getText()).toString());	

				}



				else {
					dep = hotel.getRealDepartment((String) depBox.getSelectedItem());
					firstName = firstNameField.getText();
					lastName = lastNameField.getText();
					area = (Area) areaBox.getSelectedItem();
					gender = (Gender) genderBox.getSelectedItem();  

					// Handle "Pick_One" option for Room Type
					Area selectedArea = (Area) areaBox.getSelectedItem();
					if (selectedArea == Area.Pick_One) {
						selectedArea = null;
					}

					// Handle "Pick_One" option for View
					Gender selectedGender = (Gender) genderBox.getSelectedItem();
					if (selectedGender == Gender.Pick_One) {
						selectedGender = null;
					} 

					try {
						if (!birthField.getText().trim().isEmpty()) { 
							yearOfBirth= Integer.parseInt(birthField.getText());
							if(yearOfBirth<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"year Of Birth field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}

					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only integers at year Of Birth Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!startWorkField.getText().trim().isEmpty()) { 
							startOfWork= Integer.parseInt(startWorkField.getText());
							if(startOfWork<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"start Of Work field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}

					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only integers at start Of Work Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}

					try {
						if (!idTxtField.getText().trim().isEmpty()) { 
							id=Long.parseLong(idTxtField.getText());
							if(id<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}

						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"start Of Work field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only numbers at ID Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!phoneField.getText().trim().isEmpty()) { 
							phoneNumber= Double.parseDouble(phoneField.getText());
							if(phoneNumber<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"Phone Number field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only numbers at Phone Number Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!salaryField.getText().trim().isEmpty()) { 	
							salary= Double.parseDouble(salaryField.getText());
							if(salary<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"Salary field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}

					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only numbers at Salary Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}




					try {

						if (!bonusField.getText().trim().isEmpty()) { 	
							bonus= Double.parseDouble(bonusField.getText());
							if(bonus<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"Bonus field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only numbers at Bonus Percentage Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;}



					for (Employee emp : hotel.getAllEmployees().values()) {
						boolean commonConditions =
								(firstNameField.getText().trim().isEmpty() || firstName.equals(emp.getFirstName())) &&
								(lastNameField.getText().trim().isEmpty() || lastName.equals(emp.getLastName())) &&
								(phoneField.getText().trim().isEmpty() || phoneField.getText().equals(emp.getPhoneNumber())) &&
								(area == Area.Pick_One || area == emp.getArea()) &&
								(gender == Gender.Pick_One || gender == emp.getGender()) &&
								(dep == null || dep.equals(emp.getDepartment())) &&
								(yearOfBirth == 0 || yearOfBirth.equals(emp.getYearOfBirth())) &&
								(salary == 0.0 || salary.equals(emp.getSalary())) &&
								(bonus == 0.0 || ((emp instanceof DepartmentManager) && bonus.equals(((DepartmentManager) emp).getBonus()))) &&
								(startOfWork == null || startOfWork.equals(emp.getStartOfWork()));
						// Apply conditions based on manager selection
						if (managerBox.getSelectedItem() == YN.Pick_One && commonConditions) {
							relevantEmployees.put(emp.getId(), emp);
						} else if (managerBox.getSelectedItem() == YN.Yes && emp instanceof DepartmentManager) {
							relevantEmployees.put(emp.getId(), emp);
						} else if (managerBox.getSelectedItem() == YN.No && !(emp instanceof DepartmentManager)) {
							relevantEmployees.put(emp.getId(), emp);
						}
					}

					// Clear input fields
					idTxtField.setText("");
					firstNameField.setText("");
					lastNameField.setText("");
					phoneField.setText("");
					birthField.setText("");
					salaryField.setText("");
					bonusField.setText("");
					startWorkField.setText("");

					// Display filtered employees
					answer.setText("");
					StringBuilder stringBuilder = new StringBuilder();
					//if the employee is the current employee it will print his password too other wise it will print without pass just user name
					relevantEmployees.values().forEach(employee -> {
						if (employee.getUser().equals(hotel.getCurrentUser())) {
							stringBuilder.append(employee.fullToString());
						} else {
							stringBuilder.append(employee.toString());
						}
						stringBuilder.append("\n"); // Add a newline after each employee's information
					});

					answer.setText(stringBuilder.toString());

					relevantEmployees.clear();
				}
			}});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(685, 373, 294, 76);
		add(submitBtn);

		JLabel lblStartOfWork = new JLabel("Start Of Work Year:");
		lblStartOfWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartOfWork.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblStartOfWork.setBounds(527, 75, 268, 55);
		add(lblStartOfWork);

		startWorkField = new JTextField();
		startWorkField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		startWorkField.setColumns(10);
		startWorkField.setBounds(794, 88, 185, 35);
		add(startWorkField);

		JLabel startWorkBack = new JLabel("");
		startWorkBack.setHorizontalAlignment(SwingConstants.CENTER);
		startWorkBack.setIcon(regularTxt);
		startWorkBack.setBounds(515, 75, 481, 55);
		add(startWorkBack);

		JLabel lblOrJustWrite = new JLabel("Or Just Write The ID");
		lblOrJustWrite.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrJustWrite.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblOrJustWrite.setBounds(16, 328, 448, 55);
		add(lblOrJustWrite);


		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);










	}
	public void refreshCombo () {
		depBox.removeAllItems();
		Hotel.getInstance().getAllDepartments().keySet().forEach((key)->{depBox.addItem((String)key);});
	}
	public static GetRealEmployee getInstance() {
		if (instance == null) {
			instance = new GetRealEmployee();
		}
		return instance;
	}
	private class InternalMouseAdapter extends MouseAdapter{
		JLabel label;

		public InternalMouseAdapter (JLabel label ) {
			this.label = label;	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			this.label.setIcon(hover);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			this.label.setIcon(regular);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			this.label.setIcon(press);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			this.label.setIcon(hover);
		}
	}
	private class TxtMouseAdapter extends MouseAdapter{
		JLabel label;

		public TxtMouseAdapter (JLabel label ) {
			this.label = label;	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			this.label.setIcon(hoverTxt);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			this.label.setIcon(regularTxt);
		}

	}
}
