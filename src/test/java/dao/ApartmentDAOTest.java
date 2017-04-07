package dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.hustlestar.airbnb.dao.ApartmentDAO;
import com.hustlestar.airbnb.domain.Apartment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

/**
 * Created by Yauheni_Malashchytsk on 4/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
//@Sql(value = "/scripts/database.sql")
//@DatabaseSetup(value = {"/datasets/countries/countriesSMPL.xml", "/datasets/cities/citiesSMPL.xml"}, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(value = "/datasets/apartments/getAvailableApartmentsTestSMPL.xml", type = DatabaseOperation.DELETE_ALL)
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Test
    @DatabaseSetup(value = "/datasets/apartments/getAvailableApartmentsTestSMPL.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void getAvailableApartmentsTest() throws Exception {
        List<Apartment> apartments = apartmentDAO.getAvailableApartments();
        Assert.assertEquals(13, apartments.size());

    }

    @Test
    @DatabaseSetup(value = "/datasets/apartments/findApartmentTestSMPL.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void findApartmentTest() throws Exception {
        List<Apartment> apartments = apartmentDAO.findApartment("flat");
        Assert.assertEquals(3, apartments.size());
        apartments = apartmentDAO.findApartment("room");
        Assert.assertEquals(1, apartments.size());

    }

    @Test
    @DatabaseSetup(value = "/datasets/apartments/getApartmentByCriteriaTestSMPL.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void getApartmentByCriteriaTest() throws Exception {
        List<Apartment> apartments = apartmentDAO.getApartmentByCriteria();
        Assert.assertEquals(3, apartments.size());

    }


}
