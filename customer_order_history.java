import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.EventQueue;

public class customer_order_history extends JFrame implements ActionListener{
    //declaring a textField
    private static JTextField orderField;
    private JPanel headerPanel, tablePanel, centerPanel, inputPanel;
    private JLabel inputLabel;
    private JButton theButton;
    private JTable orderTable;
    DefaultTableModel model = new DefaultTableModel();


    private String [] tableHeaders = {"Week", "day", "item_id", "quantity", "total"};
    private ArrayList<String []> orderList;
    private JScrollPane orderPane;

    public static void showWindow() {
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					customer_order_history frame = new customer_order_history();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    }


    public customer_order_history(){
        super("Customer Order History");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);

        //header panel
        headerPanel = new JPanel(new GridLayout(2, 1));
        JLabel lblNewLabel = new JLabel("Customer Order History");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));

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

        //panel for the table
        tablePanel = new JPanel();
        //orderPane = new JScrollPane(tablePanel);
        //conneecting to db

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


                	      String order_id ="";
                		  String item_name = "";
                		  String date = "";
                		  String quantity ="";
                		  String tax = "";
                		  String total = "";
//                 		  String [][] orderData = {{order_id, date,item_name, quantity,total}};
//                        orderTable = new JTable(model);
                	      try{
                	        //create a statement object
                	        Statement stmt = conn.createStatement();
                	        //create an SQL statement
                	        //TODO Step 2
                	        String sqlStatement = "SELECT * FROM customer_orders;";
                	        orderList = new ArrayList<>();
                	        //send statement to DBMS
                	        ResultSet result = stmt.executeQuery(sqlStatement);
                	        while (result.next()) {
                	          order_id = result.getString("week");
                	          date = result.getString("day");
                			  item_name = result.getString("item_id");
                			  quantity = result.getString("quantity");
                			  tax = result.getString("total") ;
                			  String[] linedata = {order_id, date,item_name, quantity,tax};
                              orderList.add(linedata);
                	        }
                	      } catch (Exception e){
                	        e.printStackTrace();
                	        JOptionPane.showMessageDialog( null,"Error accessing Database.");
                          }
            String [][] orderData = this.to2dArray(orderList);
            orderTable = new JTable(orderData, tableHeaders);
            orderPane = new JScrollPane(orderTable);
            orderTable.setFillsViewportHeight(true);

            //input panel
            inputPanel = new JPanel();
            inputLabel = new JLabel("Search order_id: ");
            orderField = new JTextField(10);





            /*adding to the panels*/

            //header panel
            headerPanel.add(lblNewLabel);
            headerPanel.add(theButton);


            //center panel
            tablePanel.add(orderPane);


            //east panel with the textField
            inputPanel.add(inputLabel);
            inputPanel.add(orderField);

            this.add(headerPanel, BorderLayout.NORTH);
            this.add(tablePanel);
            this.add(inputPanel, BorderLayout.EAST);

            this.setVisible(true);

    }

    //implementing a function to display the window
    public static void main(String[] arg){
        new customer_order_history();
    }

    public String[][] to2dArray(ArrayList<String []> theData) {

                ArrayList<String []> data = theData;

                int columnCount = data.get(0).length;

                String[][] dataList = new String[data.size()][columnCount];

                for (int i = 0; i < data.size(); i++) {

                    String [] row = data.get(i);

                    for (int j = 0; j < columnCount; j++) {

                        dataList[i][j] = row[j];
                    }
                }
                return dataList;
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