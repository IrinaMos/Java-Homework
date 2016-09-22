package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import il.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().goToContactTab();
    //int before = app.contact().getContactCount();
    //   app.contact().initContact();
    //   app.contact().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"), true);
    //   app.contact().submitContactData()
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/my.jpg");
    ContactData contact = new ContactData()
            .withFirstName("Irina").withMobileNum("0541112233")
            .withCompanyName("Random").withAddress("Israel").withLastName("Havkina").withPhoto(photo);
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

/*  @Test
  public void TestCurrent() {
    File currentDir = new File(".");
    File photo = new File("src/test/resources/my.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
*/

}