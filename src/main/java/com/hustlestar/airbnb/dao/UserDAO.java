package com.hustlestar.airbnb.dao;

import com.hustlestar.airbnb.domain.User;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
public interface UserDAO {

    void addNewUser(User user);

    User getUser(String login, String password);

    boolean updateUserPassword(String login, String newPassword);


}
