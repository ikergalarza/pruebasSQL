package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author sqlitetutorial.net
 */
public class InsertData
{

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect()
    {
        // SQLite connection string
        String name = "HelloWorld.db";
        String url = "jdbc:sqlite:"+name;

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
            //como lo utilizamos muchas veces, le hacemos un connect.
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, double capacity)
    {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";
        //ponemos ? que luego vamos a rellenar

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                        //creamos un preparesStatement para hacerlo de forma más segura, para no encontrarnos cosas maliciosas
                )
        {
            pstmt.setString(1, name);
            //1 implica la primera '?'
            pstmt.setDouble(2, capacity);
            //2 implica la segunda '?'
            pstmt.executeUpdate();

            //en la forma no segura, todos los datos van al stream de forma muy poco segura
            //en la segunda forma, mandan valores no concretos que después se cambian y más tarde se van a validar.
            //al final siempre hay que CERRAR LA CONEXIÓN

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        InsertData app = new InsertData();

        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }

}

