import java.util.*;
public class TestStudent {
    
    public static void main(String[] args) {
        ListStudent listStudent = new ListStudent();
        int choice,i=0;
        String name,id;
        Scanner sc = new Scanner(System.in);
        while (true) {
            listStudent.readMenu();
            choice = sc.nextInt();
            if(choice==1){
                System.out.print("Input student's name[For id it will increment]:");
                name = sc.nextLine();
                name = sc.nextLine();
                Student student = new Student(i, name);
                i++;
                listStudent.addStudent(student);
            }else if(choice==2){
                listStudent.displayListStudent();
            }else if(choice==3){
                listStudent.displayListStudent();
                System.out.print("Input student's name to delete:");
                name = sc.nextLine();
                name = sc.nextLine();
                listStudent.removeStudentByName(name);
            }
            else if(choice==4){
                listStudent.displayListStudent();
                System.out.print("Input student's id to update:");
                id = sc.nextLine();
                id = sc.nextLine();
                listStudent.updateStudentByID(id);
            }
            else if (choice==5) {
                System.out.println("Bye Bye!");
                break;
            }
        }
    }
}
