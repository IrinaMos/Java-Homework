package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().goToContactTab();
    //int before = app.contact().getContactCount();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Irina").withMobileNum("0541112233")
            .withCompanyName( "Random").withAddress("Israel").withLastName("Havkina").withGroup("test1");
    app.contact().createContact(contact);
    //   app.contact().initContact();
    //   app.contact().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"), true);
    //   app.contact().submitContactData()

    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
   // Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());



    // int after = app.contact().getContactCount();
    //Assert.assertEquals(after, before +1);

 //   int max=0;
 //   for (ContactData c : after) {
 //     if (c.getId() > max) {
 //       max = c.getId();
 //     }
 //   }

   // Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
   // int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

  //  before.sort(byId);
  //  after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
