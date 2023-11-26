package controllers;

import models.Karya;

public class Middleware {
    public static void checkKarya(String profile, Karya karya) {
        if (!profile.equals(karya.user.username)) {
            Application.home();
        }

    }
}