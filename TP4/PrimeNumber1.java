import java.util.Scanner;
/*Implement an application Java that let user input a number then determine if it is a prime number. Prime number is
positive number greater than 2 and divisible only to its own and 1.*/
public class PrimeNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Input number to check whether it is prime number: ");
        num = Integer.parseInt(sc.nextLine());
        if(num>0){
            int half = num/2;
            boolean isPrime = true;
            int i = 2;
            for( ;i<=half;i++){
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(num + " is prime number.");
            }else{
                System.out.printf("%d is not prime number, because it is divisible to %d.\n", num, i);
            }
        }else System.out.println(num + " is not prime number, because it is smaller or equal to 2.");
    }
}