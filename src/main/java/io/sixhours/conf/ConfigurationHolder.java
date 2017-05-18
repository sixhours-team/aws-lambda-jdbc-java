package io.sixhours.conf;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

/**
 * Holds a configuration loaded from the {@code application.yml} file on the classpath.
 *
 * @author Igor Bolic
 */
public enum ConfigurationHolder {
    instance;

    private final Yaml yaml = new Yaml(new Constructor(Configuration.class));
    private Configuration configuration;

    ConfigurationHolder() {
        load();
    }

    private void load() {
        InputStream inputStream = ConfigurationHolder.class.getResourceAsStream("/application.yml");

        this.configuration = Configuration.class.cast(yaml.load(inputStream));
    }

    public Configuration configuration() {
        return this.configuration;
    }
}
