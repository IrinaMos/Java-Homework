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
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().goToContactTab();
      app.contact().createContact(new ContactData().withFirstName("Irina").withMobileNum("0541112233")
              .withCompanyName("Random").withAddress("Israel").withLastName("Havkina"));
      // app.contact().goToContactTab();
      // if (!app.contact().isThereAContact()) {
      //   app.contact().createContact(new ContactData().withFirstName("Irina").withMobileNum("0541112233")
      //           .withCompanyName( "Random").withAddress("Israel").withLastName("Havkina").withGroup("test1"));
    }

  }

  @Test
  public void testContactModification() {
    //int before = app.contact().getContactCount();
  //  Contacts before = app.contact().all();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    // int index = before.size() - 1;
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Irina").withMobileNum("0541112233")
            .withCompanyName("Random").withAddress("Israel").withLastName("Havkina");
    app.contact().goToContactTab();
    app.contact().modifyContact(contact);
 //   Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    //int after = app.contact().getContactCount();
    //Assert.assertEquals(after, before);
    //  before.remove(modifiedContact);
    //  before.add(contact);
    // Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    //  before.sort(byId);
    //  after.sort(byId);
    //  Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
