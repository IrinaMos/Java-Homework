package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.appmanager.AplicationManager;
import il.stqa.pft.addressbook.model.GroupData;
import il.stqa.pft.addressbook.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }

  }
}