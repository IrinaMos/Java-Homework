package il.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
   //hello("world");
    Point p1;
    p1 = new Point();
    Point p2 = new Point();
    p1.x = 2;
    p1.y = 5;
    p2.x = 10;
    p2.y = 8;
    double res = distance (p1, p2);

  //   System.out.println("rasstoyanie mezhdu dvumya tochkami " + " = " + res);
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody +  "!");
  }

  public static double distance (Point p1, Point p2) {
     double temp = ((p2.x - p1.x)*(p2.x - p1.x))+((p2.y - p1.y)*(p2.y - p1.y));
    double res = Math.sqrt(temp);
    System.out.println("the distance is " + res +  "!");
    return (res);
  }

}