
//TODO:1. listt all vehicle type in table vehicle_types
//TODO:2. Add new vehicle_types (listing from database)
//TODO:3. Remove vehicle_type by id (all vehicles associated with this vehicle_type also be removed)

/*
Update Vehicle class created above by changing datatype of vehicle_type field to reference to a new created
VehicleType class. The VehicleType class include fields such as id and name. A table in database is also be
created to store these vehicle_types. Create java program that can:
1. List all vehicle_types (Listing from Database)
2. Add new vehicle_type (Store in Database)
3. Remove vehicle_type by id (all vehicles associated with this vehicle_type also be removed)*/
public class VehicleType {
    private String name;
    private int id;

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
