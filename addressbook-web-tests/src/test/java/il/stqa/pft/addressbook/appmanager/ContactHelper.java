package il.stqa.pft.addressbook.appmanager;

import il.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

  public void selectContact() {
    click(By.name("selected[]"));
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
    fillContactData (contact);
    submitContactData();
  }

  public boolean isThereAContact() {
return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}

