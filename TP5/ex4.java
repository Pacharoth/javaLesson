import java.util.Scanner;
public class ex4 {
    private double [] profit = new double[12];
    public void inputMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculate company profits");
        int i=0;
        while(i<=11){
            System.out.print("Profit for month "+(i+1)+":");
            //input the profit for each month
            profit[i] = sc.nextDouble();
            i++;
        }
    }
    public void displayResult(){
        int i=0;
        double sum=0;
        while (i<=11) {
            //plus all these 12 month to get total profit
            sum +=profit[i];
            i++;
        }
        System.out.println("\nTotal profits for 12 months: "+sum);
    }
}
class ProfitAYear{
    public static void main(String[] args) {
        ex4 profit = new ex4();
        profit.inputMoney();
        profit.displayResult();
    }
}
