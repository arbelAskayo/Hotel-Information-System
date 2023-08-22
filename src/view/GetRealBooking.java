
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

import exceptions.CustomerDoesNotExistException;
import exceptions.NegativeInputException;
import exceptions.PersonAlreadyExistException;
import exceptions.RoomDoesNotExistException;
import model.*;
import utils.Area;
import utils.Gender;
import utils.RoomTypes;
import utils.YN;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class GetRealBooking extends JPanel {
	private static GetRealBooking instance=null;
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
	private JTextField numOfDaysField;
	private JTextField customerIDField;
	private JTextField roomNumField;
	private JTextField dateField;
	JTextArea answer;
	JScrollPane textPane;
	/**
	 * Create the panel.
	 */
	private GetRealBooking() {
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

		JLabel lblGetRealBooking = new JLabel("Filter Bookings by all or some of the fields\n");
		lblGetRealBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetRealBooking.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblGetRealBooking.setBounds(6, 6, 984, 64);
		headlinePane.add(lblGetRealBooking);

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

		JLabel txtId = new JLabel("Booking Number:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId.setBounds(6, 268, 243, 55);
		add(txtId);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(265, 279, 199, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JLabel lblFirst = new JLabel("Check In Date:");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFirst.setBounds(10, 75, 207, 55);
		add(lblFirst);

		numOfDaysField = new JTextField();
		numOfDaysField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		numOfDaysField.setColumns(10);
		numOfDaysField.setBounds(768, 86, 199, 35);
		add(numOfDaysField);

		JLabel lblNumOfDays = new JLabel("Number Of Days:");
		lblNumOfDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfDays.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblNumOfDays.setBounds(526, 75, 243, 55);
		add(lblNumOfDays);

		JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerID.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCustomerID.setBounds(526, 124, 199, 55);
		add(lblCustomerID);

		customerIDField = new JTextField();
		customerIDField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		customerIDField.setColumns(10);
		customerIDField.setBounds(768, 135, 199, 35);
		add(customerIDField);

		JLabel areaBack = new JLabel("");
		areaBack.setHorizontalAlignment(SwingConstants.CENTER);
		areaBack.setIcon(regularTxt);
		areaBack.setBounds(515, 75, 481, 55);
		add(areaBack);

		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblRoomNumber.setBounds(20, 124, 213, 55);
		add(lblRoomNumber);

		roomNumField = new JTextField();
		roomNumField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		roomNumField.setColumns(10);
		roomNumField.setBounds(235, 135, 229, 35);
		add(roomNumField);

		dateField = new JTextField();
		dateField.setHorizontalAlignment(SwingConstants.CENTER);
		dateField.setText("dd/MM/yyyy");
		dateField.setForeground(new Color(175, 175, 175));
		dateField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		dateField.setColumns(10);
		dateField.setBounds(235, 88, 229, 35);
		add(dateField);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(0, 268, 481, 55);
		add(idBack);

		JLabel firstNameBack = new JLabel("");
		firstNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameBack.setIcon(regularTxt);
		firstNameBack.setBounds(0, 75, 481, 55);
		add(firstNameBack);

		JLabel lastNameBack = new JLabel("");
		lastNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack.setIcon(regularTxt);
		lastNameBack.setBounds(515, 124, 481, 55);
		add(lastNameBack);

		JLabel phoneBack = new JLabel("");
		phoneBack.setHorizontalAlignment(SwingConstants.CENTER);
		phoneBack.setIcon(regularTxt);
		phoneBack.setBounds(0, 124, 481, 55);
		add(phoneBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(738, 268, 167, 55);
		add(lblSubmit);

		answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		textPane = new JScrollPane(answer);
		textPane.setBounds(99, 337, 847, 393);
		// Set vertical and horizontal scroll policies
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(textPane);


		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseReleased(MouseEvent e)
			{
				String bookingNumber=null;
				String roomNumber = null;
				String customerID = null;
				Integer numberOfDays = 0;
				Date checkInDate = null;




				// Create a HashMap to store relevant Customers
				HashMap<String, Booking> relevantBookings = new HashMap<>();

				if(!idTxtField.getText().trim().isEmpty()) {
					answer.setText("");
					answer.setText(hotel.getAllBookings().get(idTxtField.getText()).toString());	

				}



				else {
					//Checking for possible exceptions for all fields 
					try {
						if(!(roomNumField.getText().trim().isEmpty())&&hotel.getAllRooms().get(roomNumField.getText())!=null) {
							roomNumber = roomNumField.getText();
						}
						else if(!(roomNumField.getText().trim().isEmpty())&&hotel.getAllRooms().get(roomNumField.getText())==null) {
							throw new RoomDoesNotExistException(roomNumField.getText());
						}
					}
					catch(RoomDoesNotExistException r) {
						JOptionPane.showMessageDialog(GetRealBooking.this,r.getMessage(),"Room Does Not Exist Exception ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if(!customerIDField.getText().trim().isEmpty()&&hotel.getAllCustomers().get(customerIDField.getText())!=null) {
							customerID = customerIDField.getText();
						}
						else if(!(customerIDField.getText().trim().isEmpty())&&hotel.getAllCustomers().get(customerIDField.getText())==null) {
							throw new CustomerDoesNotExistException(customerIDField.getText());
						}
					}
					catch(CustomerDoesNotExistException r) {
						JOptionPane.showMessageDialog(GetRealBooking.this,r.getMessage(),"Customer Does Not Exist Exception ",JOptionPane.ERROR_MESSAGE);
						return;
					}


					try {
						if (!numOfDaysField.getText().trim().isEmpty()) { 
							numberOfDays= Integer.parseInt(numOfDaysField.getText());
							if(numberOfDays<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(null,n.getMessage()+"number Of Days field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}

					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Please enter only integers at number Of Days Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}



					try {

						if(!(dateField.getText().trim().isEmpty())&&!(dateField.getText().trim().equals("dd/MM/yyyy"))) {
							checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateField.getText());
						}
					} catch (ParseException e1) {

						JOptionPane.showMessageDialog(GetRealBooking.this,"Please write the date like this:dd/MM/yyyy","Incorrect date",JOptionPane.ERROR_MESSAGE);
						return;
					}

					for (Booking book : hotel.getAllBookings().values()) {
						boolean commonConditions =(
								(roomNumField.getText().trim().isEmpty() || book.getRoomNumber().equals(roomNumber)) &&
								(numOfDaysField.getText().trim().isEmpty() || book.getNumberOfDays().equals(numberOfDays)) &&
								(customerIDField.getText().trim().isEmpty() || customerIDField.getText().equals(book.getCustomer().getId())) &&
								(((dateField.getText().trim().isEmpty())||(dateField.getText().trim().equals("dd/MM/yyyy"))) ||(book.getCheckInDate().equals(checkInDate)) )
								);

						if(commonConditions) {
							relevantBookings.put(book.getBookingNumber(),book);
						}

					}

					// Clear input fields
					idTxtField.setText("");
					numOfDaysField.setText("");
					customerIDField.setText("");
					roomNumField.setText("");
					dateField.setText("dd/MM/yyyy");



					// Display filtered employees
					answer.setText("");
					answer.setText(relevantBookings.toString());
					relevantBookings.clear();
				}
			}});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(673, 258, 294, 76);
		add(submitBtn);

		JLabel lblOrJustWrite = new JLabel("Or Just Write The Booking Number");
		lblOrJustWrite.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrJustWrite.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblOrJustWrite.setBounds(174, 191, 567, 55);
		add(lblOrJustWrite);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);















	}

	public static GetRealBooking getInstance() {
		if (instance == null) {
			instance = new GetRealBooking();
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
