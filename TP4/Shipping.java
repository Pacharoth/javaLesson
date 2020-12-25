import java.time.temporal.WeekFields;
import java.util.Scanner;
public class Shipping {
    Scanner sc = new Scanner(System.in);
    private double weight,aTob,bToc;
    private double litreperkilometer,litremax=5000,litreTotal,litre;
    public void readData(){
        System.out.println("Program for calculate the minimum amount of litre need to refill to reach point C.");
        System.out.print("Input distance A to B(km): ");
        aTob=sc.nextDouble();
        System.out.print("Input distance B to C(km): ");
        bToc = sc.nextDouble();
        System.out.print("Input weight of good(kg): ");
        weight = sc.nextDouble();        
    }
    public void convertLitre(){
        litreTotal=(aTob+bToc)*litreperkilometer;
        litre = litremax-litreTotal;
        System.out.println(litre+" "+litreTotal+" "+litreperkilometer);
    }
    public void checkLitre(){
        if(weight>0&& weight<=5000){
            litreperkilometer=10;
        }else if(weight>5000 && weight<=10000){
            litreperkilometer=20;
        }else if(weight>10000&&weight<=20000){
            litreperkilometer=25;
        }else if(weight>20000&&weight<=30000){
            litreperkilometer=30;
        }
        convertLitre();   
    }
    public void showResult(){
        if(weight<=30000){
            checkLitre();
            if(litre>0) System.out.println("\nminimum to refill is 0 to reach to point c");
            else System.out.println("\nminimum to refilll to reach to point c is "+(-litre));
        }else System.out.println("\nShip cannot loaded!");
    }
    public static void main(String[] args) {
        Shipping ship = new Shipping();
        ship.readData();
        ship.showResult();
    }
}
