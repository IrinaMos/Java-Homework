package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by Irena on 8/22/2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().goToContactTab();
    app.getContactHelper().selectContact();
    app.getContactHelper().contactModification();
    app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina"));
    app.getContactHelper().submitContactModification();
  }

}
