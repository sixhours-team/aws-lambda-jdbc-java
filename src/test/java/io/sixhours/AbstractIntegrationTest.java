package io.sixhours;

import io.sixhours.conf.Configuration;
import io.sixhours.conf.ConfigurationHolder;
import org.dbunit.JdbcBasedDBTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.h2.tools.RunScript;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Base class for integration tests configuration.
 *
 * @author Igor Bolic
 */
public abstract class AbstractIntegrationTest extends JdbcBasedDBTestCase {

    private final Configuration.DataSource props = ConfigurationHolder.instance
            .configuration()
            .getDatasource();

    @Override
    protected void setUp() throws Exception {
        IDatabaseConnection databaseConnection = getConnection();
        InputStream inputStream = AbstractIntegrationTest.class.getResourceAsStream("/db/schema.sql");

        RunScript.execute(databaseConnection.getConnection(), new InputStreamReader(inputStream));
        super.setUp();
    }

    @Override
    protected String getDriverClass() {
        return props.getDriverClassName();
    }

    @Override
    protected String getConnectionUrl() {
        return props.getUrl();
    }

    @Override
    protected String getUsername() {
        return props.getUsername();
    }

    @Override
    protected String getPassword() {
        return props.getPassword();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        InputStream inputStream = AbstractIntegrationTest.class.getResourceAsStream(dataSet());
        return new FlatXmlDataSetBuilder().build(inputStream);
    }

    protected abstract String dataSet();
}
