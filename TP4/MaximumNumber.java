import java.util.Scanner;
public class MaximumNumber {
    Scanner sc = new Scanner(System.in);
    private int[] number= new int[8];
    private int max;
    public void calculateMaximum(){
        max = number[0];
        for(int i=0;i<number.length;i++){
            if(max<number[i]){
                max=number[i];
            }
        }
    }
    public void readAndDisplayNumber(){
        System.out.println("Program to find maximum by 8 input(integer)");
        for(int i =0 ;i<8;i++){
            System.out.print("Input number "+(i+1)+":");
            number[i] = sc.nextInt();
        }
        calculateMaximum();
        System.out.println("Maximum number among 8 is "+max);
    }
    public static void main(String[] args) {
        MaximumNumber maxi = new MaximumNumber();
        maxi.readAndDisplayNumber();
    }
}
