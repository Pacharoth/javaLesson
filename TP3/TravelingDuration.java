import java.util.Scanner;
public class TravelingDuration {
    Scanner sc = new Scanner(System.in);
    private double percent;
    private double result;
    private int hours,minutes,seconds;
    public double calculateTime(){
        result =(7/ ((double)(100-percent)/100*30))*3600;
        return result;
    }
    public boolean checkPercentage(){
        if(percent>=0 &&percent<=100){
            return true;
        }
        return false;
    }
    public void readPercentage(){
        System.out.println("Program for calculating duration of travel from ITC to Airport");
        System.out.print("Please input traffic jam factor (in percentage [0-100]:");
        percent = sc.nextDouble();
    }
    public void convertToTime(double data){
        hours =(int)(result/3600);
        minutes = (int)((result%3600)/60);
        seconds=(int)(result%60);
    }
    public void showTime(){
        if(checkPercentage()){
            double resultData = calculateTime();
            convertToTime(resultData);
            System.out.printf("\nTraveling Duration =%02d:%02d:%02d\n",hours,minutes,seconds);
        }else{
            System.out.println("\nInvalid percentage");
        }
    }
}
class TestTime{
    public static void main(String[] args) {
        TravelingDuration time = new TravelingDuration();
        time.readPercentage();
        time.showTime();
    }
}
