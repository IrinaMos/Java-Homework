package il.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Irena on 8/20/2016.
 */
public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {

    this.wd=wd;
  }

  public void GotoGroupPage() {
      wd.findElement(By.id("header")).click();
      wd.findElement(By.linkText("groups")).click();
  }
}
