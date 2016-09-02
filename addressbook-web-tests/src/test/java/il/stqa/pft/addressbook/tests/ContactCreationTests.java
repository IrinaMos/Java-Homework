package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToContactTab();
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"));
     //   app.getContactHelper().initContact();
     //   app.getContactHelper().fillContactData(new ContactData("Irina", "0541112233", "Random", "Israel", "Havkina", "test1"), true);
     //   app.getContactHelper().submitContactData();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);
       // int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before +1);

    }

}
