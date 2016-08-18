package il.stqa.pft.sandbox;
import org.testng.annotations.Test;
import static java.lang.Math.*;

/**
 * Created by Irena on 8/19/2016.
 */
public class DistanceTests {
  @Test
  public void testDistance1(){
    Point p1 = new Point ();
    Point p2 = new Point ();
    p1.x = 10;
    p1.y = 5;
    p2.x = 20;
    p2.y = 5;
    assert p1.distance(p2)==10;
  }
  @Test
  public void testDistance2(){
    Point p1 = new Point ();
    Point p2 = new Point ();
    p1.x = 10;
    p1.y = 5;
    p2.x = 20;
    p2.y = 5;
    assert p1.distance(p2)== sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
  }
   @Test
  public void testDistance3(){
    Point p1 = new Point ();
    Point p2 = new Point ();
    p1.x = 10;
    p1.y = 5;
    p2.x = 20;
    p2.y = 5;
    assert p1.distance(p2)==p2.distance(p1);
  }
}
