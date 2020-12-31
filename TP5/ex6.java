
import java.util.Scanner;
/*
from ex5 and in the same folder we have like reverse method readString and displayResult
-So first just extends from ex5 or inheritance and rewrite some function
-Like we want to change displayResult and readString, but we use the method that built in there
*/
public class ex6 extends ex5{
    private String word;
    public void readString(){
        System.out.print("Please enter a word:");
        word = sc.nextLine();
    }
    public void displayResult(){
        System.out.println(word+reverseString(word));
    }
}
class StringMirror{
    public static void main(String[] args) {
        ex6 stringMirror = new ex6();
        stringMirror.readString();
        stringMirror.displayResult();
    }
}