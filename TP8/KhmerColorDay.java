import java.util.Scanner;

public class KhmerColorDay {
    int day;
    Scanner sc = new Scanner(System.in);
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";
    public KhmerColorDay(int day){
        if(day>=1&&day<=7){
            this.day=day;
        }
        else{
            while (true) {
                System.out.print("Please input day again(1-7):");
                this.day=sc.nextInt();
                if(this.day>=1&&this.day<=7) break;
            }
        }
    }
    public void displayResult(){
        if(day==1) System.out.println(TEXT_RED+"Sunday for Red. Sunday refer to the sun, Sunlight bring bright and strong with seen as red."+TEXT_RESET);
        else if(day==2) System.out.println(TEXT_YELLOW+"Monday for Orange. It truly looks like a beautiful moon and bring a peaceful and victory."+TEXT_RESET);
        else if(day==3)System.out.println(TEXT_PURPLE+"Tuesday for Purple or Violet. In Khmer, Tuesday translate to Mars, which means hardness and nasty."+TEXT_RESET);
        else if(day==4)System.out.println(TEXT_GREEN+"Wednesday for green of the plant (Blend of green and copper)"+TEXT_RESET);
        else if(day==5)System.out.println(TEXT_YELLOW+TEXT_GREEN+"Thursday for green or yellowish green of the leaves of a banana palm."+TEXT_RESET);
        else if (day==6) System.out.println(TEXT_BLUE+"Friday for Blue."+TEXT_RESET);
        else if(day==7)System.out.println(TEXT_GREEN+"Saturday for ripe spine."+TEXT_RESET);
    }
    
}
class MainProgram{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day;
        System.out.print("Please input date: ");
        day = sc.nextInt();
        KhmerColorDay date = new KhmerColorDay(day);
        date.displayResult();
    }
}
