import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.EventQueue;
import java.io.*;
import java.util.*;

//needed to be able to pair up quantities and item_id's
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//making personal comparator that sorts items from greatest to least
class Compare {
    static String compare (Pair arr[], int n) {
        Arrays.sort(arr, new Comparator<Pair> () {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p2.y - p1.y;
            }
        });

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
        
        String G_to_L = "Items are in order of Most Ordered to Least Ordered: " + "\n" + "\n";

        try {
            Statement stmt = conn.createStatement();
            ResultSet result;
            String sqlStatement;

            for (int i = 0; i < n; i++) {
                sqlStatement = "SELECT * FROM menu WHERE menu_id='"+arr[i].x+"';";
                result = stmt.executeQuery(sqlStatement);
                while (result.next()) {
                    G_to_L += result.getString("description") + ": " + arr[i].y + " " + "\n";
                }
            } 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error Accessing Database!");
        }

        return G_to_L;
    }
}

public class trends extends JFrame implements ActionListener{
    //declaring a textField
    private static JTextField Items_field;
    private JPanel headerPanel, tablePanel, centerPanel, Time_panel, extraPanel, labelPanel,CO_trend, orderPanel, itemPanel;
    private JPanel Items_sold, Resupply_orders;
    private JLabel CO_label;
    private JLabel Time_interval, trendsLabel, itemsLabel;
    private JButton theButton;
    private JTable orderTable;
    private String [][] orderData = {{"1", "Example", "72/32", "$7", "$9"}, {"2", "Example2", "7/4", "$12", "$15"}};
    private String [] tableHeaders = {"Order_id", "item_name", "date", "tax", "total"};
    private ArrayList<ArrayList<String>> orderList;
    private JScrollPane orderPane;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JTextField textField_2;
    private JLabel lblNewLabel_3;
    private JTextField textField_3;
    private JButton btnNewButton;


      public static void showWindow() {
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					trends frame = new trends();
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
      }


    public trends(){
        super("Trends");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);        

