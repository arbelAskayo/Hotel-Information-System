
//Author: Arbel Askayo 208642868
package view;

import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.MaxPopulationCapacityException;
import exceptions.MissingInputException;
import exceptions.NegativeInputException;
import exceptions.PersonAlreadyExistException;
import model.*;
import utils.Area;
import utils.Gender;
import utils.RoomTypes;
import utils.YN;



public class AddCustomerPanel extends JPanel {
	private static AddCustomerPanel instance=null;
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
	private JTextField dateField;
	private JTextField discountField;
	/**
	 * Create the panel.
	 */
	private AddCustomerPanel() {
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

		JLabel lblAddCustomerPanel = new JLabel("Add Customer");
		lblAddCustomerPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCustomerPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddCustomerPanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblAddCustomerPanel);

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
		txtId.setBounds(256, 77, 69, 55);
		add(txtId);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(327, 88, 392, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JLabel lblFirst = new JLabel("First Name:");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFirst.setBounds(16, 144, 150, 55);
		add(lblFirst);

		firstNameField = new JTextField();
		firstNameField.setForeground(new Color(0, 0, 0));
		firstNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		firstNameField.setColumns(10);
		firstNameField.setBounds(200, 155, 268, 35);
		add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lastNameField.setColumns(10);
		lastNameField.setBounds(689, 155, 290, 35);
		add(lastNameField);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblLastName.setBounds(527, 144, 150, 55);
		add(lblLastName);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPhone.setBounds(16, 227, 102, 55);
		add(lblPhone);

		phoneField = new JTextField();
		phoneField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		phoneField.setColumns(10);
		phoneField.setBounds(200, 238, 268, 35);
		add(phoneField);

		JLabel lblArea = new JLabel("Area:");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblArea.setBounds(527, 392, 102, 55);
		add(lblArea);

		JComboBox <Area> areaBox = new JComboBox<>(Area.values());
		areaBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		areaBox.setBounds(640, 393, 334, 55);
		add(areaBox);

		JLabel areaBack = new JLabel("");
		areaBack.setHorizontalAlignment(SwingConstants.CENTER);
		areaBack.setIcon(regularTxt);
		areaBack.setBounds(515, 393, 481, 55);
		add(areaBack);


		JComboBox <Gender>genderBox = new JComboBox<>(Gender.values());
		genderBox.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		genderBox.setBounds(644, 227, 334, 52);
		add(genderBox);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGender.setBounds(515, 227, 150, 55);
		add(lblGender);

		JComboBox <YN>vipBox = new JComboBox<>(YN.values());
		vipBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		vipBox.setBounds(191, 392, 277, 55);
		add(vipBox);


		JLabel lblYearOfBirth = new JLabel("Year Of Birth:");
		lblYearOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearOfBirth.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblYearOfBirth.setBounds(16, 307, 179, 55);
		add(lblYearOfBirth);

		birthField = new JTextField();
		birthField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		birthField.setColumns(10);
		birthField.setBounds(200, 318, 268, 35);
		add(birthField);

		JLabel lblDate = new JLabel("Date Of Joining:");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDate.setBounds(527, 307, 213, 55);
		add(lblDate);

		dateField = new JTextField();
		dateField.setForeground(new Color(175, 175, 175));
		dateField.setText("dd/MM/yyyy");
		dateField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		dateField.setColumns(10);
		dateField.setBounds(752, 315, 227, 35);
		add(dateField);

		JLabel lblVip = new JLabel("VIP ? :");
		lblVip.setHorizontalAlignment(SwingConstants.CENTER);
		lblVip.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblVip.setBounds(14, 392, 91, 55);
		add(lblVip);

		JLabel lblDiscount = new JLabel("Discount Presentage:");
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscount.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDiscount.setBounds(16, 485, 309, 55);
		lblDiscount.setVisible(false);
		add(lblDiscount);

		discountField = new JTextField();
		discountField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		discountField.setColumns(10);
		discountField.setBounds(332, 496, 136, 35);
		discountField.setVisible(false);
		add(discountField);


		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(256, 77, 481, 55);
		add(idBack);

		JLabel firstNameBack = new JLabel("");
		firstNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameBack.setIcon(regularTxt);
		firstNameBack.setBounds(0, 144, 481, 55);
		add(firstNameBack);

		JLabel lastNameBack = new JLabel("");
		lastNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack.setIcon(regularTxt);
		lastNameBack.setBounds(515, 144, 481, 55);
		add(lastNameBack);

		JLabel phoneBack = new JLabel("");
		phoneBack.setHorizontalAlignment(SwingConstants.CENTER);
		phoneBack.setIcon(regularTxt);
		phoneBack.setBounds(0, 227, 481, 55);
		add(phoneBack);

		JLabel genderBack = new JLabel("");
		genderBack.setHorizontalAlignment(SwingConstants.CENTER);
		genderBack.setIcon(regularTxt);
		genderBack.setBounds(515, 227, 481, 55);
		add(genderBack);

		JLabel birthBack = new JLabel("");
		birthBack.setHorizontalAlignment(SwingConstants.CENTER);
		birthBack.setIcon(regularTxt);
		birthBack.setBounds(0, 307, 481, 55);
		add(birthBack);

		JLabel salaryBack = new JLabel("");
		salaryBack.setHorizontalAlignment(SwingConstants.CENTER);
		salaryBack.setIcon(regularTxt);
		salaryBack.setBounds(515, 307, 481, 55);
		add(salaryBack);

		JLabel vipBack = new JLabel("");
		vipBack.setHorizontalAlignment(SwingConstants.CENTER);
		vipBack.setIcon(regularTxt);
		vipBack.setBounds(0, 393, 481, 55);
		add(vipBack);

		JLabel discountBack = new JLabel("");
		discountBack.setHorizontalAlignment(SwingConstants.CENTER);
		discountBack.setIcon(regularTxt);
		discountBack.setBounds(0, 486, 481, 55);
		discountBack.setVisible(false);
		add(discountBack);
		//showing or not showing 
		vipBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YN selectedVIP = (YN) vipBox.getSelectedItem();
				if (selectedVIP == YN.Yes) {
					lblDiscount.setVisible(true);
					discountBack.setVisible(true);
					discountField.setVisible(true);

				} else if (selectedVIP == YN.No) {
					lblDiscount.setVisible(false);
					discountBack.setVisible(false);
					discountField.setVisible(false);
				} 
			}}
				);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(393, 586, 167, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Long id= 0l;

				Double phoneNumber=0.0;
				Area area=null;
				Gender gender=null;
				Integer yearOfBirth=0;
				Date dateOfJoining=null;
				Double discountPercentage=0.0;
				Boolean isAdded=false;

				//checking for exceptions
				try {
					if(areaBox.getSelectedItem().equals(Area.Pick_One)) {
						throw new MissingInputException("Area Box");
					}
					if(genderBox.getSelectedItem().equals(Gender.Pick_One)) {
						throw new MissingInputException("Gender Box");
					}
					if(vipBox.getSelectedItem().equals(YN.Pick_One)) {
						throw new MissingInputException("VIP Box");
					}


				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddCustomerPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}


				area = (Area) areaBox.getSelectedItem();
				gender = (Gender) genderBox.getSelectedItem();

				try {
					if(firstNameField.getText().trim().isEmpty()) {
						throw new MissingInputException("First Name Field");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddCustomerPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if(lastNameField.getText().trim().isEmpty()) {
						throw new MissingInputException("Last Name Field");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddCustomerPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					yearOfBirth= Integer.parseInt(birthField.getText());


				}


				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Please enter only integers at year Of Birth Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					id=Long.parseLong(idTxtField.getText());
					if(id<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}
				}

				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,n.getMessage()+"ID field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Please enter only numbers at ID Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {

					phoneNumber= Double.parseDouble(phoneField.getText());
					if(phoneNumber<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}
				}

				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(null,n.getMessage()+"Phone Number field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Please enter only numbers at Phone Number Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					//date checking
					dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText());
				} catch (ParseException e1) {

					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Please write the date like this:dd/MM/yyyy","Incorrect date",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(vipBox.getSelectedItem().equals(YN.Yes))	{


					try {
						discountPercentage=Double.parseDouble(discountField.getText());

					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(AddCustomerPanel.this,"Please enter only numbers at Discount Percentage Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}

					VIPCustomer c = new VIPCustomer( String.valueOf(id),  firstNameField.getText(),  lastNameField.getText(), String.valueOf(phoneNumber) ,  area,  gender,
							yearOfBirth,  dateOfJoining,  discountPercentage);
					try {
						isAdded=hotel.addCustomer(c);
					} catch (PersonAlreadyExistException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(AddCustomerPanel.this,"Customer Already Exist","Already Exist",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else {
					Customer c = new Customer( String.valueOf(id),  firstNameField.getText(),  lastNameField.getText(), String.valueOf(phoneNumber) ,  area,  gender,
							yearOfBirth,  dateOfJoining);
					try {
						isAdded=hotel.addCustomer(c);
					} catch (PersonAlreadyExistException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(AddCustomerPanel.this,"Customer Already Exist","Already Exist",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}


				if(isAdded) {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Customer: "+hotel.getRealCustomer(String.valueOf(id)).toString() +"Successfuly Added !","Customer Successfuly Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(AddCustomerPanel.this,"Customer Faild To Be Added !","Customer Faild To Be Added ",JOptionPane.INFORMATION_MESSAGE);	
				}
				//reseting the fields
				idTxtField.setText("");
				firstNameField.setText("");
				lastNameField.setText("");
				phoneField.setText("");
				birthField.setText("");
				dateField.setText("dd/MM/yyyy");
				discountField.setText("");
				areaBox.setSelectedItem(Area.Pick_One);
				genderBox.setSelectedItem(Gender.Pick_One);
				vipBox.setSelectedItem(YN.Pick_One);

			}
		}
				);
		submitBtn.setIcon(regular);
		submitBtn.setBounds(327, 576, 294, 76);
		add(submitBtn);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);

	}
	public static AddCustomerPanel getInstance() {
		if (instance == null) {
			instance = new AddCustomerPanel();
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
