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

class ParkingLot{
    int maxVehicle = 5;
    Vehicle[] vehicle = new Vehicle[maxVehicle];

    void newVehicle(){
        for (int i = 0; i < maxVehicle; i++ ){
            if(Vehicle[i] == null){

                Scanner scan = new Scanner(System.in);

                vehicle[i] = new Vehicle();
                System.out.println("Please enter the License Plate");
                vehicle[i].setLicensePlate(scan.nextLine());
                System.out.println("Please enter the Owner NAme");
                vehicle[i].setOwnerName(scan.nextLine());
                System.out.println("Please enter the Hours Parked");
                vehicle[i].setHoursParked(Integer.parseInt(scan.nextLine()));
            }
        }

        void showVehicle(){

            System.out.println("Slot Details");
            System.out.println("-------------------------------------");

            for (int i = 0; i < maxVehicle; i++ ){
                if (Vehicle[i] != null){

                    // Complete this
                    System.out.println("Slot Details");
                    vehicle[i] = new Vehicle();
                    System.out.println("Please enter the License Plate");
                    vehicle[i].setLicensePlate(scan.nextLine());
                    System.out.println("Please enter the Owner NAme");
                    vehicle[i].setOwnerName(scan.nextLine());
                    System.out.println("Please enter the Hours Parked");
                    vehicle[i].setHoursParked(Integer.parseInt(scan.nextLine()));
                }
            }
        }

        void removeVehicle(){

            Scanner scan = new Scanner();
            int numP = Integer.parseInt(scan.nextLine());

            for (int i = 0; i < maxVehicle; i++ ){
                if(Vehicle[i] == null){
                }
                else{
                    if(Vehicle[i].getLicensePlate == numP){
                        Vehicle[i].setLicensePlate = "";
                        Vehicle[i].setOwnerName = "";
                        Vehicle[i].setHoursParked = 0;
                        System.out.println("Vehicle is sucssesfully removed");

                    }
                }
            }
        }
    }
}

class App{
    public static void main(String[] args){

        int system = 1;

        Scanner scan = new Scanner(System.in);
        ParkingLot pl = new ParkingLot();
        
        while(system == 1){
            System.out.println("--------------------------------------------");
            System.out.println("Welcome to the Parking App")
            System.out.println("--------------------------------------------");
            System.out.println("");
            System.out.println("Please select a option...");
            System.out.println(" 1 - Add a new Vehicle");
            System.out.println(" 2 - Remove a new Vehicle");
            System.out.println(" 3 - Display slots");
            System.out.println(" 4 - exit");

            input = Integer.parseInt(scan.nextLine());

            switch (input) {
                case 1:
                    pl.newVehicle();
                    break;
            
                case 2:
                    pl.removeVehicle();
                    break;
            
                case 3:
                    
                    break;
            
                case 4:
                    system = 0;
                    break;
            
                default:
                    break;
            }
        }
    }
}