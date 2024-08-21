

import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

import java.time.format.DateTimeFormatter;
public class serverview implements ActionListener{
	// variables needed to sum order up
	static float discount = 0;
	static float special_price = 0;
	static int special_menu = 0;
	
	static int n1 = 0;
	static int n2 = 0;
	static int n3 = 0;
	static int n4 = 0;
	static int n5 = 0;
	static int n6 = 0;
	static int n7 = 0;
	static int n8 = 0;
	static int n9 = 0;
	static int n10 = 0;
	static int n11 = 0;
	static int n12 = 0;
	static int n13 = 0;
	static int n14 = 0;
	static int n15 = 0;
	static int n16 = 0;
	static int n17 = 0;
	static int n18 = 0;
	static int n19 = 0;
	static int n20 = 0;
	static int n21 = 0;
	static int n22 = 0;
	static int n23 = 0;
	static int n24 = 0;

	private static JTextField textField;

    public static void main(String[] args) {
        showWindow();
    }

    public static void showWindow() {
    	//created of gui and elements
        JFrame serv = new JFrame("Server View");
        serv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a object
        GUI s2 = new GUI();
        serv.setSize(800, 600);
        
        JLabel lblNewLabel = new JLabel("Customer Order");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        
        JLabel lblNewLabel_1 = new JLabel("Order ID:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Event ID:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JButton btnNewButton = new JButton("Veiw Events");
        btnNewButton.setBackground(Color.RED);
        
        btnNewButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
				Connection conn2 = null;
				try {
					Class.forName("org.postgresql.Driver");
					conn2 = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
					   "csce315909_7user", "Sqldb_7");
				  } catch (Exception exe) {
					exe.printStackTrace();
					System.err.println(exe.getClass().getName()+": "+exe.getMessage());
					System.exit(0);
				  }
        		String name = "";
        		String str = JOptionPane.showInputDialog(btnNewButton, "What is the event id?");
        		
				if(str != null) {
        		try {
        			Statement stmt1 = conn2.createStatement();
        	         //create an SQL statement
					 int event_id = Integer.parseInt(str);
        	         //TODO Step 2
        	         String sqlStatement2 = "SELECT * from events WHERE event_id = '"+event_id+"';";
        	         //send statement to DBMS
        	         ResultSet result = stmt1.executeQuery(sqlStatement2);
        	         while (result.next()) {
        	           name = result.getInt("discount")+"\n";
        	         }
					 discount = Float.parseFloat(name);
        	       } catch (Exception exe){
        	         JOptionPane.showMessageDialog(null,"Event does not exist");
        	       }
				}
					try {
						conn2.close();
						//JOptionPane.showMessageDialog(null,"Connection Closed.");
					} catch(Exception exe) {
						//JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
					}
        	}
        });
        
        JButton btnNewButton_2 = new JButton("Add Special Menu Item");
        btnNewButton_2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
				Connection conn2 = null;
				try {
					Class.forName("org.postgresql.Driver");
					conn2 = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
					   "csce315909_7user", "Sqldb_7");
				  } catch (Exception exe) {
					exe.printStackTrace();
					System.err.println(exe.getClass().getName()+": "+exe.getMessage());
					System.exit(0);
				  }
        		String name = "";
        		String str = JOptionPane.showInputDialog(btnNewButton, "Please Enter the Special Menu Item ID: ");
        	    special_menu = Integer.parseInt(str);
        		try {
        			Statement stmt1 = conn2.createStatement();
        	         //create an SQL statement
        	         //TODO Step 2
        	         String sqlStatement2 = "SELECT * from menu WHERE menu_id = '"+special_menu+"';";
        	         //send statement to DBMS
        	         ResultSet result = stmt1.executeQuery(sqlStatement2);
        	         while (result.next()) {
        	           name = result.getInt("price")+"\n";
        	         }
					 special_price = Float.parseFloat(name);
        	       } catch (Exception exe){
        	         JOptionPane.showMessageDialog(null,"Invalid Menu ID");
        	       }

					try {
						conn2.close();
						//JOptionPane.showMessageDialog(null,"Connection Closed.");
					} catch(Exception exe) {
						//JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
					}
					String amount = JOptionPane.showInputDialog(btnNewButton, "Please enter the number of special menu items being ordered: ");
	        		n22 = Integer.parseInt(str);
        	}
        });
        
        JLabel lblNewLabel_3 = new JLabel("Date:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
  
        JLabel lblNewLabel_4 = new JLabel();
        String time = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new Date());
        lblNewLabel_4.setText(time);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        
        JLabel lblNewLabel_5 = new JLabel("Payment Type:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Cash");
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Credit");
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Debit");
        
        JLabel lblNewLabel_6 = new JLabel("Meals:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("5 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_4 = new JCheckBox("4 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_5 = new JCheckBox("3 Finger Meal");
        
        JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Kids Meal");
        
        JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Gallon of Tea");
        
        JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Family Pack");
        
        JLabel lblNewLabel_7 = new JLabel("Drinks:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_8 = new JLabel("Individual Items:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_9 = new JLabel("Sides:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Fountain Drink");
        
        JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Bottle Drink");
        
        JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Club Sandwich Only");
        
        JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Chicken Sandwich");
        
        JCheckBox chckbxNewCheckBox_13 = new JCheckBox("Grill Cheese Sandwhich");
        
        JCheckBox chckbxNewCheckBox_14 = new JCheckBox("Chicken Finger");
        
        JCheckBox chckbxNewCheckBox_15 = new JCheckBox("Club Sandwich Meal");
        
        JCheckBox chckbxNewCheckBox_16 = new JCheckBox("Grill Cheese Meal");
        
        JCheckBox chckbxNewCheckBox_17 = new JCheckBox("Sandwich Meal");
        
        JCheckBox chckbxNewCheckBox_18 = new JCheckBox("Layne's Sauce");
        
        JCheckBox chckbxNewCheckBox_19 = new JCheckBox("Texas Toast");
        
        JCheckBox chckbxNewCheckBox_20 = new JCheckBox("Potato Salad");
        
        JCheckBox chckbxNewCheckBox_21 = new JCheckBox("Crinkle Cut Fries");
        
        JLabel lblNewLabel_10 = new JLabel("Managers Specials:");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JButton btnNewButton_1 = new JButton("Place Order");
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBackground(Color.RED);
		JButton btnBackToHome = new JButton("Back to Home");
		btnBackToHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				serv.setVisible(false);
				GUI viewGUI = new GUI();
				viewGUI.showWindow();
			}
		});

		btnBackToHome.setOpaque(true);
		btnBackToHome.setBorderPainted(false);
		btnBackToHome.setBackground(Color.RED);
		btnBackToHome.setBounds(490, 5, 118, 37);
		serv.getContentPane().add(btnBackToHome);
        
        // handles number of items being added to the order
        
        chckbxNewCheckBox_3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_3, "How many Items are being added? ");
        		n1 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_4.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_4, "How many Items are being added? ");
        		n2 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_5.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_5, "How many Items are being added? ");
        		n3 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_6.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_6, "How many Items are being added? ");
        		n4 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_7.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_7, "How many Items are being added? ");
        		n5 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_8.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_8, "How many Items are being added? ");
        		n6 = Integer.parseInt(str);
        	}
        });
        chckbxNewCheckBox_9.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_9, "How many Items are being added? ");
        		n7 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_10.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_10, "How many Items are being added? ");
        		n8 = Integer.parseInt(str);
        	}
        });
        
        
        chckbxNewCheckBox_11.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_11, "How many Items are being added? ");
        		n9 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_12.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_12, "How many Items are being added? ");
        		n10 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_13.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_13, "How many Items are being added? ");
        		n11 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_14.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_14, "How many Items are being added? ");
        		n12 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_15.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_15, "How many Items are being added? ");
        		n13 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_16.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_16, "How many Items are being added? ");
        		n14 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_17.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_17, "How many Items are being added? ");
        		n15 = Integer.parseInt(str);
        	}
        });
        //
        
        chckbxNewCheckBox_18.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_18, "How many Items are being added? ");
        		n16 = Integer.parseInt(str);
        	}
        });
        
        
        chckbxNewCheckBox_19.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_19, "How many Items are being added? ");
        		n17 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_20.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_20, "How many Items are being added? ");
        		n18 = Integer.parseInt(str);
        	}
        });
        
        chckbxNewCheckBox_21.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog(chckbxNewCheckBox_21, "How many Items are being added? ");
        		n19 = Integer.parseInt(str);
        	}
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
				
		//JOptionPane.showMessageDialog(null,"Opened database successfully");
		

            	float subtot1 = 0, subtot2 = 0, subtot3 = 0, subtot4 = 0, subtot5 = 0, subtot6 = 0, subtot7 = 0, subtot8 = 0, 
            			subtot9 = 0, subtot10 = 0, subtot11 = 0, subtot12 = 0, subtot13 = 0, subtot14 = 0, subtot15 = 0, subtot16 = 0, 
            			subtot17 = 0, subtot18 = 0, subtot19 = 0, subtot20 = 0, subtot21 = 0, subtot22 = 0, subtot23 = 0, subtot24 = 0, 
            			subtot25 = 0;
            	String submsg1 = " ", submsg2 = " ", submsg3 = " ", submsg4 = " ", submsg5 = " ", submsg6 = " ", submsg7 = " ", 
            			submsg8 = " ", submsg9 = " ", submsg10 = " ", submsg12 = " ", submsg13 = " ", submsg14 = " ", submsg15 = " ", submsg16 = " ",
            					submsg17 = " ", submsg18 = " ", submsg19 = " ", submsg20 = " ", submsg21 = " ", submsg22 = " ", submsg23 = " ", submsg24 = " ",
            							 submsg25 = " ", submsg11 = " ";
            	
            	String ordernumber = textField.getText();
            	Calendar calendar = Calendar.getInstance();
            	Date date = calendar.getTime();
				int week = 5; // hard coded for now because we do not have given start week date so its vague to calculate the week we are currently on
            	String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
				String sqlStatement = "";
				// block if statements for checking all checkboxes, totaling order, and adjusting inventory
				Connection conn = null;
		
				//TODO STEP 1
				try {
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
					"csce315909_7user", "Sqldb_7");
				} catch (Exception exe) {
					exe.printStackTrace();
					System.err.println(exe.getClass().getName()+": "+exe.getMessage());
					System.exit(0);
				}
				try (Statement stmt = conn.createStatement()) {
					String totalorder = "";
					if(chckbxNewCheckBox_3.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '501';";
						String name = "";
						Float p1 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p1 = Float.parseFloat(name);
						subtot1 = (float) (p1*n1);
						submsg1 = "5 Finger Meal";
						totalorder = totalorder + submsg1 + " : $" + subtot1 + "\n";
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 501, '"+n1+"','"+subtot1+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n1+"'*0.09375)/20)*5))/quantity WHERE item_id='c1001';";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n1+"'*0.34375)/5)))/quantity WHERE item_id='c1002';";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n1+"')/170)))/quantity WHERE item_id='d2004';";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n1+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002';";

						chckbxNewCheckBox_3.setSelected(false);
					}
					if(chckbxNewCheckBox_4.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '502';";
						String name = "";
						Float p2 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p2 = Float.parseFloat(name);
						subtot2 = (float) (p2*n2);
						submsg2 = "4 Finger Meal";
						totalorder = totalorder + submsg2 + " : $" + subtot2 + "\n";
						chckbxNewCheckBox_4.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 502, '"+n2+"','"+subtot2+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n2+"'*0.09375)/20)*4))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n2+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n2+"')/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n2+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_5.isSelected()) {

						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '503';";
						String name = "";
						Float p3 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p3 = Float.parseFloat(name);
						subtot3 = (float) (p3*n3);
						submsg3 = "3 Finger Meal";
						totalorder = totalorder + submsg3 + " : $" + subtot3 + "\n";
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 503, '"+n1+"','"+subtot3+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n3+"'*0.09375)/20)*3))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n3+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n3+"')/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n3+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
						chckbxNewCheckBox_5.setSelected(false);
					}
					if(chckbxNewCheckBox_6.isSelected()) {

						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '504';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot4 = (float) (p4*n3);
						submsg4 = "Kids Meal";
						totalorder = totalorder + submsg4 + " : $" + subtot4 + "\n";
						chckbxNewCheckBox_6.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 504, '"+n4+"','"+subtot4+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n4+"'*0.09375)/20)*2))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n4+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n4+"')/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n4+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_7.isSelected()) {

						
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '505';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot5 = (float) (p4*n4);
						submsg5 = "Gallon of Tea";
						totalorder = totalorder + submsg5 + " : $" + subtot5 + "\n";
						chckbxNewCheckBox_7.setSelected(false);
						sqlStatement = "INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 505, '"+n5+"','"+subtot5+"');";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_8.isSelected()) {
						
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '506';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot6 = (float) (p4*n6);
						submsg6 = "Family Pack";
						totalorder = totalorder + submsg6 + " : $" + subtot6 + "\n";
						chckbxNewCheckBox_8.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 506, '"+n6+"','"+subtot6+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n6+"'*0.09375)/20)*20))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n6+"'*0.34375*4)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n6+"'*4)/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n6+"'*0.1875*4/1)/30)))/quantity WHERE item_id='f3002' ;";
						
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_9.isSelected()) {

						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '507';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot7 = (float) (p4*n7);
						submsg7 = "Fountain Drink";
						totalorder = totalorder + submsg7 + " : $" + subtot7 + "\n";
						chckbxNewCheckBox_9.setSelected(false);
						sqlStatement = "INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 507, '"+n7+"','"+subtot7+"');";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_10.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '519';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot8 = (float) (p4*n8);
						submsg8 = "Bottle Drink";
						totalorder = totalorder + submsg8 + " : $" + subtot8 + "\n";
						chckbxNewCheckBox_10.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 519, '"+n8+"','"+subtot8+"');";
						//System.out.println(sqlStatement);
					}
					
					if(chckbxNewCheckBox_12.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '510';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot9 = (float) (p4*n10);
						submsg9 = "Chicken Sandwich";
						totalorder = totalorder + submsg9 + " : $" + subtot9 + "\n";
						chckbxNewCheckBox_12.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 510, '"+n10+"','"+subtot9+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n10+"'*0.09375)/20)*3))/quantity WHERE item_id='c1001' ;";
						//System.out.println(sqlStatement);
					}//////////////////////////////////////
					if(chckbxNewCheckBox_11.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '508';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot10 = (float) (p4*n9);
						submsg10 = "Club Sandwich Only";
						totalorder = totalorder + submsg10 + " : $" + subtot10 + "\n";
						chckbxNewCheckBox_11.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 508, '"+n9+"','"+subtot10+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n9+"'*0.09375)/20)*3))/quantity WHERE item_id='c1001' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_13.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '512';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot11 = (float) (p4*n11);
						submsg11 = "Grill Cheese Sandwich";
						totalorder = totalorder + submsg11 + " : $" + subtot11 + "\n";
						chckbxNewCheckBox_13.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 512, '"+n11+"','"+subtot11+"');";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_14.isSelected()) {

						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '514';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}

						p4 = Float.parseFloat(name);
						subtot12 = (float) (p4*n12);
						submsg12 = "Chicken Finger";
						totalorder = totalorder + submsg12 + " : $" + subtot12 + "\n";
						chckbxNewCheckBox_14.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 514, '"+n12+"','"+subtot12+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n12+"'*0.09375)/20)*1))/quantity WHERE item_id='c1001' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_15.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '507';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot13 = (float) (p4*n13);
						submsg13 = "Club Sandwich Meal";
						totalorder = totalorder + submsg13 + " : $" + subtot13 + "\n";
						chckbxNewCheckBox_15.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 507, '"+n13+"','"+subtot13+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n13+"'*0.09375)/20)*3))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n13+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n13+"')/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n13+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_16.isSelected()) {

						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '511';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot14 = (float) (p4*n14);
						submsg14 = "Grill Cheese Meal";
						totalorder = totalorder + submsg14 + " : $" + subtot14 + "\n";
						chckbxNewCheckBox_16.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 511, '"+n14+"','"+subtot14+"');";
						//System.out.println(sqlStatement);
					}
					
					if(chckbxNewCheckBox_17.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '509';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot15 = (float) (p4*n15);
						submsg15 = "Sandwich Meal";
						totalorder = totalorder + submsg15 + " : $" + subtot15 + "\n";
						chckbxNewCheckBox_17.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 509, '"+n15+"','"+subtot15+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n15+"'*0.09375)/20)*3))/quantity WHERE item_id='c1001' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n15+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n15+"')/170)))/quantity WHERE item_id='d2004' ;";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n15+"'*0.1875/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_18.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '513';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot16 = (float) (p4*n16);
						submsg16 = "Layne's Sauce";
						totalorder = totalorder + submsg16 + " : $" + subtot16 + "\n";
						chckbxNewCheckBox_18.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 513, '"+n16+"','"+subtot16+"');";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_19.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '515';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot17 = (float) (p4*n17);
						submsg17 = "Texas Toast";
						totalorder = totalorder + submsg17 + " : $" + subtot17 + "\n";
						chckbxNewCheckBox_19.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 515, '"+n17+"','"+subtot17+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n17+"')/170)))/quantity WHERE item_id='d2004' ;";
						//System.out.println(sqlStatement);
					}
					
					if(chckbxNewCheckBox_20.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '516';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot18 = (float) (p4*n18);
						submsg18 = "Potato Salad";
						totalorder = totalorder + submsg18 + " : $" + subtot18 + "\n";
						chckbxNewCheckBox_20.setSelected(false);
						sqlStatement = sqlStatement + "INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 516, '"+n18+"','"+subtot18+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n18+"'*0.34375)/5)))/quantity WHERE item_id='c1002' ;";
						//System.out.println(sqlStatement);
					}
					if(chckbxNewCheckBox_21.isSelected()) {
						String sqlStatement2 = "SELECT * from menu WHERE menu_id = '517';";
						String name = "";
						Float p4 = (float) 0;
						//send statement to DBMS
						ResultSet result = stmt.executeQuery(sqlStatement2);
						while (result.next()) {
						name = result.getFloat("price")+"\n";
						}
						p4 = Float.parseFloat(name);
						subtot19 = (float) (p4*n19);
						submsg19 = "Crinkle Cut Fries";
						totalorder = totalorder + submsg19 + " : $" + subtot19 + "\n";
						chckbxNewCheckBox_21.setSelected(false);
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"', 517, '"+n19+"','"+subtot19+"');";
						sqlStatement = sqlStatement + " UPDATE inventory SET quantity = quantity - (((('"+n19+"'*0.1875*4/1)/30)))/quantity WHERE item_id='f3002' ;";
						//System.out.println(sqlStatement);
					}
					if( special_price != 0) {
						float subtot201 =  (float) (special_price*n22);
						totalorder = totalorder + " Special Menu Item : $" + subtot201 + "\n";
						sqlStatement = sqlStatement + " INSERT INTO customer_orders VALUES ('"+week+"','"+day+"','"+special_menu+"', '"+n22+"','"+subtot201+"');";
					}
					
					float total = subtot1+subtot2+subtot3+subtot4+subtot5+subtot6+subtot7+subtot8+subtot9+subtot10+subtot11+subtot12+
							subtot13+subtot14+subtot15+subtot16+subtot17+subtot18;
					if (discount != 0) {
						total = total - discount*total;
						JOptionPane.showMessageDialog(null, totalorder + "\n" +
							"TOTAL: $" + total);
						chckbxNewCheckBox.setSelected(false);
						chckbxNewCheckBox_1.setSelected(false);
						chckbxNewCheckBox_2.setSelected(false);
						textField.setText("");
					} else {
					JOptionPane.showMessageDialog(null, totalorder + "\n" +
							"TOTAL: $" + total);
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);
					textField.setText("");
					int result = stmt.executeUpdate(sqlStatement);
					System.out.println(sqlStatement);
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	//closing the connection
				try {
				  conn.close();
				//   JOptionPane.showMessageDialog(null,"Connection Closed.");
				} catch(Exception exe) {
				  JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
				}
				

        }
        });
        
        
        
        
        
        
        // auto generated code from eclipse window builder for gui formatting
        GroupLayout groupLayout = new GroupLayout(serv.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        									.addComponent(chckbxNewCheckBox_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(chckbxNewCheckBox_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        									.addComponent(chckbxNewCheckBox_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        								.addComponent(lblNewLabel_6))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(chckbxNewCheckBox_10, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(lblNewLabel_7)
        									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(chckbxNewCheckBox_7, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        										.addComponent(chckbxNewCheckBox_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        						.addComponent(chckbxNewCheckBox_6, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_12)
        						.addComponent(chckbxNewCheckBox_11, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_13, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_14, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblNewLabel_9)
        						.addComponent(chckbxNewCheckBox_18, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_21, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(chckbxNewCheckBox_19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_10)
        						.addComponent(btnNewButton_2)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(lblNewLabel_5)
        							.addGap(18)
        							.addComponent(chckbxNewCheckBox)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(chckbxNewCheckBox_1))
        						.addComponent(chckbxNewCheckBox_8, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        						.addComponent(chckbxNewCheckBox_17, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(chckbxNewCheckBox_15, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(chckbxNewCheckBox_16, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chckbxNewCheckBox_2))
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addGap(15)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel_1)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_2)
        				.addComponent(btnNewButton))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_3)
        				.addComponent(lblNewLabel_4))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_5)
        				.addComponent(chckbxNewCheckBox)
        				.addComponent(chckbxNewCheckBox_1)
        				.addComponent(chckbxNewCheckBox_2))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_6)
        				.addComponent(lblNewLabel_9)
        				.addComponent(lblNewLabel_8)
        				.addComponent(lblNewLabel_10)
        				.addComponent(lblNewLabel_7))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(chckbxNewCheckBox_3)
        				.addComponent(chckbxNewCheckBox_7)
        				.addComponent(chckbxNewCheckBox_11)
        				.addComponent(chckbxNewCheckBox_18)
        				.addComponent(btnNewButton_2))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(chckbxNewCheckBox_4)
        				.addComponent(chckbxNewCheckBox_9)
        				.addComponent(chckbxNewCheckBox_19)
        				.addComponent(chckbxNewCheckBox_12))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(2)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_5)
        						.addComponent(chckbxNewCheckBox_10))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_6)
        						.addComponent(chckbxNewCheckBox_14))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chckbxNewCheckBox_8))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(chckbxNewCheckBox_20)
        						.addComponent(chckbxNewCheckBox_13))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chckbxNewCheckBox_21)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chckbxNewCheckBox_15)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chckbxNewCheckBox_16)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chckbxNewCheckBox_17)
        			.addGap(37)
        			.addComponent(btnNewButton_1)
        			.addGap(102))
        );
        // unused so far
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setLabel("EVENTS");
        addPopup(btnNewButton, popupMenu);
        serv.getContentPane().setLayout(groupLayout);

        serv.setVisible(true);
     }
	
    

    private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

