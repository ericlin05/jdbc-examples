package com.example;

import java.sql.*;
import java.math.*;

class ClouderaJDBCImpalaExample {
  static String JDBCDriver = "com.cloudera.impala.jdbc41.Driver";
  static String ConnectionURL = "jdbc:impala://host-10-17-101-197.coe.cloudera.com:21050";
  public static void main(String[] args) {
    Connection con = null; Statement stmt = null; ResultSet rs = null;
    try {
      Class.forName(JDBCDriver);
      con = DriverManager.getConnection(ConnectionURL);
      stmt = con.createStatement();
      stmt.execute("DROP TABLE IF EXISTS impala_jdbc_test");
      stmt.execute("CREATE TABLE impala_jdbc_test (col1 int, col2 string)");
      stmt.execute("INSERT OVERWRITE TABLE impala_jdbc_test VALUES (1, 'col1 value'), (2, 'col2 value')");
      rs = stmt.executeQuery("SELECT * FROM impala_jdbc_test");
 
      System.out.printf("%20s%20s\r\n", "col1", "col2");
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
