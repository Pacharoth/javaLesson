
import java.util.Scanner;

/*
-get input
-reverse string 
-check the first string equal to the second string 
-like example noon after reverse still noon
-if hello when reverse olleh ,so it doesn't equal to the first string and it is not palindrome
-function
-readString -reverseString -checkPalindrome -displayResult
*/
public class ex5 {
    Scanner sc = new Scanner(System.in);
    private String word;

    public void readString() {
        System.out.print("Please gives a word to check:");
        word = sc.nextLine();
    }

    public String reverseString(String wordPalin) {
        StringBuilder result = new StringBuilder();
        int i = wordPalin.length() - 1;
        while (i >= 0) {
            result.append(wordPalin.charAt(i));
            i--;
        }
        return result.toString();
    }

    public boolean checkPalindrome(String wordPalin) {
        String secondStr = reverseString(wordPalin);
        if (secondStr.indexOf(wordPalin) > -1)
            return true;
        return false;
    }

    public void displayResult() {
        if (checkPalindrome(word))
            System.out.println(word + " is palindrome");
        else
            System.out.println(word + " is not palindrome");
    }
}

class Palindrome {
    public static void main(String[] args) {
        ex5 palindrome = new ex5();
        palindrome.readString();
        palindrome.displayResult();
    }
}