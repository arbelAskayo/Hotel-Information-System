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



public class GetRealCustomer extends JPanel {
	private static GetRealCustomer instance=null;
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
	private JTextField discountPercentageField;
	private JTextField dateField;
	/**
	 * Create the panel.
	 */
	private GetRealCustomer() {
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

		JLabel lblGetRealCustomer = new JLabel("Filter Customers by all or some of the fields\n");
		lblGetRealCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetRealCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblGetRealCustomer.setBounds(6, 6, 984, 64);
		headlinePane.add(lblGetRealCustomer);

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
		lblArea.setBounds(527, 75, 102, 55);
		add(lblArea);

		JComboBox <Area> areaBox = new JComboBox<>(Area.values());
		areaBox.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		areaBox.setBounds(641, 78, 334, 55);
		add(areaBox);

		JLabel areaBack = new JLabel("");
		areaBack.setHorizontalAlignment(SwingConstants.CENTER);
		areaBack.setIcon(regularTxt);
		areaBack.setBounds(515, 75, 481, 55);
		add(areaBack);


		JComboBox <Gender>genderBox = new JComboBox<>(Gender.values());
		genderBox.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		genderBox.setBounds(645, 174, 334, 52);
		add(genderBox);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGender.setBounds(515, 174, 150, 55);
		add(lblGender);

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

		JLabel lblVIP = new JLabel("VIP ?:");
		lblVIP.setHorizontalAlignment(SwingConstants.CENTER);
		lblVIP.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblVIP.setBounds(515, 223, 150, 55);
		add(lblVIP);

		dateField = new JTextField();
		dateField.setText("dd/MM/yyyy");
		dateField.setForeground(new Color(175, 175, 175));
		dateField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		dateField.setColumns(10);
		dateField.setBounds(237, 88, 227, 35);
		add(dateField);

		JLabel lblDate = new JLabel("Date Of Joining:");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDate.setBounds(10, 75, 213, 55);
		add(lblDate);

		JComboBox<YN> VIPBox = new JComboBox<>(YN.values());

		VIPBox.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		VIPBox.setBounds(702, 224, 277, 55);
		add(VIPBox);

		JLabel lblDiscountPercentage = new JLabel("Discount % :");
		lblDiscountPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscountPercentage.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDiscountPercentage.setBounds(515, 272, 212, 55);
		lblDiscountPercentage.setVisible(false);
		add(lblDiscountPercentage);

		discountPercentageField = new JTextField();
		discountPercentageField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		discountPercentageField.setColumns(10);
		discountPercentageField.setBounds(739, 283, 240, 35);
		discountPercentageField.setVisible(false);
		add(discountPercentageField);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(0, 384, 481, 55);
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

		JLabel VIPBack = new JLabel("");
		VIPBack.setHorizontalAlignment(SwingConstants.CENTER);
		VIPBack.setIcon(regularTxt);
		VIPBack.setBounds(515, 223, 481, 55);
		add(VIPBack);

		JLabel discountPercentageBack = new JLabel("");
		discountPercentageBack.setHorizontalAlignment(SwingConstants.CENTER);
		discountPercentageBack.setIcon(regularTxt);
		discountPercentageBack.setBounds(515, 273, 481, 55);
		discountPercentageBack.setVisible(false);
		add(discountPercentageBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(768, 384, 167, 55);
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

		VIPBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YN selectedMange= (YN) VIPBox.getSelectedItem();
				if (selectedMange == YN.Yes) {
					lblDiscountPercentage.setVisible(true);
					discountPercentageField.setVisible(true);
					discountPercentageBack.setVisible(true);

				} else if (selectedMange == YN.No) {
					lblDiscountPercentage.setVisible(false);
					discountPercentageField.setVisible(false);
					discountPercentageBack.setVisible(false);
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
				Integer yearOfBirth = 0;
				Date dateOfJoining = null;
				Double  discountPercentage=0.0;

				// Create a HashMap to store relevant Customers
				HashMap<String, Customer> relevantCustomers = new HashMap<>();

				if(!idTxtField.getText().trim().isEmpty()) {
					answer.setText("");
					answer.setText(hotel.getAllCustomers().get(idTxtField.getText()).toString());	

				}



				else {

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

						if(!(dateField.getText().trim().isEmpty())&&!(dateField.getText().trim().equals("dd/MM/yyyy"))) {
							dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText());
						}
					} catch (ParseException e1) {

						JOptionPane.showMessageDialog(GetRealCustomer.this,"Please write the date like this:dd/MM/yyyy","Incorrect date",JOptionPane.ERROR_MESSAGE);
						return;
					}





					try {

						if (!discountPercentageField.getText().trim().isEmpty()) { 	
							discountPercentage= Double.parseDouble(discountPercentageField.getText());
							if(discountPercentage<=0) {
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



					for (Customer cus : hotel.getAllCustomers().values()) {
						boolean commonConditions =(
								(firstNameField.getText().trim().isEmpty() || firstName.equals(cus.getFirstName())) &&
								(lastNameField.getText().trim().isEmpty() || lastName.equals(cus.getLastName())) &&
								(phoneField.getText().trim().isEmpty() || phoneField.getText().equals(cus.getPhoneNumber())) &&
								(area == Area.Pick_One || area == cus.getArea()) &&
								(gender == Gender.Pick_One || gender == cus.getGender()) &&
								(yearOfBirth == 0 || yearOfBirth.equals(cus.getYearOfBirth())) &&
								(((dateField.getText().trim().isEmpty())||(dateField.getText().trim().equals("dd/MM/yyyy"))) ||(cus.getDateOfJoining().equals(dateOfJoining)) ) &&
								( discountPercentage== 0.0 || ((cus instanceof VIPCustomer) && discountPercentage.equals(((VIPCustomer) cus).getDiscountPercentage()))) 
								);
						// Apply conditions based on VIP selection
						if (VIPBox.getSelectedItem() == YN.Pick_One && commonConditions) {
							relevantCustomers.put(cus.getId(), cus);
						} else if (VIPBox.getSelectedItem() == YN.Yes && cus instanceof VIPCustomer) {
							relevantCustomers.put(cus.getId(), cus);
						} else if (VIPBox.getSelectedItem() == YN.No && !(cus instanceof VIPCustomer)) {
							relevantCustomers.put(cus.getId(), cus);
						}
					}

					// Clear input fields
					idTxtField.setText("");
					firstNameField.setText("");
					lastNameField.setText("");
					phoneField.setText("");
					birthField.setText("");
					dateField.setText("dd/MM/yyyy");
					discountPercentageField.setText("");


					// Display filtered employees
					answer.setText("");
					answer.setText(relevantCustomers.toString());
					relevantCustomers.clear();
				}
			}});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(702, 375, 294, 76);
		add(submitBtn);

		JLabel dateOfJoiningBack = new JLabel("");
		dateOfJoiningBack.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfJoiningBack.setIcon(regularTxt);
		dateOfJoiningBack.setBounds(0, 75, 481, 55);
		add(dateOfJoiningBack);

		JLabel lblOrJustWrite = new JLabel("Or Just Write The ID");
		lblOrJustWrite.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrJustWrite.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblOrJustWrite.setBounds(6, 324, 448, 55);
		add(lblOrJustWrite);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);















	}

	public static GetRealCustomer getInstance() {
		if (instance == null) {
			instance = new GetRealCustomer();
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
