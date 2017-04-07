package com.hustlestar.airbnb.dao.orcl;

import com.hustlestar.airbnb.dao.ApartmentDAO;
import com.hustlestar.airbnb.domain.Apartment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yauheni_Malashchytsk on 4/4/2017.
 */
@Repository
public class ApartmentOracle extends AbstractDAO implements ApartmentDAO {

    private static final String ID = "A_ID";
    private static final String COUNTRY = "A_CO_ID";
    private static final String CITY = "A_CI_ID";
    private static final String ADDRESS = "A_ADDRESS";
    private static final String TITLE = "A_TITLE";

    public static final String GET_ALL_APARTMENTS =
            "SELECT * FROM APARTMENTS";
    public static final String FIND_APARTMENT_BY_TITLE =
            "SELECT * FROM APARTMENTS WHERE A_TITLE LIKE ?";

    public List<Apartment> getAvailableApartments() {
        return getJdbcTemplate().query(GET_ALL_APARTMENTS,
                new Object[]{},
                getRowMapper());
    }

    public List<Apartment> getApartmentByCriteria(String... params) {
        return null;
    }

    public List<Apartment> findApartment(String title) {
        return getJdbcTemplate().query(FIND_APARTMENT_BY_TITLE,
                new Object[]{"%"+title+"%"},
                getRowMapper());
    }

    private RowMapper<Apartment> getRowMapper() {
        return new RowMapper<Apartment>() {
            public Apartment mapRow(ResultSet resultSet, int i) throws SQLException {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getInt(ID));
                apartment.setCountry(resultSet.getInt(COUNTRY));
                apartment.setCity(resultSet.getInt(CITY));
                apartment.setAddress(resultSet.getString(ADDRESS));
                apartment.setTitle(resultSet.getString(TITLE));
                return apartment;
            }
        };
    }
}
