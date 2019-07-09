package io.sixhours.conf;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

/**
 * Holds a configuration loaded from the {@code application.yml} file on the classpath.
 */
public enum ConfigurationHolder {
    INSTANCE;

    private final Yaml yaml = new Yaml(new Constructor(Configuration.class));
    private final Configuration configuration = load();

    private Configuration load() {
        final InputStream inputStream = ConfigurationHolder.class.getResourceAsStream("/application.yml");

        return yaml.load(inputStream);
    }

    public Configuration configuration() {
        return this.configuration;
    }
}
