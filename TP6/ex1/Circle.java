//surface = pi*r^2
//length = 2*pi*r
public class Circle {
    Point center;
    Point p;
    //composition
    //so it mean cannot change all , just individual disadvantage( memory consumption)
    public Circle(Point _center,Point _p){
        //aggregation when change need to depend the other for example change all in that circle
        // center = _center;
        // p=_p; 
        this.center = new Point(_center.x,_center.y);
        this.p = new Point(_p.x,_p.y);
    }
    public double radius(){
        return center.distance(p);
    }
    public double length(){
        return 2*Math.PI*radius();
    }
    public double surface(){
        return  Math.PI*Math.pow(radius(), 2);
        
    }
    //hashtable change all object as number. It is easy to find and not confuse
    //hashCode equals

}
