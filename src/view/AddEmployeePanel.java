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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.MissingInputException;
import exceptions.NegativeInputException;
import exceptions.PersonAlreadyExistException;
import exceptions.UserAlreadyExistException;
import model.*;
import utils.Area;
import utils.Gender;
import utils.YN;

import javax.swing.JComboBox;



public class AddEmployeePanel extends JPanel {
	private static AddEmployeePanel instance=null;
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
	private JTextField userNameField;
	private JTextField passwordField;
	/**
	 * Create the panel.
	 */
	private AddEmployeePanel() {
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

		JLabel lblAddEmployeePanel = new JLabel("Add Employee");
		lblAddEmployeePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployeePanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddEmployeePanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblAddEmployeePanel);

		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelAdd.getInstance());
			}
		});

		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(0, 681, 102, 91);
		lblback.setIcon(back);
		add(lblback);

		JLabel txtId = new JLabel("ID:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId.setBounds(10, 88, 69, 55);
		add(txtId);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(76, 99, 392, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JLabel lblFirst = new JLabel("First Name:");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFirst.setBounds(10, 163, 150, 55);
		add(lblFirst);

		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		firstNameField.setColumns(10);
		firstNameField.setBounds(196, 174, 268, 35);
		add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lastNameField.setColumns(10);
		lastNameField.setBounds(689, 174, 290, 35);
		add(lastNameField);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblLastName.setBounds(527, 163, 150, 55);
		add(lblLastName);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPhone.setBounds(10, 245, 102, 55);
		add(lblPhone);

		phoneField = new JTextField();
		phoneField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		phoneField.setColumns(10);
		phoneField.setBounds(200, 256, 268, 35);
		add(phoneField);

		JLabel lblArea = new JLabel("Area:");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblArea.setBounds(527, 407, 102, 55);
		add(lblArea);

		JComboBox <Area> areaBox = new JComboBox<>(Area.values());
		areaBox.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		areaBox.setBounds(645, 408, 334, 55);
		add(areaBox);

		JLabel areaBack = new JLabel("");
		areaBack.setHorizontalAlignment(SwingConstants.CENTER);
		areaBack.setIcon(regularTxt);
		areaBack.setBounds(515, 407, 481, 55);
		add(areaBack);


		JComboBox <Gender>genderBox = new JComboBox<>(Gender.values());
		genderBox.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		genderBox.setBounds(645, 248, 334, 52);
		add(genderBox);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGender.setBounds(515, 245, 150, 55);
		add(lblGender);

		depBox = new JComboBox<>();
		depBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		depBox.setBounds(191, 408, 277, 55);
		add(depBox);

		JLabel lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearOfBirth.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblYearOfBirth.setBounds(10, 329, 179, 55);
		add(lblYearOfBirth);

		birthField = new JTextField();
		birthField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		birthField.setColumns(10);
		birthField.setBounds(200, 340, 268, 35);
		add(birthField);

		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSalary.setBounds(527, 329, 114, 55);
		add(lblSalary);

		salaryField = new JTextField();
		salaryField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		salaryField.setColumns(10);
		salaryField.setBounds(689, 340, 290, 35);
		add(salaryField);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDepartment.setBounds(10, 407, 181, 55);
		add(lblDepartment);

		JLabel lblManger = new JLabel("Manager ?:");
		lblManger.setHorizontalAlignment(SwingConstants.CENTER);
		lblManger.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblManger.setBounds(16, 485, 150, 55);
		add(lblManger);

		JComboBox<YN> managerBox = new JComboBox<>(YN.values());

		managerBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		managerBox.setBounds(193, 486, 277, 55);
		add(managerBox);

		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonus.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblBonus.setBounds(515, 486, 150, 55);
		lblBonus.setVisible(false);
		add(lblBonus);

		bonusField = new JTextField();
		bonusField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		bonusField.setColumns(10);
		bonusField.setBounds(689, 496, 290, 35);
		bonusField.setVisible(false);
		add(bonusField);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(0, 88, 481, 55);
		add(idBack);

		JLabel firstNameBack = new JLabel("");
		firstNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameBack.setIcon(regularTxt);
		firstNameBack.setBounds(0, 163, 481, 55);
		add(firstNameBack);

		JLabel lastNameBack = new JLabel("");
		lastNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack.setIcon(regularTxt);
		lastNameBack.setBounds(515, 163, 481, 55);
		add(lastNameBack);

		JLabel phoneBack = new JLabel("");
		phoneBack.setHorizontalAlignment(SwingConstants.CENTER);
		phoneBack.setIcon(regularTxt);
		phoneBack.setBounds(0, 245, 481, 55);
		add(phoneBack);

		JLabel genderBack = new JLabel("");
		genderBack.setHorizontalAlignment(SwingConstants.CENTER);
		genderBack.setIcon(regularTxt);
		genderBack.setBounds(515, 245, 481, 55);
		add(genderBack);

		JLabel birthBack = new JLabel("");
		birthBack.setHorizontalAlignment(SwingConstants.CENTER);
		birthBack.setIcon(regularTxt);
		birthBack.setBounds(0, 329, 481, 55);
		add(birthBack);

		JLabel salaryBack = new JLabel("");
		salaryBack.setHorizontalAlignment(SwingConstants.CENTER);
		salaryBack.setIcon(regularTxt);
		salaryBack.setBounds(515, 329, 481, 55);
		add(salaryBack);

		JLabel depBack = new JLabel("");
		depBack.setHorizontalAlignment(SwingConstants.CENTER);
		depBack.setIcon(regularTxt);
		depBack.setBounds(0, 407, 481, 55);
		add(depBack);

		JLabel mangerBack = new JLabel("");
		mangerBack.setHorizontalAlignment(SwingConstants.CENTER);
		mangerBack.setIcon(regularTxt);
		mangerBack.setBounds(0, 486, 481, 55);
		add(mangerBack);

		JLabel bounosBack = new JLabel("");
		bounosBack.setHorizontalAlignment(SwingConstants.CENTER);
		bounosBack.setIcon(regularTxt);
		bounosBack.setBounds(515, 486, 481, 55);
		bounosBack.setVisible(false);
		add(bounosBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(407, 681, 167, 55);
		add(lblSubmit);

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
				Long id= 0l;

				Double phoneNumber=0.0;
				Area area=null;
				Gender gender=null;
				Department dep =null;
				Integer yearOfBirth=0;
				Integer startOfWork=null;
				Double salary=0.0;
				Double bonus=0.0;
				Boolean isAdded=false;
				String userName;

				try {
					if(areaBox.getSelectedItem().equals(Area.Pick_One)) {
						throw new MissingInputException("Area Box");
					}
					if(genderBox.getSelectedItem().equals(Gender.Pick_One)) {
						throw new MissingInputException("Gender Box");
					}
					if(managerBox.getSelectedItem().equals(YN.Pick_One)) {
						throw new MissingInputException("Manager Box");
					}

				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddEmployeePanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				area = (Area) areaBox.getSelectedItem();
				gender = (Gender) genderBox.getSelectedItem();
				dep=hotel.getRealDepartment((String)depBox.getSelectedItem());
				try {
					if(firstNameField.getText().trim().isEmpty()) {
						throw new MissingInputException("First Name Field");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddEmployeePanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if(lastNameField.getText().trim().isEmpty()) {
						throw new MissingInputException("Last Name Field");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddEmployeePanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if(userNameField.getText().trim().isEmpty()) {
						throw new MissingInputException("User Name Field");
					}
					userName=userNameField.getText();
					if(hotel.getAllUsers().get(userName)!=null)
					{ 
						throw new UserAlreadyExistException();
					}
				}
				catch(UserAlreadyExistException ex) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,ex.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddEmployeePanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if(passwordField.getText().trim().isEmpty()) {
						throw new MissingInputException("Password Field");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddEmployeePanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					yearOfBirth= Integer.parseInt(birthField.getText());

				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only integers at year Of Birth Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					startOfWork= Integer.parseInt(startWorkField.getText());

				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only integers at start Of Work Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					id=Long.parseLong(idTxtField.getText());
					if(id<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}
					if(hotel.getAllEmployees().containsKey(id)) {
						throw new PersonAlreadyExistException();
					}
				}
				catch (PersonAlreadyExistException e11) {

					JOptionPane.showMessageDialog(AddEmployeePanel.this,e11.getMessage(),"Already Exist",JOptionPane.ERROR_MESSAGE);
					return;
				}

				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,n.getMessage()+"ID field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only numbers at ID Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {

					phoneNumber= Double.parseDouble(phoneField.getText());
					if(phoneNumber<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}
				}

				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,n.getMessage()+"Phone Number field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only numbers at Phone Number Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {

					salary= Double.parseDouble(salaryField.getText());
					if(salary<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}
				}

				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,n.getMessage()+"Salary field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only numbers at Salary Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}



				if(managerBox.getSelectedItem().equals(YN.Yes))	{


					try {
						bonus=Double.parseDouble(bonusField.getText());

						if(bonus<0) {
							throw new NegativeInputException("Please enter only positive numbers at ");
						}
					}

					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(AddEmployeePanel.this,n.getMessage()+"Bonus field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(AddEmployeePanel.this,"Please enter only numbers at Bonus Percentage Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}

					DepartmentManager emp =new DepartmentManager( String.valueOf(id),   firstNameField.getText(),  lastNameField.getText(), String.valueOf(phoneNumber) ,  area,  gender,
							yearOfBirth, startOfWork, salary,  dep,  bonus);

					User use= new User (userNameField.getText(),passwordField.getText(),String.valueOf(id));
					hotel.addUser(use);


					try {
						isAdded=hotel.addDepartmentManager(emp);
					} catch (PersonAlreadyExistException e11) {

						JOptionPane.showMessageDialog(AddEmployeePanel.this,"Employee Already Exist","Already Exist",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else {
					Employee emp =new Employee( String.valueOf(id),  firstNameField.getText(),  lastNameField.getText(), String.valueOf(phoneNumber) ,  area,  gender,
							yearOfBirth, startOfWork, salary,dep);
					User use= new User (userNameField.getText(),passwordField.getText(),String.valueOf(id));
					hotel.addUser(use);
					try {
						isAdded=hotel.addEmployee(emp);

					} catch (PersonAlreadyExistException e11) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(AddEmployeePanel.this,"Employee Already Exist","Already Exist",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				idTxtField.setText("");
				firstNameField.setText("");
				lastNameField.setText("");
				phoneField.setText("");
				birthField.setText("");
				salaryField.setText("");
				bonusField.setText("");
				startWorkField.setText("");
				areaBox.setSelectedItem(Area.Pick_One);
				genderBox.setSelectedItem(Gender.Pick_One);
				managerBox.setSelectedItem(YN.Pick_One);



				if(isAdded) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Employee: "+hotel.getAllEmployees().get(String.valueOf(id)) +" Successfuly Added !","Employee Successfuly Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(AddEmployeePanel.this,"Employee Faild To Be Added !","Employee Faild To Be Added ",JOptionPane.INFORMATION_MESSAGE);	
				}


			}
		}
				);
		submitBtn.setIcon(regular);
		submitBtn.setBounds(344, 671, 294, 76);
		add(submitBtn);

		JLabel lblStartOfWork = new JLabel("Start Of Work Year:");
		lblStartOfWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartOfWork.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblStartOfWork.setBounds(527, 88, 268, 55);
		add(lblStartOfWork);

		startWorkField = new JTextField();
		startWorkField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		startWorkField.setColumns(10);
		startWorkField.setBounds(794, 99, 185, 35);
		add(startWorkField);

		JLabel startWorkBack = new JLabel("");
		startWorkBack.setHorizontalAlignment(SwingConstants.CENTER);
		startWorkBack.setIcon(regularTxt);
		startWorkBack.setBounds(515, 88, 481, 55);
		add(startWorkBack);



		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblUserName.setBounds(0, 582, 205, 55);
		add(lblUserName);

		userNameField = new JTextField();
		userNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		userNameField.setColumns(10);
		userNameField.setBounds(191, 593, 268, 35);
		add(userNameField);



		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPassword.setBounds(527, 580, 150, 55);
		add(lblPassword);

		passwordField = new JTextField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		passwordField.setColumns(10);
		passwordField.setBounds(689, 593, 290, 35);
		add(passwordField);


		JLabel salaryBack_1 = new JLabel("");
		salaryBack_1.setHorizontalAlignment(SwingConstants.CENTER);
		salaryBack_1.setBounds(515, 580, 481, 55);
		salaryBack_1.setIcon(regularTxt);
		add(salaryBack_1);

		JLabel startWorkBack_1 = new JLabel("");
		startWorkBack_1.setHorizontalAlignment(SwingConstants.CENTER);
		startWorkBack_1.setBounds(0, 580, 481, 55);
		startWorkBack_1.setIcon(regularTxt);
		add(startWorkBack_1);


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
	public static AddEmployeePanel getInstance() {
		if (instance == null) {
			instance = new AddEmployeePanel();
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
