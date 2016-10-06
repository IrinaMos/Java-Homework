package il.stqa.pft.mantis01.tests;

import il.stqa.pft.mantis01.appmanager.MailMessage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irena on 10/4/2016.
 */
public class RegistrationTests extends TestBase {

  @BeforeMethod
  public void startMailService() {
    app.mail().start();
  }

  @Test
  public void testRegistration() throws IOException, MessagingException {
    long now = System.currentTimeMillis();
    String user = String.format("user%s", +now);
    String password = "password";
    String email = String.format("user%s@localhost.localdomain", now);
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waitFormatMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
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

}
