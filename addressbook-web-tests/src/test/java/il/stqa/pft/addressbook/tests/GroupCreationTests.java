package il.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import il.stqa.pft.addressbook.model.GroupData;
import il.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line!=null) {
      xml+=line;
     // String[] split = line.split(";");
     // list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
    return groups.stream().map((g) ->new Object[] {g}).collect(Collectors.toList()).iterator();
   // return list.iterator();
  }
    /*list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});*/

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
      List<Object[]> list = new ArrayList<Object[]>();
      BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
      String json = "";
      String line = reader.readLine();
      while (line!=null) {
        json+=line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); //List<GroupData>.class
      return groups.stream().map((g) ->new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
   //String[] names = new String[]{"test1", "test2", "test3"};
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

