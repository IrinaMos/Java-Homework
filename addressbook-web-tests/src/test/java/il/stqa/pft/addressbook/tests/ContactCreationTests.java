package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToContactTab();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"));
     //   app.getContactHelper().initContact();
     //   app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"), true);
     //   app.getContactHelper().submitContactData();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before +1);
    }

}
