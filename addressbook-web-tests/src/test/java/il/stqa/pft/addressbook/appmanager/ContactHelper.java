package il.stqa.pft.addressbook.appmanager;

import il.stqa.pft.addressbook.model.ContactData;
import il.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irena on 8/21/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactData() {
    //   click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.cssSelector("#content>form>input"));
  }

  // public void fillContactData(ContactData contactData, boolean creation) {
  public void fillContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getMobileNum());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("address"), contactData.getAdress());

    //   if (creation) {
    //    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    //   } else {
    //     Assert.assertFalse(isElementPresent(By.name("new_group")));
    //   }
  }

  public void initContact() {
    click(By.name("searchform"));
    click(By.linkText("add new"));
  }

  public void goToContactTab() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void contactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
    // wd.switchTo().alert().dismiss();
  }

  public void createContact(ContactData contact) {
    initContact();
    fillContactData(contact);
    submitContactData();
    goToContactTab();
  }

  public void modifyContact(ContactData contact) {
    selectContactById(contact.getId());
    contactModification();
    fillContactData(contact);
    submitContactModification();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts ();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = (element.findElement(By.xpath(".//td[3]"))).getAttribute("innerHTML");
      int id = Integer.parseInt(element.findElement(By.xpath(".//td[1]/input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(name));
    }
    return contacts;
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    //List<WebElement> elements = wd.findElements (By.name("selected[]"));
    // List<WebElement> elements = wd.findElements (By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[1]"));
    //List<WebElement> elements = wd.findElements (By.cssSelector("tr.center"));
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = (element.findElement(By.xpath("//td[3]"))).getAttribute("innerHTML");
      int id = Integer.parseInt(element.findElement(By.xpath("//td[1]/input")).getAttribute("value"));
      // ContactData contact = new ContactData().withId(id).withFirstName(name);
      contacts.add(new ContactData().withId(id).withFirstName(name));
    }
    return contacts;
  }

}

