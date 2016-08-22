package il.stqa.pft.addressbook.appmanager;

import il.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Irena on 8/21/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactData() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type (By.name("lastname"),contactData.getLastName());
    type(By.name("mobile"),contactData.getMobileNum());
    type(By.name("company"),contactData.getCompanyName());
    type(By.name("address"),contactData.getAdress() );
  }

  public void initContact() {
    click(By.name("searchform"));
    click(By.linkText("add new"));
  }

  public void goToContactTab() {
    click(By.linkText("home"));
  }

  public void selectContact() {
    click(By.id("2"));
  }

  public void contactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}

