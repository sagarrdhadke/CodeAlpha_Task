import java.util.*;

class Room {
    int roomNumber;
    String category; // Single, Double, Suite, etc.
    boolean isAvailable = true;

    public Room(int number, String category) {
        this.roomNumber = number;
        this.category = category;
    }
}

class Booking {
    String customerName;
    int roomNumber;
    Date checkInDate;
    Date checkOutDate;

    public Booking(String name, int room, Date in, Date out) {
        this.customerName = name;
        this.roomNumber = room;
        this.checkInDate = in;
        this.checkOutDate = out;
    }

    @Override
    public String toString() {
        return "Booking: " + customerName + " | Room: " + roomNumber + " | From: " + checkInDate + " To: "
                + checkOutDate;
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Sample rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(201, "Suite"));
        rooms.add(new Room(202, "Single"));
    }

    public void searchAvailableRooms(String category) {
        for (Room room : rooms) {
            if (room.category.equalsIgnoreCase(category) && room.isAvailable) {
                System.out.println("Available Room: " + room.roomNumber + " (" + room.category + ")");
            }
        }
    }

    public boolean bookRoom(String customerName, int roomNumber, Date checkIn, Date checkOut) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                bookings.add(new Booking(customerName, roomNumber, checkIn, checkOut));
                System.out.println("Booking confirmed!");
                return true;
            }
        }
        System.out.println("Room not available.");
        return false;
    }

    public void showBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter room category (Single/Double/Suite): ");
                String category = sc.nextLine();
                hotel.searchAvailableRooms(category);
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter room number: ");
                int room = sc.nextInt();
                System.out.print("Enter check-in date (timestamp): ");
                Date in = new Date(sc.nextLong());
                System.out.print("Enter check-out date (timestamp): ");
                Date out = new Date(sc.nextLong());
                hotel.bookRoom(name, room, in, out);
            } else if (choice == 3) {
                hotel.showBookings();
            } else {
                break;
            }
        }

        sc.close();
    }
}
