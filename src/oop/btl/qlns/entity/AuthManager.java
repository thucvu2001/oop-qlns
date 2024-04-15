package oop.btl.qlns.entity;

import java.util.ArrayList;
import java.util.List;

public class AuthManager {
    private static List<Auth> auths;
    private static boolean loggedIn;
    private static String loggedInUsername;

    public AuthManager() {
        this.auths = new ArrayList<>();
        this.loggedIn = false;
        this.loggedInUsername = null;
    }

    public boolean register(String username, String password) {
        if (password.isBlank()) {
            System.out.println("=====> password cannot be null");
            return false;
        }
        Auth auth = new Auth(username, password);
        for (Auth a : auths) {
            if (a.getUsername().equals(username)) {
                System.out.println("=====> username already exists");
                return false;
            }
        }
        auths.add(auth);
        return true;
    }

    public boolean login(String username, String password) {
        for (Auth auth : auths) {
            if (auth.getUsername().equals(username) && auth.getPassword().equals(password)) {
                this.loggedIn = true;
                this.loggedInUsername = username;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.loggedIn = false;
        this.loggedInUsername = null;
    }
}
