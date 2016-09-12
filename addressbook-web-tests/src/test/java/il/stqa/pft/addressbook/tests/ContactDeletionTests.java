package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().goToContactTab();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstName("Irina").withMobileNum("0541112233")
              .withCompanyName( "Random").withAddress("Israel").withLastName("Havkina").withGroup("test1"));
    }

  }

  @Test

  public void testContactDeletion() {
    //int before = app.contact().getContactCount();
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() -1);
    //int after = app.contact().getContactCount();
    //Assert.assertEquals(after, before -1);

    before.remove(index);
    Assert.assertEquals (before, after);

  }

}
