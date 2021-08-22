package com.nextbasecrm.step_definitions;

import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


//    @Before
//    public void loginSetup() {
//        Log.info("Logging in");
//        Driver.getDriver().get("https://login2.nextbasecrm.com/");
//        LoginPage.login("helpdesk32@cybertekschool.com","UserUser");
//
//    }

    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            Log.info("Taking screenshot.");
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //Driver.closeDriver();
    }
}
