import java.util.Scanner;
public class TimeToSecond {
    private int minutes,hours,seconds;
    Scanner sc = new Scanner(System.in);
    public void readTime(){
        System.out.println("Program for converting time to second");
        System.out.print("Please input hours: ");
        hours=sc.nextInt();
        System.out.print("Please input minutes: ");
        minutes=sc.nextInt();
        System.out.print("Please input seconds: ");
        seconds=sc.nextInt();
    }
    public int calculateTime(){
        return (hours*3600)+(minutes*60)+seconds;
    }
    public boolean checkTime(){
        if(minutes>59){
            return false;
        }
        if(seconds>59){
            return false;
        }
        return true;
    }
    public String toString(int data){
        if(checkTime()){
            return String.format("\nNumber of seconds = %dx3600 + %dx60 + %d=%d",hours,minutes,seconds,data);
        }
        return String.format("\nInvalid Time");
    }
}
class timeTest{
    public static void main(String[] args) {
        TimeToSecond data= new TimeToSecond();
        data.readTime();
        int time = data.calculateTime();
        String printData = data.toString(time);
        System.out.println(printData);
    }
}
