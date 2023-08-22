
//Author: Arbel Askayo 208642868
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.*;
import exceptions.*;
import utils.Area;
import utils.Gender;
import utils.Specialization;
import utils.YN;

public class AddDepPanel extends JPanel {
	private static AddDepPanel instance=null;
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
	/**
	 * Create the panel.
	 */
	private AddDepPanel() {
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

		JLabel lblAddDepPanel = new JLabel("Add Department");
		lblAddDepPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDepPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddDepPanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblAddDepPanel);

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

		JLabel txtId = new JLabel("Department ID:");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtId.setBounds(246, 225, 211, 55);
		add(txtId);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(467, 236, 240, 35);
		add(idTxtField);
		idTxtField.setColumns(10);

		JComboBox<Specialization> specializationBox = new JComboBox<>(Specialization.values());
		specializationBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		specializationBox.setBounds(449, 393, 258, 55);
		add(specializationBox);

		JLabel lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecialization.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSpecialization.setBounds(246, 392, 191, 55);
		add(lblSpecialization);

		JLabel idBack = new JLabel("");
		idBack.addMouseListener(new TxtMouseAdapter(idBack));
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setIcon(regularTxt);
		idBack.setBounds(238, 225, 481, 55);
		add(idBack);

		JLabel specializationBack = new JLabel("");
		specializationBack.setHorizontalAlignment(SwingConstants.CENTER);
		specializationBack.setIcon(regularTxt);
		specializationBack.setBounds(238, 392, 481, 55);
		add(specializationBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(393, 586, 167, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn){
			@Override
			public void mouseReleased(MouseEvent e){


				String departmentId;
				Specialization specialization;
				Boolean isAdded=false;
				try {
					if(specializationBox.getSelectedItem().equals(Specialization.Pick_One)) {
						throw new MissingInputException("Specialization Box");
					}

				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(null,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				specialization = (Specialization) specializationBox.getSelectedItem();
				try {
					if(idTxtField.getText().trim().isEmpty()) {
						throw new MissingInputException("ID Field ");

					}

					departmentId=idTxtField.getText();

					if(hotel.getAllDepartments().containsKey(departmentId)) {
						throw new DepAlreadyExistException();
					}
				}
				catch(DepAlreadyExistException ex) {
					JOptionPane.showMessageDialog(AddDepPanel.this,ex.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(MissingInputException ex) {
					JOptionPane.showMessageDialog(AddDepPanel.this,ex.getMessage(),"Invalid Input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				Department d = new Department( departmentId,  specialization);
				try {
					isAdded=hotel.addDepartment(d);
				} catch (DepAlreadyExistException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(AddDepPanel.this,e1.getMessage(),"Already Exist",JOptionPane.ERROR_MESSAGE);
					return;
				}


				idTxtField.setText("");

				if(isAdded) {
					JOptionPane.showMessageDialog(AddDepPanel.this,"Department Successfuly Added !","Department Successfuly Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(AddDepPanel.this,"Department Faild To Be Added !","Department Faild To Be Added ",JOptionPane.INFORMATION_MESSAGE);	
				}

				AddEmployeePanel addEmployeePanel = AddEmployeePanel.getInstance();
				addEmployeePanel.revalidate();
				addEmployeePanel.repaint();

			}}
				);
		submitBtn.setIcon(regular);
		submitBtn.setBounds(327, 576, 294, 76);
		add(submitBtn);

		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);
	}

	public static AddDepPanel getInstance() {
		if (instance == null) {
			instance = new AddDepPanel();
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
