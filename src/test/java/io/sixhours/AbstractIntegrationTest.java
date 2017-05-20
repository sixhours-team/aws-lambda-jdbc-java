package io.sixhours;

import io.sixhours.conf.Configuration;
import io.sixhours.conf.ConfigurationHolder;
import org.dbunit.DataSourceBasedDBTestCase;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Base class for integration tests configuration.
 *
 * @author Igor Bolic
 */
public abstract class AbstractIntegrationTest extends DataSourceBasedDBTestCase {

    private final Configuration configuration = ConfigurationHolder.instance.configuration();

    @Override
    protected void setUp() throws Exception {
        DataSource dataSource = getDataSource();
        InputStream inputStream = AbstractIntegrationTest.class.getResourceAsStream("/db/schema.sql");

        RunScript.execute(dataSource.getConnection(), new InputStreamReader(inputStream));
        super.setUp();
    }

    @Override
    protected DataSource getDataSource() {
        Configuration.DataSource props = configuration.getDatasource();

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(props.getUrl());
        return dataSource;
    }
}
