package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().goToContactTab();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"));
    }
    app.getContactHelper().selectContact(before-1);
    app.getContactHelper().contactModification();
    app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", null));
    app.getContactHelper().submitContactModification();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}
