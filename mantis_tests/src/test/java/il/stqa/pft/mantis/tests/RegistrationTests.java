package il.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Irena on 10/4/2016.
 */
public class RegistrationTests extends TestBase{

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user@localhost.localdomain");


  }
}
