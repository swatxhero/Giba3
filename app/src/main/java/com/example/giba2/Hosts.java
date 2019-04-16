package com.example.giba2;

public class Hosts {

    private String orgName;
    private String username;
    private String password;
    private String ein;
    private String email;

    public Hosts() {}

    public Hosts(String orgName, String username, String password,
                 String ein, String email) {
        this.orgName = orgName;
        this.username = username;
        this.password = password;
        this.ein = ein;
        this.email = email;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
