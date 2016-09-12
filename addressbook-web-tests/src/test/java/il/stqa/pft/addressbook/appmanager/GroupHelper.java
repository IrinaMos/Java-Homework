package il.stqa.pft.addressbook.appmanager;

import il.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irena on 8/20/2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  // public void returnToGroupPage() {
//    click(By.linkText("group page"));
  // }

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

  public void selectGroups(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void GroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void returnToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));

  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupData group) {
   selectGroups(index);
    GroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(int index) {
   selectGroups(index);
   deleteGroups();
   returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //GroupData group = new GroupData().withId(id).withName(name).withFooter(null).withHeader(null);
      groups.add(new GroupData().withId(id).withName(name));
    }
      return groups;
  }
}
