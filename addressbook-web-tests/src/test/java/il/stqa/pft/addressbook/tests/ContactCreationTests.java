package il.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import il.stqa.pft.addressbook.model.ContactData;
import il.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    //  list.add(new Object[] {new ContactData().withFirstName("irina1").withLastName("havkina1")
    //           .withMobileNum("54545451")});
    //   list.add(new Object[] {new ContactData().withFirstName("irina2").withLastName("havkina2")
    //          .withMobileNum("54545452")});
    //  list.add(new Object[] {new ContactData().withFirstName("irina3").withLastName("havkina3")
    //           .withMobileNum("54545453")});
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new ContactData().withFirstName(split[0]).withLastName(split[1]).withMobileNum(split[2])});
      line = reader.readLine();

    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml+=line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((c) ->new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromXml")
  public void testContactCreation(ContactData contact) {
    app.contact().goToContactTab();
    Contacts before = app.contact().all();
   // File photo = new File("src/test/resources/my.jpg");
    //ContactData contact = new ContactData()
    //  .withFirstName("Irina").withLastName("Havkina").withMobileNum("07734973");
    //.withCompanyName("Random").withAddress("Israel").withPhoto(photo);
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

 /* @BeforeMethod
  public void ensurePreconditions () {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }*/

   /*@Test(dataProvider = "validContactsFromXml")
  public void testContactCreation(ContactData contact) {
    Groups groups = app.db().groups();
  //  File photo = new File("src/test/resources/my.jpg");
    ContactData newContact = new ContactData().withFirstName("Irina")
            .withLastName("Havkina").withMobileNum("07734973")
            .inGroup(groups.iterator().next());
    app.contact().goToContactTab();
    app.contact().createContact(contact);
    app.contact().fillContactData((new ContactData().withFirstName("Irina")
            .withLastName("Havkina").withMobileNum("07734973")));
    app.contact().submitContactData();
    app.contact().goToContactTab();
  }*/



/*  @Test
  public void TestCurrent() {
    File currentDir = new File(".");
    File photo = new File("src/test/resources/my.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
*/

}