import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ReceptionistTest class to Unit test
 * Reservation
 * Reservation Cancelling
 * Check-in
 * Check-out
 */
public class ReceptionistTest {

    final String header = "ReservationType,Name,Surname,Identification Number,Address,Phone Number,E-Posta," +
            " Room Type,Room No,Night Stay,Room Price ($)";

    // Create test objects
    Receptionist r1 = new Receptionist();

    Guest g1 = new Guest("Receptionist", "Arda Can", "Doğan",
            "12345678904",
            "Kocaeli", "05347654321", "ardadogan@windowslive.com");

    Rooms newRoomReservation1 = new Rooms(g1,"Deluxe",
            3333, 2, 100);


    Guest g3 = new Guest("Guest", "Duru İklim", "Hasoğlu",
            "41234567899",
            "Antalya", "05344654020", "duruiklim@hasoglu.com");
    Rooms newRoomReservation3 = new Rooms(g3,"Suit",
            2222, 5, 200);



    /**
     * Reservation and Reservation Cancelling operations testing
     */
    @Test
    public void personOperations()
    {

        try {
            // Reservation test
            assertEquals(true,r1.reservation(newRoomReservation1));
            System.out.println("Receptionist reservation test is succesfull !");

            // Reservation cancelling test
            assertEquals(true, r1.cancelReservation(3333));
            System.out.println("Receptionist reservation cancelling test is succesfull !");

            // Save the updated reserved rooms list
            r1.saveTheGuestRecord();

        } catch(Exception E) {
                System.out.println("An Exception Caught : " + E);
        }

    }



    /**
     * Check-in operation test
     */
    @Test
    public void checkInOperation()
    {
        r1.reservation(newRoomReservation3);
        assertEquals(true,r1.checkRoomStatus(2222));

        r1.saveTheRecords(header+", Check-in Date",2222);
        System.out.println("Receptionist Check-in test is succesfull !");
    }


    /**
     * Check-out operation test
     */
    @Test
    public void checkOutOperation()
    {
        r1.reservation(newRoomReservation3);
        assertEquals(true,r1.checkRoomStatus(2222));

        r1.saveTheRecords(header+", Check-out Date",2222);
        System.out.println("Receptionist Check-out test is succesfull !");
    }

}