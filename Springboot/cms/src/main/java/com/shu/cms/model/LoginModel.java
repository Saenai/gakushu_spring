package com.shu.cms.model;

public class LoginModel {
    String id;
    String pw;
    String role;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String encryptedPw() {

        // TODO

        return pw;
    }
}
