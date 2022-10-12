package com.ntobeko.kiokoa.models;

public class Credential {
    private String siteName, userName, password;

    public Credential(String siteName, String userName, String password) {
        this.siteName = siteName;
        this.userName = userName;
        this.password = password;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
