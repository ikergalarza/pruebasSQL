package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class CreateTable
{


    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable()
    {
        // SQLite connection string
        String name = "HelloWorld.db";
        String url = "jdbc:sqlite:" + name;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    capacity real\n"
                + ");";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        Statement stmt = conn.createStatement()
                        //a raiz de la conexión creo un statement
                )
        {
            // create a new table
            //al principio el statement está vacío
            stmt.execute(sql);
            //hacemos un statement con el código sql
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        createNewTable();
    }

}
