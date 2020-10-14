package com.autos.UI.dashboards;

public class UserContext {
    public static String user;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        UserContext.user = user;
    }
}
