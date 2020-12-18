import java.util.Scanner;
public class ReilsToDollar {
    private int result;
    Scanner sc = new Scanner(System.in);
    public void readReil(){
        System.out.println("Program for converting money in Reils to Dollars.");
        System.out.println("Conversion rate is: 1USD = 4000REILS");
        System.out.print("Please input money in Reil: ");
        result=sc.nextInt();
    }
    public double calculateReilToDollar(){
        return (double)result/4000;
    }
    public void showResult(){
        System.out.println("\n"+result+" RIELS = "+calculateReilToDollar()+" USD");
    }
    public static void main(String[] args) {
        ReilsToDollar money = new ReilsToDollar();
        money.readReil();
        money.showResult();
    }
}
