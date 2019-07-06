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
        final Constructor constructor = Database.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        thrown.expect(InvocationTargetException.class);
        thrown.expectCause(isA(AssertionError.class));

        constructor.newInstance();
    }

    @Test
    public void thatDataSourceIsInitialized() throws Exception {
        final Field field = Database.class.getDeclaredField("dataSource");
        field.setAccessible(true);
        final Object value = field.get(null);

        assertThat(value, notNullValue());
        assertThat(value, instanceOf(HikariDataSource.class));

        final HikariDataSource hikariDataSource = (HikariDataSource) value;
        assertThat(hikariDataSource.getDriverClassName(), is("org.h2.Driver"));
        assertThat(hikariDataSource.getJdbcUrl(), is("jdbc:h2:mem:test"));
        assertThat(hikariDataSource.getUsername(), is("test-username"));
        assertThat(hikariDataSource.getPassword(), is("test-password"));
    }

}