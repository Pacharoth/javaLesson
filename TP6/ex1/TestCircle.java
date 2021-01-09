public class TestCircle {
    public static void main(String[] args) {
        Point c = new Point();
        Point p = new Point(3,0);
        Circle circle = new Circle(c,p);
        System.out.println("Radius: "+circle.radius());
        System.out.println("Length: "+circle.length());
        System.out.println("surface: "+circle.surface());
    }
}
