
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
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuview extends JFrame {

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
					menuview frame = new menuview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//enables the user to navigate to the window
	public static void showWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuview frame = new menuview();
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
	public menuview() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// title for the entire page
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		//these initializations were done at the beginning to be able to do the gui formatting
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JList list = new JList();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();

		//button which allows the user to return to the home landing page
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

		// auto generated code from eclipse window builder for gui formatting
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
						.addComponent(btnBackToHome, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(462, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(150))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(btnBackToHome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(60, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
							.addContainerGap())))
		);
		

		//ADD ITEM SECTION

		panel_3.setLayout(null);

		//title for this section
		JLabel lblNewLabel_3 = new JLabel("Add Item:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_3);
		
		//label for item_id
		JLabel lblNewLabel_4 = new JLabel("item_id:");
		lblNewLabel_4.setBounds(0, 11, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		//label for bundle_id
		JLabel lblNewLabel_5 = new JLabel("bundle_id:");
		lblNewLabel_5.setBounds(0, 36, 83, 14); 
		panel_3.add(lblNewLabel_5);
		
		//label for price
		JLabel lblNewLabel_6 = new JLabel("Price:");
		lblNewLabel_6.setBounds(0, 61, 46, 14);
		panel_3.add(lblNewLabel_6);

		//label for description
		JLabel lblNewLabel_7 = new JLabel("Description:");
		lblNewLabel_7.setBounds(0, 86, 83, 14);
		panel_3.add(lblNewLabel_7);
		
		//item_id textfield
		textField = new JTextField();
		textField.setBounds(124, 11, 76, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		//bundle_id textfield
		textField_1 = new JTextField();
		textField_1.setBounds(124, 36, 76, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		//price textfield
		textField_2 = new JTextField();
		textField_2.setBounds(124, 61, 76, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		//description textfield
		textField_3 = new JTextField();
		textField_3.setBounds(124, 86, 76, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		//button to create a new menu item
		JButton btnNewButton = new JButton("Create Item");
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
					int menu_id = Integer.parseInt(textField.getText());
					String bundle_id = textField_1.getText();
					float price = Float.parseFloat(textField_2.getText());
					String description = textField_3.getText();
					Statement stmt = conn.createStatement();
					String sqlStatement = "INSERT INTO menu VALUES ('"+menu_id+"','"+bundle_id+"', '"+price+"', '"+description+"');";
					stmt.executeUpdate(sqlStatement);
				} catch (Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error accessing Database.");
				}
						
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(42, 121, 107, 39);
		panel_3.add(btnNewButton);

		
		//DISPLAY FOR MENU AND PRICE SECTION

		panel_5.setLayout(null);
		
		//price title
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);
		panel_1.setLayout(null);

		//getting the values that need to be displayed
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
		String items = "";
		String price = "";
		try{
		//create a statement object
		Statement stmt = conn.createStatement();
		//create an SQL statement
		//TODO Step 2
		String sqlStatement = "SELECT * FROM menu;";
		//send statement to DBMS
		ResultSet result = stmt.executeQuery(sqlStatement);
		while (result.next()) {
			items += result.getString("menu_id")+ " - " + result.getString("description")+"\n";
			price += result.getString("menu_id")+ " - " + result.getString("price")+"\n";
		}
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error accessing Database.");
		}

		//textArea that displays menu items
		JTextArea textArea = new JTextArea(items);
		textArea.setBounds(12, 12, 180, 332);
		panel_1.add(textArea);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 180, 332);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(textArea);

		//textArea that display price
		JTextArea textArea_1 = new JTextArea(price);
		textArea_1.setBounds(10, 11, 137, 333);
		panel_5.add(textArea_1);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 137, 333);
		panel_5.add(scrollPane_1);
		scrollPane_1.setViewportView(textArea_1);
		
		//title for menu items
		JLabel lblNewLabel_1 = new JLabel("Menu Item:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);

	}
}
