package il.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
    //hello("world");

    //Point p1 = new Point();
    //Point p2 = new Point();
    Point p = new Point ();
    p.x1 = 2;
    p.y1 = 5;
    p.x2 = 10;
    p.y2 = 8;

    p.distance();

  //  double res = distance (p1, p2);
    //   System.out.println("rasstoyanie mezhdu dvumya tochkami " + " = " + res);
  }

  /*public static void hello(String somebody) {
    System.out.println("Hello, " + somebody +  "!");
  }*/

 /* public static double distance (Point p1, Point p2) {
    double temp = ((p2.x - p1.x)*(p2.x - p1.x))+((p2.y - p1.y)*(p2.y - p1.y));
    double res = Math.sqrt(temp);
    System.out.println("the distance is " + res +  "!");
    return (res);
  }*/

}