package sn;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aggregator
{
    public static void main(String[] args)
    {
        //User user1 = new User(1);
        //System.out.println(user1.getUserType());
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            System.out.println(statement.executeQuery("select * from users"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getString()
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            InitialContext io = new InitialContext();
            DataSource ds = (DataSource) io.lookup("jdbc/Library");

            //Context initContext = new InitialContext();
            //Context webContext = (Context)initContext.lookup("java:/comp/env");
            //DataSource ds = (DataSource) webContext.lookup("jdbc/lessons");

            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                sb.append("<h1>" + resultSet.getString("id") + "<h1>");
                sb.append("<h1>" + resultSet.getString("type") + "<h1>");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
