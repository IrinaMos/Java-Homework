package il.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getContactHelper().goToContactTab();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();

  }
}
