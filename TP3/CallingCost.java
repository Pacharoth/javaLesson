import java.util.Scanner;

public class CallingCost {
    private int starthours,startminutes,startseconds,resultstart;
    private double cost;
    private int hours,minutes,seconds,time;
    Scanner sc = new Scanner(System.in);
    private int endhours,endminutes,endseconds,resultend;
    public void readTime(){
        System.out.println("Program for calculating cost of a call");
        System.out.print("Please input start hours: ");
        starthours=sc.nextInt();
        System.out.print("Please input start minutes: ");
        startminutes=sc.nextInt();
        System.out.print("Please input start second: ");
        startseconds=sc.nextInt();
        System.out.print("\nPlease input end hours: ");
        endhours=sc.nextInt();
        System.out.print("Please input end minutes: ");
        endminutes=sc.nextInt();
        System.out.print("Please input end seconds: ");
        endseconds=sc.nextInt();
    }
    public int convertToSecond(int hours,int minutes,int seconds){
        return (hours*3600)+(minutes*60)+seconds;
    }
    public void convertToTime(int sec){
        hours=sec/3600;
        minutes=(sec%3600)/60;
        seconds = sec%60;
    }
    public void showResult(){
        resultstart=convertToSecond(starthours, startminutes,startseconds);
        resultend=convertToSecond(endhours, endminutes, endseconds);
        if(resultend>resultstart){
            time=resultend-resultstart;
            convertToTime(time);
            cost=((resultend-resultstart)*0.05)/60;
            System.out.printf("\nTotal call duration : %dh %dmm %ds\n",hours,minutes,seconds);
            System.out.println("Total cost of this call:"+cost+"$");
        }else{
            System.out.println("Time end cant be smaller than start time");
        }
    }
}
class timeCall{
    public static void main(String[] args) {
        CallingCost call = new CallingCost();
        call.readTime();
        call.showResult();
    }
}
