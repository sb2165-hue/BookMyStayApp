import java.util.HashMap;
import java.util.Map;

// Inventory Manager
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register Room Type
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Update Availability
    public void updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, count);
        } else {
            System.out.println("Room type not found.");
        }
    }

    // Get Availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Display Inventory
    public void displayInventory() {
        System.out.println("===== Current Room Inventory =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }

        System.out.println();
    }
}

// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.addRoomType("Single Room", 10);
        inventory.addRoomType("Double Room", 5);
        inventory.addRoomType("Suite Room", 2);

        // Display current inventory
        inventory.displayInventory();

        // Update availability
        inventory.updateAvailability("Single Room", 8);

        // Display updated inventory
        System.out.println("After Updating Availability:");
        inventory.displayInventory();
    }
}