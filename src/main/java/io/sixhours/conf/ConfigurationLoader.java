package io.sixhours.conf;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

/**
 * Loads configuration from the {@code application.yml} file on the classpath.
 *
 * @author Igor Bolic
 */
public enum ConfigurationLoader {
    instance;

    private final Yaml yaml = new Yaml(new Constructor(Configuration.class));
    private Configuration configuration;

    ConfigurationLoader() {
        load();
    }

    private void load() {
        InputStream inputStream = ConfigurationLoader.class.getResourceAsStream("/application.yml");

        this.configuration = Configuration.class.cast(yaml.load(inputStream));
    }

    public Configuration configuration() {
        return this.configuration;
    }
}
