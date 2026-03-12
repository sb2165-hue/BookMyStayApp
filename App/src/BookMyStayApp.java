// Abstract Room Class
abstract class Room {
    String roomType;
    double price;
    int availableRooms;

    Room(String roomType, double price, int availableRooms) {
        this.roomType = roomType;
        this.price = price;
        this.availableRooms = availableRooms;
    }

    abstract void displayRoomDetails();
}

// Single Room Class
class SingleRoom extends Room {

    SingleRoom(int availableRooms) {
        super("Single Room", 2000, availableRooms);
    }

    void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: ₹" + price);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}

// Double Room Class
class DoubleRoom extends Room {

    DoubleRoom(int availableRooms) {
        super("Double Room", 3500, availableRooms);
    }

    void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: ₹" + price);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}

// Suite Room Class
class SuiteRoom extends Room {

    SuiteRoom(int availableRooms) {
        super("Suite Room", 6000, availableRooms);
    }

    void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: ₹" + price);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }
}

// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Hotel Room Availability =====");

        // Creating Room Objects
        Room single = new SingleRoom(10);
        Room doubleRoom = new DoubleRoom(5);
        Room suite = new SuiteRoom(2);

        // Display Room Information
        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();

        System.out.println("Application Terminated.");
    }
}