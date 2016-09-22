package il.stqa.pft.addressbook.tests;

import il.stqa.pft.addressbook.model.GroupData;
import il.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
   // String[] names = new String[]{"test1", "test2", "test3"};
   // GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
    app.goTo().groupPage();
    Groups before = app.group().all();
    //  GroupData group = new GroupData().withName("test1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}


//  app.group().initGroupCreation();
// app.group().fillGroupForm(new GroupData("test1", null, null));
// app.group().submitGroupCreation();
// app.group().returnToGroupPage();


//   int max = 0;
//  for (GroupData g : after) {
//    if (g.getId() > max) {
//      max = g.getId();
//   }
// }

// group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
// group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
//  before.add(group);
//Assert.assertEquals(before, after);

