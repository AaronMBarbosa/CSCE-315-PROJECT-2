package serverview;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;

/*
  TODO:
  1) Change credentials for your own team's database
  2) Change SQL command to a relevant query that retrieves a small amount of data
  3) Create a JTextArea object using the queried data
  4) Add the new object to the JPanel p
*/

public class GUI extends JFrame implements ActionListener {
	public GUI() {
	}
    static JFrame f;

    public static void main(String[] args)
    {
      //Building the connection
//      Connection conn = null;
//      //TODO STEP 1
//      try {
//        Class.forName("org.postgresql.Driver");
//        conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315909_7db",
//           "csce315909_7user", "Sqldb_7");
//      } catch (Exception e) {
//        e.printStackTrace();
//        System.err.println(e.getClass().getName()+": "+e.getMessage());
//        System.exit(0);
//      }
      //JOptionPane.showMessageDialog(null,"Opened database successfully");

      String name = "";
      // try{
      //   //create a statement object
      //   Statement stmt = conn.createStatement();
      //   //create an SQL statement
      //   //TODO Step 2
      //   String sqlStatement = "SELECT * FROM inventory ORDER BY name LIMIT 10;";
      //   //send statement to DBMS
      //   ResultSet result = stmt.executeQuery(sqlStatement);
      //   while (result.next()) {
      //     name += result.getString("name")+"\n";
      //   }
      // } catch (Exception e){
      //   JOptionPane.showMessageDialog(null,"Error accessing Database.");
      // }
      // create a new frame
      f = new JFrame("DB GUI");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // create a object
      GUI s = new GUI();

      // create a panel
    
      
      JButton b1=new JButton("Customer Orders");    
      JButton b2=new JButton("Current Story Inventory");    
      JButton b3=new JButton("Incoming Orders");    
      JButton b4=new JButton("Reports(Trends)");    
      JButton b5=new JButton("Inventory Orders");    
      JButton b6=new JButton("Events");    
      JButton b7=new JButton("Server View");
      JButton b8=new JButton("Menu");
      JButton close1 = new JButton("Close"); 
      
      b7.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent arg0) {
          f.setVisible(false);
          serverview  viewserver = new serverview();
          viewserver.showWindow();
        }
      });
      close1.addActionListener(s);
      
       // adding buttons to the frame       
      f.getContentPane().add(b1); f.getContentPane().add(b2); f.getContentPane().add(b3);  
      f.getContentPane().add(b4); f.getContentPane().add(b5); f.getContentPane().add(b6);
      f.getContentPane().add(b7); f.getContentPane().add(b8);
      f.getContentPane().add(close1);
      
      // setting grid layout of 3 rows and 3 columns 
         
      f.getContentPane().setLayout(new GridLayout(3,3));    
      f.setSize(900,900);    
      f.setVisible(true);   
      
      // add actionlistener to button

      //TODO Step 3 

      //TODO Step 4

      // add button to panel
      

      // add panel to frame
  

      // set the size of frame
      f.setSize(1100, 600);
 
      f.show();

      //closing the connection
      // try {
      //   conn.close();
      //   JOptionPane.showMessageDialog(null,"Connection Closed.");
      // } catch(Exception e) {
      //   JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
      // }
    }

    // if button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Close")) {
            f.dispose();
        }
    }
}
