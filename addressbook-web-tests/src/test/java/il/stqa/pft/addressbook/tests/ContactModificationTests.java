package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().goToContactTab();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"));
    }
    //int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().contactModification();
    app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", null));
    app.getContactHelper().submitContactModification();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    //int after = app.getContactHelper().getContactCount();
    //Assert.assertEquals(after, before);
  }

}
