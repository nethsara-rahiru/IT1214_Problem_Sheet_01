import java.util.*;

class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    int getTicketNumber() {
        return ticketNumber;
    }

    String getCustomerName() {
        return customerName;
    }

    int getSeatNumber() {
        return seatNumber;
    }
}

class BookingSystem {
    int maxSeats = 10;
    Ticket[] tickets = new Ticket[maxSeats];

    void bookTicket() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Ticket Number: ");
        int tNum = Integer.parseInt(scan.nextLine());

        System.out.print("Enter Customer Name: ");
        String cName = scan.nextLine();

        System.out.print("Enter Seat Number (1 - " + maxSeats + "): ");
        int sNum = Integer.parseInt(scan.nextLine());

        if (sNum < 1 || sNum > maxSeats) {
            System.out.println("Invalid seat number.");
            return;
        }

        if (tickets[sNum - 1] != null) {
            System.out.println("Seat already booked.");
            return;
        }

        tickets[sNum - 1] = new Ticket();
        tickets[sNum - 1].setTicketNumber(tNum);
        tickets[sNum - 1].setCustomerName(cName);
        tickets[sNum - 1].setSeatNumber(sNum);

        System.out.println("Ticket booked successfully for seat " + sNum);
    }

    void cancelTicket() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Ticket Number to cancel: ");
        int cancelNum = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < maxSeats; i++) {
            if (tickets[i] != null && tickets[i].getTicketNumber() == cancelNum) {
                tickets[i] = null;
                System.out.println("Ticket " + cancelNum + " canceled.");
                return;
            }
        }

        System.out.println("Ticket not found.");
    }

    void showBookings() {
        System.out.println("Booked Tickets:");
        System.out.println("-------------------------------------");
        for (int i = 0; i < maxSeats; i++) {
            if (tickets[i] != null) {
                System.out.println("Ticket Number : " + tickets[i].getTicketNumber());
                System.out.println("Customer Name : " + tickets[i].getCustomerName());
                System.out.println("Seat Number   : " + tickets[i].getSeatNumber());
                System.out.println("-------------------------------------");
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookingSystem bs = new BookingSystem();
        int system = 1;
        int input;

        while (system == 1) {
            System.out.println("--------------------------------------------");
            System.out.println("Welcome to the Movie Ticket Booking System");
            System.out.println("--------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println(" 1 - Book a Ticket");
            System.out.println(" 2 - Cancel a Ticket");
            System.out.println(" 3 - Show All Bookings");
            System.out.println(" 4 - Exit");

            System.out.print("Enter your choice: ");
            try {
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (input) {
                case 1:
                    bs.bookTicket();
                    break;
                case 2:
                    bs.cancelTicket();
                    break;
                case 3:
                    bs.showBookings();
                    break;
                case 4:
                    system = 0;
                    System.out.println("Exiting Movie Ticket Booking System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
