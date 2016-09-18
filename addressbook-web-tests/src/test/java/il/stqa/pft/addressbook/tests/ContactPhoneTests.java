package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Irena on 9/16/2016.
 */
public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactTab();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstName("Irina")
              .withHomeNum("+(44)666").withMobileNum("999").withWorkNum("888")
              .withCompanyName("Random").withAddress("Israel").withLastName("Havkina").withGroup("test1"));
    }

  }

  @Test
  public void testContactPhones() {
    app.contact().goToContactTab();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    // assertThat(contact.getMobileNum(), equalTo(cleaned(contactInfoFromEditForm.getMobileNum())));
    //  assertThat(contact.getWorkNum(), equalTo(cleaned(contactInfoFromEditForm.getWorkNum())));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomeNum(), contact.getMobileNum(), contact.getWorkNum())
            .stream().filter((s) -> ! (s == null || s.equals("")))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
