import java.util.*;

// Reservation: Represents a booking request
class Reservation {
    private final String guestName;
    private final String roomType;
    private final int nights;

    public Reservation(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName +
                ", Room: " + roomType +
                ", Nights: " + nights;
    }
}

// BookingRequestQueue: Maintains FIFO order
class BookingRequestQueue {
    private final Queue<Reservation> queue = new LinkedList<>();

    // Add request to queue
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request Added: " + reservation);
    }

    // View all requests (read-only)
    public List<Reservation> viewAllRequests() {
        return new ArrayList<>(queue); // defensive copy
    }

    // Peek next request (without removing)
    public Reservation peekNext() {
        return queue.peek();
    }

    // Get queue size
    public int size() {
        return queue.size();
    }
}

// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Step 1: Guests submit booking requests
        requestQueue.addRequest(new Reservation("Alice", "Deluxe", 2));
        requestQueue.addRequest(new Reservation("Bob", "Suite", 1));
        requestQueue.addRequest(new Reservation("Charlie", "Standard", 3));
        requestQueue.addRequest(new Reservation("Diana", "Deluxe", 1));

        System.out.println("\n--- All Booking Requests (FIFO Order) ---");

        // Step 2: View all requests (without modifying queue)
        List<Reservation> allRequests = requestQueue.viewAllRequests();

        for (Reservation r : allRequests) {
            System.out.println(r);
        }

        // Step 3: Peek next request to be processed
        System.out.println("\nNext Request to Process:");
        System.out.println(requestQueue.peekNext());

        // Step 4: Show queue size
        System.out.println("\nTotal Requests in Queue: " + requestQueue.size());
    }
}