import java.util.Scanner;
public class PrimeNumber {
    private int number,numberDiv;
    Scanner sc = new Scanner(System.in);
    public void readPrimeNumber(){
        System.out.print("Input number to check whether it is prime number:");
        number = sc.nextInt();
    }
    public void showResult(){
        int i=2;
        
        if(number>2){
            boolean prime = true;
            while(i<=number/2){
                if(number%i==0){
                    prime = false;
                    numberDiv=i;
                    break;
                }
                i++;
            }
            if(prime){
                System.out.println(number+" is prime number.");
            }else System.out.println(number+" is not prime number, because it is divisible to "+numberDiv);
        }else System.out.println(number + " is not prime number, because it is smaller or equal to 2.");
    }
}
class TestPrime{
    public static void main(String[] args) {
        PrimeNumber primenum = new PrimeNumber();
        primenum.readPrimeNumber();
        primenum.showResult();
    }
}
