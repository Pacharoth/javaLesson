import java.util.Scanner;
public class ex3 {
    private int a;
    public void readNumber(){
        System.out.print("Input number as Integer:");
        Scanner sc = new Scanner(System.in);
        //read the number we start and take only even number
        a = sc.nextInt();
    }
    public void displayResult(){
        int i=a;
        while (i<=5000) {
            if(i%2==0){
                System.out.print(i+"\t");
            }
            i++;
        }
    }
}
class EvenNumber{
    public static void main(String[] args) {
        ex3 even = new ex3();
        even.readNumber();
        even.displayResult();
    }
}
