package com.example.jpa;

public class UserMain {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User caramiUser = new User("carami","carami@exam.com");

        userDAO.createUser(caramiUser);


    }
}
