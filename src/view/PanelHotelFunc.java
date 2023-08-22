//Author: Arbel Askayo 208642868
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import model.Booking;
import model.Hotel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;






public class PanelHotelFunc extends JPanel {
	private static PanelHotelFunc instance=null;
	private static Menu menu=Menu.getInstance();
	private static Hotel hotel=Hotel.getInstance();
	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/click.png")).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hover.png")).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/default.png")).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
	ImageIcon press;
	ImageIcon hover;
	ImageIcon regular;

	/**
	 * Create the panel.
	 */
	private PanelHotelFunc() {
		setBounds(0,0, 996, 772);
		press = new ImageIcon(pressImg);
		hover = new ImageIcon(hoverImg);
		regular = new ImageIcon(regularImg);
		setLayout(null);


		JTextArea answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		JScrollPane textPane = new JScrollPane(answer);
		textPane.setBounds(61, 448, 884, 282);
		// Set vertical and horizontal scroll policies
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(textPane);

		JPanel headlinePane = new JPanel();
		headlinePane.setLayout(null);
		headlinePane.setBackground(new Color(78, 153, 114));
		headlinePane.setBounds(0, 0, 996, 76);
		add(headlinePane);

		JLabel lblHotelFunctions = new JLabel("Hotel Functions");
		lblHotelFunctions.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelFunctions.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblHotelFunctions.setBounds(260, 6, 427, 64);
		headlinePane.add(lblHotelFunctions);

		JLabel lblKEmployees = new JLabel("K Employees");
		lblKEmployees.setBounds(105, 88, 300, 69);
		lblKEmployees.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblKEmployees.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblallCustomersByPK = new JLabel("All Customers By PK");
		lblallCustomersByPK.setHorizontalAlignment(SwingConstants.CENTER);
		lblallCustomersByPK.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblallCustomersByPK.setBounds(105, 179, 300, 69);
		add(lblallCustomersByPK);

		JLabel lblAllBookingByRevenue = new JLabel("All Booking By Revenue");
		lblAllBookingByRevenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllBookingByRevenue.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAllBookingByRevenue.setBounds(61, 271, 379, 69);
		add(lblAllBookingByRevenue);

		JLabel lblAllCustomersCmp = new JLabel("All Customers Cmp");
		lblAllCustomersCmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllCustomersCmp.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAllCustomersCmp.setBounds(105, 367, 300, 69);
		add(lblAllCustomersCmp);

		JLabel lblTotalProfit = new JLabel("Total Profit");
		lblTotalProfit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				JOptionPane.showMessageDialog(PanelHotelFunc.this,"Hotel Total Profit: "+hotel.totalProfit(),"Hotel Total Profit ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblTotalProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalProfit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTotalProfit.setBounds(545, 88, 400, 69);
		add(lblTotalProfit);

		JLabel lblBookingsOfCustomer = new JLabel("Bookings Of a Customer");
		lblBookingsOfCustomer.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(BookingsOfCustomerPanel.getInstance());

			}
		});

		lblBookingsOfCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingsOfCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblBookingsOfCustomer.setBounds(555, 180, 400, 69);
		add(lblBookingsOfCustomer);

		JLabel lblWhoBookedTheMostrooms = new JLabel("Who Booked The Most Rooms?");

		lblWhoBookedTheMostrooms.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhoBookedTheMostrooms.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblWhoBookedTheMostrooms.setBounds(545, 272, 400, 69);
		add(lblWhoBookedTheMostrooms);

		JLabel kEmployeesBtn = new JLabel("");
		kEmployeesBtn.setBounds(0, 72, 500, 95);
		kEmployeesBtn.addMouseListener(new ConfiguredMouseAdapter(kEmployeesBtn) {

			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(KEmployeesPanel.getInstance());

			}

		});
		kEmployeesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		kEmployeesBtn.setIcon(regular);

		JLabel allCustomersByPKBtn = new JLabel("");
		allCustomersByPKBtn.addMouseListener(new ConfiguredMouseAdapter(allCustomersByPKBtn) {

			@Override
			public void mouseClicked(MouseEvent e) {
				answer.setText("");
				answer.setText("All Customers By PK :     "+hotel.allCustomersByPK());
			}
		});
		allCustomersByPKBtn.setHorizontalAlignment(SwingConstants.CENTER);
		allCustomersByPKBtn.setBounds(0, 164, 500, 95);
		allCustomersByPKBtn.setIcon(regular);
		add(allCustomersByPKBtn);

		JLabel allBookingByRevenueBtn = new JLabel("");
		allBookingByRevenueBtn.addMouseListener(new ConfiguredMouseAdapter(allBookingByRevenueBtn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				answer.setText("");
				answer.setText("All Bookings By Revenue :     "+hotel.allBookingByRevenue());
				writeAllBookingByRevenue();

			}

		});
		allBookingByRevenueBtn.setHorizontalAlignment(SwingConstants.CENTER);
		allBookingByRevenueBtn.setBounds(0, 260, 500, 95);
		allBookingByRevenueBtn.setIcon(regular);
		add(allBookingByRevenueBtn);

		JLabel allCustomersCmpBtn = new JLabel("");
		allCustomersCmpBtn.addMouseListener(new ConfiguredMouseAdapter(allCustomersCmpBtn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				answer.setText("");
				answer.setText("All Customers Cmp :     "+hotel.allCustomersCmp().toString());
			}


		});
		allCustomersCmpBtn.setHorizontalAlignment(SwingConstants.CENTER);
		allCustomersCmpBtn.setBounds(0, 353, 500, 95);
		allCustomersCmpBtn.setIcon(regular);
		add(allCustomersCmpBtn);

		JLabel totalProfitBtn = new JLabel("");
		totalProfitBtn.addMouseListener(new ConfiguredMouseAdapter(totalProfitBtn));
		totalProfitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		totalProfitBtn.setBounds(490, 72, 500, 95);
		totalProfitBtn.setIcon(regular);
		add(totalProfitBtn);

		JLabel allBookingsOfSpecCustomerBtn = new JLabel("");
		allBookingsOfSpecCustomerBtn.addMouseListener(new ConfiguredMouseAdapter(allBookingsOfSpecCustomerBtn));
		allBookingsOfSpecCustomerBtn.setHorizontalAlignment(SwingConstants.CENTER);
		allBookingsOfSpecCustomerBtn.setBounds(490, 164, 500, 95);
		allBookingsOfSpecCustomerBtn.setIcon(regular);
		add(allBookingsOfSpecCustomerBtn);

		JLabel CustomerBookedTheMostRoomsBtn = new JLabel("");
		CustomerBookedTheMostRoomsBtn.addMouseListener(new ConfiguredMouseAdapter(CustomerBookedTheMostRoomsBtn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				answer.setText("");
				answer.setText("Customer Who Booked The Most Rooms: "+hotel.customerBookedTheMostRooms());
			}
		});
		CustomerBookedTheMostRoomsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerBookedTheMostRoomsBtn.setBounds(490, 260, 500, 95);
		CustomerBookedTheMostRoomsBtn.setIcon(regular);
		add(CustomerBookedTheMostRoomsBtn);







		setLayout(null);
		add(headlinePane);
		add(lblKEmployees);
		add(kEmployeesBtn);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);







	}
	public static PanelHotelFunc getInstance() {
		if (instance == null) {
			instance = new PanelHotelFunc();
		}
		return instance;
	}
	private class ConfiguredMouseAdapter extends MouseAdapter{
		JLabel label;

		public ConfiguredMouseAdapter (JLabel label ) {
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
	private void writeAllBookingByRevenue() {
		LocalDate currentDate = LocalDate.now();
		TreeSet<Booking> bookings = Hotel.getInstance().allBookingByRevenue();
		List<Booking> bookingList = new ArrayList<>(bookings);

		try (XWPFDocument document = new XWPFDocument()) {
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			run.setBold(true);
			run.setText("All Bookings By Revenue:\n\n\n");

			for (Booking booking : bookingList) {
				XWPFParagraph entryParagraph = document.createParagraph();
				XWPFRun entryRun = entryParagraph.createRun();
				entryRun.setText(booking.toString());
				entryRun.addBreak();
			}

			String fileName = "AllBookingsByRevenue_"+ currentDate +".docx";
			try (FileOutputStream out = new FileOutputStream(fileName)) {
				document.write(out);
				JOptionPane.showMessageDialog(this, "Word File Created Successfully: " + fileName, "File Created", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Error Creating Word File: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error creating Word document: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
