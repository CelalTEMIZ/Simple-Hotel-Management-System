import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GuestTest class to Unit test
 * Reservation and cancel reservation methods unit testing.
 */
public class GuestTest {

    // Create test object
    Guest g2 = new Guest("Guest", "Deniz", "Kahraman",
            "34981247901",
            "Trabzon", "05422135401", "denizkahraman@yilmazgroup.com");

    Rooms newRoomReservation2 = new Rooms(g2, "Luxury",
            1111, 2, 300);


    /**
     * According to guest surname gets the reservation detail.
     */
    @Test
    public void getRoomDetailToGuest()
    {
        String detail = "Guest,Deniz,Kahraman,34981247901,Trabzon,05422135401,denizkahraman@yilmazgroup.com," +
                "Luxury,1111,2,300,";

        g2.reservation(newRoomReservation2);
        assertEquals(detail, g2.getRoomDetailToGuest("Kahraman"));
        System.out.println("getRoomDetailToGuest() method test is succesfull !");
    }


    /**
     * Reservation
     * Reservation cancelling
     * Save guest records tests
     */
    @Test
    public void personOperations()
    {
        try {
            // Reservation
            assertEquals(true,g2.reservation(newRoomReservation2));
            System.out.println("Guest reservation test is succesfull !");

            g2.saveTheGuestRecord();

            // Reservation Cancelling
            assertEquals(true, g2.cancelReservation(1111));
            System.out.println("Guest reservation cancelling test is succesfull !");

            g2.saveTheGuestRecord();
        }
        catch(Exception E) {
            System.out.println("An Exception Caught : " + E);
        }

    }
}