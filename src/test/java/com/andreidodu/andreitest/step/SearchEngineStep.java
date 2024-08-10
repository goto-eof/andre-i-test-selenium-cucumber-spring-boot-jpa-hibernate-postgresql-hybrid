package com.andreidodu.andreitest.step;

import com.andreidodu.andreitest.service.TagService;
import com.andreidodu.andreitest.util.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Durations;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@AllArgsConstructor
public class SearchEngineStep {

    private final HomePage homePage;
    private final By searchResultElement = By.cssSelector("#toys div.toy-wrapper p.toy-name");

    @BeforeClass
    public static void cleanAndPopulateDB() {
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        TagService springBean = (TagService) context.getBean("tagService");
        cleaningDatabase(springBean);
        saveDataOnDB(springBean);
    }

    public static void cleaningDatabase(TagService tagService) {
        log.info("cleaning database");
        if (!tagService.cleanTable()) {
            log.error("unable to clean database");
            Assert.fail();
        }
        log.info("database cleaned");
    }

    public static void saveDataOnDB(TagService tagService) {
        log.info("populating database");
        if (!tagService.populateTable()) {
            log.error("unable to populate database");
            Assert.fail();
        }
        log.info("database populated");
    }

    @Given("the status of the data has as value {string}")
    public void settingStatus(String status) {
        log.info("setting status to {}", status);

        log.info("updating item status with value {}", status);
        log.info("status updated successfully");
    }

    @When("searching in the search engine the project name {string}")
    public void callingRemoteService(String projectName) throws InterruptedException {
        log.info("searching for {}", projectName);
        try {
            this.homePage.goToHomePage()
                    .goToSearchBoxAndSearch(projectName);
        } catch (Exception e) {
            this.homePage.quit();
            fail();
        }
        log.info("service called successfully");
    }

    @Then("the result is {string}")
    public void checkResult(String result) throws InterruptedException {
        log.info("checking the result, it should be {}", result);
        try {
            if (!this.homePage.isElementPresent(searchResultElement, Durations.FIVE_SECONDS)) {
                assertEquals(result, "");
                this.homePage.quit();
                return;
            }
            String textRead = this.homePage.readTextMessage(searchResultElement, Durations.ONE_MINUTE);
            if (!result.equals(textRead)) {
                log.error("result: test failed\nexpected: {}\nfound: {}\n\n", result, textRead);
                this.homePage.quit();
                fail();
            }
            this.homePage.quit();
            log.info("the result is correct.");
        } catch (NoSuchElementException e) {
            if (result.equalsIgnoreCase("")) {
                log.info("the result is correct.");
                this.homePage.quit();
                return;
            }
            log.error("the result is not correct.");
            this.homePage.quit();
            Assert.fail();
        }
    }

}
