import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*Create class VehicleStore containing the following features:
1. List all vehicle_types (Listing from Database)
2. Add new vehicle_type (Store in Database)
3. Remove vehicle_type by id (all vehicles associated with this vehicle_type also be removed)
4. List all vehicles in a vehicle_type (Listing from Database)
5. Add new vehicle (store in Database)
6. Remove vehicle by number (delete from Database)
7. Update vehicle by number (update data in Database)
TODO:8. Sell vehicle(s) to customer(s) (programmer can add more classes/tables as needed)*/
public class VehicleStore {
    private Vehicle vehicle = new Vehicle();
    private VehicleType vehicleType = new VehicleType();
    private Connection conn = null;
    private Statement statement = null;
    private String CustomerName=null;
    Scanner sc = new Scanner(System.in);
    public String getCustomerName() {
        return this.CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public Connection getConn() {
        return this.conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStatement() {
        return this.statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void listVehicleType() {
        getVehicleType().listTypeFromDatabase();
    }

    public void listAllVehicle() {
        getVehicle().ListFromDatabase();
    }

    public void addNewVehicleType() {
        getVehicleType().insertNewType();
    }

    public void removeVehicleTypeById() {
        getVehicleType().removeVehicleType();
    }

    public void listAllVehicleByVehicleType() {
        getVehicleType().listAllVehicleByType();
    }

    public void addNewVehicle() {
        getVehicle().inputData();
        getVehicle().insertToDatabase();
    }

    public void removeVehicleByNumber() {
        getVehicle().removeFromDatabase();
    }

    public void updateVehicleByNumber() {
        getVehicle().updateDataToDatabase();
    }

    public void readMenu() {
        System.out.println("1. List all vehicle_types (Listing from Database)\n"
                + "2. Add new vehicle_type (Store in Database)\n"
                + "3. Remove vehicle_type by id (all vehicles associated with this vehicle_type also be removed)\n"
                + "4. List all vehicles in a vehicle_type (Listing from Database)\n"
                + "5. Add new vehicle (store in Database)\n" + "6. Remove vehicle by number (delete from Database)\n"
                + "7. Update vehicle by number (update data in Database)\n"
                + "8. Sell vehicle(s) to customer(s) (programmer can add more classes/tables as needed)\n"
                + "9. Exit the program\n" + "10.List all vehicle\n"+
                "11. List customer");
        System.out.print("Enter choice:");
    }
    public void sellVehicleToCustomer(){
        System.out.println("Enter name customer:");
        setCustomerName(sc.nextLine());
        System.out.println("Enter Vehicle to buy by Number Vehicle:");
        getVehicle().setNumber(sc.nextLine());
        try {
            ResultSet res = getStatement().executeQuery("select * from Vehicle where vehicle_number='"+getVehicle().getNumber()+"';");
            if(res.next()){
                try {
                    getStatement().executeUpdate("insert into Customer(`customer_name`,`vehicle_number`) values('"+getCustomerName()+"','"+getVehicle().getNumber()+"');");
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("There is not vehicle "+getVehicle().getNumber());

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void createDatabase() {
        getVehicle().createDatebase(getVehicleType());
        setConn(getVehicle().getConn());
        setStatement(getVehicle().getStmt());
        try {
            getStatement().executeUpdate(
                    "create table if not exists `Customer`(CustomerId int not null primary key auto_increment,customer_name varchar(100) not null,vehicle_number varchar(200) not null,foreign key(vehicle_number) references Vehicle(vehicle_number) on delete cascade);");
            System.out.println("Customer "+getCustomerName()+" has bought vehicle number "+getVehicle().getNumber());

        } catch (Exception e) {
            System.out.println("cant create table customer");
        }
    }
    public void listCustomers(){
        try {
            ResultSet resu = getStatement().executeQuery("select * from Customer");
            if(resu.next()){
               try {
                ResultSet result = getStatement().executeQuery("select * from Customer natural join Vehicle");
                while (result.next()) {
                    System.out.println("Customer{id:"+result.getInt("CustomerId")+",customer name:"+result.getString("customer_name")+",vehicle:"+result.getString("vehicle_number")+"}");
                }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
            }else{
                System.out.println("There is no customer in Customer Table");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeDatabase() {
        getVehicle().closeDatabase();
    }

}

class MainVehicleStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleStore vehicleStore = new VehicleStore();
        int choice;
        vehicleStore.createDatabase();
        while (true) {
            vehicleStore.readMenu();
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                vehicleStore.listVehicleType();
            } else if (choice == 2) {
                vehicleStore.addNewVehicleType();
            } else if (choice == 3) {
                vehicleStore.removeVehicleTypeById();
            } else if (choice == 4) {
                vehicleStore.listAllVehicleByVehicleType();
            } else if (choice == 5) {
                vehicleStore.addNewVehicle();
            } else if (choice == 6) {
                vehicleStore.removeVehicleByNumber();
            } else if (choice == 7) {
                vehicleStore.updateVehicleByNumber();
            } else if (choice == 8) {
                vehicleStore.sellVehicleToCustomer();
            } else if (choice == 9) {
                System.out.println("Exit program");
                break;
            } else if (choice == 10) {
                vehicleStore.listAllVehicle();
            }else if(choice==11){
                vehicleStore.listCustomers();
            }
        }
    }
}
