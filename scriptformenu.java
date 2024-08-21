

import java.sql.*;
import java.io.*;
/*
CSCE 315
9-27-2021 Lab
 */
public class scriptformenu {

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
     String csvFilePath = "MenuKey.csv";
     String lineText = null;
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
      int counter = 0;
      BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
      lineReader.readLine();
      lineReader.readLine();
      lineText = lineReader.readLine();
      String[] data = lineText.split(",");
      Statement stmt = conn.createStatement();
      int menu_id = 0;
      String name = null;
      String desc = " ";
      float price = 0;
      //Bundle ID taken into consideration for the MenuKey
      String bundle_id = " ";
      String sqlStatement = "";
       while(lineText != null) {

        data = lineText.split(",");
         if(data.length < 6) {
            menu_id =  Integer.parseInt(data[1]);
            name = data[2];
            desc = data[3];
            price = Float.parseFloat(data[4].substring(1));
            bundle_id = data[9];
         } else if (data.length == 7) {
          menu_id =  Integer.parseInt(data[1]);
          name = data[2];
          desc = data[3];
          desc = "20 fingers 4 toasts, 4 fries, 8 sauces";
          price = Float.parseFloat(data[6].substring(1));
          bundle_id = data[9];

         } else if (data.length == 6) {
          menu_id =  Integer.parseInt(data[1]);
          name = data[2];
          desc = data[3];
          desc = "side, 1 finger";
          price = Float.parseFloat(data[5].substring(1));
          bundle_id = data[9];
         }
          else {
       //create a statement object
       menu_id =  Integer.parseInt(data[1]);
       name = data[2];
       desc = data[3];
       if(desc.equals("\"plus toast")) {
         desc = "plus toast, fries, potato salad, sauce, drink";
       }

       bundle_id = data[9];
       }
       sqlStatement = "INSERT INTO menu VALUES ('"+menu_id+"','"+bundle_id+"');";
      
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
