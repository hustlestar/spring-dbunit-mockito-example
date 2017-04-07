package com.hustlestar.airbnb.dao.orcl;

import com.hustlestar.airbnb.dao.UserDAO;
import com.hustlestar.airbnb.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yauheni_Malashchytsk on 4/3/2017.
 */
@Repository
public class UserOracle extends AbstractDAO implements UserDAO {

    public static final String LAST_NAME = "U_LAST_NAME";
    public static final String FIRST_NAME = "U_FIRST_NAME";
    public static final String ID = "U_ID";
    public static final String EMAIL = "U_EMAIL";
    public static final String LOGIN = "U_LOGIN";

    public static final String GET_USER =
            "SELECT * FROM USERS WHERE U_LOGIN=? AND U_PASSWORD=?";
    public static final String INSERT_USER =
            "INSERT INTO USERS" +
                    " (U_ID, U_LOGIN, U_EMAIL, U_PASSWORD, U_FIRST_NAME, U_LAST_NAME)" +
                    " VALUES (null, ?, ?, ?, ?, ?)";
    public static final String UPDATE_PASSWORD =
            "UPDATE USERS SET U_PASSWORD=? WHERE U_LOGIN = ?";

    //ResourceBundle bundle = ResourceBundle.getBundle("");

    //String sql = bundle.getString();
    public void addNewUser(User user) {
        getJdbcTemplate().update(
                INSERT_USER,
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName());
        user.setId(1);
    }

    public User getUser(final String login, String password) {
        return getJdbcTemplate().queryForObject(
                GET_USER,
                new Object[]{login, password},
                new RowMapper<User>() {
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setId(resultSet.getInt(ID));
                        user.setLogin(resultSet.getString(LOGIN));
                        user.setEmail(resultSet.getString(EMAIL));
                        user.setFirstName(resultSet.getString(FIRST_NAME));
                        user.setLastName(resultSet.getString(LAST_NAME));
                        return user;
                    }
                }
        );
    }

    public boolean updateUserPassword(String login, String newPassword) {
        return getJdbcTemplate().update(
                UPDATE_PASSWORD,
                newPassword,
                login) > 0;
    }
}
