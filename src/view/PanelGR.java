//Author: Arbel Askayo 208642868
package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;



public class PanelGR extends JPanel {
	private static PanelGR instance=null;

	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/click.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hover.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/default.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	ImageIcon press;
	ImageIcon hover;
	ImageIcon regular;

	private static Menu menu=Menu.getInstance();
	/**
	 * Create the panel.
	 */
	private PanelGR() {
		setBounds(0,0, 996, 772);

		press = new ImageIcon(pressImg);
		hover = new ImageIcon(hoverImg);
		regular = new ImageIcon(regularImg);
		setLayout(null);



		JPanel headlinePane = new JPanel();
		headlinePane.setLayout(null);
		headlinePane.setBackground(new Color(78, 153, 114));
		headlinePane.setBounds(0, 0, 996, 76);
		add(headlinePane);

		JLabel lblGetReals = new JLabel("Get Reals");
		lblGetReals.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetReals.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblGetReals.setBounds(260, 6, 427, 64);
		headlinePane.add(lblGetReals);
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(371, 160, 204, 69);
		lblRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblbooking = new JLabel("Booking");
		lblbooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblbooking.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblbooking.setBounds(371, 260, 204, 69);
		add(lblbooking);

		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblEmployee.setBounds(367, 360, 204, 69);
		add(lblEmployee);

		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblCustomer.setBounds(371, 460, 204, 69);
		add(lblCustomer);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblDepartment.setBounds(371, 560, 204, 69);
		add(lblDepartment);

		JLabel roomBtn = new JLabel("");
		roomBtn.setBounds(357, 148, 226, 95);
		roomBtn.addMouseListener(new ConfiguredMouseAdapter(roomBtn) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(GetRealRoom.getInstance());

			}
		});
		roomBtn.setHorizontalAlignment(SwingConstants.CENTER);
		roomBtn.setIcon(regular);

		JLabel bookingBtn = new JLabel("");
		bookingBtn.addMouseListener(new ConfiguredMouseAdapter(bookingBtn){
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(GetRealBooking.getInstance());

			}
		});
		bookingBtn.setHorizontalAlignment(SwingConstants.CENTER);
		bookingBtn.setBounds(357, 248, 226, 95);
		bookingBtn.setIcon(regular);
		add(bookingBtn);

		JLabel employeeBtn = new JLabel("");
		employeeBtn.addMouseListener(new ConfiguredMouseAdapter(employeeBtn){
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(GetRealEmployee.getInstance());

			}
		});
		employeeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		employeeBtn.setBounds(357, 348, 226, 95);
		employeeBtn.setIcon(regular);
		add(employeeBtn);

		JLabel customerBtn = new JLabel("");
		customerBtn.addMouseListener(new ConfiguredMouseAdapter(customerBtn){
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(GetRealCustomer.getInstance());

			}
		});
		customerBtn.setHorizontalAlignment(SwingConstants.CENTER);
		customerBtn.setBounds(357, 448, 226, 95);
		customerBtn.setIcon(regular);
		add(customerBtn);

		JLabel departmentBtn = new JLabel("");
		departmentBtn.addMouseListener(new ConfiguredMouseAdapter(departmentBtn){
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(GetRealDep.getInstance());

			}
		});
		departmentBtn.setHorizontalAlignment(SwingConstants.CENTER);
		departmentBtn.setBounds(357, 548, 226, 95);
		departmentBtn.setIcon(regular);
		add(departmentBtn);


		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		setLayout(null);
		add(headlinePane);
		add(lblRoom);
		add(roomBtn);
		add(lblbackground);


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


	public static PanelGR getInstance() {
		if (instance == null) {
			instance = new PanelGR();
		}
		return instance;
	}
}
