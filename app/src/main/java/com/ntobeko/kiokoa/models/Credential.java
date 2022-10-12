package com.ntobeko.kiokoa.models;

public class Credential {
    private String siteName, userName, password;

    public Credential(String siteName, String userName, String password) {
        this.siteName = siteName;
        this.userName = userName;
        this.password = password;
    }
}
