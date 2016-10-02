package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import il.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions () {
    app.contact().goToContactTab();
    if (!app.contact().isThereAContact()) {
              app.contact().createContact(new ContactData().withFirstName("Irina").withMobileNum("0541112233")
              .withCompanyName( "Random").withAddress("Israel").withLastName("Havkina"));
    }

  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().goToContactTab();
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }



 /* @BeforeMethod
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
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    //int index = before.size()-1;
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() -1);
    //int after = app.contact().getContactCount();
    //Assert.assertEquals(after, before -1);

    //before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
    // Assert.assertEquals (before, after);

  }*/

}
