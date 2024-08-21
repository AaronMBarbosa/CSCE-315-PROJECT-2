
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eventsview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextArea textField;
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
					eventsview frame = new eventsview();
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
					eventsview frame = new eventsview();
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
	public eventsview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//main title for the page
		JLabel lblNewLabel = new JLabel("Events");
		lblNewLabel.setBounds(5, 5, 94, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));

		//initialization of all panels used on the page
		JPanel panel = new JPanel();
		panel.setBounds(15, 50, 142, 32);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 88, 202, 299);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(233, 50, 147, 32);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(398, 88, 210, 299);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(398, 50, 97, 32);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(233, 88, 147, 299);
		panel_3.setLayout(null);
		

		//ADD EVENT SECTION

		//discount amount label
		JLabel lblNewLabel_4 = new JLabel("Discount Amount:");
		lblNewLabel_4.setBounds(0, 22, 104, 14);
		panel_3.add(lblNewLabel_4);
		
		//events code label
		JLabel lblNewLabel_5 = new JLabel("Event Code:");
		lblNewLabel_5.setBounds(0, 47, 104, 14);
		panel_3.add(lblNewLabel_5);
		
		//date for new event label
		JLabel lblNewLabel_6 = new JLabel("Date for Event:");
		lblNewLabel_6.setBounds(0, 72, 104, 14);
		panel_3.add(lblNewLabel_6);
		
		//Discount Amount
		textField_1 = new JTextField();
		textField_1.setBounds(126, 19, 74, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		//Event code
		textField_2 = new JTextField();
		textField_2.setBounds(126, 47, 74, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		//date for event
		textField_3 = new JTextField();
		textField_3.setBounds(126, 72, 74, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		//button used to create a new event
		JButton btnNewButton = new JButton("Create Event");
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
					int event_id = Integer.parseInt(textField_2.getText());
					float discount = Float.parseFloat(textField_1.getText());
					String date= textField_3.getText();
					Statement stmt = conn.createStatement();
					String sqlStatement = "INSERT INTO events VALUES ('"+event_id+"','"+discount+"', '"+date+"');";
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
		btnNewButton.setBounds(46, 139, 118, 37);
		panel_3.add(btnNewButton);
		panel_5.setLayout(null);
		
		//label for add event section
		JLabel lblNewLabel_3 = new JLabel("Add Event:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_3);
		

		//VIEW EVENTS SECTION

		//label for date of event section
		JLabel lblNewLabel_2 = new JLabel("Date of Event:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);
		panel_1.setLayout(null);
		
		//process used to get the data needed to display in the upcoming events and date of event section
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

	      String ev = "";
		  String dates = "";
	      try{
	        //create a statement object
	        Statement stmt = conn.createStatement();
	        //create an SQL statement
	        //TODO Step 2
	        String sqlStatement = "SELECT * FROM events;";
	        //send statement to DBMS
	        ResultSet result = stmt.executeQuery(sqlStatement);
	        while (result.next()) {
	          ev += result.getString("event_id")+"\n";
			  dates += result.getString("date")+"\n";
	        }
	      } catch (Exception e){
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Error accessing Database.");
	      }
		
		if (ev.equals("")) {
			ev = "There are no current events!";
		}

		//textarea that displays events
		JTextArea textArea = new JTextArea(ev);
		textArea.setBounds(10, 11, 182, 277);
		panel_1.add(textArea);

		//textArea that displays dates
		textField = new JTextArea(dates);
		textField.setBounds(10, 11, 127, 277);
		panel_5.add(textField);
		textField.setColumns(10);
		
		//label for upcoming events
		JLabel lblNewLabel_1 = new JLabel("Upcoming Events:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.add(panel_5);
		contentPane.add(panel_2);
		contentPane.add(panel_3);
		contentPane.add(panel_4);
		
		

		//enables the user to return to the home landing page
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
		btnBackToHome.setBounds(490, 5, 118, 37);
		contentPane.add(btnBackToHome);
	}
}