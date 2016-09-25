package sn;

import java.util.HashMap;
import java.util.List;
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

    private void setUserType()
    {
        Map<String, List<String>> map = SQLHelper.executeQuery("SELECT (type) FROM users WHERE id = " + id);
        List<String> list = map.get("type");
        String temp = list.get(0);

        if (temp.equalsIgnoreCase("admin")) {
            userType = UserType.ADMIN;
            return;
        }
        if (temp.equalsIgnoreCase("user")) {
            userType = UserType.USER;
            return;
        }
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
