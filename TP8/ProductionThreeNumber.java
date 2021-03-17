import java.util.Scanner;

public class ProductionThreeNumber {
    private float[] number = new float[3];
    public void readThreeNumber(){
        Scanner sc =new Scanner(System.in);
        for (int i = 0; i < 3;i++) {
            System.out.print("Enter number["+(i+1)+"]:");
            number[i] = sc.nextFloat();
        }
    }
    public float calculateNumber(){
        return number[0]*number[1]*number[2];
    }
    public void displayResult(){
        
        System.out.println("Production of them is "+calculateNumber());
        
    }
    public static void main(String[] args) {
        ProductionThreeNumber result = new ProductionThreeNumber();
        result.readThreeNumber();
        result.displayResult();
    }
}
