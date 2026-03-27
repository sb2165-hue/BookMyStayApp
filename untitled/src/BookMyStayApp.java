import java.util.*;
class BookMyStayApp{
    private final String roomType;
    private final double price;
    private final List<String> amenities;

    public BookMyStayApp(String roomType, double price, List<String> amenities) {
        this.roomType = roomType;
        this.price = price;
        this.amenities = new ArrayList<>(amenities); // defensive copy
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getAmenities() {
        return new ArrayList<>(amenities); // return copy
    }
}

// Inventory: State holder (Read-only access during search)
class BookMyStayApp {
    private final Map<String, Integer> roomAvailability = new HashMap<>();

    public void addRoom(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public int getAvailableCount(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getAllAvailability() {
        return Collections.unmodifiableMap(roomAvailability); // read-only view
    }
}

// Search Service: Handles search logic (No state modification)
class BookMyStayApp {

    private final Inventory inventory;
    private final Map<String, Room> roomCatalog;

    public BookMyStayApp(Inventory inventory, Map<String, Room> roomCatalog) {
        this.inventory = inventory;
        this.roomCatalog = roomCatalog;
    }

    public List<Room> searchAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : inventory.getAllAvailability().entrySet()) {
            String roomType = entry.getKey();
            int count = entry.getValue();

            // Validation: include only available rooms
            if (count > 0 && roomCatalog.containsKey(roomType)) {
                availableRooms.add(roomCatalog.get(roomType));
            }
        }

        return availableRooms;
    }
}

// Main class (Driver)
public class BookMyStayApp {

    public static void main(String[] args) {

        // Step 1: Create Room Catalog
        Map<String, Room> roomCatalog = new HashMap<>();
        roomCatalog.put("Deluxe", new Room("Deluxe", 2500, Arrays.asList("WiFi", "AC")));
        roomCatalog.put("Suite", new Room("Suite", 5000, Arrays.asList("WiFi", "AC", "Pool")));
        roomCatalog.put("Standard", new Room("Standard", 1500, Arrays.asList("Fan")));

        // Step 2: Setup Inventory
        Inventory inventory = new Inventory();
        inventory.addRoom("Deluxe", 3);
        inventory.addRoom("Suite", 0);   // unavailable
        inventory.addRoom("Standard", 5);

        // Step 3: Perform Search
        SearchService searchService = new SearchService(inventory, roomCatalog);
        List<Room> availableRooms = searchService.searchAvailableRooms();

        // Step 4: Display Results
        System.out.println("Available Rooms:\n");

        for (Room room : availableRooms) {
            System.out.println("Room Type : " + room.getRoomType());
            System.out.println("Price     : ₹" + room.getPrice());
            System.out.println("Amenities : " + room.getAmenities());
            System.out.println("---------------------------");
        }
    }
}