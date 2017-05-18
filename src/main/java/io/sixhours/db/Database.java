package io.sixhours.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import io.sixhours.conf.Configuration;
import io.sixhours.conf.ConfigurationLoader;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Encapsulates creation of {@link DataSource} connection.
 *
 * @author Igor Bolic
 */
public class Database {

    private static final DataSource dataSource;

    static {
        Configuration configuration = ConfigurationLoader.instance.configuration();
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
