package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Irena on 9/18/2016.
 */
public class ContactAddressTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactTab();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstName("Irina")
              .withHomeNum("+(44)666").withMobileNum("999").withWorkNum("888")
              .withCompanyName("Random").withAddress("Israel Bat Yam")
              .withLastName("Havkina").withFirstMail("emailone").withSecondtMail("emailtwo")
              .withThirdtMail("emailthree"));
    }

}

  @Test
  public void testContactAddress (){
    app.contact().goToContactTab();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> ! (s == null || s.equals("")))
        //    .map(ContactAddressTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {

    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}


