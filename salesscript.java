

import java.sql.*;
import java.io.*;
/*
CSCE 315
9-27-2021 Lab
 */
public class jdbcpostgreSQL {

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
     String csvFilePath = "FirstWeekSales.csv";
     String lineText = null;

    //Connecting to the database
    try {
        conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }

      //parsing sales data
      System.out.println("Opened database successfully");
      BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
      lineReader.readLine();
      lineText = lineReader.readLine();
      String[] data = lineText.split(",");
      Statement stmt = conn.createStatement();
      int week = 1;
      String day = " ";
      int item_id = 0;
      int quantity = 0;
      float total = 0;
      int count = 0;
      String sqlStatement = "";
       while(lineText != null) {
       
       data = lineText.split(",");
       if(data.length == 0) {
        System.out.print("I triggered");
        lineText = lineReader.readLine();
        data = lineText.split(",");
       }
       if(data[0] != "") {
         day   = data[0];
         total = Float.parseFloat(data[4].substring(2));
       } else if (count > 0) {
         item_id  = Integer.parseInt(data[1]);
         quantity = Integer.parseInt(data[2]);
       }
       count += 1;
       // Inserting sales data into database.
       if (count > 1) {
       sqlStatement = "INSERT INTO sales_raw VALUES ('"+week+"','"+day+"','"+item_id+"', '"+quantity+"','"+total+"');";
       stmt.executeUpdate(sqlStatement);
       }
      
       System.out.println(sqlStatement);

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
