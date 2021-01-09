import java.util.*;
public class CourseDice {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Course course = new Course();
        String name;
        int choice;
        while (true) {
            course.displayMenu();
            choice = sc.nextInt();
            if(choice==1)course.listAllCourse();
            else if(choice==2){
                System.out.print("search Course Name:");
                sc.nextLine();
                name = sc.nextLine();
                course.findCourseByName(name);
            }
            else if(choice==3){
                System.out.print("Add new course:");
                sc.nextLine();
                name = sc.nextLine();
                Course courses = new Course();
                courses.setCourse(name);
                course.addNewCourse(courses);
            }else if(choice==4){
                System.out.println("Bye bye!");
                break;
            }
        }
    }
}
