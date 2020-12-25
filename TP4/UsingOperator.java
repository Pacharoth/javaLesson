import java.util.Formatter;
public class UsingOperator {
    public static void main(String[] args) {
        //int a = Integer.valueOf("00111100",2);
        //int a = 0x3C;
        int a = 60;
        String strA=String.format("%32s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("a=%d\t%s\t%s\n", a, strA,Integer.toHexString(a));
        int b = 13;
        String strB = String.format("%32s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("b=%d\t%s\t%s\n", b, strB,Integer.toHexString(b));
        System.out.println("----------------------------------------");
        int aNb = a & b;
        String strANB = String.format("%32s",Integer.toBinaryString(aNb)).replace(' ','0');
        System.out.printf("a&b  \t%s\t%s\n",strANB, Integer.toHexString(aNb));
        int CompA = ~a;
        String strCompA = String.format("%32s",Integer.toBinaryString(CompA)).replace(' ','0');
        System.out.printf("~a  \t%s\t%s\n",strCompA, Integer.toHexString(CompA));
        int c = a>b ? a : b;
        a = 7<<2;
        System.out.println(a);
    }
}