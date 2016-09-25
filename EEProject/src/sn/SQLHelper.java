package sn;

import sn.exception.NullValueException;
import sn.exception.UnexpectedException;
import sn.exception.UniqueValueException;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;


public class SQLHelper
{
    private static Statement statement;

    static
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

    private SQLHelper(){}

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
                    String columnName = data.getColumnName(columnNumber);
                    if (!table.containsKey(columnName)) {
                        List<String> values = new ArrayList<>();
                        table.put(columnName, values);
                    }
                    table.get(columnName).add(rs.getString(columnNumber));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return table;
    }

    public static String getResultAsString(String command)
    {
        Map<String, List<String>> table = executeQuery(command);
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, List<String>> pair : table.entrySet())
        {
            sb.append(pair.getKey()).append(" = ").append(pair.getValue().toString()).append("\n\r");
        }
        return sb.toString();
    }

    public static boolean isSomethingFound(String command)
    {
        Map<String, List<String>> table = executeQuery(command);
        return !table.isEmpty();
    }

    public static void addUser(String fname, String email, String password)
            throws NullValueException, UniqueValueException, UnexpectedException
    {
        try
        {
            if (    fname != null & !fname.equals("") &
                    password != null & !password.equals("") &
                    email != null & !email.equals(""))
            {
                if (isSomethingFound("SELECT (id) FROM users where email = '" + email + "'"))
                {
                    throw new UniqueValueException();
                }

                SQLHelper.execute("INSERT INTO users (type, email, password) VALUES " +
                        "('USER', '" + email + "', '" + password + "')");

                int id = Integer.parseInt(SQLHelper.executeQuery
                        ("SELECT (id) FROM users WHERE email = '" + email + "'").get("id").get(0));

                SQLHelper.execute("INSERT INTO info (info_id, fname) VALUES " +
                        "('" + id +  "', '" + fname + "')");
            }
            else
            {
                throw new NullValueException();
            }
        }catch (RuntimeException e)
        {
            throw new UnexpectedException();
        }


    }
 }
