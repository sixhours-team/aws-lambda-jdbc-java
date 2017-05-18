package io.sixhours.conf;

import lombok.Data;

/**
 * Configuration properties.
 *
 * @author Igor Bolic
 */
@Data
public class Configuration {

    DataSource datasource;

    @Data
    public static final class DataSource {
        private String url;
        private String username;
        private String password;
    }
}
