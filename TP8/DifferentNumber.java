import java.util.Scanner;

// Create a Java application to count a number of integers in the range from 100 to 999 all figures of which are different.
public class DifferentNumber {
    int number;
    Scanner sc = new Scanner(System.in);
    public boolean checkDiffDigit(String number){
    
        if(number.charAt(0)==number.charAt(1)||
        number.charAt(0)==number.charAt(2)||
        number.charAt(1)==number.charAt(2)){
            return false;
        }
        return true;
    }
    public int countDifferentDigit(){
        int count=0;
        for (int i = 100; i <=999; i++) {
            String p = Integer.toString(i);
            if(checkDiffDigit(p))count+=1;
        }
        return count;
    }
    public void displayResult(){
        System.out.println("There are "+countDifferentDigit()+" all different digits from 100-999");
    }
}
class MainCountDifferentNumberInDigit{
    public static void main(String[] args) {
        DifferentNumber number = new DifferentNumber();
        number.displayResult();
    }
}