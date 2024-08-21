

import java.sql.*;
import java.io.*;

public class firstdayorder_script {

  //MAKE SURE YOU ARE ON VPN or TAMU WIFI TO ACCESS DATABASE
  public static void main(String args[]) throws IOException, SQLException {

    //Building the connection with your credentials
     Connection conn = null;
     String teamNumber = "7";
     String sectionNumber = "909";
     String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
     String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
     String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
     String userPassword = "Sqldb_7";
     String csvFilePath = "First day order.csv";
     String lineText = null;
     int batchSize = 20;
     int count = 0;

    //Connecting to the database
    try {
        conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }

     System.out.println("Opened database successfully");

       // Populating the actual inventory table within our database
      int counter = 0;
      BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
      lineReader.readLine();
      lineReader.readLine();
      lineReader.readLine();
      lineText = lineReader.readLine();
      String[] data = lineText.split(",");
      String sku = "temp";
      Statement stmt = conn.createStatement();
      String sqlStatement = "";

      //  This loops through the file, reads through the data, and write to the inventory table.
       while(count < 53) {
        data = lineText.split(",");
         if(data.length < 5) {
          lineText = lineReader.readLine();
          data = lineText.split(",");
         }

      //  Commented below is the breakdown that we used to determine the positioning of data points within First Day Order.csv.
      //  --------------------
      //  String item_name = data[1];
      //  sku = data[2];
      //  int amount = Integer.parseInt(data[3]);
      //  int delivered = Integer.parseInt(data[4]);
      //  String sold_by = data[5];
      //  String delivered_by = data[6];
      //  int multiplier = Integer.parseInt(data[7]);
      //  float price = Float.parseFloat(data[8].substring(1));
      //  float total_cost = Float.parseFloat(data[9].substring(1));

       //actual inventory
       String item_id = data[2];
       float price = Float.parseFloat(data[8].substring(1));
       String name = data[1];
       int quantity = Integer.parseInt(data[4]);

      //sqlStatement that holds or sequel command
       sqlStatement = "INSERT INTO inventory VALUES ('"+item_id+"','"+price+"','"+name+"','"+quantity+"');";
      
       System.out.println(sqlStatement);
       stmt.executeUpdate(sqlStatement);
       lineText = lineReader.readLine();
       count++;
       }
       lineReader.close();

    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
      System.out.println("Connection NOT Closed.");
    }//end try catch
  }//end main
}//end Class
