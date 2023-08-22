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
import exceptions.DepManagerDoesNotExistException;
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

import utils.Specialization;



public class GetRealDep extends JPanel {
	private static GetRealDep instance=null;
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
	private JTextField manageField;
	/**
	 * Create the panel.
	 */
	private GetRealDep() {
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

		JLabel lblGetRealDep = new JLabel("Filter Departments by all or some of the fields\n");
		lblGetRealDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetRealDep.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblGetRealDep.setBounds(6, 6, 984, 64);
		headlinePane.add(lblGetRealDep);

		JLabel lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecialization.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSpecialization.setBounds(26, 104, 191, 55);
		add(lblSpecialization);

		JLabel txtId_1 = new JLabel("Department ID:");
		txtId_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtId_1.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId_1.setBounds(6, 268, 211, 55);
		add(txtId_1);

		JLabel lblDepartmentManagerId = new JLabel("Department Manager ID:");
		lblDepartmentManagerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartmentManagerId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblDepartmentManagerId.setBounds(532, 104, 435, 55);
		add(lblDepartmentManagerId);



		JComboBox<Specialization> specializationBox = new JComboBox<>(Specialization.values());
		specializationBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		specializationBox.setBounds(216, 105, 258, 55);
		add(specializationBox);

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

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(265, 279, 199, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(0, 268, 481, 55);
		add(idBack);

		JLabel firstNameBack = new JLabel("");
		firstNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameBack.setIcon(regularTxt);
		firstNameBack.setBounds(6, 105, 481, 55);
		add(firstNameBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(738, 268, 167, 55);
		add(lblSubmit);

		JTextArea answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		JScrollPane textPane = new JScrollPane(answer);
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
				String manageID =null;
				Specialization specialization = null;


				if(specializationBox.getSelectedItem()==Specialization.Pick_One) {
					specialization=null;
				}
				else {
					specialization=(Specialization) specializationBox.getSelectedItem();
				}
				try {
					if(!manageField.getText().trim().isEmpty()&&(hotel.getRealDepartmentManager(manageField.getText())!=null)) {
						manageID = manageField.getText();
					}
					else if(!(manageField.getText().trim().isEmpty())&&hotel.getAllCustomers().get(manageField.getText())==null) {
						throw new DepManagerDoesNotExistException(manageField.getText());
					}
				}
				catch(DepManagerDoesNotExistException r) {
					JOptionPane.showMessageDialog(GetRealDep.this,r.getMessage(),"Department Manager Does Not Exist Exception ",JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Create a HashMap to store relevant Customers
				HashMap<String, Department> relevantDepartments = new HashMap<>();

				if(!idTxtField.getText().trim().isEmpty()) {
					answer.setText("");
					answer.setText(hotel.getAllDepartments().get(idTxtField.getText()).toString());	

				}



				else {


					for (Department dep : hotel.getAllDepartments().values()) {
						boolean commonConditions =(
								(specialization==null||dep.getSpecialization().equals(specialization))&&
								(manageID == null || (dep.getDepManager() != null && dep.getDepManager().getId().equals(manageID)))
								);

						if(commonConditions) {
							relevantDepartments.put(dep.getDepartmentId(),dep);
						}

					}

					// Clear input fields
					idTxtField.setText("");
					manageField.setText("");

					// Display filtered Departments
					answer.setText("");
					answer.setText(relevantDepartments.toString());
					relevantDepartments.clear();
				}
			}});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(673, 258, 294, 76);
		add(submitBtn);

		JLabel lblOrJustWrite = new JLabel("Or Just Write The Department ID");
		lblOrJustWrite.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrJustWrite.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblOrJustWrite.setBounds(185, 191, 567, 55);
		add(lblOrJustWrite);

		manageField = new JTextField();
		manageField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		manageField.setColumns(10);
		manageField.setBounds(534, 160, 433, 35);
		add(manageField);

		JLabel lastNameBack = new JLabel("");
		lastNameBack.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack.setIcon(regularTxt);
		lastNameBack.setBounds(509, 149, 487, 55);
		add(lastNameBack);

		JLabel lastNameBack_1 = new JLabel("");
		lastNameBack_1.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameBack_1.setBounds(509, 104, 487, 55);
		lastNameBack_1.setIcon(regularTxt);
		add(lastNameBack_1);


		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);


















	}

	public static GetRealDep getInstance() {
		if (instance == null) {
			instance = new GetRealDep();
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
