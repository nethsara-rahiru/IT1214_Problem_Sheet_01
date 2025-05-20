import java.util.*;

class Vehicle{
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }
    void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    void setHoursParked(int hoursParked){
        this.hoursParked = hoursParked;
    }
    String getLicensePlate(){
        return licensePlate;
    }
    String getOwnerName(){
        return ownerName;
    }
    int getHoursParked(){
        return hoursParked;
    }

}

class App{
    public static void main(String[] args){

    }
}