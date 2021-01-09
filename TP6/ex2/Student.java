import java.util.ArrayList;
import java.util.Scanner;
public class Student {
    private String name;
    private String id;
    public Student(int id, String name){
        this.name = name;
        this.id = "e"+id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getId(){
        return id;
    }
    public void setId(int id){
        this.id = "e"+ id;
    }
}
