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
import javax.swing.SwingConstants;

import exceptions.MissingInputException;
import model.DepartmentManager;
import model.Hotel;
import model.Suite;
import model.*;

import javax.swing.JTextField;



public class RemoveRoomPanel extends JPanel {
	private static RemoveRoomPanel instance=null;
	private static Menu menu=Menu.getInstance();
	private static Hotel hotel=Hotel.getInstance();
	private Image backImg = new ImageIcon(LoginFrame.class.getResource("/view/back.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	private Image pressImg = new ImageIcon(LoginFrame.class.getResource("/view/clicked.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image regularImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
	private Image hoverTxtImg = new ImageIcon(LoginFrame.class.getResource("/view/hove.png")).getImage().getScaledInstance(1200, 250, Image.SCALE_SMOOTH);
	private Image reguTxtlarImg = new ImageIcon(LoginFrame.class.getResource("/view/reg.png")).getImage().getScaledInstance(1200, 250, Image.SCALE_SMOOTH);
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
	public RemoveRoomPanel() {
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

		JLabel lblRemoveRoomPanel = new JLabel("Remove Room");
		lblRemoveRoomPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveRoomPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		lblRemoveRoomPanel.setBounds(260, 6, 427, 64);
		headlinePane.add(lblRemoveRoomPanel);

		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.menuClick(PanelRemove.getInstance());
			}
		});

		lblback.setHorizontalAlignment(SwingConstants.CENTER);
		lblback.setBounds(0, 681, 102, 91);
		lblback.setIcon(back);
		add(lblback);



		JLabel fieldTxt = new JLabel("Room ID to Remove:");
		fieldTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		fieldTxt.setBounds(125, 265, 275, 55);
		add(fieldTxt);

		idTxtField = new JTextField();
		idTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		idTxtField.setBounds(397, 277, 423, 35);
		add(idTxtField);
		idTxtField.setColumns(10);


		JLabel TxtBack = new JLabel("");
		TxtBack.addMouseListener(new TxtMouseAdapter(TxtBack));
		TxtBack.setHorizontalAlignment(SwingConstants.CENTER);
		TxtBack.setIcon(regularTxt);
		TxtBack.setBounds(103, 265, 748, 55);
		add(TxtBack);

		JLabel lblSubmit = new JLabel("Submit");
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblSubmit.setBounds(394, 587, 163, 55);
		add(lblSubmit);

		JLabel submitBtn = new JLabel("");
		submitBtn.addMouseListener(new InternalMouseAdapter(submitBtn){
			@Override
			public void mouseReleased(MouseEvent e) {
				Boolean isRemv=false;
				String className=null;


				try {

					if(!idTxtField.getText().trim().isEmpty()) {
						if( hotel.getAllRooms().get(idTxtField.getText())!=null) {	

							if(hotel.getAllRooms().get(idTxtField.getText()) instanceof Suite) {
								className="Suite";
								isRemv=hotel.removeSuite( (Suite) hotel.getAllRooms().get(idTxtField.getText())) ;

							}
							else if(hotel.getAllRooms().get(idTxtField.getText()) instanceof SuperiorRoom) {
								className="SuperiorRoom";
								isRemv=hotel.removeSuperiorRoom( (SuperiorRoom) hotel.getAllRooms().get(idTxtField.getText())) ;	
							}
							else {
								className="StandardRoom";
								isRemv=hotel.removeStandardRoom( (StandardRoom) hotel.getAllRooms().get(idTxtField.getText())) ;
							}

							if(isRemv){
								JOptionPane.showMessageDialog(RemoveRoomPanel.this,className+ " Successfuly Removed !" ,className+" Successfuly Removed",JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(RemoveRoomPanel.this,className+" Faild To Be Removed !" ,className+" Faild To Be Removed",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(RemoveRoomPanel.this,"Room Does Not Exist ","Room Does Not Exist ",JOptionPane.ERROR_MESSAGE);
							return;
						}

					}
					else {
						throw new MissingInputException("Room Number Field");
					}

				}
				catch(MissingInputException em){
					JOptionPane.showMessageDialog(RemoveRoomPanel.this,em.getMessage(),"Invalid input",JOptionPane.ERROR_MESSAGE);
					return;
				}
				idTxtField.setText("");

			}
		}

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
	public static RemoveRoomPanel getInstance() {
		if (instance == null) {
			instance = new RemoveRoomPanel();
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