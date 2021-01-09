import java.util.*;
public class Course {
    private String course;
    List<Course> listCourse = new ArrayList<Course>();
    public Course(){ 
        
    }
    public List<Course> getListCourse(){
        return listCourse;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String getCourseName(){
        return course;
    }
    public void listAllCourse(){
        int i=0;
        System.out.println("\nrID\tCourses' name");
        for (Course courses : getListCourse()) {
            System.out.println((i+1)+"\t"+courses.getCourseName());
            i+=1;
        }
        if(getListCourse().isEmpty()){
            System.out.println("There is no course.");
        }
    }
    public void findCourseByName(String name){
        int i=0;
        int p=0;
        System.out.println("\nrID\tCourseList:\n");
        System.out.println("");
        Iterator<Course> itr = getListCourse().iterator();
        while (itr.hasNext()) {
            Course courses= itr.next();
            if(name.equals(courses.getCourseName())){
                System.out.println((i+1)+"\t"+courses.getCourseName());
                i+=1;
                p=1;
            }
        }
        if(p==0){
            System.out.println("There is no "+name+" in Course List.");
        }
    }
    public void addNewCourse(Course course){
        getListCourse().add(course);
        System.out.println(course.getCourseName()+" has been added");
    }
    public void displayMenu(){
        System.out.println("\nProgram for all courses\n"+
        "1.List all courses\n"+
        "2.Find courses by name\n"+
        "3.Add new course\n"+
        "4.Quit");
        System.out.print("Enter choices:");

    }

}
