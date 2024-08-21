import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventoryview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventoryview frame = new inventoryview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//allows the user to navigate to the page
	public static void showWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventoryview frame = new inventoryview();
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
	public inventoryview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INVENTORY SEARCH SECTION

		//label that holds the title of the page
		JLabel lblNewLabel = new JLabel("Inventory Levels");
		lblNewLabel.setBounds(10, 11, 236, 39);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		//This panel holds the "Search item_id: " label below
		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 143, 33);
		contentPane.add(panel);
		
		//label used to show where to type in and search for an item_id
		JLabel lblNewLabel_1 = new JLabel("Search item_id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		//panel holds the textbox that searches for item_id's
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 61, 115, 33);
		contentPane.add(panel_1);
		
		//textField used to take input for the search box
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		//this panel holds the textArea that displays the item that you search for
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 105, 685, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//this textArea displays the item that you search for
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 665, 22);
		panel_2.add(textArea);

		//button used to actually search
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Building the connection
				Connection conn = null;
				//TODO STEP 1
				try {
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
					"csce315909_7user", "Sqldb_7");
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}
				try {
					String item_id = textField.getText();
					Statement stmt = conn.createStatement();
					String sqlStatement = "SELECT * FROM inventory WHERE item_id='"+item_id+"';";
					ResultSet result = stmt.executeQuery(sqlStatement);
					String output = "";
					while (result.next()) {
						output = "item_id: " + item_id + ", " + "price: " + result.getString("price") + ", " +
								"name: " + result.getString("name") + ", " + "quantity: " + result.getString("quantity");
					}
					// System.out.println(output);
					textArea.setText(output);
				} catch (Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error accessing Database.");
				}
						
			}
		});
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(275, 61, 89, 33);
		contentPane.add(btnNewButton_1);
		

		//MANAGER OVERRIDE SECTION

		//this label holds the title for the manager override section
		JLabel lblNewLabel_2 = new JLabel("Manager Inventory Override:");
		lblNewLabel_2.setBounds(10, 238, 189, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2);
		
		//panel that holds everything
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 269, 395, 131);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		//item_id
		JLabel lblNewLabel_3 = new JLabel("Item_id:");
		lblNewLabel_3.setBounds(0, 11, 131, 14);
		panel_3.add(lblNewLabel_3);
		
		//current stock
		JLabel lblNewLabel_3_1 = new JLabel("Current Stock:");
		lblNewLabel_3_1.setBounds(0, 50, 131, 14);
		panel_3.add(lblNewLabel_3_1);
		
		//manual adjustment
		JLabel lblNewLabel_3_2 = new JLabel("New Stock Amount:");
		lblNewLabel_3_2.setBounds(0, 94, 131, 14);
		panel_3.add(lblNewLabel_3_2);
		
		//item_id
		textField_1 = new JTextField();
		textField_1.setBounds(141, 8, 86, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		//current stock
		textField_2 = new JTextField();
		textField_2.setBounds(141, 47, 86, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		//manual adjustment
		textField_3 = new JTextField();
		textField_3.setBounds(141, 91, 86, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Make Change");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Building the connection
				Connection conn = null;
				//TODO STEP 1
				try {
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
					"csce315909_7user", "Sqldb_7");
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
				}
				try {
					String item_id = textField_1.getText();
					int my_new = Integer.parseInt(textField_3.getText());
					Statement stmt = conn.createStatement();
					String sqlStatement = "UPDATE inventory SET quantity='"+my_new+"' WHERE item_id='"+item_id+"';";
					stmt.executeUpdate(sqlStatement);
				} catch (Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error accessing Database.");
				}
						
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(267, 90, 118, 23);
		panel_3.add(btnNewButton);


		//this button enables the user to go back to the home landing page
		JButton btnBackToHome = new JButton("Back to Home");
		btnBackToHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				GUI viewGUI = new GUI();
				viewGUI.showWindow();
			}
		});
		btnBackToHome.setOpaque(true);
		btnBackToHome.setBorderPainted(false);
		btnBackToHome.setBackground(Color.RED);
		btnBackToHome.setBounds(594, 11, 118, 37);
		contentPane.add(btnBackToHome);
	}

}
