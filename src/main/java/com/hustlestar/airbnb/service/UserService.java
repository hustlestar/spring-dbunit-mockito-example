package com.hustlestar.airbnb.service;

import com.hustlestar.airbnb.domain.User;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
public interface UserService {

    User registerUser(String login, String email, String password, String password2);

    User authorizeUser(String login, String password);

    boolean changePassword(String login, String oldPassword, String newPassword, String newPassword2);

    String restorePassword(String login, String email);

    User editProfile();

}
