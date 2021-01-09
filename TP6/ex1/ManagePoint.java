public class ManagePoint {
    public static void main(String[] args) {
        Point p1 = new Point(); // object name p1 instantiated (new)
        // using default constructor
        p1.x = 2; // set attribute x of object name p1 to 2
        p1.y = 5; // set attribute y of object name p1 to 5
        Point p2 = new Point(); // object name p2 instantiated (new)
        // using default constructor
        p2.x = 8; // set attribute x of object name p2 to 8
        p2.y = 3; // set attribute y of object name p2 to 3
        // create variable distance to distance value. Now, initialize it 0 
        //   ____________________
        // \/(x2-x1)^2-(y2-y1)^2
        double distance = 0;
        distance = p1.distance(p2);
        
        System.out.printf("Distance between p1(%d,%d) and p2(%d,%d) is: %f",p1.x, p1.y, p2.x, p2.y,distance);
    }
}
