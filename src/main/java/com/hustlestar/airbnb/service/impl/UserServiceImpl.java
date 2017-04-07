package com.hustlestar.airbnb.service.impl;

import com.hustlestar.airbnb.dao.UserDAO;
import com.hustlestar.airbnb.domain.User;
import com.hustlestar.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    public User registerUser(String login, String email, String password, String password2) {

        User user = new User();
        userDAO.addNewUser(user);

        return user;
    }

    public User authorizeUser(String login, String password) {
        return userDAO.getUser(login, password);
    }

    public boolean changePassword(String login, String oldPassword, String newPassword, String newPassword2) {
        return userDAO.updateUserPassword(login, newPassword);
    }

    public String restorePassword(String login, String email) {
        String newPassword = "some";
        if (userDAO.updateUserPassword(login, newPassword)) {
            return newPassword;
        }
        return null;
    }

    public User editProfile() {
        return null;
    }
}
