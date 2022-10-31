package com.firstSBApp.app;

import database.Database;
import jwt.JwtProvider;
import model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Routes {

    @PostMapping("/login")
    String login(@RequestBody User user) {
        System.out.println("userName from postman: " + user.getUserName());

        Database db = new Database();
        Boolean isUserInDB = db.isInDB(user.getUserName());
        if(!isUserInDB) return "not registered";

        User loggedUser = user;
        String newJwt = new JwtProvider().createToken(loggedUser);
        return newJwt;
    }
}