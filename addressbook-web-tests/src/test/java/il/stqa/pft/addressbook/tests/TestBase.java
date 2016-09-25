package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  //protected static final AplicationManager app = new AplicationManager(BrowserType.FIREFOX);

  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));


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
