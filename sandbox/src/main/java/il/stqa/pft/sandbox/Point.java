package il.stqa.pft.sandbox;

/**
 * Created by Irena on 8/13/2016.
 */
public class Point {
   double x1;
   double y1;
   double x2;
   double y2;


  public  double distance () {
    double temp = ((x2 - x1)*(x2 - x1))+((y2 - y1)*(y2 - y1));
    double res = Math.sqrt(temp);
    System.out.println("the distance is " + res +  "!");
    return (res);
  }
}
