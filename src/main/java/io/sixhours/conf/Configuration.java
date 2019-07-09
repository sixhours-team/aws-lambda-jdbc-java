package io.sixhours.conf;

import lombok.Data;

/**
 * Configuration properties.
 */
@Data
public class Configuration {

    DataSource datasource;

    @Data
    public static final class DataSource {
        String driverClassName;
        String url;
        String username;
        String password;
    }
}
