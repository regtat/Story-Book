package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void home() {
        String username = Security.session.get("username");
        User user = User.find("username=?1", username).first();

        if (user == null) {
            String name = "";
            render(name);
        } else {
            String name = " " + user.fullname;
            render(name);
        }

    }

    public static void home(String message) {
        String username = Security.session.get("username");
        User user = User.find("username=?1", username).first();

        if (user == null) {
            String name = "";
            render(name);
        } else {
            String name = " " + user.fullname;
            render(name, message);
        }

    }

    public static void signup() {
        render();
    }

    public static void signup(boolean isSignedUp) {
        render(isSignedUp);
    }

    public static void signedup(User user) {
        user.save();
        signup(true);
    }

}