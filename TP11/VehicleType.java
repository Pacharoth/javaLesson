import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
Update Vehicle class created above by changing datatype of vehicle_type field to reference to a new created
VehicleType class. The VehicleType class include fields such as id and name. A table in database is also be
created to store these vehicle_types. Create java program that can:
1. List all vehicle_types (Listing from Database)
2. Add new vehicle_type (Store in Database)
3. Remove vehicle_type by id (all vehicles associated with this vehicle_type also be removed)*/
public class VehicleType {
    Scanner sc = new Scanner(System.in);
    private String name;
    private int id;
    private Connection conn = null;
    private Statement statement = null;

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

    public void listTypeFromDatabase() {
        try {
            ResultSet resu = getStatement().executeQuery("select * from VehicleTypes;");
            if (resu.next()) {

                try {
                    ResultSet result = getStatement().executeQuery("select * from VehicleTypes;");
                    while (result.next()) {
                        System.out.println("VehicleType{id:" + result.getInt("vehicle_type_id")
                                + ",vehicle type's name:" + result.getString("vehicle_type") + "}");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("There is no data in VehicleType");
            }
        } catch (SQLException e) {
            System.out.println("There is no VehicleTypes");
        }
    }

    public void insertNewType() {
        System.out.println("Enter new Type:");
        setName(sc.nextLine().toLowerCase());
        ResultSet p = checkExist();
        if (p == null) {
            try {
                getStatement().executeUpdate("insert into `VehicleTypes`(`vehicle_type`) values('" + getName() + "');");
                System.out.println("Type " + getName() + " has been added.");
            } catch (SQLException err) {
                System.err.println(err.getMessage());
            }
        } else {
            System.out.println("Cannot insert to database because there is " + getName());
        }
    }

    public void listAllVehicleByType() {
        System.out.println("Enter vehicle's type:");
        setName(sc.nextLine());
        try {
            ResultSet resu = getStatement().executeQuery(
                    "select * from VehicleTypes natural join Vehicle where vehicle_type='" + getName() + "'");
            if (resu.next()) {
                try {
                    ResultSet res = getStatement().executeQuery(
                            "select * from VehicleTypes natural join Vehicle where vehicle_type='" + getName() + "'");
                    while (res.next()) {
                        System.out.println(String.format(
                                "Vehicle{Number :%s, vehicle_type:%s,year creation: %d,price: %.2f,date_available: %s }",
                                res.getString("vehicle_number"), res.getString("vehicle_type"),
                                res.getInt("year_of_creation"), res.getDouble("price"),
                                res.getString("date_available")));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("There no Vehicle in Type " + getName());
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeVehicleType() {
        System.out.println("Enter id type to delete:");
        setId(Integer.parseInt(sc.nextLine()));
        try {
            ResultSet r = getStatement()
                    .executeQuery("select * from `VehicleTypes` where vehicle_type_id=" + getId() + ";");
            if (r.next()) {
                try {
                    getStatement().executeUpdate("delete from `VehicleTypes` where vehicle_type_id=" + getId() + ";");
                    System.out.println("ID " + getId() + " vehicle type has been removed");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("There is no id " + getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ResultSet checkExist() {
        try {
            ResultSet sql = getStatement()
                    .executeQuery("select * from `VehicleTypes` where vehicle_type='" + getName() + "';");
            if (sql.next()) {
                return sql;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void createDatabase(Connection connection, Statement stat) {
        try {
            setConn(connection);
            setStatement(stat);
            getStatement().executeUpdate(
                    "create table if not exists `VehicleTypes`( vehicle_type_id int auto_increment primary key,vehicle_type varchar(200) unique);");
            System.out.println("table Vehicle Type has been created");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
