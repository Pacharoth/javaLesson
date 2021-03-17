import java.util.Scanner;
// Create a Java application to read an integer A. The program must determine that the cube of the sum of digits of this
// number is equal to A*A.
public class SquareAndCube {
    private int number,cube,square;
    Scanner sc = new Scanner(System.in);

    public void setNumber(int number){
        this.number = number;
    }
    public void inputNumber(){
        System.out.print("Enter number:");
        int num= sc.nextInt();
        setNumber(num);
    }
    public boolean checkCubeWithSquare(){
        int sum =0,num=number,tmp,result=1;
        while (num>0) {
            result = num%10; //27%10=7
            sum =sum+ result;
            num = num/10;
        }
        System.out.println(sum);
        cube=sum*sum*sum;
        square=number*number;
        if(cube==square)return true;
        return false;
    }
    public void displayResult(){
        if(checkCubeWithSquare()){
            System.out.println("cube of sum of digit of "+number+" and "+number+" x "+number+" are equal to "+cube+",so they are equal");
        }else{
            System.out.println("cube of sum of digit of "+number+" is not equal to "+number+" x "+number+
            " because cube of sum digit of "+number+"="+cube+"and square of "+number+"="+square);
        }
    }   
}
class MainSquareAndCube{
    public static void main(String[] args) {
        SquareAndCube result = new SquareAndCube();
        result.inputNumber();
        result.displayResult();
    }
}