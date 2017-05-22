package io.sixhours.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Database utility class tests.
 *
 * @author Igor Bolic
 */
public class DatabaseTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void thatConstructorThrowsException() throws Exception {
        Constructor<?> constructor = Database.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        thrown.expect(InvocationTargetException.class);
        thrown.expectCause(isA(AssertionError.class));

        constructor.newInstance(null);
    }

    @Test
    public void thatDataSourceIsInitialized() throws Exception {
        Field field = Database.class.getDeclaredField("dataSource");
        field.setAccessible(true);
        Object value = field.get(null);

        assertThat(value, notNullValue());
        assertThat(value, instanceOf(DataSource.class));
    }

}