package StudentData;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Student {
    private String name, city, country;
    private Date dob;
    private int tel;
    private Group group;

    private Student() { }

    public Student(String name, String city, String country, Date dob, int tel)
            throws BirthDateException {
        setName(name);
        setCity(city);
        setCountry(country);
        setDob(dob);
        setTel(tel);
    }

    public static Student dataInput() throws Exception{
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Input name: ");
        student.setName(sc.nextLine());
        System.out.print("Input city: ");
        student.setCity(sc.nextLine());
        System.out.print("Input country:");
        student.setCountry(sc.nextLine());
        System.out.print("Input Telephone:");
        student.setTel(Integer.parseInt(sc.nextLine()));
        System.out.print("Input Date(dd/mm/yyyy):");
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        student.setDob(d);
        System.out.print("Input group's name:");
        student.group=new Group(sc.nextLine());
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                ", tel=" + tel +
                ", group=" + group.toString() +
                '}';
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName(){return name;}
    public void setName(String name){
        FieldUtil.checkNullOrEmptyOrBlank(name,"Name");
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        FieldUtil.checkNullOrEmptyOrBlank(city, "City");
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        FieldUtil.checkNullOrEmptyOrBlank(country, "Country");
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) throws BirthDateException{
        Calendar cal = Calendar.getInstance();//current date and time
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 12);
        Date twelveYearsOld = cal.getTime();
        if(dob.compareTo(twelveYearsOld) <= 0) {
            this.dob = dob;
        }else
            throw new BirthDateException();
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        FieldUtil.checkNullOrEmptyOrBlank(String.valueOf(tel), "Telephone");
        this.tel = tel;
    }

}