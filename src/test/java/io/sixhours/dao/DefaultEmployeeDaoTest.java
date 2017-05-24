package io.sixhours.dao;

import io.sixhours.AbstractIntegrationTest;
import io.sixhours.pojo.Employee;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Employee DAO tests.
 *
 * @author Igor Bolic
 */
public class DefaultEmployeeDaoTest extends AbstractIntegrationTest {

    private final EmployeeDao service = DefaultEmployeeDao.instance;

    public void testThatFindReturnsPersonList() throws Exception {
        List<Employee> employees = service.findAll();

        assertThat(employees, notNullValue());
        assertThat(employees.size(), is(4));
        assertThat(employees.get(2), notNullValue());
        assertThat(employees.get(2).getId(), is(3));
        assertThat(employees.get(2).getFirstName(), is("Ami"));
        assertThat(employees.get(2).getLastName(), is("Johnson"));
        assertThat(employees.get(2).getAddress(), is("123 Sullivan St"));
        assertThat(employees.get(2).getCity(), is("Boston"));
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        InputStream inputStream = AbstractIntegrationTest.class.getResourceAsStream("/db/data.xml");
        return new FlatXmlDataSetBuilder().build(inputStream);
    }
}