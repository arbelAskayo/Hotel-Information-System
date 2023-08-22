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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Hotel;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class PanelHome extends JPanel {
	private static PanelHome instance = null;
	private static Menu menu=Menu.getInstance();
	private static Hotel hotel=Hotel.getInstance();
	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/click.png"))
			.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hover.png"))
			.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/default.png"))
			.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	ImageIcon press;
	ImageIcon hover;
	ImageIcon regular;
	JLabel clearBtn;
	JLabel lblClear;
	private JLabel lblClock;
	JLabel lblHello;
	private JLabel lblDate;

	/**
	 * Create the panel.
	 */
	private PanelHome() {
		setBounds(0, 0, 996, 772);

		press = new ImageIcon(pressImg);
		hover = new ImageIcon(hoverImg);
		regular = new ImageIcon(regularImg);

		JPanel headlinePane = new JPanel();
		headlinePane.setLayout(null);
		headlinePane.setBackground(new Color(78, 153, 114));
		headlinePane.setBounds(0, 0, 996, 76);
		add(headlinePane);

		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblHome.setBounds(260, 6, 427, 64);
		headlinePane.add(lblHome);

		lblClear = new JLabel("Clear All Data");
		lblClear.setBounds(371, 160, 204, 69);
		lblClear.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);

		clearBtn = new JLabel("");
		clearBtn.setBounds(357, 148, 226, 95);
		clearBtn.addMouseListener(new ConfiguredMouseAdapter(clearBtn));
		clearBtn.setHorizontalAlignment(SwingConstants.CENTER);
		clearBtn.setIcon(regular);

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateClockAndDate(); // Call the combined method
			}
		});
		timer.start();


		lblHello = new JLabel("");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setFont(new Font("Krungthep", Font.BOLD, 60));
		lblHello.setForeground(Color.WHITE);
		lblHello.setBounds(213, 428, 542, 100);
		add(lblHello);

		lblClock = new JLabel();
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBounds(213, 518, 548, 160);
		add(lblClock);
		lblClock.setFont(new Font("Krungthep", Font.BOLD, 50));
		lblClock.setForeground(Color.WHITE);

		lblDate = new JLabel();
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(134, 690, 692, 76);
		add(lblDate);
		lblDate.setFont(new Font("Krungthep", Font.BOLD, 40));
		lblDate.setForeground(Color.WHITE);


		setLayout(null);
		add(headlinePane);
		add(lblClear);
		add(clearBtn);
		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);





	}
	public void setLblHello() {
		lblHello.setText("Hello "+Hotel.getInstance().getCurrentUser().getUsername());

	}
	public static PanelHome getInstance() {
		if (instance == null) {
			instance = new PanelHome();
		}
		return instance;
	}

	private class ConfiguredMouseAdapter extends MouseAdapter {
		JLabel label;

		public ConfiguredMouseAdapter(JLabel label) {
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
			clearAllDataWithConfirmation();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			this.label.setIcon(hover);
		}

		private void clearAllDataWithConfirmation() {
			int choice = JOptionPane.showConfirmDialog(
					PanelHome.this,
					"Are you sure you want to delete all data?",
					"Confirmation",
					JOptionPane.YES_NO_OPTION
					);

			if (choice == JOptionPane.YES_OPTION) {
				hotel.clearAllData();
				// Call the saveHotelData() method from your Hotel class 
				Hotel.saveHotelData();

				JOptionPane.showMessageDialog(
						PanelHome.this,
						"All data has been deleted.",
						"Information",
						JOptionPane.INFORMATION_MESSAGE
						);
			}
		}
	}

	public JLabel getClearBtn() {
		return clearBtn;
	}
	public JLabel getLblClear() {
		return lblClear;
	}
	private void updateClockAndDate() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

		Date now = new Date();
		lblClock.setText(timeFormat.format(now));
		lblDate.setText(dateFormat.format(now));
	}
}
