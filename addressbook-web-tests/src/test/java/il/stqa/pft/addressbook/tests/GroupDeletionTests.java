package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().GotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
       app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroups();
    app.getGroupHelper().deleteGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
