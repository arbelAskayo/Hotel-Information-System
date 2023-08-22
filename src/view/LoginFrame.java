//Author: Arbel Askayo 208642868
package view;

import java.awt.BorderLayout;
import model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginFrame extends JFrame {


	private static Hotel preHotel;
	private static PanelAdd panelAdd=PanelAdd.getInstance();
	private static PanelRemove panelRemove=PanelRemove.getInstance();

	private Image hotelLogo = new ImageIcon(LoginFrame.class.getResource("/view/hotelIconNobackground.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	private Image keyLogo = new ImageIcon(LoginFrame.class.getResource("/view/keyLogoNoBackground.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		preHotel=Hotel.loadHotelData();
		if(preHotel!=null) {
			Menu.getInstance().loadData(preHotel);
		}
		Hotel.getInstance().addAdmin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 1357, 840);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new LineBorder(new Color(0, 102, 153), 2));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setBorder(null);
		txtUserName.setText("User Name ..?");
		txtUserName.setBounds(6, 6, 417, 46);
		panel.add(txtUserName);
		txtUserName.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);

		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setText("Password");
		txtPassword.setBounds(6, 6, 417, 46);
		panel_1.add(txtPassword);

		JPanel loginBtnPan = new JPanel();
		loginBtnPan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginBtnPan.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginBtnPan.setBackground(new Color(204, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = txtUserName.getText();
				String Password = String.valueOf(txtPassword.getPassword());
				User user= new User(username,Password);
				Hotel hotel =Hotel.getInstance();
				//user name is in the system
				if(hotel.getAllUsers().containsKey(user.getUsername())) {
					//the pass correct
					if(hotel.getAllUsers().get(user.getUsername()).getPassword().equals(user.getPassword())) {
						hotel.setCurrentUser(hotel.getAllUsers().get(user.getUsername()));
						//not the admin 
						if(!hotel.getCurrentUser().getUsername().equals("admin")) {
							PanelAdd.getInstance().getEmployeeBtn().setVisible(false);
							PanelAdd.getInstance().getLblEmployee().setVisible(false);
							PanelRemove.getInstance().getEmployeeBtn().setVisible(false);
							PanelRemove.getInstance().getLblEmployee().setVisible(false);
							PanelHome.getInstance().getClearBtn().setVisible(false);
							PanelHome.getInstance().getLblClear().setVisible(false);

						}
						else {
							PanelAdd.getInstance().getEmployeeBtn().setVisible(true);
							PanelAdd.getInstance().getLblEmployee().setVisible(true);
							PanelRemove.getInstance().getEmployeeBtn().setVisible(true);
							PanelRemove.getInstance().getLblEmployee().setVisible(true);
							PanelHome.getInstance().getClearBtn().setVisible(true);
							PanelHome.getInstance().getLblClear().setVisible(true);
						}

					}
					//incorrect pass
					else {
						JOptionPane.showMessageDialog(LoginFrame.this," Incorrect Password ","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				//no such user name
				else {
					JOptionPane.showMessageDialog(LoginFrame.this,"There Is No Such User In The System","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(LoginFrame.this,"Successful Login","Succses",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false); 
				//saying hello to the user
				PanelHome.getInstance().setLblHello();
				Menu.getInstance().setVisible(true);


			}



		});
		loginBtnPan.setBackground(new Color(204, 204, 204));
		loginBtnPan.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(125, 5, 95, 39);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 33));
		loginBtnPan.add(lblNewLabel);

		JLabel lblHotelLogo = new JLabel("");
		lblHotelLogo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUser = new JLabel("User Name:");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Krungthep", Font.BOLD, 33));
		lblUser.setForeground(Color.WHITE);

		JLabel lblPass = new JLabel("Password:");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Krungthep", Font.BOLD, 33));
		lblPass.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(222)
						.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addGap(483))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(220)
						.addComponent(lblPass, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addGap(483))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(480)
						.addComponent(loginBtnPan, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
						.addGap(532))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(366)
						.addComponent(lblHotelLogo, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
						.addGap(414))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(42)
						.addComponent(lblHotelLogo)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
						.addGap(46)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
						.addGap(40)
						.addComponent(loginBtnPan, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(288))
				);

		JLabel lblkeyLogo = new JLabel("");
		lblkeyLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblkeyLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblkeyLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblkeyLogo.setBounds(6, 5, 123, 47);
		loginBtnPan.add(lblkeyLogo);
		lblHotelLogo.setIcon(new ImageIcon(hotelLogo));
		lblkeyLogo.setIcon(new ImageIcon(keyLogo));
		contentPane.setLayout(gl_contentPane);
	}

}
