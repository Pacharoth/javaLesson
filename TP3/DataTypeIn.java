// import java.util.Scanner;
// public class DataTypeIn {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         try {
//             byte b1=2;
//             System.out.print("Input a byte value [-128, 127]: ");
//             Byte b = Byte.valueOf(sc.nextLine(),2);//-128...127
//             System.out.println(b);
//         }catch (NumberFormatException e){   
//             System.err.println("Invalid input byte value!\nvalid range is between -128 to 127.");

//         }
//     }
// }
import java.util.Scanner;
public class DataTypeIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Input a byte value ["+(int)Math.pow(-2,15)+" - "+(int)(Math.pow(2,15)-1)+"]: ");
            Short s = Short.parseShort(sc.nextLine());//-2**15...2**15
            System.out.println(s);
        }catch (NumberFormatException e){
            System.err.println("Invalid input short value!\nvalid range is between "+(int)Math.pow(-2,15)+" to "+(int)(Math.pow(2,15)-1)+".");
            e.printStackTrace();
        }
        sc.close();
    }
}