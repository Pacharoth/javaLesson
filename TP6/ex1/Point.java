public class Point {
    int x,y;
    //overloading the same function but different parameter
    //overiding the same function and overwrite
    //context = meaning
    public Point(){

    }
    public Point(int _x){
        x = _x;
    }
    public Point(int _x,int _y){
        x = _x;
        y = _y;
    }
    public double distance(Point p2){
        double distance = Math.sqrt(Math.pow(p2.x - x, 2) + Math.pow(p2.y - y, 2));
        return distance;
    }
}

