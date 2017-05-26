package io.sixhours.db;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.*;
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
        Constructor constructor = Database.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        thrown.expect(InvocationTargetException.class);
        thrown.expectCause(isA(AssertionError.class));

        constructor.newInstance();
    }

    @Test
    public void thatDataSourceIsInitialized() throws Exception {
        Field field = Database.class.getDeclaredField("dataSource");
        field.setAccessible(true);
        Object value = field.get(null);

        assertThat(value, notNullValue());
        assertThat(value, instanceOf(HikariDataSource.class));
        assertThat(HikariDataSource.class.cast(value).getDriverClassName(), is("org.h2.Driver"));
        assertThat(HikariDataSource.class.cast(value).getJdbcUrl(), is("jdbc:h2:mem:test"));
        assertThat(HikariDataSource.class.cast(value).getUsername(), is("test-username"));
        assertThat(HikariDataSource.class.cast(value).getPassword(), is("test-password"));
    }

}