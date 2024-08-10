package com.andreidodu.andreitest.constants;

public interface CucumberConfigurationValues {
    String GLUE = "com.andreidodu.andreitest.step";
    String CUCUMBER_CONFIG = "com.andreidodu.andreitest.configuration";
    String FEATURES_SEQUENTIAL = "src/test/resources/sequential-features";
    String FEATURES_PARALLEL = "src/test/resources/parallel-features";
    String PLUGIN_PRETTY = "pretty";
    String PLUGIN_JSON_TARGET = "json:target/cucumber.json";
}