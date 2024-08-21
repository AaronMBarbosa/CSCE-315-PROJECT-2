import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.plaf.ActionMapUIResource;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class inventory_orders_view extends JFrame {

	private JPanel contentPane;
    private JScrollPane scroller;
    private JTable IVO_table;
//     DefaultTableModel = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	private String [] tableHeaders = {"Item id ", "Price  ", "Name", "quantity"};
    private ArrayList<String []> orderList = new ArrayList<>();
    private JScrollPane orderPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventory_orders_view frame = new inventory_orders_view();
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
					inventory_orders_view frame = new inventory_orders_view();
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
	public inventory_orders_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        //main title
		JLabel lblNewLabel = new JLabel("Inventory Orders");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 11, 254, 50);
		contentPane.add(lblNewLabel);


        //INVENTORY LOW IN STOCK SECTION

		JPanel panel = new JPanel();
// 		JScrollPane scroller = new JScrollPane(panel);
		panel.setBounds(10, 83, 398, 294);
		contentPane.add(panel);
// 		panel.setLayout(null);


		JLabel lblNewLabel_1 = new JLabel("Inventory Low in Stock:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 222, 32);
		panel.add(lblNewLabel_1);




// 		JTextArea textArea = new JTextArea();
// 		textArea.setBounds(10, 52, 378, 231);
// 		panel.add(textArea);


        //  GETTING ALL INVENTORY ITEMS
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
            Statement stmt = conn.createStatement();
            Statement secondStatement = conn.createStatement();
            String sqlStatement = "SELECT * FROM inventory LIMIT 20;";
            ResultSet result = stmt.executeQuery(sqlStatement);
            String output = "";
            while (result.next()) {
				String item_id = result.getString("item_id");
				String name = result.getString("name");
				String price = result.getString("price");
				String quantity = result.getString("quantity");
				String quantity_treshold = result.getString("quantity_treshold");
				String [] theRow = {item_id, price, name, quantity};
				System.out.println(Float.parseFloat(quantity) );
				System.out.println(Float.parseFloat(result.getString("quantity_treshold")));
               	if(Float.parseFloat(quantity) <= Float.parseFloat(quantity_treshold)){
					orderList.add(theRow);
					String insertStatement = "INSERT INTO inventory_orders (item_id, price, name, quantity) VALUES ('" + item_id  + "', '" + Float.parseFloat(price) + "', '" + name + "', '" + Float.parseFloat(quantity) + "');";
					System.out.println("SQL in IF: " + insertStatement);
					int rss = secondStatement.executeUpdate(insertStatement);
            	}
        }
//             textArea.setText(output);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Stop sign 1");
        }

        String [][] orderData = this.to2dArray(orderList);
        IVO_table = new JTable(orderData, tableHeaders);
        scroller = new JScrollPane(IVO_table);
        IVO_table.setFillsViewportHeight(true);

        panel.add(scroller);


        //ORDER RESTOCK SECTION

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(418, 83, 201, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Order Restock:");
		lblNewLabel_1_1.setBounds(6, 5, 185, 38);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_1_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(6, 54, 185, 184);
		panel_1.add(textArea_1);

		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent arg0){
		        Connection conn = null;
		        try {
		            Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
                	"csce315909_7user", "Sqldb_7");
                }
                catch (Exception e) {
                		e.printStackTrace();
                	    System.err.println(e.getClass().getName()+": "+e.getMessage());
                		System.exit(0);
                }
                try{
                    Statement stt = conn.createStatement();
                    String sqlstt = "UPDATE inventory SET quantity = quantity + 5;";
                    int rs = stt.executeUpdate(sqlstt);
                    Statement stt2  = conn.createStatement();
                    String sqlstt2 = "TRUNCATE inventory_orders; ";
                    int rs2 = stt2.executeUpdate(sqlstt2);
                }
                catch(Exception e ){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error Accessing Database");
                }
		    }
		});
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(6, 249, 185, 34);
		panel_1.add(btnNewButton);


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

	public String [][] to2dArray(ArrayList<String[]> theList){
	    int rowSize = theList.size();
	    int colSize = theList.get(0).length;
	    String[][] orderArray = new String[rowSize][colSize];

	    for(int i = 0; i < rowSize ; i++){
	        orderArray[i] = theList.get(i);
	    }

	    return orderArray;
	}

}