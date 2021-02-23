import java.util.Scanner;

public class CostCalculation {
    Scanner sc = new Scanner(System.in);
    float price;
    public CostCalculation(){

    }
    public void inputCost(){
        while (true) {
            System.out.print("Input cost:");
            price = sc.nextFloat();
            if(price>=0){
                break;
            }else{
                System.out.println("Cost should be bigger or equal than 0");
            }
        }
    }
    public float calculateCost(){
        System.out.println(price);
        if(price>=500)return price*(float)(25/100);
        else if(price>=200)return price*(float)(12/100);
        else if(price>=100)return price*(float)(7/100);
        else if(price>=50)return price*(float)(3/100);
        else if(price>=10) return price-2;
        return price;
    }
    public void displayResult(){
        System.out.println("amount of cost: "+calculateCost());
    }
    public static void main(String[] args) {
        CostCalculation product = new CostCalculation();
        product.inputCost();
        product.displayResult();
    }
}
