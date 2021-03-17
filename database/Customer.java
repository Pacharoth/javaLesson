import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Customer {
    private Integer number = null;
    private Date date_enter = null;
    private OrderStatus status = OrderStatus.NONE;
    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate_enter() {
        return this.date_enter;
    }

    public void setDate_enter(Date date_enter) {
        this.date_enter = date_enter;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public Customer(Integer number,Date date_enter,OrderStatus status){
        this.number = number;
        this.date_enter=date_enter;

    }
    public Customer(Integer number){
        this(number, null, OrderStatus.None))
    }
    public void dateInput(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Input number:");
        setNumber(Integer.parseInt(sc.nextLine()));
        System.out.println("Input date: ");
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy H:m:s");
        try {
            setDate_enter(dateFormat.parse(sc.nextLine()));
        } catch (Exception err) {
            System.err.println("Invalid date and time format.");
        }
        setStatus(OrderStatus.valueOf(sc.nextLine().toUpperCase()));
    }
    public void loadData(Connection conn,int number) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs =  stmt.executeQuery("Select * from `customer` where number="+number);
        if(rs.next()){
            setNumber(number);
            setDate_enter(rs.getDate("date_enter"));
            setStatus(OrderStatus.valueOf(rs.getString("status")));
        }
    }
    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", date_enter='" + getDate_enter() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }


}

enum OrderStatus{NONE, WAITING_TO_ORDER, WAITING_FOR_FOOD, ORDERING}