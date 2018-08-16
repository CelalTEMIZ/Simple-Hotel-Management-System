import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementSystemTestTest {

    @Test
    public void main()
    {

        try {

            final String header = "ReservationType,Name,Surname,Identification Number,Address,Phone Number,E-Posta," +
                    " Room Type,Room No,Night Stay,Room Price ($)";

            // Create test objects
            Receptionist r1 = new Receptionist();


            Guest g1 = new Guest("Guest", "Arda Can", "Doğan",
                    "12345678904",
                    "Kocaeli", "05347654321", "ardadogan@windowslive.com");

            Rooms newRoomReservation1 = new Rooms(g1,"Deluxe",
                    3333, 2, 100);


            // Second reservation details
            Guest g2 = new Guest("Receptionist", "Duru İklim", "Hasoğlu",
                    "41234567899",
                    "Antalya", "05344654020", "duruiklim@hasoglu.com");
            Rooms newRoomReservation2 = new Rooms(g2,"Suit",
                    2222, 5, 200);


            Guest g3 = new Guest("Guest", "Bilge Simay", "Eroğlu",
                    "54891497628",
                    "Istanbul", "05341234567", "bilgeeroglu@galatasaray.edu.tr");

            Rooms newRoomReservation3 = new Rooms(g3, "Luxury",
                    1111, 5, 300);

            ///////////////////////////////////////////////
            //////// Guest operation test /////////////////
            ///////////////////////////////////////////////

            // Reservation
            assertEquals(true,g1.reservation(newRoomReservation1));
            System.out.println("Guest reservation test is succesfull !");

            // Save the reservation record
            g1.saveTheGuestRecord();
            System.out.println("Guest reservation record is successfull !");


            String detail = "Guest,Arda Can,Doğan,12345678904,Kocaeli,05347654321,ardadogan@windowslive.com," +
                    "Deluxe,3333,2,100,";

            // According to guest surname gets the reservation details.
            assertEquals(detail, g1.getRoomDetailToGuest("Doğan"));
            System.out.println("getRoomDetailToGuest() method test is succesfull !");


            // According to room no gets the reservation details.
            assertEquals(detail, g1.getRoomDetail(3333));   //Guest g1
            System.out.println("getRoomDetail() method test is succesfull !");


            // Reservation cancelling test
            assertEquals(true, g1.cancelReservation(3333)); //Guest g1
            System.out.println("Guest reservation cancelling test is succesfull !");

            ///////////////////////////////////
            // Receptionist operation test ////
            ///////////////////////////////////

            // Reservation test
            assertEquals(true,r1.reservation(newRoomReservation2));
            System.out.println("Receptionist reservation test is succesfull !");

            // Save the reservation record
            r1.saveTheGuestRecord();
            System.out.println("Receptionist reservation record is successfull !");

            // Reservation cancelling
            assertEquals(true, r1.cancelReservation(2222));
            System.out.println("Receptionist reservation cancelling test is succesfull !");


            // Make reservation to check-in and check-out tests
            r1.reservation(newRoomReservation3);

            // Reservation check-in test
            assertEquals(true,r1.checkRoomStatus(1111));
            System.out.println("Receptionist Check-in test is succesfull !");
            r1.saveTheRecords(header+", Check-in Date",1111);

            // Reservation check-out test
            assertEquals(true,r1.checkRoomStatus(1111));
            System.out.println("Receptionist Check-out test is succesfull !");
            r1.saveTheRecords(header+", Check-out Date",1111);

            } catch(Exception E) {
                System.out.println("An Exception Caught : " + E);
            }

    }
}