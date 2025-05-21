import java.util.*;

class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    String getLicensePlate() {
        return licensePlate;
    }

    String getOwnerName() {
        return ownerName;
    }

    int getHoursParked() {
        return hoursParked;
    }
}

class ParkingLot {
    int maxVehicle = 5;
    Vehicle[] vehicle = new Vehicle[maxVehicle];

    void newVehicle() {
        for (int i = 0; i < maxVehicle; i++) {
            if (vehicle[i] == null) {
                Scanner scan = new Scanner(System.in);
                vehicle[i] = new Vehicle();

                System.out.print("Please enter the License Plate: ");
                vehicle[i].setLicensePlate(scan.nextLine());

                System.out.print("Please enter the Owner Name: ");
                vehicle[i].setOwnerName(scan.nextLine());

                System.out.print("Please enter the Hours Parked: ");
                vehicle[i].setHoursParked(Integer.parseInt(scan.nextLine()));
                
                System.out.println("Vehicle added to slot " + (i + 1));
                break; // Only add one vehicle at a time
            }
        }
    }

    void showVehicle() {
        System.out.println("\nSlot Details");
        System.out.println("-------------------------------------");

        for (int i = 0; i < maxVehicle; i++) {
            if (vehicle[i] != null) {
                System.out.println("Slot Number   : " + (i + 1));
                System.out.println("License Plate : " + vehicle[i].getLicensePlate());
                System.out.println("Owner         : " + vehicle[i].getOwnerName());
                System.out.println("Hours         : " + vehicle[i].getHoursParked());
                System.out.println("-------------------------------------");
            }
        }
    }

    void removeVehicle() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter License Plate to remove: ");
        String plateToRemove = scan.nextLine();

        for (int i = 0; i < maxVehicle; i++) {
            if (vehicle[i] != null && vehicle[i].getLicensePlate().equals(plateToRemove)) {
                vehicle[i] = null;
                System.out.println("Vehicle successfully removed from slot " + (i + 1));
                return;
            }
        }
        System.out.println("Vehicle with License Plate " + plateToRemove + " not found.");
    }
}

public class App {
    public static void main(String[] args) {
        int system = 1;
        int input;

        Scanner scan = new Scanner(System.in);
        ParkingLot pl = new ParkingLot();

        while (system == 1) {
            System.out.println("\n--------------------------------------------");
            System.out.println("Welcome to the Parking App");
            System.out.println("--------------------------------------------");
            System.out.println("Please select an option...");
            System.out.println(" 1 - Add a new Vehicle");
            System.out.println(" 2 - Remove a Vehicle");
            System.out.println(" 3 - Display slots");
            System.out.println(" 4 - Exit");

            System.out.print("Enter your choice: ");
            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (input) {
                case 1:
                    pl.newVehicle();
                    break;
                case 2:
                    pl.removeVehicle();
                    break;
                case 3:
                    pl.showVehicle();
                    break;
                case 4:
                    system = 0;
                    System.out.println("Exiting Parking App.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
