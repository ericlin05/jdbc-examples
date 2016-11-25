import java.sql.*;

public class TeradataJDBCExample
{
    // Name of the user able to create, drop, and manipulate tables
    public static String sUser = "vmtest";
    public static String sPassword = "vmtest";

    public static void main(String args[])
    throws ClassNotFoundException
    {
        // Creation of URL to be passed to the JDBC driver
        String url = "jdbc:teradata://localhost/database=vmtest,TMODE=ANSI,CHARSET=UTF8";
        String query = "SELECT * FROM test";

        try
        {
            // Loading the Teradata JDBC driver
            Class.forName("com.teradata.jdbc.TeraDriver");
            System.out.println(" JDBC driver loaded. \n");

            // Attempting to connect to Teradata
            System.out.println(" Attempting to connect to Teradata via" +
                               " the JDBC driver...");

            // Creating a connection object
            Connection con = DriverManager.getConnection(url, sUser, sPassword);
            System.out.println(" User " + sUser + " connected.");
            System.out.println(" Connection to Teradata established. \n");

            try
            {
                // Creating a statement object from an active connection
                Statement stmt = con.createStatement();
                System.out.println(" Statement object created. \n");

                try
                {
                    ResultSet rset = stmt.executeQuery(query);
		
                    while (rset.next()) {
                        // retrieve and display first column value
                        System.out.println("Column 1: " + rset.getInt(1));
                        System.out.println("Column 2: " + rset.getTimestamp(2));
                    }
                }
                finally
                {
                    stmt.close();
                }
            }
            finally
            {
                con.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println();
            System.out.println("*** SQLException caught ***");

            while (ex != null)
            {
                System.out.println(" Error code: " + ex.getErrorCode());
                System.out.println(" SQL State: " + ex.getSQLState());
                System.out.println(" Message: " + ex.getMessage());
                ex.printStackTrace();
                System.out.println();
                ex = ex.getNextException();
            }

            throw new IllegalStateException ("Sample failed.") ;
        }
    }
}
