package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author sqlitetutorial.net
 */
public class HelloWorld
{
    /**
     * Connect to a sample database
     */
    public static void connect()
    {
        Connection conn = null;

        // db parameters
        String path = "myDB.db";
        String url = "jdbc:sqlite:" + path;
        //:sqlite nos indica el tipo de BD
        /* vamos a implemetar las clases que están dentro del .jar
una simple conexión, para eso necesitaremos el parth del archivo,
 */
        try
        {
            // create a connection to the database
            //pulsando la tecla ctrl puedo ver lo que quiera dentro del código.
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e)
        {
            System.out.println("Cannot connect to " + url + "database");
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connect();
    }
}
