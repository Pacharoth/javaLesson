package TP;

public class Fruit {
    private double weight; //attribute 
                    //we should assign them as private to prevent our program
                    //Internal state should check in internal
                    //only class owner can change the private
                    //prevent other change 
    public double getWeight(){
        return weight;
        
    }
    //good example for using private check error in internal(modulority)
    public void setWeight(double weight){
        if(weight>0)this.weight=weight;
        
    }
}
class FruitTest{
    public static void main(String[]args){
        Fruit mongo = new Fruit();//Fruit class Fruit() object
        mongo.setWeight(-200);
        System.out.println("Mongo weight:"+mongo.getWeight());
        Fruit jackfruit = new Fruit();
        jackfruit.setWeight(500); //internal state of jackfruit
        System.out.println("Jack fruit weight:"+jackfruit.getWeight());
    }
}