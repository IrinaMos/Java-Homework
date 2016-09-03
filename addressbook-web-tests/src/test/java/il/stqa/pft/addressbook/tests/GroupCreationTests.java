package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().GotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    //  app.getGroupHelper().initGroupCreation();
    // app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    // app.getGroupHelper().submitGroupCreation();
    // app.getGroupHelper().returnToGroupPage();


 //   int max = 0;
  //  for (GroupData g : after) {
  //    if (g.getId() > max) {
  //      max = g.getId();
   //   }
   // }

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
