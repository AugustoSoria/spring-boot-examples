package database;

import model.User;

import java.util.Objects;

public class Database {
    User[] users = new User[2];

    public Database() {
        users[0] = new User(0, "Lucas23", "123asd", "admin");
        users[1] = new User(1, "Matias12", "123asd123", "dev");
    }


    public Boolean isInDB(String userName) {
        for (User element : users) {
            if (Objects.equals(element.getUserName(), userName)) return true;
        }
        return false;
    }

}

