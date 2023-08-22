//Author: Arbel Askayo 208642868
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.HashMap;

import exceptions.MaxPopulationCapacityException;
import exceptions.NegativeInputException;

import model.Hotel;
import model.StandardRoom;
import model.Suite;
import model.SuperiorRoom;
import utils.RoomTypes;
import utils.YN;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class GetRealRoom extends JPanel {

	private static GetRealRoom instance=null;
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
	private JTextField idField;
	/**
	 * Create the panel.
	 */
	private GetRealRoom() {
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

		JLabel lblGetRealRoomPanel = new JLabel("Filter Rooms by all or some of the fields bellow");
		lblGetRealRoomPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetRealRoomPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblGetRealRoomPanel.setBounds(6, 6, 984, 64);
		headlinePane.add(lblGetRealRoomPanel);

		JLabel typerBack = new JLabel("");
		typerBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelGR.getInstance());
			}
		});

		typerBack.setHorizontalAlignment(SwingConstants.CENTER);
		typerBack.setBounds(0, 681, 102, 91);
		typerBack.setIcon(back);
		add(typerBack);

		JLabel txtType = new JLabel("Room Type:");
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		txtType.setBounds(10, 88, 179, 55);
		add(txtType);

		JLabel lblPrice = new JLabel("Daily Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblPrice.setBounds(515, 144, 150, 55);
		add(lblPrice);

		priceField = new JTextField();
		priceField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		priceField.setColumns(10);
		priceField.setBounds(689, 155, 290, 35);
		add(priceField);


		JLabel lblRoomId = new JLabel("Room ID:");
		lblRoomId.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomId.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblRoomId.setBounds(361, 381, 142, 55);
		add(lblRoomId);

		idField = new JTextField();
		idField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idField.setColumns(10);
		idField.setBounds(515, 392, 268, 35);
		add(idField);


		costField = new JTextField();
		costField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		costField.setColumns(10);
		costField.setBounds(689, 99, 290, 35);
		add(costField);

		JLabel lblCost = new JLabel("Daily Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCost.setBounds(515, 88, 150, 55);
		add(lblCost);

		JLabel lblFloor = new JLabel("Floor:");
		lblFloor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFloor.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblFloor.setBounds(20, 144, 102, 55);
		add(lblFloor);

		JLabel lblJaccozi = new JLabel("Jaccozi ? :");
		lblJaccozi.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaccozi.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblJaccozi.setBounds(10, 314, 150, 55);
		lblJaccozi.setVisible(false);
		add(lblJaccozi);



		floorField = new JTextField();
		floorField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		floorField.setColumns(10);
		floorField.setBounds(200, 155, 268, 35);
		add(floorField);

		JLabel lblView = new JLabel("View :");
		lblView.setHorizontalAlignment(SwingConstants.CENTER);
		lblView.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblView.setBounds(515, 258, 102, 55);
		add(lblView);

		JComboBox <YN> viewBox = new JComboBox<>(YN.values());
		viewBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		viewBox.setBounds(645, 259, 334, 55);
		add(viewBox);

		JLabel viewBack = new JLabel("");
		viewBack.setHorizontalAlignment(SwingConstants.CENTER);
		viewBack.setIcon(regularTxt);
		viewBack.setBounds(515, 258, 481, 55);
		add(viewBack);

		JLabel lblGrade = new JLabel("Room Grade:");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblGrade.setBounds(10, 199, 179, 55);
		add(lblGrade);

		gradeField = new JTextField();
		gradeField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		gradeField.setColumns(10);
		gradeField.setBounds(200, 210, 268, 35);
		add(gradeField);

		JLabel lblCapacity = new JLabel("Max Population Capacity:");
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacity.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblCapacity.setBounds(525, 202, 362, 55);
		add(lblCapacity);

		capacityField = new JTextField();
		capacityField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		capacityField.setColumns(10);
		capacityField.setBounds(892, 210, 87, 35);
		add(capacityField);

		JLabel lblSize = new JLabel("Size :");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSize.setBounds(0, 258, 102, 55);
		add(lblSize);



		JComboBox <YN>jaccoziBox = new JComboBox<>(YN.values());
		jaccoziBox.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		jaccoziBox.setBounds(207, 315, 261, 55);
		jaccoziBox.setVisible(false);
		add(jaccoziBox);

		JLabel lblBalcony = new JLabel("Balcony Size: ");
		lblBalcony.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalcony.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblBalcony.setBounds(515, 314, 194, 55);
		lblBalcony.setVisible(false);
		add(lblBalcony);

		balconyField = new JTextField();
		balconyField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		balconyField.setColumns(10);
		balconyField.setBounds(721, 325, 262, 35);
		balconyField.setVisible(false);
		add(balconyField);

		sizeField = new JTextField();
		sizeField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		sizeField.setColumns(10);
		sizeField.setBounds(200, 269, 268, 35);
		add(sizeField);



		JLabel priceBack = new JLabel("");
		priceBack.setHorizontalAlignment(SwingConstants.CENTER);
		priceBack.setIcon(regularTxt);
		priceBack.setBounds(515, 144, 481, 55);
		add(priceBack);

		JLabel costBack = new JLabel("");
		costBack.setHorizontalAlignment(SwingConstants.CENTER);
		costBack.setIcon(regularTxt);
		costBack.setBounds(515, 88, 481, 55);
		add(costBack);

		JLabel floorBack = new JLabel("");
		floorBack.setHorizontalAlignment(SwingConstants.CENTER);
		floorBack.setIcon(regularTxt);
		floorBack.setBounds(0, 144, 481, 55);
		add(floorBack);

		JLabel gradeBack = new JLabel("");
		gradeBack.setHorizontalAlignment(SwingConstants.CENTER);
		gradeBack.setIcon(regularTxt);
		gradeBack.setBounds(0, 202, 481, 55);
		add(gradeBack);

		JLabel capacityBack = new JLabel("");
		capacityBack.setHorizontalAlignment(SwingConstants.CENTER);
		capacityBack.setIcon(regularTxt);
		capacityBack.setBounds(515, 202, 481, 55);
		add(capacityBack);

		JLabel sizeBack = new JLabel("");
		sizeBack.setHorizontalAlignment(SwingConstants.CENTER);
		sizeBack.setIcon(regularTxt);
		sizeBack.setBounds(0, 258, 481, 55);
		add(sizeBack);

		JLabel jaccoziBack = new JLabel("");
		jaccoziBack.setHorizontalAlignment(SwingConstants.CENTER);
		jaccoziBack.setIcon(regularTxt);
		jaccoziBack.setBounds(0, 314, 481, 55);
		jaccoziBack.setVisible(false);
		add(jaccoziBack);

		JLabel balconyBack = new JLabel("");
		balconyBack.setHorizontalAlignment(SwingConstants.CENTER);
		balconyBack.setIcon(regularTxt);
		balconyBack.setBounds(515, 314, 481, 55);
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

		typeBox.setBounds(201, 88, 261, 52);
		add(typeBox);

		JLabel typeBack = new JLabel("");
		typeBack.addMouseListener(new TxtMouseAdapter(typeBack));
		typeBack.setHorizontalAlignment(SwingConstants.CENTER);
		typeBack.setIcon(regularTxt);
		typeBack.setBounds(0, 88, 481, 55);
		add(typeBack);

		JLabel idBack = new JLabel("");
		idBack.setHorizontalAlignment(SwingConstants.CENTER);
		idBack.setBounds(319, 381, 481, 55);
		idBack.setIcon(regularTxt);
		add(idBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setBounds(812, 381, 167, 55);
		add(lblSubmit);

		JTextArea answer = new JTextArea();
		answer.setEditable(false);
		answer.setFont(new Font("Krungthep", Font.BOLD, 30));
		answer.setForeground(new Color(56, 56, 56));
		answer.setLineWrap(true); // Set line wrap to true
		answer.setWrapStyleWord(true); // Wrap only at word boundaries

		JScrollPane textPane = new JScrollPane(answer);
		textPane.setBounds(99, 448, 847, 282);
		// Set vertical and horizontal scroll policies
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(textPane);


		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn) {
			@Override
			public void mouseReleased(MouseEvent e) {

				Double price = 0.0;
				Double cost = 0.0;
				Integer floor = -100;
				Integer capacity = 0;
				Integer size = 0;
				Double balcony = 0.0;
				Double grade = 0.0;
				Boolean view = null;
				Boolean Jaccozi = null;

				// Create a HashMap to store relevant rooms
				HashMap<String, Room> relevantRooms = new HashMap<>();

				if(!idField.getText().trim().isEmpty()) {
					answer.setText("");
					answer.setText(hotel.getAllRooms().get(idField.getText()).toString());	

				}
				else {
					// Handle "Pick_One" option for Room Type
					RoomTypes selectedRoomType = (RoomTypes) typeBox.getSelectedItem();
					if (selectedRoomType == RoomTypes.Pick_One) {
						selectedRoomType = null;
					}

					// Handle "Pick_One" option for View
					YN selectedView = (YN) viewBox.getSelectedItem();
					if (selectedView == YN.Pick_One) {
						view = null;
					} else {
						view = selectedView == YN.Yes;
					}

					// Handle "Pick_One" option for Jacuzzi
					YN selectedJaccozi = (YN) jaccoziBox.getSelectedItem();
					if (selectedJaccozi == YN.Pick_One) {
						Jaccozi = null;
					} else {
						Jaccozi = selectedJaccozi == YN.Yes;
					}

					// Parse and handle other fields
					try {
						if (!floorField.getText().trim().isEmpty()) {
							floor = Integer.parseInt(floorField.getText());
						}
					}  catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only integers at floor Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!capacityField.getText().trim().isEmpty()) { 
							capacity= Integer.parseInt(capacityField.getText());
							if(capacity<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}
					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(GetRealRoom.this,n.getMessage()+"capacity field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}

					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only integers at capacity Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {

						if (!sizeField.getText().trim().isEmpty()) { 
							size=Integer.parseInt(sizeField.getText());
							if(size<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}



					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(GetRealRoom.this,n.getMessage()+"size field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only integers at size Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {

						if (!gradeField.getText().trim().isEmpty()) { 
							grade=Double.parseDouble(gradeField.getText());
						}


					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only double at grade Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!priceField.getText().trim().isEmpty()) { 
							price= Double.parseDouble(priceField.getText());
							if(price<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}


					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(GetRealRoom.this,n.getMessage()+"price field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only double at price Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!costField.getText().trim().isEmpty()) { 
							cost= Double.parseDouble(costField.getText());
							if(cost<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}

					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(GetRealRoom.this,n.getMessage()+"cost field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only double at cost Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						if (!balconyField.getText().trim().isEmpty()) { 
							balcony= Double.parseDouble(costField.getText());
							if(balcony<=0) {
								throw new NegativeInputException("Please enter only positive numbers at ");
							}
						}

					}
					catch(NegativeInputException n) {
						JOptionPane.showMessageDialog(GetRealRoom.this,n.getMessage()+"balcony field","Negative number ",JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(GetRealRoom.this,"Please enter only double at balcony Field","Invalid input",JOptionPane.ERROR_MESSAGE);
						return;
					}


					// Filtering the rooms based on user input
					for (Room room : hotel.getAllRooms().values()) {
						if (room instanceof Suite) {
							Suite suite = (Suite) room;
							if ((floor == -100 || floor == suite.getFloor())
									&& (selectedRoomType == null || selectedRoomType == RoomTypes.Suite)
									&& (capacity == 0 || capacity == suite.getMaxPopulationCapacity())
									&& (size == 0 || size == suite.getSize())
									&& (grade == 0.0 || Double.compare(grade, suite.getRoomGrade()) == 0)
									&& (Double.compare(price, 0.0) == 0 || Double.compare(price, suite.getDailyPrice()) == 0)
									&& (Double.compare(cost, 0.0) == 0 || Double.compare(cost, suite.getAvgDailyCost()) == 0)
									&& (view == null || view == suite.isHasView())
									&& (Double.compare(balcony, 0.0) == 0 || Double.compare(balcony, suite.getBalconySize()) == 0)
									&& (Jaccozi == null || Jaccozi == suite.isHasJaccozi())) {
								relevantRooms.put(suite.getRoomNumber(), suite);
							}
						}

						else if (room instanceof SuperiorRoom) {
							SuperiorRoom superiorRoom = (SuperiorRoom) room;
							if ((floor == -100 || floor == superiorRoom.getFloor())
									&& (selectedRoomType == null || selectedRoomType == RoomTypes.SuperiorRoom)
									&& (capacity == 0 || capacity == superiorRoom.getMaxPopulationCapacity())
									&& (size == 0 || size == superiorRoom.getSize())
									&& (grade == 0.0 || Double.compare(grade, superiorRoom.getRoomGrade()) == 0)
									&& (Double.compare(price, 0.0) == 0 || Double.compare(price, superiorRoom.getDailyPrice()) == 0)
									&& (Double.compare(cost, 0.0) == 0 || Double.compare(cost, superiorRoom.getAvgDailyCost()) == 0)
									&& (view == null || view == superiorRoom.isHasView())
									&& (Jaccozi == null || Jaccozi == superiorRoom.isHasJaccozi())) {
								relevantRooms.put(superiorRoom.getRoomNumber(), superiorRoom);
							}

						} 
						else if (room instanceof StandardRoom) {
							StandardRoom standardRoom = (StandardRoom) room;
							if ((floor == -100 || floor == standardRoom.getFloor())
									&& (selectedRoomType == null || selectedRoomType == RoomTypes.StandardRoom)
									&& (capacity == 0 || capacity == standardRoom.getMaxPopulationCapacity())
									&& (size == 0 || size == standardRoom.getSize())
									&& (grade == 0.0 || Double.compare(grade, standardRoom.getRoomGrade()) == 0)
									&& (Double.compare(price, 0.0) == 0 || Double.compare(price, standardRoom.getDailyPrice()) == 0)
									&& (Double.compare(cost, 0.0) == 0 || Double.compare(cost, standardRoom.getAvgDailyCost()) == 0)
									&& (view == null || view == standardRoom.isHasView())) {
								relevantRooms.put(standardRoom.getRoomNumber(), standardRoom);
							}
						} 
					}

					answer.setText("");
					answer.setText(relevantRooms.toString());
					relevantRooms.clear();
				}}
		});
		submitBtn.setIcon(regular);
		submitBtn.setBounds(742, 371, 294, 76);
		add(submitBtn);

		JLabel lblNewLabel = new JLabel("Or just by ID:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(20, 378, 268, 58);
		add(lblNewLabel);



		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 996, 772);
		lblbackground.setBackground(new Color(78, 153, 114));
		lblbackground.setIcon(new ImageIcon(PanelAdd.class.getResource("/view/backGroundVid(1).gif")));
		lblbackground.setFont(new Font("Lucida Grande", Font.PLAIN, 39));
		add(lblbackground);















	}
	public static GetRealRoom getInstance() {
		if (instance == null) {
			instance = new GetRealRoom();
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