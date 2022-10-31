package model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String role;

    public User(int id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
