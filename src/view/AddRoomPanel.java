//Author: Arbel Askayo 208642868
package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.MaxPopulationCapacityException;
import exceptions.MissingInputException;
import exceptions.NegativeInputException;
import utils.Area;
import utils.Gender;
import utils.RoomTypes;
import utils.YN;
import model.*;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomPanel extends JPanel {
	private static AddRoomPanel instance=null;
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
	private JTextField priceField;
	private JTextField costField;
	private JTextField floorField;
	private JTextField gradeField;
	private JTextField capacityField;
	private JTextField balconyField;
	private JTextField sizeField;
	/**
	 * Create the panel.
	 */
	private AddRoomPanel() {
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

		JLabel lblAddRoomPanel = new JLabel("Add Room");
		lblAddRoomPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddRoomPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblAddRoomPanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblAddRoomPanel);

		JLabel typerBack = new JLabel("");
		typerBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelAdd.getInstance());
			}
		});

		typerBack.setHorizontalAlignment(SwingConstants.CENTER);
		typerBack.setBounds(0, 681, 102, 91);
		typerBack.setIcon(back);
		add(typerBack);

		JLabel txtType = new JLabel("Room Type:");
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtType.setBounds(16, 144, 179, 55);
		add(txtType);

		JLabel lblPrice = new JLabel("Daily Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPrice.setBounds(527, 227, 150, 55);
		add(lblPrice);

		priceField = new JTextField();
		priceField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		priceField.setColumns(10);
		priceField.setBounds(689, 238, 290, 35);
		add(priceField);

		costField = new JTextField();
		costField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		costField.setColumns(10);
		costField.setBounds(689, 155, 290, 35);
		add(costField);

		JLabel lblCost = new JLabel("Daily Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCost.setBounds(527, 144, 150, 55);
		add(lblCost);

		JLabel lblFloor = new JLabel("Floor:");
		lblFloor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloor.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFloor.setBounds(16, 227, 102, 55);
		add(lblFloor);

		JLabel lblJaccozi = new JLabel("Jaccozi ? :");
		lblJaccozi.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaccozi.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblJaccozi.setBounds(16, 485, 150, 55);
		lblJaccozi.setVisible(false);
		add(lblJaccozi);



		floorField = new JTextField();
		floorField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		floorField.setColumns(10);
		floorField.setBounds(200, 238, 268, 35);
		add(floorField);

		JLabel lblView = new JLabel("View :");
		lblView.setHorizontalAlignment(SwingConstants.CENTER);
		lblView.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblView.setBounds(527, 392, 102, 55);
		add(lblView);

		JComboBox <YN> viewBox = new JComboBox<>(YN.values());
		viewBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		viewBox.setBounds(640, 393, 334, 55);
		add(viewBox);

		JLabel viewBack = new JLabel("");
		viewBack.setHorizontalAlignment(SwingConstants.CENTER);
		viewBack.setIcon(regularTxt);
		viewBack.setBounds(515, 393, 481, 55);
		add(viewBack);

		JLabel lblGrade = new JLabel("Room Grade:");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGrade.setBounds(16, 307, 179, 55);
		add(lblGrade);

		gradeField = new JTextField();
		gradeField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		gradeField.setColumns(10);
		gradeField.setBounds(200, 318, 268, 35);
		add(gradeField);

		JLabel lblCapacity = new JLabel("Max Population Capacity:");
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacity.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCapacity.setBounds(527, 307, 362, 55);
		add(lblCapacity);

		capacityField = new JTextField();
		capacityField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		capacityField.setColumns(10);
		capacityField.setBounds(892, 315, 87, 35);
		add(capacityField);

		JLabel lblSize = new JLabel("Size :");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSize.setBounds(16, 392, 102, 55);
		add(lblSize);



		JComboBox <YN>jaccoziBox = new JComboBox<>(YN.values());
		jaccoziBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		jaccoziBox.setBounds(193, 486, 261, 55);
		jaccoziBox.setVisible(false);
		add(jaccoziBox);

		JLabel lblBalcony = new JLabel("Balcony Size: ");
		lblBalcony.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalcony.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblBalcony.setBounds(527, 486, 194, 55);
		lblBalcony.setVisible(false);
		add(lblBalcony);

		balconyField = new JTextField();
		balconyField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		balconyField.setColumns(10);
		balconyField.setBounds(717, 496, 262, 35);
		balconyField.setVisible(false);
		add(balconyField);

		sizeField = new JTextField();
		sizeField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		sizeField.setColumns(10);
		sizeField.setBounds(200, 403, 268, 35);
		add(sizeField);



		JLabel priceBack = new JLabel("");
		priceBack.setHorizontalAlignment(SwingConstants.CENTER);
		priceBack.setIcon(regularTxt);
		priceBack.setBounds(515, 227, 481, 55);
		add(priceBack);

		JLabel costBack = new JLabel("");
		costBack.setHorizontalAlignment(SwingConstants.CENTER);
		costBack.setIcon(regularTxt);
		costBack.setBounds(515, 144, 481, 55);
		add(costBack);

		JLabel floorBack = new JLabel("");
		floorBack.setHorizontalAlignment(SwingConstants.CENTER);
		floorBack.setIcon(regularTxt);
		floorBack.setBounds(0, 227, 481, 55);
		add(floorBack);

		JLabel gradeBack = new JLabel("");
		gradeBack.setHorizontalAlignment(SwingConstants.CENTER);
		gradeBack.setIcon(regularTxt);
		gradeBack.setBounds(0, 307, 481, 55);
		add(gradeBack);

		JLabel capacityBack = new JLabel("");
		capacityBack.setHorizontalAlignment(SwingConstants.CENTER);
		capacityBack.setIcon(regularTxt);
		capacityBack.setBounds(515, 307, 481, 55);
		add(capacityBack);

		JLabel sizeBack = new JLabel("");
		sizeBack.setHorizontalAlignment(SwingConstants.CENTER);
		sizeBack.setIcon(regularTxt);
		sizeBack.setBounds(0, 393, 481, 55);
		add(sizeBack);

		JLabel jaccoziBack = new JLabel("");
		jaccoziBack.setHorizontalAlignment(SwingConstants.CENTER);
		jaccoziBack.setIcon(regularTxt);
		jaccoziBack.setBounds(0, 486, 481, 55);
		jaccoziBack.setVisible(false);
		add(jaccoziBack);

		JLabel balconyBack = new JLabel("");
		balconyBack.setHorizontalAlignment(SwingConstants.CENTER);
		balconyBack.setIcon(regularTxt);
		balconyBack.setBounds(515, 486, 481, 55);
		balconyBack.setVisible(false);
		add(balconyBack);

		JComboBox<RoomTypes> typeBox = new JComboBox<>(RoomTypes.values());
		typeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomTypes selectedRoomType = (RoomTypes) typeBox.getSelectedItem();
				if (selectedRoomType == RoomTypes.SuperiorRoom) {
					lblJaccozi.setVisible(true);
					jaccoziBack.setVisible(true);
					jaccoziBox.setVisible(true);
					balconyBack.setVisible(false);
					balconyField.setVisible(false);
					lblBalcony.setVisible(false);
				} else if (selectedRoomType == RoomTypes.Suite) {
					lblJaccozi.setVisible(true);
					jaccoziBack.setVisible(true);
					balconyBack.setVisible(true);
					balconyField.setVisible(true);
					lblBalcony.setVisible(true);
					jaccoziBox.setVisible(true);
				} else if (selectedRoomType == RoomTypes.StandardRoom) {
					lblJaccozi.setVisible(false);
					jaccoziBack.setVisible(false);
					balconyBack.setVisible(false);
					balconyField.setVisible(false);
					lblBalcony.setVisible(false);
					jaccoziBox.setVisible(false);
				}
			}
		});

		typeBox.setBounds(207, 144, 261, 52);
		add(typeBox);

		JLabel typeBack = new JLabel("");
		typeBack.addMouseListener(new TxtMouseAdapter(typeBack));
		typeBack.setHorizontalAlignment(SwingConstants.CENTER);
		typeBack.setIcon(regularTxt);
		typeBack.setBounds(0, 144, 481, 55);
		add(typeBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(393, 586, 167, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseReleased(MouseEvent e) {
				Double price=0.0;
				Double cost=0.0;
				Integer floor=0;
				Integer capacity=0;
				Integer size=0;
				Double balcony=0.0;
				Double grade=0.0;
				Boolean view=false;
				Boolean Jaccozi=false;
				Boolean isAdded=false;

				try {
					if(typeBox.getSelectedItem().equals(RoomTypes.Pick_One)) {
						throw new MissingInputException("Room Types Box");
					}
					if(viewBox.getSelectedItem().equals(YN.Pick_One)) {
						throw new MissingInputException("View Box");
					}
				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(AddRoomPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(jaccoziBox.getSelectedItem().equals("Yes")) {
					Jaccozi=true;
				}

				if(viewBox.getSelectedItem().equals("Yes")) {
					view=true;
				}

				try {
					if (floorField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the floor field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					floor = Integer.parseInt(floorField.getText());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter only integers at the floor field", "Invalid input", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (capacityField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the capacity field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					capacity= Integer.parseInt(capacityField.getText());

				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only integers at capacity Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (sizeField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the size field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					size=Integer.parseInt(sizeField.getText());
					if(size<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}

				}
				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,n.getMessage()+"size field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only integers at size Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (gradeField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the grade field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					grade=Double.parseDouble(gradeField.getText());

				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only double at grade Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (priceField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the price field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}
					price= Double.parseDouble(priceField.getText());
					if(price<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}

				}
				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,n.getMessage()+"price field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only double at price Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if (costField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the cost field", "Invalid input", JOptionPane.ERROR_MESSAGE);
						return;}
					cost= Double.parseDouble(costField.getText());
					if(cost<=0) {
						throw new NegativeInputException("Please enter only positive numbers at ");
					}

				}
				catch(NegativeInputException n) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,n.getMessage()+"cost field","Negative number ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only double at cost Field","Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {	 
					if(typeBox.getSelectedItem().equals(RoomTypes.SuperiorRoom)){
						try {
							if(jaccoziBox.getSelectedItem().equals(YN.Pick_One)) {
								throw new MissingInputException(" Jaccozi Box ");
							}
						}
						catch(MissingInputException em){
							JOptionPane.showMessageDialog(AddRoomPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
							return;
						}
						SuperiorRoom r =new SuperiorRoom(price, floor, cost, grade, capacity,
								size,view ,Jaccozi);
						isAdded=hotel.addSuperiorRoom(r);

					}
					else if(typeBox.getSelectedItem().equals(RoomTypes.Suite)) {
						try{
							if (balconyField.getText().trim().isEmpty()) {
								JOptionPane.showMessageDialog(AddRoomPanel.this, "Please enter something in the balcony field", "Invalid input", JOptionPane.ERROR_MESSAGE);
								return;}
							balcony=Double.parseDouble(balconyField.getText());
							if(balcony<=0.0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}

						}
						catch(NegativeInputException n) {
							JOptionPane.showMessageDialog(AddRoomPanel.this,n.getMessage()+"balcony field","Negative number ",JOptionPane.ERROR_MESSAGE);
							return;
						}
						catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(AddRoomPanel.this,"Please enter only double at balcony Field","Invalid input",JOptionPane.ERROR_MESSAGE);
							return;
						}
						Suite r =new Suite(price, floor, cost, grade, capacity,
								size,view ,Jaccozi,balcony);
						isAdded=hotel.addSuite(r);
					}
					else {
						StandardRoom r =new StandardRoom(price, floor, cost, grade, capacity,
								size,view);
						isAdded=hotel.addStandardRoom(r);
					}
				}
				catch ( MaxPopulationCapacityException e2) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,e2,"Capacity Error",JOptionPane.ERROR_MESSAGE);
					return;
				}

				floorField.setText("");
				capacityField.setText("");
				priceField.setText("");
				costField.setText("");
				gradeField.setText("");
				balconyField.setText("");
				sizeField.setText("");

				if(isAdded) {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Room Successfuly Added !","Room Successfuly Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(AddRoomPanel.this,"Room Faild To Be Added !","Room Faild To Be Added ",JOptionPane.INFORMATION_MESSAGE);	
				}


			}
		});
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
	public static AddRoomPanel getInstance() {
		if (instance == null) {
			instance = new AddRoomPanel();
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
