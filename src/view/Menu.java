//Author: Arbel Askayo 208642868
package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Hotel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Menu extends JFrame {
	private static Menu instance=null;
	private static Hotel hotel=Hotel.getInstance();
	private JPanel contentPane;
	private Image hotelLogo = new ImageIcon(LoginFrame.class.getResource("/view/hotelIconNobackground.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	private Image logoutIcon = new ImageIcon(LoginFrame.class.getResource("/view/logout icon.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	private PanelHome panelHome=PanelHome.getInstance();
	private  PanelAdd panelAdd=PanelAdd.getInstance();
	private PanelRemove panelRemove=PanelRemove.getInstance();
	private PanelGR panelGR=PanelGR.getInstance();
	private PanelHotelFunc panelHotelFunc=PanelHotelFunc.getInstance();
	private AddRoomPanel addRoomPanel= AddRoomPanel.getInstance();
	private AddBookingPanel addBookingPanel=AddBookingPanel.getInstance();
	private AddEmployeePanel addEmployeePanel=AddEmployeePanel.getInstance();
	private AddCustomerPanel addCustomerPanel=AddCustomerPanel.getInstance();
	private AddDepPanel addDepPanel=AddDepPanel.getInstance();
	private RemoveRoomPanel removeRoomPanel= RemoveRoomPanel.getInstance();
	private RemoveBookingPanel removeBookingPanel=RemoveBookingPanel.getInstance();
	private RemoveEmployeePanel removeEmployeePanel=RemoveEmployeePanel.getInstance();
	private RemoveCustomerPanel removeCustomerPanel=RemoveCustomerPanel.getInstance();
	private RemoveDepPanel removeDepPanel=RemoveDepPanel.getInstance();
	private GetRealRoom getRealRoom=GetRealRoom.getInstance();
	private GetRealEmployee getRealEmployee=GetRealEmployee.getInstance();
	private BookingsOfCustomerPanel bookingsOfCustomerPanel=BookingsOfCustomerPanel.getInstance();
	private KEmployeesPanel kEmployeesPanel=KEmployeesPanel.getInstance();
	private GetRealCustomer getRealCustomer=GetRealCustomer.getInstance();
	private GetRealBooking getRealBooking=GetRealBooking.getInstance();
	private GetRealDep getRealDep=GetRealDep.getInstance();





	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private Menu() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(600, 300, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 61, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		// Add a window listener to handle window closing event
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int choice = JOptionPane.showConfirmDialog(
						Menu.this,
						"Are you sure you want to quit?",
						"Confirmation",
						JOptionPane.YES_NO_OPTION
						);

				if (choice == JOptionPane.YES_OPTION) {
					// Save the serialized data here using the saveHotelData() method
					Hotel.saveHotelData();
					// Quit the application

					System.exit(0);


				} else if (choice == JOptionPane.NO_OPTION) {

					return;
				}
			}
		});






		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(51, 102, 102));

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(hotelLogo));

		JPanel btnHome = new JPanel();
		btnHome.addMouseListener(new PaneMouseAdapter(btnHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClick(panelHome);
			}

		});
		btnHome.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnHome.setBackground(new Color(238, 238, 238));
		btnHome.setLayout(null);

		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblHome.setBounds(6, 6, 278, 63);
		btnHome.add(lblHome);

		JPanel btnAddFunctions = new JPanel();
		btnAddFunctions.addMouseListener(new PaneMouseAdapter(btnAddFunctions) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClick(panelAdd);
			}
		});
		btnAddFunctions.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnAddFunctions.setBackground(UIManager.getColor("Button.background"));
		btnAddFunctions.setLayout(null);

		JLabel lblAddFunc = new JLabel("Add Functions");
		lblAddFunc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFunc.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddFunc.setBounds(6, 6, 278, 63);
		btnAddFunctions.add(lblAddFunc);

		JPanel btnRemoveFunctions = new JPanel();
		btnRemoveFunctions.addMouseListener(new PaneMouseAdapter(btnRemoveFunctions) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClick(panelRemove);
			}
		});
		btnRemoveFunctions.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnRemoveFunctions.setBackground(UIManager.getColor("Button.background"));
		btnRemoveFunctions.setLayout(null);

		JLabel lblRemoveFunc = new JLabel("Remove Fucntions");
		lblRemoveFunc.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveFunc.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRemoveFunc.setBounds(6, 6, 278, 63);
		btnRemoveFunctions.add(lblRemoveFunc);

		JPanel btnGR = new JPanel();
		btnGR.addMouseListener(new PaneMouseAdapter(btnGR) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClick(panelGR);
			}
		});
		btnGR.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnGR.setBackground(UIManager.getColor("Button.background"));
		btnGR.setLayout(null);

		JLabel lblGR = new JLabel("Get Real");
		lblGR.setHorizontalAlignment(SwingConstants.CENTER);
		lblGR.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblGR.setBounds(6, 6, 278, 63);
		btnGR.add(lblGR);

		JPanel btnHotelFunctions = new JPanel();
		btnHotelFunctions.addMouseListener(new PaneMouseAdapter(btnHotelFunctions) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClick(panelHotelFunc);
			}
		});
		btnHotelFunctions.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnHotelFunctions.setBackground(UIManager.getColor("Button.background"));
		btnHotelFunctions.setLayout(null);

		JLabel lblHotelFunc = new JLabel("Hotel Functions");
		lblHotelFunc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelFunc.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblHotelFunc.setBounds(6, 6, 278, 63);
		btnHotelFunctions.add(lblHotelFunc);

		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hotel.saveHotelData();
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				Menu.this.dispose();
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setIcon(new ImageIcon(logoutIcon));

		JPanel PaneMainContent = new JPanel();
		PaneMainContent.setBackground(new Color(46, 45, 47));

		menuClick(panelHome);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
						.addComponent(PaneMainContent, GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
				.addComponent(PaneMainContent, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
				);
		GroupLayout gl_PaneMainContent = new GroupLayout(PaneMainContent);
		gl_PaneMainContent.setHorizontalGroup(
				gl_PaneMainContent.createParallelGroup(Alignment.LEADING)
				.addComponent(panelHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelAdd, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelHotelFunc, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelRemove, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelGR, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(addRoomPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(addBookingPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(addEmployeePanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(addCustomerPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(addDepPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeRoomPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeBookingPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeEmployeePanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeCustomerPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeDepPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealRoom, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealEmployee, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(bookingsOfCustomerPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(kEmployeesPanel, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealCustomer, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealBooking, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealDep, GroupLayout.PREFERRED_SIZE, 996, GroupLayout.PREFERRED_SIZE)






				);
		gl_PaneMainContent.setVerticalGroup(
				gl_PaneMainContent.createParallelGroup(Alignment.LEADING)
				.addComponent(panelHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelAdd, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelHotelFunc, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelRemove, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelGR, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(addRoomPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(addBookingPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(addEmployeePanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(addCustomerPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(addDepPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeRoomPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeBookingPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeEmployeePanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeCustomerPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeDepPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealRoom, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealEmployee, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(bookingsOfCustomerPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(kEmployeesPanel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealCustomer, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealBooking, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(getRealDep, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)



				);
		PaneMainContent.setLayout(gl_PaneMainContent);
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
				gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(32)
						.addComponent(lblIconLogo, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addGap(35))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnAddFunctions, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnRemoveFunctions, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnGR, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(btnHotelFunctions, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(83)
						.addComponent(logout, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
						.addGap(95))
				);
		gl_menuPanel.setVerticalGroup(
				gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(lblIconLogo, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addGap(6)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(btnAddFunctions, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(btnRemoveFunctions, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(btnGR, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(btnHotelFunctions, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(47)
						.addComponent(logout, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addGap(53))
				);
		menuPanel.setLayout(gl_menuPanel);
		contentPane.setLayout(gl_contentPane);







	}


	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

	public void menuClick(JPanel panel) {


		panelHome.setVisible(false);
		panelAdd.setVisible(false);
		panelRemove.setVisible(false);
		panelGR.setVisible(false);
		panelHotelFunc.setVisible(false);
		addRoomPanel.setVisible(false);
		addBookingPanel.setVisible(false);
		addEmployeePanel.setVisible(false);
		addCustomerPanel.setVisible(false);
		addDepPanel.setVisible(false);
		removeRoomPanel.setVisible(false);
		removeBookingPanel.setVisible(false);
		removeEmployeePanel.setVisible(false);
		removeCustomerPanel.setVisible(false);
		removeDepPanel.setVisible(false);
		getRealRoom.setVisible(false);
		getRealEmployee.setVisible(false);
		bookingsOfCustomerPanel.setVisible(false);
		kEmployeesPanel.setVisible(false);
		getRealCustomer.setVisible(false);
		getRealBooking.setVisible(false);
		getRealDep.setVisible(false);


		//refreshing the combo boxes

		addEmployeePanel.refreshCombo();
		getRealEmployee.refreshCombo();
		panel.setVisible(true);

	}


	private class PaneMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PaneMouseAdapter (JPanel panel ) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(51, 102, 140));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(238, 238, 238));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(95, 100, 238));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(238, 238, 238));
		}
	}
	public void loadData(Hotel otherHotel) {
		Hotel.getInstance().copyData(otherHotel);
	}

}
