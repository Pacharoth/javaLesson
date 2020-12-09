import java.util.Scanner;
public class Hello{
    public static void helloName(){
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.println("Hello "+name+"!");
    }
    public static void main(String[] args){
        helloName();
    }
}