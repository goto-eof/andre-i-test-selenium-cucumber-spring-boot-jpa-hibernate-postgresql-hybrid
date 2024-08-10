package com.andreidodu.andreitest.step;

import com.andreidodu.andreitest.service.TagService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
@AllArgsConstructor
public class CommonSequentialStep {
    private final TagService tagService;

    @Given("cleaning database")
    public void cleaningDatabase() {
        log.info("cleaning database");
        if (!tagService.cleanTable()) {
            log.error("unable to clean database");
            Assert.fail();
        }
        log.info("database cleaned");
    }

    @And("restoring session")
    public void restoringSession() {
        log.info("restoring session");
    }

    @And("saving data on db")
    public void saveDataOnDB() {
        log.info("populating database");
        if (!this.tagService.populateTable()) {
            log.error("unable to populate database");
            Assert.fail();
        }
        log.info("database populated");
    }

}
