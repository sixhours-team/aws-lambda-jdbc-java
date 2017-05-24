package io.sixhours;

import io.sixhours.db.Database;
import org.dbunit.DataSourceBasedDBTestCase;
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

    @Override
    protected void setUp() throws Exception {
        DataSource dataSource = getDataSource();
        InputStream inputStream = AbstractIntegrationTest.class.getResourceAsStream("/db/schema.sql");

        RunScript.execute(dataSource.getConnection(), new InputStreamReader(inputStream));
        super.setUp();
    }

    @Override
    protected DataSource getDataSource() {
        return Database.dataSource();
    }
}
