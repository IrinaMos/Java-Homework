package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().GotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    //  app.getGroupHelper().initGroupCreation();
    // app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    // app.getGroupHelper().submitGroupCreation();
    // app.getGroupHelper().returnToGroupPage();
  }

}
