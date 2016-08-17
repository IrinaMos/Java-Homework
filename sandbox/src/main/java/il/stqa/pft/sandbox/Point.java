package il.stqa.pft.sandbox;

/**
 * Created by Irena on 8/13/2016.
 */
public class Point {
   double x;
   double y;



  public  double distance (Point p2) {
    double res = Math.sqrt((x-p2.x)*(x-p2.x+(y-p2.y)*(y-p2.y)));
    return (res);
  }
}
