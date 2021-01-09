import java.util.*;
public class ListStudent {
    // make student as list to add an objects in list
    List<Student> students=new ArrayList<Student>();
    Scanner sc = new Scanner(System.in);
    public List<Student> listAllStudent(){
        return students;
    }
    public Student getASudent(int i){
        return listAllStudent().get(i);
    }
    public void addStudent(Student student){
        students.add(student);
        System.out.println(student.getName()+" has been added");
    }
    public void deleteAllStudent(){
        students.removeAll(students);
    }
    public void displayListStudent(){
        System.out.println("\n\nStudentList");
        System.out.println("SID\tSName");
        for(Student student: listAllStudent()){
            System.out.println(student.getId()+"\t"+student.getName());
        }
        if (listAllStudent().isEmpty()) {
            System.out.println("There's no student.");
        }
        System.out.println();
    }
    public void updateStudentByID(String id){
        int p = 1;
        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()){
            Student student = itr.next();
            if(id.equals(student.getId())){
                System.out.println("Student ID:"+student.getId()+"and name:"+student.getName()+"is updated");
                System.out.print("Input new student name:");
                String name = sc.next();
                student.setName(name);
                p=0;
            }
        }
        if(p==1){
            System.out.println("there no "+id+" as"+" id to update in student list!");
        }
    }
    public void removeStudentByName(String name){
        int p=0;
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if(name.equals(student.getName())){
                System.out.println("Student ID: "+student.getId()+" and name: "+student.getName()+" has been deleted" );
                itr.remove();
                p=1;
            }
        }
        if(p==0){
            System.out.println("there no student's name:"+name+"\n");
        }
    }
    public void readMenu(){
        System.out.println("Student List System\n");
        System.out.println("1.Add new student\n"+
        "2. List students\n"+
        "3. Remove student by name\n"+
        "4. Update student information by id\n"
        +"5. Quit");
        System.out.print("Enter choice[1-5]:");
    }
}
