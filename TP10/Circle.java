

import Point3D.PointThreeD;

public class Circle {
    PointThreeD point ;
    PointThreeD point2;


    public Circle(){
        System.out.println("Point 1");
        
        this.point = PointThreeD.inputData();
        System.out.println("Point 2");
    
        this.point2=PointThreeD.inputData();
    }

    public boolean  equal(Circle circle){
        double circlelength = circle.getRadius()-getRadius();
        if(circlelength==0){
            return true;
        }
        return false;
    }
    public int compareTo(Circle c){

        return (int)(c.getLength()-getLength());
    }
    public double getLength(){
        double length = getRadius()*2;
        return length;
    }
    public double getSurface(){
        double x =Math.pow((point.getX()-point2.getX()), 2);
        double y = Math.pow((point.getY()-point2.getY()), 2);
        double z = Math.pow((point.getZ()-point2.getZ()), 2);
        double surface =x+y+z;
        return surface;
    }
    public double getRadius(){
        double radius = Math.sqrt(getSurface());
        return radius;
    }
    public void inc(int number){
        point.setX(point.getX()+number);
        point.setY(point.getY()+number);
        point.setZ(point.getZ()+number);
        point2.setX(point.getX()+number);
        point2.setY(point.getY()+number);
        point2.setZ(point.getZ()+number);
    }
    public void dec(int number){
        point.setX(point.getX()-number);
        point.setY(point.getY()-number);
        point.setZ(point.getZ()-number);
        point2.setX(point.getX()-number);
        point2.setY(point.getY()-number);
        point2.setZ(point.getZ()-number);
    }
    @Override
    public String toString(){
        return "length of circle:"+String.format("%.2f",getLength())+",Radius:"+String.format("%.2f",getRadius())+
        ",X("+point.getX()+","+point2.getX()+")"+",Y("+point.getY()+","+point2.getY()+")"+
        ",Z("+point.getZ()+","+point2.getZ()+")";
    }
}
class MainCircle{
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        if(circle1.equal(circle2))System.out.println("They are equal(radius)");
        else System.out.println("They are not equal (radius)");
        if(circle1.compareTo(circle2)>0) System.out.println("circle1 is bigger than circle2");
        else if(circle1.compareTo(circle2)<0) System.out.println("circle1 is smaller than circle2");
        else System.out.println("They have the same length");
        System.out.println("Before Increase");
        System.out.println("Circle1 "+circle1.toString());
        System.out.println("Circle2 "+circle2.toString());
        System.out.println("After Increase 2");
        circle1.inc(2);
        circle2.inc(2);
        System.out.println("Circle1 "+circle1.toString());
        System.out.println("Circle2 "+circle2.toString());
        System.out.println("Decrease 2");
        circle1.dec(2);
        circle2.dec(2);
        System.out.println("Circle1 "+circle1.toString());
        System.out.println("Circle2 "+circle2.toString());

    }
}
