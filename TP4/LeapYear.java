import java.util.Scanner;
public class LeapYear {
    Scanner sc=new Scanner(System.in);
    private int year;
    public void readYear(){
        System.out.println("Program check leap year");
        System.out.print("Input year start from 1:");
        year=sc.nextInt();
    }
    
    public boolean checkYear(){
        if(year%400==0)return true;
        else if(year%100==0)return false;
        else if(year%4==0) return true;
        return false;
    }
    public void showResult(){
        if(year>0){
            if(checkYear()){
                System.out.println("\n"+year+" is Leap Year.");
            }
            else{
                System.out.println("\n"+year+" is not Leap Year.");
            }
        }
    }
    public static void main(String[] args) {
        LeapYear leapyear = new LeapYear();
        leapyear.readYear();
        leapyear.showResult();
    }
}
