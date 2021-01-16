import java.util.Scanner;

public class MainSMSEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SMSList smses = new SMSList();
        smses.loadSMS();
        int choice;
        do {
            smses.readMenuEn();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    smses.add();
                    break;
                case 2:
                    smses.viewDetail();
                    break;
                case 3:
                    smses.show();
                    break;
                case 4:
                    smses.remove();
                    break;
                case 5:
                    smses.writeInFile();
                    System.out.println("Bye! Bye! have a good day");
                    break;
                default:
                    break;
            }
        } while (choice != 5);

    }
}
