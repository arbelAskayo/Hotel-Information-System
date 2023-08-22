
//Author: Arbel Askayo 208642868
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Booking;
import model.Customer;
import model.Hotel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.MissingInputException;
import exceptions.NegativeInputException;
import exceptions.RoomDoesNotExistException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class AddBookingPanel extends JPanel {
	private static AddBookingPanel instance=null;
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
	private JTextField roomNumberField;
	private JTextField customerIDField;
	private JTextField checkInDateField;
	private JTextField daysField;
	private Clip clip;

	/**
	 * Create the panel.
	 */
	private AddBookingPanel() {
		setBounds(0,0, 996, 772);
		back = new ImageIcon(backImg);
		press = new ImageIcon(pressImg);
		hover = new ImageIcon(hoverImg);
		regular = new ImageIcon(regularImg);
		regularTxt= new ImageIcon(reguTxtlarImg);
		hoverTxt = new ImageIcon(hoverTxtImg);
		setLayout(null);

		initializeAudioClip();

		JPanel headlinePane = new JPanel();
		headlinePane.setLayout(null);
		headlinePane.setBackground(new Color(78, 153, 114));
		headlinePane.setBounds(0, 0, 996, 76);
		add(headlinePane);

		JLabel lblAddBookingPanel = new JLabel("Add Booking");
		lblAddBookingPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBookingPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddBookingPanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblAddBookingPanel);

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

		JLabel txtId = new JLabel("Room Number:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId.setBounds(511, 390, 212, 55);
		add(txtId);

		roomNumberField = new JTextField();
		roomNumberField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		roomNumberField.setBounds(719, 401, 251, 35);
		add(roomNumberField);
		roomNumberField.setColumns(10);

		JLabel lblCusID = new JLabel("Customer ID:");
		lblCusID.setHorizontalAlignment(SwingConstants.CENTER);
		lblCusID.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCusID.setBounds(6, 390, 187, 55);
		add(lblCusID);

		customerIDField = new JTextField();
		customerIDField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		customerIDField.setColumns(10);
		customerIDField.setBounds(200, 401, 268, 35);
		add(customerIDField);



		JLabel cusIDBack = new JLabel("");
		cusIDBack.setHorizontalAlignment(SwingConstants.CENTER);
		cusIDBack.setIcon(regularTxt);
		cusIDBack.setBounds(0, 390, 481, 55);
		add(cusIDBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(393, 586, 167, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn){
			@Override
			public void mouseReleased(MouseEvent e) {
				//date checking
				Date date = null;
				String roomNum=null;
				Customer c=null;
				Integer days =0;
				Boolean is=false;

				//Checking for possible exceptions for all fields 


				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(checkInDateField.getText());
				} catch (ParseException e1) {

					JOptionPane.showMessageDialog(AddBookingPanel.this,"Please write the date like this:dd/MM/yyyy","Incorrect date",JOptionPane.ERROR_MESSAGE);
					return;
				}
				c=hotel.getRealCustomer((String)customerIDField.getText());
				if(c==null) {
					JOptionPane.showMessageDialog(AddBookingPanel.this,"There is no such customer in the system."+hotel.getAllCustomers(),"Incorrect customer ID",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				try {
					if(!(roomNumberField.getText().trim().isEmpty())&&hotel.getAllRooms().get(roomNumberField.getText())!=null) {
						roomNum = roomNumberField.getText();
					}
					else if(!(roomNumberField.getText().trim().isEmpty())&&hotel.getAllRooms().get(roomNumberField.getText())==null) {
						throw new RoomDoesNotExistException(roomNumberField.getText());
					}
					else if(roomNumberField.getText().trim().isEmpty()) {
						throw new MissingInputException("Room Number Field ");
					}

				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddBookingPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(RoomDoesNotExistException r) {
					JOptionPane.showMessageDialog(AddBookingPanel.this,r.getMessage(),"Room Does Not Exist Exception ",JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					if (!daysField.getText().trim().isEmpty()) { 
						days= Integer.parseInt(daysField.getText());
						if(days<=0) {
							throw new NegativeInputException("Please enter only positive numbers at ");
						}
					}
					else {
						throw new MissingInputException("Days Field  ");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddBookingPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddBookingPanel.this,n.getMessage()+"number Of Days field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}

				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddBookingPanel.this,"Please enter only integers at number Of Days Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}



				Booking b= new Booking( roomNum,c,date,days);
				is=hotel.addBooking(b);
				checkInDateField.setText("dd/MM/yyyy");
				roomNumberField.setText("");
				daysField.setText("");
				customerIDField.setText("");
				if(is) {
					//CHa ching SOUND EFFECT	
					clip.start();

					JOptionPane.showMessageDialog(AddBookingPanel.this,"Booking Successfuly Added !","Booking Successfuly Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(AddBookingPanel.this,"Booking Faild To Be Added !","Booking Faild To Be Added ",JOptionPane.INFORMATION_MESSAGE);	
				}


			}
		});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(327, 576, 294, 76);
		add(submitBtn);



		JLabel lblCheckInDate = new JLabel("Check In Date:");
		lblCheckInDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckInDate.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCheckInDate.setBounds(0, 123, 212, 55);
		add(lblCheckInDate);

		checkInDateField = new JTextField();
		checkInDateField.setForeground(new Color(24, 137, 111));
		checkInDateField.setText("dd/MM/yyyy");
		checkInDateField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		checkInDateField.setColumns(10);
		checkInDateField.setBounds(217, 134, 251, 35);
		add(checkInDateField);



		JLabel lblNumberOfDays = new JLabel("Number Of Days:");
		lblNumberOfDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfDays.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblNumberOfDays.setBounds(549, 123, 243, 55);
		add(lblNumberOfDays);

		daysField = new JTextField();
		daysField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		daysField.setColumns(10);
		daysField.setBounds(789, 135, 181, 35);
		add(daysField);

		JLabel roomNumberBack = new JLabel("");
		roomNumberBack.addMouseListener(new TxtMouseAdapter(roomNumberBack));
		roomNumberBack.setHorizontalAlignment(SwingConstants.CENTER);
		roomNumberBack.setIcon(regularTxt);
		roomNumberBack.setBounds(509, 390, 481, 55);
		add(roomNumberBack);

		JLabel checkInDateBack = new JLabel("");
		checkInDateBack.setHorizontalAlignment(SwingConstants.CENTER);
		checkInDateBack.setIcon(regularTxt);
		checkInDateBack.setBounds(0, 123, 481, 55);
		add(checkInDateBack);

		JLabel numOfDaysBack = new JLabel("");
		numOfDaysBack.setHorizontalAlignment(SwingConstants.CENTER);
		numOfDaysBack.setIcon(regularTxt);
		numOfDaysBack.setBounds(515, 123, 481, 55);
		add(numOfDaysBack);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);
	}
	public static AddBookingPanel getInstance() {
		if (instance == null) {
			instance = new AddBookingPanel();
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

	// in order to use the sound effect
	private void initializeAudioClip() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(
					getClass().getResourceAsStream("/view/chaChing.wav")
					);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
