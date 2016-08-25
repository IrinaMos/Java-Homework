package il.stqa.pft.addressbook.appmanager;

import il.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Irena on 8/20/2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
      click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
    click(By.xpath("//div[@id='content']/form"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteGroups() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroups() {
    click(By.name("selected[]"));
  }

  public void GroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}
