package com.example;

import java.sql.*;
import java.math.*;
class ClouderaJDBCHiveExample {
  static String JDBCDriver = "com.cloudera.hive.jdbc4.HS2Driver";
  static String ConnectionURL = "jdbc:hive2://host-10-17-101-195.coe.cloudera.com:10000";
  public static void main(String[] args) {
    Connection con = null; Statement stmt = null; ResultSet rs = null;
    String query = "select * from $table";
    try {
      Class.forName(JDBCDriver);
      con = DriverManager.getConnection(ConnectionURL);
      stmt = con.createStatement();
      stmt.execute("DROP TABLE IF EXISTS hive_jdbc_test");
      stmt.execute("CREATE TABLE hive_jdbc_test (a int, b string)");
      stmt.execute("INSERT OVERWRITE TABLE hive_jdbc_test VALUES (1, 'test'), (2, 'another test')");
      rs = stmt.executeQuery("SELECT * FROM hive_jdbc_test");
 
      System.out.printf("%20s%20s\r\n", "a", "b");
      while(rs.next()) {
        System.out.printf("%20s%20s\r\n", rs.getString(1), rs.getString(2)); }
    } catch (SQLException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {if (rs != null) {
        rs.close();
      }
      } catch (SQLException se1) {}
      try { if (stmt!=null) {stmt.close();}}
      catch (SQLException se2) {}
      try { if (con!=null) {con.close();}}
      catch (SQLException se3) {se3.printStackTrace();}
    }
  }
}
