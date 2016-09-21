package sn;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLHelper
{
    private static SQLHelper instance;
    private static Statement statement;


    public static void test()
    {
        try {
            System.out.println(statement.executeQuery("select * from books"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private SQLHelper()
    {
        try
        {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/Library");
            Connection connection = ds.getConnection();
            SQLHelper.statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static SQLHelper getInstance()
    {
        synchronized (SQLHelper.class)
        {
            if (instance == null) {
                instance = new SQLHelper();
            }
        }
        return instance;
    }

    public static void execute(String command)
    {
        try {
            statement.execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<String>> executeQuery(String command)
    {
        Map<String, List<String>> table = new HashMap<>();

        try {
            ResultSet rs = statement.executeQuery(command);
            ResultSetMetaData data = rs.getMetaData();
            int columnsCount = data.getColumnCount();

            while (rs.next()) {
                for (int columnNumber = 1; columnNumber <= columnsCount; columnNumber++) {
                    String tableName = data.getTableName(columnNumber);
                    if (!table.containsKey(tableName)) {
                        List<String> values = new ArrayList<>();
                        table.put(tableName, values);
                    }
                    table.get(tableName).add(rs.getString(columnNumber));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return table;
    }
 }
