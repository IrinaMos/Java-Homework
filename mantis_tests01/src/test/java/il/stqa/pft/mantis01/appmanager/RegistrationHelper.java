package il.stqa.pft.mantis01.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Irena on 10/4/2016.
 */
public class RegistrationHelper extends HelperBase {
  //private final ApplicationManager app;
 // private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
   // this.app = app;
    super(app);
   // wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
//    wd.findElement(By.name ("username")).sendKeys("username");
    type(By.name("username"), username);
    type(By.name("email"), email);
    Click(By.cssSelector("input[value='Signup'"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    Click(By.cssSelector("input[value='Update User'"));
  }
}
