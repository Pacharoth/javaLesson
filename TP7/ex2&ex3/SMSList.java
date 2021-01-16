import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SMSList {
    int initialize=0;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> SMSes = new ArrayList<>();

    public void readMenuEn() {
        System.out.println("1.Send new SMS with Encrypted content using password method\n" + "2.View SMS detail\n"
                + "3. List SMSes\n" + "4. Remove SMSes by index\n" + "5. Quit\n");
        System.out.print("Enter choice:");
    }

    public void readMenuDe() {
        System.out.println("1.List all SMSes\n" + "2.View SMS detail\n" + "3. View readable SMSes\n"
                + "4. Remove SMSes by index\n" + "5. Quit\n");
        System.out.print("Enter choice:");
    }

    public void loadSMS() {
        try {

            File files = new File("./data");
            // System.out.println(files.list().length);
            for (int i = 0; i < files.list().length; i++) {
                File myFile = new File("./data/SMS"+i+".txt");
                Scanner reader = new Scanner(myFile);
                String data = reader.nextLine();
                SMSes.add(data);
            }
        } catch (Exception e) {
            System.out.println("cant found the file");
            e.printStackTrace();
        }
    }
    public void writeInFile(){
        try {
            int i=0;
            for (String myobj : SMSes) {
                FileWriter myWriter = new FileWriter("./data/SMS"+i+".txt");
                myWriter.write(myobj);
                i++;
                myWriter.close();
            }
            
        } catch (IOException e) {
            System.out.println("Error occured.");
            e.printStackTrace();
        }
    }
    public void add() {
        
        String subjects, phone_numbers, recieve_numbers, passwords, types, contents, status;
        System.out.println("Add information");
        System.out.print("Enter password to encrypt your message:");
        passwords = sc.nextLine();
        System.out.print("Subject:");
        subjects = sc.nextLine();
        System.out.print("Phone number:");
        phone_numbers = sc.nextLine();
        System.out.print("Recieve number:");
        recieve_numbers = sc.nextLine();
        System.out.print("Type Message(text/mms):");
        types = sc.nextLine();
        System.out.print("Content:");
        contents = sc.nextLine();
        System.out.print("Status(new/read):");
        status = sc.nextLine();
        SMS sms = new SMS(subjects, phone_numbers, recieve_numbers, types, contents, status);
        System.out.println(sms.toString());
        EncryptMessage encryptmsg = new EncryptMessage(sms.toString(), passwords);
        SMSes.add(encryptmsg.encryptMessage());
        System.out.println("SMS is sent");
        // initialize+=1;
    }

    public void viewDetail() {
        int index;
        show();
        System.out.println("Find detail in Encryption");
        System.out.print("Please enter by index to find specific msg:");
        index = sc.nextInt();
        String s = findByIndex(index);
        if (s != null)
            System.out.println("Message content:" + s + "\n\n");
        else
            System.out.println("Message is not found at index " + index);
    }

    public void show() {
        int i = 0;
        for (String sms : SMSes) {
            System.out.println("index =" + i + "\t" + sms + "\n\n");
            i += 1;
        }
        if(SMSes.isEmpty()){
            System.out.println("No SMS");
        }
    }

    public String findByIndex(int index) {
        int i = 0;
        for (String sms : SMSes) {
            if (index == i) {
                return sms;
            }
            i++;
        }
        return null;
    }

    public void remove() {
        int index;
        show();
        System.out.println("Use index/order to remove");
        System.out.print("index at:");
        index = sc.nextInt();
        String s = findByIndex(index);
        if (s != null) {
            System.out.println("SMS at index " + index + " is removed");
            deleteFile(index);
            SMSes.remove(s);
            initialize+=1;
        } else
            System.out.println("SMS at index " + index + " is not found");
    }
    public void deleteFile(int s){
        try {

            File files = new File("./data");
            System.out.println(files.list().length);
            for (int i = 0; i < files.list().length; i++) {
                File myFile = new File("./data/SMS"+i+".txt");
                Scanner reader = new Scanner(myFile);
                String data = reader.nextLine();
                if(i==s){
                    System.out.println(s);
                    myFile.delete();
                }
            }
        } catch (Exception e) {
            // System.out.println("cant found the file");
            e.printStackTrace();
        }
    }
}
