package uk.co.costcutter.hooks;

import static uk.co.costcutter.common.DriverFactory.getChromeDriver;
import static uk.co.costcutter.common.DriverFactory.getWebDriverWait;
import static uk.co.costcutter.common.DriverFactory.quitWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

  @Before()
  public void beforeScenario() {

    getChromeDriver();
    getWebDriverWait(5);
  }

  @After()
  public void afterScenario() {
    quitWebDriver();
  }
}