        //header panel
        headerPanel = new JPanel(new BorderLayout());
        JLabel lblNewLabel = new JLabel("Trends");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));

        theButton = new JButton("Back to Home");
        theButton.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent arg0) {
        				setVisible(false);
        				GUI viewGUI = new GUI();
        				viewGUI.showWindow();
        			}
        });

        theButton.setBackground(Color.RED);
        theButton.setForeground(Color.BLACK);
        theButton.setOpaque(true);
        theButton.setBorderPainted(false);
        theButton.addActionListener(this);

        centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        // extraPanel = new JPanel(new GridLayout(1, 3));

        labelPanel = new JPanel(new GridLayout(1, 3));
        //labelPanel.add();

        //time interval panel
        Time_panel = new JPanel();
        Time_interval = new JLabel("Start Week: ");

        /*panels to be had inside the grids*/

        //items sold
        itemPanel = new JPanel(new BorderLayout());
        //         itemPanel.setBackground(Color.BLUE);
        itemsLabel =  new JLabel("Inventory Usage:");
        Items_field = new JTextField(10);


        //add another label or textField


        //panel for the Customer order trends
        CO_trend = new JPanel(new BorderLayout());
        JTextArea CO_Field = new JTextArea();
        CO_label =  new JLabel("Customer Order Trends: ");


        /*adding to the panels*/

        //header panel
        headerPanel.add(lblNewLabel, BorderLayout.WEST);
        headerPanel.add(theButton, BorderLayout.EAST);

        //adding time interval panel
        headerPanel.add(Time_panel);

        //customer order panel
        CO_trend.add(CO_label, BorderLayout.NORTH);
        CO_trend.add(CO_Field);

        //items panel
        itemPanel.add(itemsLabel, BorderLayout.NORTH);
        itemPanel.add(Items_field);

        labelPanel.add(CO_trend);
        labelPanel.add(itemPanel);
        centerPanel.add(labelPanel);
        getContentPane().add(headerPanel, BorderLayout.NORTH);

        //west panel with textField
        Time_panel.add(Time_interval);
        
        textField = new JTextField();
        Time_panel.add(textField);
        textField.setColumns(10);
        
        lblNewLabel_1 = new JLabel("Start Day(1-7):\r\n");
        Time_panel.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        Time_panel.add(textField_1);
        textField_1.setColumns(10);
        
        lblNewLabel_2 = new JLabel("End Week");
        Time_panel.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        Time_panel.add(textField_2);
        textField_2.setColumns(10);
        
        lblNewLabel_3 = new JLabel("End Day(1-7):");
        Time_panel.add(lblNewLabel_3);
        
        textField_3 = new JTextField();
        Time_panel.add(textField_3);
        textField_3.setColumns(10);
        
        btnNewButton = new JButton("Enter");
        Time_panel.add(btnNewButton);
        JTextArea inventoryusage = new JTextArea();
        itemPanel.add(inventoryusage);
        // logic for showing inventory usage
        btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                // sums for all menu items
                int sum501 = 0;
                int sum502 = 0;
                int sum503 = 0;
                int sum504 = 0;
                int sum505 = 0;
                int sum506 = 0;
                int sum507 = 0;
                int sum508 = 0;
                int sum509 = 0;
                int sum510 = 0;
                int sum511 = 0;
                int sum512 = 0;
                int sum513 = 0;
                int sum514 = 0;
                int sum515 = 0;
                int sum516 = 0;
                int sum517 = 0;
                int sum518 = 0;
                int sum519 = 0;

                // parsing for start and end bounds
				int startweek = Integer.parseInt(textField.getText());
                String startday = textField_1.getText();
                int start = Integer.parseInt(startday);
                int endweek = Integer.parseInt(textField_2.getText());
                String endday = textField_3.getText();

                if (start == 1) {
                    startday = "Monday";
                } else if (start == 2) {
                    startday = "Tuesday";
                } else if (start == 3) {
                    startday = "Wednesday";
                } else if (start == 4) {
                    startday = "Thursday";
                } else if (start == 5) {
                    startday = "Friday";
                } else if (start == 6) {
                    startday = "Saturday";
                } else if (start == 7) {
                    startday = "Sunday";
                    startweek++;
                }
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
            while(startweek != endweek+1 && startday != endday){
                    try {
                    // goes through week + day by day and totals up all the menu items
					Statement stmt = conn.createStatement();
					String sqlStatement = "SELECT * FROM customer_orders WHERE week='"+startweek+"' and day ='"+startday+"';";
					ResultSet result = stmt.executeQuery(sqlStatement);                    
				
					while (result.next()) {
                        
                        if(Integer.parseInt(result.getString("item_id")) == 501) {
						    sum501 = sum501 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 502) {
                            sum502 = sum502 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 503) {
						sum503 = sum503 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 504) {
                            sum504 = sum504 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 505) {
                            sum505 = sum505 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 506) {
                            sum506 = sum506 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 507) {
						sum507 = sum507 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 508) {
                            sum508 = sum508 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 509) {
                            sum509 = sum509 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 510) {
                            sum510 = sum510 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 511) {
						sum511 = sum511 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 512) {
                            sum512 = sum512 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 513) {
                            sum513 = sum513 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 514) {
                            sum514 = sum514 + Integer.parseInt(result.getString("quantity"));
                            }
                        if(Integer.parseInt(result.getString("item_id")) == 515) {
						    sum515 = sum515 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 516) {
                            sum516 = sum516 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 517) {
                            sum517 = sum517 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 518) {
                            sum518 = sum518 + Integer.parseInt(result.getString("quantity"));
                        }
                        if(Integer.parseInt(result.getString("item_id")) == 519) {
                            sum519 = sum519 + Integer.parseInt(result.getString("quantity"));
                        }
					}

                    // adjusts to the next day or week
                    if (startday == "Monday") {
                        startday = "Tuesday";
                    } else if (startday == "Tuesday") {
                        startday = "Wednesday";
                    } else if (startday == "Wednesday") {
                        startday = "Thursday";
                    } else if (startday == "Thursday") {
                        startday = "Friday";
                    } else if (startday == "Friday") {
                        startday = "Saturday";
                    } else if (startday == "Saturday") {
                        startday = "Sunday";
                    } else if (startday == "Sunday") {
                        startday = "Monday";
                        startweek++;
                    }
                    

				} catch (Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"One of the Inputs was Incorrectly Formatted");
				}
                

            }

            //  pair class and comparator to sort an array of pairs
            Pair popularOrdering[] = new Pair[19];
            popularOrdering[0] = new Pair(501, sum501);
            popularOrdering[1] = new Pair(502, sum502);
            popularOrdering[2] = new Pair(503, sum503);
            popularOrdering[3] = new Pair(504, sum504);
            popularOrdering[4] = new Pair(505, sum505);
            popularOrdering[5] = new Pair(506, sum506);
            popularOrdering[6] = new Pair(507, sum507);
            popularOrdering[7] = new Pair(508, sum508);
            popularOrdering[8] = new Pair(509, sum509);
            popularOrdering[9] = new Pair(510, sum510);
            popularOrdering[10] = new Pair(511, sum511);
            popularOrdering[11] = new Pair(512, sum512);
            popularOrdering[12] = new Pair(513, sum513);
            popularOrdering[13] = new Pair(514, sum514);
            popularOrdering[14] = new Pair(515, sum515);
            popularOrdering[15] = new Pair(516, sum516);
            popularOrdering[16] = new Pair(517, sum517);
            popularOrdering[17] = new Pair(518, sum518);
            popularOrdering[18] = new Pair(519, sum519);

            Compare compInstance = new Compare();
            CO_Field.setText(compInstance.compare(popularOrdering, popularOrdering.length));
            // calculates the amount of each inventory item used based on the data received
            String c1001 = "Chicken Breast (SKU c1001): " + String.valueOf((sum501*0.09375*5) + (sum502*0.09375/20*4) +(sum503*0.09375*3) +(sum504*0.09375*2) +(sum506*0.09375) + 
            (sum510*0.09375*3) + (sum508*0.09375*3) + (sum514*0.09375*1) + (sum507*0.09375*3) + (sum509*0.09375*3) + " lbs \n");
            String c1002 = "Potato Salad Used (SKU c1002): " + String.valueOf((sum501*0.345375) + (sum502*0.345375) +(sum503*0.345375) +(sum504*0.345375) +(sum506*0.345375*4) + 
            + (sum514*0.345375) + (sum507*0.345375) + (sum509*0.345375)) + " lbs \n";
            String d2004 = "Bread Used (SKU d2004): " + String.valueOf((sum501) + (sum502) +(sum503) +(sum504) +(sum506*4) + 
            + (sum507) + (sum509)) + " slices \n";
            String f3002 = "Fries (SKU f3002): " + String.valueOf((sum501*0.1875) + (sum502*0.1875) +(sum503*0.1875) +(sum504*0.1875) +(sum506*0.1875*4) + 
            + (sum514*0.1875) + (sum507*0.1875) + (sum509*0.1875) + (sum517*0.1875)) + " lbs \n";
            String tea = "Tea: " + sum505 + " Gallons \n" ;
            String grillcheese = "Slices of Cheese (SKU c1005): " + sum511 + sum512 + "\n";
            String drink = "Drinks : " + String.valueOf((sum518 + sum501 + sum502 + sum503 + sum504 + sum507 + sum509 + sum511)*16)  + " oz. \n";
            String output = c1001 + c1002 + d2004 + f3002 + tea + grillcheese + drink + "\n" + "All numbers calculated based only on customer orders! \n";
            inventoryusage.setText(output);


                 //closing the connection
				try {
                    conn.close();
                  //   JOptionPane.showMessageDialog(null,"Connection Closed.");
                  } catch(Exception exe) {
                    JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
                  }
			}
		});




        getContentPane().add(centerPanel);


       // this.setVisible(true);

    }

    //implementing a function to display the window
    public static void main(String[] arg){
        new trends();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        Object objSrc = e.getSource();
        if(objSrc.equals(theButton)){
            this.dispose();
        }
    }
}