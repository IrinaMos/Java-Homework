package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().GotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);
    //  app.getGroupHelper().initGroupCreation();
    // app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    // app.getGroupHelper().submitGroupCreation();
    // app.getGroupHelper().returnToGroupPage();
  }

}
