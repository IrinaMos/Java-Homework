package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContact();
        app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina"));
        app.getContactHelper().submitContactData();
    }

}