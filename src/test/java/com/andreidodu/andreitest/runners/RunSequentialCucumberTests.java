package com.andreidodu.andreitest.runners;


import com.andreidodu.andreitest.constants.CucumberConfigurationValues;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;


@Slf4j
@CucumberOptions(
        plugin = {CucumberConfigurationValues.PLUGIN_PRETTY, CucumberConfigurationValues.PLUGIN_JSON_TARGET},
        glue = {CucumberConfigurationValues.GLUE, CucumberConfigurationValues.CUCUMBER_CONFIG},
        features = CucumberConfigurationValues.FEATURES_SEQUENTIAL)
@Component
public class RunSequentialCucumberTests extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws GitAPIException, IOException {
    }

    @PostConstruct
    public void postConstruct() throws GitAPIException, IOException {
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
    }

    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        super.tearDownClass();
    }

}