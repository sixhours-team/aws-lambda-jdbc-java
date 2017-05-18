package io.sixhours.conf;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Configuration loader tests.
 *
 * @author Igor Bolic
 */
public class ConfigurationHolderTest {

    @Test
    public void thatConfigurationValuesAreLoaded() throws Exception {
        Configuration configuration = ConfigurationHolder.instance.configuration();

        assertThat(configuration, notNullValue());
        assertThat(configuration.getDatasource(), notNullValue());
        assertThat(configuration.getDatasource().getUrl(), is("jdbc:mysql://test-host:3306/test-db"));
        assertThat(configuration.getDatasource().getUsername(), is("test-username"));
        assertThat(configuration.getDatasource().getPassword(), is("test-password"));
    }

}