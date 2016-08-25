package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Irena on 8/20/2016.
 */
public class TestBase {

  protected final AplicationManager app = new AplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
