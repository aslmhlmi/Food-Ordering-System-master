package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class OrderMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					OrderMenu window = new OrderMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public OrderMenu() throws IOException {
		createAndShowGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	void createAndShowGUI() throws IOException {
		frame = new JFrame("Order Form");
		frame.setBounds(100, 100, 593, 391); // x,y,width,height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblFillInDetails = new JLabel("Details Of Customer");
		lblFillInDetails.setBounds(49, 13, 170, 23);
		lblFillInDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFillInDetails.setForeground(Color.BLUE);
		frame.getContentPane().add(lblFillInDetails);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(49, 38, 59, 40);
		frame.getContentPane().add(lblName);
		textField = new JTextField();
		textField.setBounds(165, 47, 211, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NIRC : ");
		lblNewLabel_1.setBounds(49, 80, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		textField_1 = new JTextField();
		textField_1.setBounds(165, 76, 211, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number :");
		lblNewLabel_2.setBounds(49, 110, 102, 14);
		frame.getContentPane().add(lblNewLabel_2);
		textField_2 = new JTextField();
		textField_2.setBounds(165, 106, 211, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address : ");
		lblNewLabel_3.setBounds(49, 145, 102, 14);
		frame.getContentPane().add(lblNewLabel_3);
		textField_3 = new JTextField();
		textField_3.setBounds(165, 140, 211, 55);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Delivery Place : ");
		lblNewLabel_4.setBounds(48, 206, 103, 14);
		frame.getContentPane().add(lblNewLabel_4);
		textField_4 = new JTextField();
		textField_4.setBounds(165, 203, 102, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Delivery Time : ");
		lblNewLabel_5.setBounds(49, 231, 102, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		String[] timeStrings = { "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM", "12:00 PM"};
		JComboBox comboBox = new JComboBox(timeStrings);
		comboBox.setBounds(165, 228, 102, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("*Delivery after 10 PM - ADD RM 5*");
		lblNewLabel_6.setBounds(49, 260, 200, 14);
		lblNewLabel_6.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnCancel = new JButton("<< Cancel");
		btnCancel.setBounds(49, 290, 90, 23);
		frame.getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FoodMenu food = new FoodMenu();
				try {
					food.createAndShowGUI();
					food.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frame.dispose();
			}
		});
		JButton btnConfirm = new JButton("Confirm >>");
		btnConfirm.setBounds(247, 290, 112, 23);
		frame.getContentPane().add(btnConfirm);
		
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field cannot be empty");
				} else {
					JOptionPane.showMessageDialog(null, "Your Order Will be Delivered Soon, Thank You For Ordering!");
					MainMenu main = new MainMenu();
					try {
						MainMenu.main(null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					main.setVisible(true);
					// setVisible(false);
					frame.dispose();
				}
			}
		});

		
	
		Image image = ImageIO.read(new File("C:\\Users\\user\\eclipse-workspace\\Food-Ordering-System-master\\image\\order.png"));
		Image imageScaled = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(401, 51, 163, 241);
		frame.getContentPane().add(lblNewLabel);
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
