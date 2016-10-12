package il.stqa.pft.mantis01.tests;

import il.stqa.pft.mantis01.appmanager.MailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irena on 10/7/2016.
 */
public class ChangePasswordTests extends TestBase {
  FirefoxDriver wd;

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @BeforeMethod
  public void SetUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/mantisbt-1.2.19/summary_page.php");
  }


  @Test
  public void testChangePassword() throws IOException, MessagingException {
    Login();
    gotoManageUsersPage();
    wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=3']"))).click();
    String user = wd.findElementByXPath("//div[3]/form/table/tbody/tr[2]/td[2]/input").getAttribute("value");
    String email = wd.findElementByXPath("//div[3]/form/table/tbody/tr[4]/td[2]/input").getAttribute("value");
    String password = "password";
    clickOnReset();
    // HttpSession session = app.newSession();
    List<MailMessage> mailMessages = app.mail().waitFormatMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    finishResetPassword(confirmationLink, "password");
    assertTrue(app.newSession().login(user,password));

    //   assertTrue(session.login("administrator", "root"));
    //   assertTrue(session.isLoggedInAs("administrator"));
  }

  private void finishResetPassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).sendKeys("password");
    wd.findElement(By.name("password_confirm")).click();
    wd.findElement(By.name("password_confirm")).sendKeys("password");
    wd.findElement(By.cssSelector("input[value='Update User']")).click();
  }

  private void clickOnReset() {
    wd.findElement((By.xpath("//div[4]/form[1]/input[3]"))).click();
  }

  private void Login() {
    wd.findElement(By.name("username")).click();
    wd.findElement(By.name("username")).sendKeys("administrator");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).sendKeys("root");
    wd.findElement(By.cssSelector("input.button")).click();
  }

  private void gotoManageUsersPage() {
    wd.findElement((By.xpath("//table[2]/tbody/tr/td[1]/a[7]"))).click();
    wd.findElement(By.xpath("//div[2]/p/span[1]/a")).click();
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailService() {
    app.mail().stop();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
