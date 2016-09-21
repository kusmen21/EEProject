package sn;

import java.util.HashMap;
import java.util.Map;

public class User
{
    private long id;
    private UserType userType;
    private HashMap<String, String> info;

    public User(int id)
    {
        this.id = id;
        setUserType();
    }

    public void setUserType()
    {
        userType = UserType.valueOf(SQLHelper.executeQuery("SELECT (type) FROM users;").get("type").get(0));
    }

    public UserType getUserType()
    {
        return userType;
    }


    public Map getInfo()
    {
        return info;
    }

    public String getInfo(String key)
    {
        return null;
    }

    public void setInfo(Map<String, String> requestMap)
    {

    }


}
