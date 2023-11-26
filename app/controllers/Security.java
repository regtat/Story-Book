package controllers;

import models.*;

public class Security extends controllers.Secure.Security {
    public static boolean authenticate(String username, String password) {
        boolean boleh = false;

        User x = User.find("username=?1 and password=?2", username, password).first();

        if(x != null){
            boleh = true;
        }

        return boleh;
    }

    public static void onDisconnected() {
        Application.home();
    }

    public static void onAuthenticated() {
        KaryaApplication.index();
    }

    public static boolean check(String profile) {
        if ("admin".equals(profile))  {
            return User.find("username=?1", connected()).<User>first().isAdmin;
        }

        return false;
    }

    public static String dapatkanNama() {
        String username = Security.session.get("username");
        return User.find("username=?1", username).<User>first().fullname;
    }

    public static boolean isLoggedIn() {
        if (Security.session.get("username") != null) {
            return true;
        }

        return false;
    }
    
}