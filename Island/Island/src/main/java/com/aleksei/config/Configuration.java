package com.aleksei.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

import static java.util.Optional.ofNullable;

public class Configuration {
    public static final Config ROOT = loadRoot();

    private static Config loadRoot() {
        return ofNullable(System.getProperty("config.type")).map(
                Configuration::apply
        ).map(config -> config.withFallback(ConfigFactory.parseResources("application.conf"))).orElseGet(ConfigFactory::load);
    }

    private static Config apply(String type) {
        return switch (type) {
            case "file" ->
                    ConfigFactory.parseFile(new File(ofNullable(System.getProperty("config.location")).orElse("application.conf")));
            case "resource" ->
                    ConfigFactory.parseResources(ofNullable(System.getProperty("config.location")).orElse("application.conf"));
            default -> null;
        };
    }
}
