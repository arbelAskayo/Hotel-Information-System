//Author: Arbel Askayo 208642868
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Hotel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class BookingsOfCustomerPanel extends JPanel {
	private static BookingsOfCustomerPanel instance=null;
	private static Menu menu=Menu.getInstance();
	private static Hotel hotel=Hotel.getInstance();
	private Image backImg = new ImageIcon(LoginFrame.class.getResource("/view/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/clicked.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverTxtImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(1000, 250, Image.SCALE_SMOOTH);
	private Image reguTxtlarImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(1000, 250, Image.SCALE_SMOOTH);
	ImageIcon back;
	ImageIcon press;
	ImageIcon hover;
	ImageIcon regular;
	ImageIcon hoverTxt;
	ImageIcon regularTxt;
	private JTextField idTxtField;
	/**
	 * Create the panel.
	 */
	public BookingsOfCustomerPanel() {
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

		JLabel lblBookingsOfCustomerPanel = new JLabel("All Bookings Of A Customer");
		lblBookingsOfCustomerPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingsOfCustomerPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblBookingsOfCustomerPanel.setBounds(6, 6, 984, 64);
		headlinePane.add(lblBookingsOfCustomerPanel);

		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelHotelFunc.getInstance());
			}
		});

		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(0, 681, 102, 91);
		lblback.setIcon(back);
		add(lblback);

		JLabel fieldTxt = new JLabel("Customer ID:");
		fieldTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		fieldTxt.setBounds(91, 111, 203, 55);
		add(fieldTxt);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(268, 122, 337, 35);
		add(idTxtField);
		idTxtField.setColumns(10);


		JLabel TxtBack = new JLabel("");
		TxtBack.addMouseListener(new TxtMouseAdapter(TxtBack));
		TxtBack.setHorizontalAlignment(SwingConstants.CENTER);
		TxtBack.setIcon(regularTxt);
		TxtBack.setBounds(68, 111, 617, 55);
		add(TxtBack);



		JTextArea answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		JScrollPane textPane = new JScrollPane(answer);
		textPane.setBounds(99, 198, 847, 532);
		// Set vertical and horizontal scroll policies
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(textPane);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setBounds(732, 111, 167, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				answer.setText("");
				if(idTxtField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(BookingsOfCustomerPanel.this,"The Field Is Empty","Empty Field",JOptionPane.ERROR_MESSAGE);
					return;
				}
				else {

					try{
						Long id = Long.parseLong(idTxtField.getText());
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(BookingsOfCustomerPanel.this,"Please write an integer at the ID section.","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (hotel.getRealCustomer(idTxtField.getText())==null) {
						JOptionPane.showMessageDialog(BookingsOfCustomerPanel.this,"There is no such customer in the system.","Invalid input",JOptionPane.ERROR_MESSAGE);
					}
					else {
						answer.setText(hotel.getRealCustomer(idTxtField.getText()).getAllBookings().toString());
					}
				}


			}
		});

		submitBtn.setIcon(regular);
		submitBtn.setBounds(668, 98, 294, 76);
		add(submitBtn);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);


	}
	public static BookingsOfCustomerPanel getInstance() {
		if (instance == null) {
			instance = new BookingsOfCustomerPanel();
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
