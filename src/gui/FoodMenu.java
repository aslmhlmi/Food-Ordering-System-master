
package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class FoodMenu {
	static private JFrame frame;
	static private JButton backButton, orderButton;
	static private JTextField textField;
	static private JTextField textField_1;
	static private JTextField textField_2;
	static private JTextField textField_3; // promotion code
	static private JTextField textField_4;
	
	
	
	double promo;
	double totalAfterPromo;
		
	//Declare two decimal places
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	
	
	
	static private GridBagConstraints gbc;
	private JTable table;
	DefaultTableModel dtm; //table
	Double[] priceFoods;
	Double[] priceDonuts;
	double f1, f2, f3, f4, f5;
	double d1, d2, d3, d4;

	private JSpinner[] numSpinnerFoods;
	static private JLabel[] foodLabel;
	static private JLabel[] foodImage;
	private String[] file;

	private JSpinner[] numSpinnerDonuts;
	static private JLabel[] donutLabel;
	static private JLabel[] donutImage;
	private String[] fileDonuts;

	private static final int ELEMENTS = 5;
	private static final int DONUT_ELEMENTS = 4;

	double totalFoods = 0;
	double totalDonuts = 0;
	double total = 0;
	double totalSST = 0;
	double totalAfterDelivery = 0;
	double totalPrice = 0;
	double food1, food2, food3, food4, food5;
	double donut1, donut2, donut3, donut4;

	double totalForFoods;
	double totalForDonuts;

	void createAndShowGUI() throws IOException {
		frame = new JFrame("Main Menu ");
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		JLabel lblFoodMenu = new JLabel("Food Menu");
		lblFoodMenu.setBounds(15, 5, 81, 10);
		lblFoodMenu.setForeground(Color.BLUE); 
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(480, 5, 81, 10);
		lblFoodOrdered.setForeground(Color.BLUE);
		
		frame.getContentPane().add(lblFoodMenu);
		frame.getContentPane().add(lblFoodOrdered);

		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(475, 25, 1, 1); // int x, int y, int width, int height
		table.setSize(255, 300); // width,height
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
															// column
		table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
															// column
		table.setShowGrid(false); // remove cell boarder
		frame.getContentPane().add(table);
		
		JLabel lblTotal = new JLabel("Total :     RM");
		lblTotal.setBounds(490, 330, 100, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setBounds(650, 330, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblSST = new JLabel("Total After SST : RM");
		lblSST.setBounds(490, 360, 120, 14);
		frame.getContentPane().add(lblSST);
		textField_1 = new JTextField();
		textField_1.setBounds(650, 360, 86, 20);
		frame.getContentPane().add(textField_1);
		textField.setColumns(10);
		textField_1.setEditable(false);

		
		JLabel lblTotalDelivery = new JLabel("Total Include Delivery : RM");
		lblTotalDelivery.setBounds(490, 390, 155, 14);
		frame.getContentPane().add(lblTotalDelivery);
		textField_2 = new JTextField();
		textField_2.setBounds(650, 390, 86, 20);
		frame.getContentPane().add(textField_2);
		textField.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblPromeCode = new JLabel("Already have a code? Enter here! :");
		lblPromeCode.setBounds(490, 420, 100, 14);
		frame.getContentPane().add(lblPromeCode);
		textField_3 = new JTextField();
		textField_3.setBounds(650, 420, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);		
		

		ActionListener action = null;
		textField_3.addActionListener( action );

		
		
		
		
		JLabel lblTotalPrice = new JLabel("Total Price :   RM");
		lblTotalPrice.setBounds(490, 450, 100, 14);
		frame.getContentPane().add(lblTotalPrice);
		textField_4 = new JTextField();
		textField_4.setBounds(650, 450, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_3.setColumns(10);
		textField_4.setEditable(false);
		
		orderButton = new JButton("Order >>");
		orderButton.setBounds(630, 480, 89, 23);
		frame.getContentPane().add(orderButton);
		
		backButton = new JButton(" << Back");
		backButton.setBounds(500, 480, 89, 23);
		frame.getContentPane().add(backButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		addIt(tabbedPane, "KFC");
		addIt1(tabbedPane, "Donuts & Coffee");
		tabbedPane.setBounds(10, 20, 450, 480);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					MainMenu menu = new MainMenu();
					MainMenu.main(header);
					// menu.createAndShowGUI();
					menu.setVisible(true);
					// setVisible(false);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You not ordered anything yet");
				} else {
					try {
						OrderMenu order = new OrderMenu();
						OrderMenu.main(header);
						order.setVisible(true);
						setVisible(false);
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}

	void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		foodImage = new JLabel[ELEMENTS];
		foodLabel = new JLabel[ELEMENTS];
		numSpinnerFoods = new JSpinner[ELEMENTS];
		file = new String[ELEMENTS];
		priceFoods = new Double[ELEMENTS];

		file[0] = new String("/SetA.png");
		file[1] = new String("/SetB.png");
		file[2] = new String("/SetC.png");
		file[3] = new String("/Nugget.png");
		file[4] = new String("/CheeseWe.png");
		
		foodLabel[0] = new JLabel("Set A");
		foodLabel[1] = new JLabel("Set B");
		foodLabel[2] = new JLabel("Set C");
		foodLabel[3] = new JLabel("6 pieces chicken nuggets");
		foodLabel[4] = new JLabel("Cheezy wedges");
		
		priceFoods[0] = 12.50;
		priceFoods[1] = 15.50;
		priceFoods[2] = 12.50;
		priceFoods[3] = 10.50;
		priceFoods[4] = 4.50;

		for (int i = 0; i < ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(file[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
//			Image image = ImageIO.read(file[i]);
//			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerFoods[i] = new JSpinner(spnummodel);
			numSpinnerFoods[i].addChangeListener(listenerForKFC);
			foodImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		for (int i = 0; i < ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(foodImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(foodLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerFoods[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
	}

	void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		donutImage = new JLabel[DONUT_ELEMENTS];
		donutLabel = new JLabel[DONUT_ELEMENTS];
		numSpinnerDonuts = new JSpinner[DONUT_ELEMENTS];
		priceDonuts = new Double[DONUT_ELEMENTS];

		fileDonuts = new String[DONUT_ELEMENTS];
		fileDonuts[0] = new String("/1.jpeg");
		fileDonuts[1] = new String("/2.png");
		fileDonuts[2] = new String("/6.png");
		fileDonuts[3] = new String("/12.jpeg");

		donutLabel[0] = new JLabel("1 piece donut");
		donutLabel[1] = new JLabel("2 pieces donut");
		donutLabel[2] = new JLabel("6 pieces donut");
		donutLabel[3] = new JLabel("12 pieces donut");

		priceDonuts[0] = 2.80;
		priceDonuts[1] = 5.00;
		priceDonuts[2] = 14.00;
		priceDonuts[3] = 26.00;

		for (int i = 0; i < DONUT_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDonuts[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerDonuts[i] = new JSpinner(spnummodel);
			numSpinnerDonuts[i].addChangeListener(listenerForDonuts);
			donutImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < DONUT_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(donutImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(donutLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerDonuts[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);

		}
	}

	ChangeListener listenerForKFC = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Set A")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(f1 * quantity, row, 2);
						food1 = f1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Set B")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f2 * quantity, row, 2);
						food2 = f2 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Set C")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f3 * quantity, row, 2);
						food3 = f3 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("6 pieces chicken nuggets")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f4 * quantity, row, 2);
						food4 = f4 * quantity;
						
					} else if (dtm.getValueAt(row, 0).equals("Cheezy wedges")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(f5 * quantity, row, 2);
						food5 = f5 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5;
					total = totalForFoods + totalForDonuts;
					totalSST = (0.06 * total) + total;
					if(totalSST < 15.00) {
						totalAfterDelivery = totalSST + 6.00;
					} else
						totalAfterDelivery = totalSST;
			
					textField.setText(total + " ");
					textField_1.setText(totalSST + " ");
					textField_2.setText(totalAfterDelivery + " ");

					
					if(textField_3.getText().equals("STAYATHOME10")) 
					{
						promo = totalAfterDelivery * 0.1;
					} else
						promo = 0;
	
					totalAfterPromo = totalAfterDelivery - promo;
					textField_4.setText(totalAfterPromo + " ");
					
					textField.setText(String.valueOf(df.format (total)));
					textField_1.setText(String.valueOf(df.format (totalSST)));
					textField_2.setText(String.valueOf(df.format (totalAfterDelivery)));
					textField_4.setText(String.valueOf(df.format (totalAfterPromo)));
					
					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerFoods[i] == e.getSource()) {
					totalFoods = priceFoods[i];
					switch (foodLabel[i].getText()) {
					case "Set A":
						f1 = 12.50;
						food1 = f1;
						break;
					case "Set B":
						f2 = 15.50;
						food2 = f2;
						break;
					case "Set C":
						f3 = 12.50;
						food3 = f3;
						break;
					case "6 pieces chicken nuggets":
						f4 = 10.50;
						food4 = f4;
						break;
					case "Cheezy wedges":
						f5 = 4.50;
						food5 = f5;
						break;
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5;
					total = totalForFoods + totalForDonuts;
					totalSST = (0.06 * total) + total;
					if(totalSST < 15.00) {
						totalAfterDelivery = totalSST + 6.00; 
					} else
						totalAfterDelivery = totalSST;
					
					textField.setText(total + "");
					textField_1.setText(totalSST + "");
					textField_2.setText(totalAfterDelivery + "");
					

					if(textField_3.getText().equals("STAYATHOME10")) 
					{
						promo = totalAfterDelivery * 0.1;
					} else
						promo = 0;
					
					
					totalAfterPromo = totalAfterDelivery - promo;
					textField_4.setText(totalAfterPromo + " ");


					textField.setText(String.valueOf(df.format (total)));
					textField_1.setText(String.valueOf(df.format (totalSST)));
					textField_2.setText(String.valueOf(df.format (totalAfterDelivery)));
					textField_4.setText(String.valueOf(df.format (totalAfterPromo)));
					
					
					dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, totalFoods, numSpinnerFoods[i] });
					return;
				}

			}
		}
	};

	ChangeListener listenerForDonuts = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("1 piece donut")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d1 * quantity, row, 2);
						donut1 = d1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("2 pieces donut")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(d2 * quantity, row, 2);
						donut2 = d2 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("6 pieces donut")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d3 * quantity, row, 2);
						donut3 = d3 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("12 pieces donut")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d4 * quantity, row, 2);
						donut4 = d4 * quantity;

					} 
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForDonuts = donut1 + donut2 + donut3 + donut4;
					total = totalForFoods + totalForDonuts;
					totalSST = (0.06 * total) + total;
					if(totalSST < 15.00) {
						totalAfterDelivery = totalSST + 6.00;
					} else
						totalAfterDelivery = totalSST;
					
					textField.setText(total + " ");
					textField_1.setText(totalSST + " ");
					textField_2.setText(totalAfterDelivery + " ");

					if(textField_3.getText().equals("STAYATHOME10")) 
					{
						promo = totalAfterDelivery * 0.1;
					} else
						promo = 0;
					
					
					totalAfterPromo = totalAfterDelivery - promo;
					textField_4.setText(totalAfterPromo + " ");


					textField.setText(String.valueOf(df.format (total)));
					textField_1.setText(String.valueOf(df.format (totalSST)));
					textField_2.setText(String.valueOf(df.format (totalAfterDelivery)));
					textField_4.setText(String.valueOf(df.format (totalAfterPromo)));
					
					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < DONUT_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerDonuts[i] == e.getSource()) {
					totalDonuts = priceDonuts[i];
					switch (donutLabel[i].getText()) {
					case "1 piece donut":
						d1 = 2.80;
						donut1 = d1;
						break;
					case "2 pieces donut":
						d2 = 5.00;
						donut2 = d2;
						break;
					case "6 pieces donut":
						d3 = 14.00;
						donut3 = d3;
						break;
					case "12 pieces donut":
						d4 = 26.00;
						donut4 = d4;
						break;
					}
					totalForDonuts = donut1 + donut2 + donut3 + donut4;
					total = totalForFoods + totalForDonuts;
					totalSST = (0.06 * total) + total;
					if(totalSST < 15.00) {
						totalAfterDelivery = totalSST + 6.00;
					} else
						totalAfterDelivery = totalSST;
					
					textField.setText(total + " ");
					textField_1.setText(totalSST + " ");
					textField_2.setText(totalAfterDelivery + " ");
					
					if(textField_3.getText().equals("STAYATHOME10")) 
					{
						promo = totalAfterDelivery * 0.1;
					} else
						promo = 0;
					
					
					totalAfterPromo = totalAfterDelivery - promo;
					textField_4.setText(totalAfterPromo + " ");
					
					textField.setText(String.valueOf(df.format (total)));
					textField_1.setText(String.valueOf(df.format (totalSST)));
					textField_2.setText(String.valueOf(df.format (totalAfterDelivery)));
					textField_4.setText(String.valueOf(df.format (totalAfterPromo)));
					
					dtm.addRow(new Object[] { donutLabel[i].getText(), quantity, totalDonuts, numSpinnerDonuts[i] });
					return;
				}

			}
		}
	};

	public void setVisible(boolean b) throws IOException {
	}

	public static int getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}


}
