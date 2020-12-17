import java.util.Scanner;
public class Time {
    private int hours, minutes, seconds;
    public static Time parseTime(String secs) {
        int seconds = Integer.parseInt(secs);
        Time t = new Time();
        t.hours = (int)(seconds / 3600);// 1 hour = 3600 seconds
        t.minutes = (int)((seconds % 3600)/60);
        t.seconds = seconds % 60;
        return t;
    }
    public String toString(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public void showHours(){
        System.out.printf("%02d\n", hours);
    }
    public void showMinute(){
        System.out.printf("%02d\n",minutes);
    }
    public void showSecond(){
        System.out.printf("%02d\n",seconds);
    }
}
class TimeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input time in seconds: ");
        try {
            Time time = Time.parseTime(sc.nextLine());
            System.out.println(time);
        }catch (NumberFormatException e){
            System.err.println("Invalid time input!");
        }
    }
}