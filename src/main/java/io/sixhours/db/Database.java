package io.sixhours.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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

    private static final HikariDataSource dataSource;

    static {
        Configuration configuration = ConfigurationHolder.instance.configuration();
        Configuration.DataSource props = configuration.getDatasource();

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(props.getDriverClassName());
        config.setJdbcUrl(props.getUrl());
        config.setUsername(props.getUsername());
        config.setPassword(props.getPassword());

        dataSource = new HikariDataSource(config);
    }

    public static Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
