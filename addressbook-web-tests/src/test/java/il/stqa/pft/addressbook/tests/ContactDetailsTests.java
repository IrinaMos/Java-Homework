package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Irena on 9/19/2016.
 */
public class ContactDetailsTests extends TestBase {
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
  public void testContactDetails() {
    app.contact().goToContactTab();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
    assertThat(mergeDetails(contact), equalTo(cleaned(contactInfoFromDetailsForm.getDetails())));

    //assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeDetails(ContactData contact) {
    return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getAllPhones(),
            contact.getAllMails())
            .stream().filter((s) -> !(s == null || s.equals("")))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String details) {
    return details.replaceAll("[()]", "").replaceAll("\\sHavkina", "\nHavkina").replace(" ","").replaceAll("\n\n", "\n").replaceAll("H:", "").replaceAll("M:", "")
            .replaceAll("(www.gmai.com)", "").replaceAll("(www.rom.co.il)", "").replaceAll("(www.jj.com)", "");

  }
}





