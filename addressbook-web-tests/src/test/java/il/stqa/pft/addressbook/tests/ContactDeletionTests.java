package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getContactHelper().goToContactTab();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"));
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }
}
