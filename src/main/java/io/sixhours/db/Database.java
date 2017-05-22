package io.sixhours.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import io.sixhours.conf.Configuration;
import io.sixhours.conf.ConfigurationHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Encapsulates creation of {@link DataSource} connection.
 *
 * @author Igor Bolic
 */
public final class Database {

    private Database() {
        throw new AssertionError();
    }

    private static final DataSource dataSource;

    static {
        Configuration configuration = ConfigurationHolder.instance.configuration();
        Configuration.DataSource props = configuration.getDatasource();

        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(props.getUrl());
        ds.setUser(props.getUsername());
        ds.setPassword(props.getPassword());

        dataSource = ds;
    }

    public static Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
