import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TODO:update
public class Vehicle {
    private String number;
    private int year_creation;
    private double price;
    private Date date_availability;
    private String vehicle_type;

    private Statement stmt = null;
    private Connection conn = null;
    Scanner sc = new Scanner(System.in);

    public Vehicle() {
    }

    public String getVehicle_type() {
        return this.vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public Connection getConn() {
        return this.conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    };

    public Statement getStmt() {
        return this.stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Vehicle(String number, int year_creation, double price, Date date_availability, String vehicle_type) {
        setDate_availability(date_availability);
        setNumber(number);
        setPrice(price);
        setYear_creation(year_creation);
        setVehicle_type(vehicle_type);
    }

    public void updateDataToDatabase() {
        System.out.println("Search number of vehicle to update:");
        setNumber(sc.nextLine());
        ResultSet result = checkExist();
        if (result != null) {
            System.out.println("Vehicle " + getNumber() + " is exists please update");
            System.out.println("Input type of vehicle:");
            setVehicle_type(sc.nextLine());
            System.out.println("Input Year creation:");
            setYear_creation(Integer.parseInt(sc.nextLine()));
            System.out.println("Input price:");
            setPrice(Double.parseDouble(sc.nextLine()));
            System.out.println("Date of Avalability(dd/MM/yyyy):");
            try {
                setDate_availability(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                java.sql.Date date = new java.sql.Date(getDate_availability().getTime());
                getStmt().executeUpdate(String.format("update `Vehicle` set `vehicle_type`='%s',`year_of_creation`= '%d' ,`price`='%.3f',`date_available`=DATE '"+date.toString()+"';",
                getVehicle_type(),getYear_creation(),getPrice(),getPrice()));
                System.out.println("Vehicle "+getNumber()+" has been updated");
            } catch (Exception e) {
                System.out.println("Cant update data");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("There is no Vehicle "+getNumber());
        }

    }

    public void removeFromDatabase() {
        System.out.println("Remove by number of vehicle:");
        setNumber(sc.nextLine());
        try {
            getStmt().executeUpdate("delete from `Vehicle` where vehicle_number='" + getNumber() + "';");
            System.out.println("Vehicle "+getNumber()+" has been removed");
        } catch (Exception e) {
            System.out.println("Can't delete or there is no " + getNumber() + " in vehicle list");
        }
    }

    public void ListFromDatabase() {
        try {
            ResultSet alldata = getStmt().executeQuery("select * from `Vehicle`;");
            while (alldata.next()) {
                System.out.println(String.format(
                        "Vehicle{Number :%s, vehicle_type:%s,year creation: %d,price: %.2f,date_available: %s }",
                        alldata.getString("vehicle_number"), alldata.getString("vehicle_type"),
                        alldata.getInt("year_of_creation"), alldata.getDouble("price"),
                        alldata.getString("date_available")));
            }
            if (!alldata.next()) {
                System.out.println("There is no vehicle in stock!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputData() {
        System.out.println("Input vehicle number:");
        setNumber(sc.nextLine());
        System.out.println("Input type of vehicle:");
        setVehicle_type(sc.nextLine());
        System.out.println("Input Year creation:");
        setYear_creation(Integer.parseInt(sc.nextLine()));
        System.out.println("Input price:");
        setPrice(Double.parseDouble(sc.nextLine()));
        System.out.println("Date of Avalability(dd/MM/yyyy):");
        try {
            setDate_availability(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet checkExist() {
        try {
            ResultSet alldata = getStmt()
                    .executeQuery("select * from `Vehicle` where vehicle_number='" + getNumber() + "';");
            if (alldata.next()) {
                return alldata;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void insertToDatabase() {
        try {
            ResultSet alldata = getStmt()
                    .executeQuery("select * from `Vehicle` where vehicle_number='" + getNumber() + "';");
            if(!alldata.next()){
                try {
                    java.sql.Date data = new java.sql.Date(getDate_availability().getTime());
                    String sql = String.format(
                            "insert into `Vehicle` (`vehicle_number`,`vehicle_type`,`year_of_creation`,`price`,`date_available`) values ('%s','%s',%d,%.3f,DATE '"
                                    + data.toString() + "');",
                            getNumber(), getVehicle_type(), getYear_creation(), getPrice());
                   
                    getStmt().executeUpdate(sql);
                    System.out.println("Vehicle "+getNumber()+" has been added");
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
    
                }
            }else{
                System.out.println("Cant insert or Vehicle "+getNumber()+" already exists.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void readMenu() {
        System.out.println("1. List all vehicles (Listing from Database)" + "\n2. Add new vehicle (store in Database)\n"
                + "3. Remove vehicle by number of vehicle(delete from Database)\n"
                + "4. Update vehicle by number (update data in Database)\n" + "5.Exit");
        System.out.println("Enter choice:");
    }

    public void createDatebase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting database");
            setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/", "admin", "admin4321"));
            setStmt(getConn().createStatement());
            System.out.println("Start up database");
            getStmt().executeUpdate("create database if not exists `Vehicle`;");
            getStmt().executeUpdate("use `Vehicle`;");
            System.out.println("databse created");
            getStmt().executeUpdate(
                    "create table if not exists `Vehicle` (vehicle_number varchar(100) unique,vehicle_type varchar(100),year_of_creation int,price decimal(13,3),date_available DATE);");
            System.err.println("table created");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "{" + " number='" + getNumber() + "'" + ", year_creation='" + getYear_creation() + "'" + ", price='"
                + getPrice() + "'" + ", date_availability='" + getDate_availability() + "'" + ", type='"
                + getVehicle_type() + "'" + "}";
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear_creation() {
        return this.year_creation;
    }

    public void setYear_creation(int year_creation) {
        this.year_creation = year_creation;
    }

    public void closeDatabase() {
        if (getConn() != null) {
            try {
                getConn().close();
            } catch (SQLException e) {
                System.out.println("Cant close database");
            }
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate_availability() {
        return this.date_availability;
    }

    public void setDate_availability(Date date_availability) {
        this.date_availability = date_availability;
    }

}

class TestVehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Vehicle vehicle = new Vehicle();
        vehicle.createDatebase();
        while (true) {
            vehicle.readMenu();
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1)
                vehicle.ListFromDatabase();
            else if (choice == 2) {
                vehicle.inputData();
                vehicle.insertToDatabase();
            } else if (choice == 3)
                vehicle.removeFromDatabase();
            else if (choice == 4)
                vehicle.updateDataToDatabase();
            else if (choice == 5) {
                vehicle.closeDatabase();
                System.out.println("Exit program");
                break;
            }
        }
    }
}