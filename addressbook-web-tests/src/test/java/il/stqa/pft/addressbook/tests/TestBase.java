package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Irena on 8/20/2016.
 */
public class TestBase {

  protected static final AplicationManager app = new AplicationManager(BrowserType.FIREFOX);

  //@BeforeMethod
  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  //@AfterMethod
  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
