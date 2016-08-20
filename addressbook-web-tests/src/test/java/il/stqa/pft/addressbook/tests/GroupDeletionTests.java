package il.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().GotoGroupPage();
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().deleteGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
