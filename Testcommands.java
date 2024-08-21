

import java.sql.*;
import java.io.*;
/*
CSCE 315
9-27-2021 Lab
 */
public class Testcommands {

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
     String csvFilePath = "week4.csv";
     String lineText = null;

    //Connecting to the database
    try {
        conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }

      System.out.println("Opened database successfully");
      Statement stmt = conn.createStatement();
      System.out.println();

      System.out.println("Number of entries in menu:");
       String sqlStatement2 = "SELECT COUNT(*) FROM menu;";
       ResultSet result2 = stmt.executeQuery(sqlStatement2);
       while (result2.next()) {
        System.out.println(result2.getString("Count"));
        }
      System.out.println();

      System.out.println("Menu Table:");
       sqlStatement2 =  "SELECT * FROM menu;";
       result2 = stmt.executeQuery(sqlStatement2);
       while (result2.next()) {
        System.out.println(result2.getString("bundle_id"));
        }
        System.out.println();

        System.out.println("Customer Orders Table:");
        sqlStatement2 =  "SELECT * FROM customer_orders;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("week"));
          System.out.print("-");
          System.out.print(result2.getString("item_id"));
          System.out.print("-");
          System.out.println(result2.getString("quantity"));
          }
          System.out.println();

        System.out.println("Inventory Table:");
        sqlStatement2 =  "SELECT * FROM inventory;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("item_id"));
          System.out.print("-");
          System.out.print(result2.getString("price"));
          System.out.print("-");
          System.out.println(result2.getString("name"));
          }
          System.out.println();

        System.out.println("First three items in the menu table:");
        sqlStatement2 =  "SELECT * FROM menu LIMIT 3;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("menu_id"));
          System.out.print("-");
          System.out.println(result2.getString("bundle_id"));
          }
          System.out.println();

        System.out.println("First three items in the customer orders table:");
        sqlStatement2 =  "SELECT * FROM customer_orders LIMIT 3;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("week"));
          System.out.print("-");
          System.out.print(result2.getString("day"));
          System.out.print("-");
          System.out.print(result2.getString("item_id"));
          System.out.print("-");
          System.out.println(result2.getString("quantity"));
          }
          System.out.println();

          System.out.println("First three items in the inventory table:");
          sqlStatement2 =  "SELECT * FROM inventory LIMIT 3;";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.print(result2.getString("price"));
            System.out.print("-");
            System.out.print(result2.getString("quantity"));
            System.out.print("-");
            System.out.println(result2.getString("name"));
            }
            System.out.println();

          System.out.println("All of week 2 from the customer order table:");
          sqlStatement2 =  "SELECT * from customer_orders WHERE week=2;";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("week"));
            System.out.print("-");
            System.out.print(result2.getString("day"));
            System.out.print("-");
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.println(result2.getString("quantity"));
            }
            System.out.println();

          System.out.println("All of week 4 from the customer order table:");
          sqlStatement2 =  "SELECT * from customer_orders WHERE week=4;";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("week"));
            System.out.print("-");
            System.out.print(result2.getString("day"));
            System.out.print("-");
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.println(result2.getString("quantity"));
            }
            System.out.println();

          System.out.println("Information regarding the ranch inventory:");
          sqlStatement2 = "SELECT * from inventory WHERE name='Ranch';";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.print(result2.getString("price"));
            System.out.print("-");
            System.out.print(result2.getString("quantity"));
            System.out.print("-");
            System.out.println(result2.getString("name"));
            }
            System.out.println();

          System.out.println("Information regarding the flour inventory:");
          sqlStatement2 = "SELECT * from inventory WHERE name='flour';";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.print(result2.getString("price"));
            System.out.print("-");
            System.out.print(result2.getString("quantity"));
            System.out.print("-");
            System.out.println(result2.getString("name"));
            }
            System.out.println();

          System.out.println("Information regarding the straw inventory:");
          sqlStatement2 = "SELECT * from inventory WHERE name='Straw';";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.print(result2.getString("price"));
            System.out.print("-");
            System.out.print(result2.getString("quantity"));
            System.out.print("-");
            System.out.println(result2.getString("name"));
            }
            System.out.println();

          System.out.println("Information regarding the bottled root beer inventory:");
          sqlStatement2 = "SELECT * from inventory WHERE name='Bottled Root Beer';";
          result2 = stmt.executeQuery(sqlStatement2);
          while (result2.next()) {
            System.out.print(result2.getString("item_id"));
            System.out.print("-");
            System.out.print(result2.getString("price"));
            System.out.print("-");
            System.out.print(result2.getString("quantity"));
            System.out.print("-");
            System.out.println(result2.getString("name"));
            }
            System.out.println();

        System.out.println("Information regarding menu item 501:");
        sqlStatement2 =  "SELECT * from menu WHERE menu_id=507;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("menu_id"));
          System.out.print("_");
          System.out.println(result2.getString("bundle_id"));
          }
          System.out.println();

        System.out.println("Information regarding menu item 516:");
        sqlStatement2 =  "SELECT * from menu WHERE menu_id=516;";
        result2 = stmt.executeQuery(sqlStatement2);
        while (result2.next()) {
          System.out.print(result2.getString("menu_id"));
          System.out.print("_");
          System.out.println(result2.getString("bundle_id"));
          }
          System.out.println();

    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
      System.out.println("Connection NOT Closed.");
    }//end try catch
  }//end main
}//end Class
