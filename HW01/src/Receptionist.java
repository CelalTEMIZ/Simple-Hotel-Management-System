import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 * Receptionist Class
 * Class that represents a Receptionist
 * @author Celal TEMIZ
 */
public class Receptionist extends Person
{

    final String header = "ReservationType,Name,Surname,Identification Number,Address,Phone Number,E-Posta," +
        " Room Type,Room No,Night Stay,Room Price ($)";

    /**
     * Class constructor without parameters
     */
    public Receptionist()
    {
        this.personType="";
        this.firstName="";
        this.lastName="";
    }

    /**
     * Class constructor specifying objects to create
     * @param personType
     * @param firstName
     * @param lastName
     */
    public Receptionist(String personType,String firstName, String lastName)
    {
        this.personType=personType;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * Save the receptionist's reservation check-in and check-out records to given csv file.
     * @param header the String to record file header
     * @param roomNo the integer to room no
     */
    public void saveTheRecords(String header,int roomNo)
    {
        String fileName = "CheckIn-CheckOutRecords.csv";

        try {

            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(header);

            pw.print(getRoomDetail(roomNo));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            pw.println(dateFormat.format(date));

            pw.flush();
            pw.close();

        } catch(Exception E){
            System.out.println("Exception Caught : " + E);
        }
    }

    /**
     * Receptionist Check out operation to guest
     */
    public boolean checkOutOperation()
    {
        int roomNo;
        Scanner input = new Scanner(System.in);

        System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
        System.out.println(header);
        showReservedRooms();

        System.out.println("\n> Enter the room no :");
        roomNo = input.nextInt();

        // Check to operation according to room no
        if (checkRoomStatus(roomNo) == true)
        {
            System.out.println("\nCheck-Out operation is succesfull !!\n");
            System.out.println(header+", Check-Out Date");

            System.out.print(getRoomDetail(roomNo));
            getDate();

            // Save the check-out details in the CheckInRecords.csv file.
            saveTheRecords(header+", Check-Out Date",roomNo);
            return true;
        }

        else {
            System.out.println("Check-out operation is not successfull !");
            return  false;
        }
    }

    /**
     * Get date information to receptionist check-in and check-out operation
     */
    public void getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    /**
     * Receptionist Check in operation
     */
    public boolean checkInOperation()
    {
        int roomNo;
        Scanner input = new Scanner(System.in);

        System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
        System.out.println(header);
        showReservedRooms();

        System.out.println("\n> Enter the room no :");
        roomNo = input.nextInt();
        if(checkRoomStatus(roomNo)==true)
        {
            System.out.println("\nCheck-in operation is succesfull !!\n");
            System.out.println(header+", Check-in Date");

            System.out.print(getRoomDetail(roomNo));
            getDate();

            // Save the check-in details in the CheckInRecords.csv file
            saveTheRecords(header+", Check-in Date", roomNo);
            return true;

        }
        else {
            System.out.println("Check-in operation is not successfull !");
            return false;
        }
    }


    /**
     * Get guest information,create a guest object.Then,create a room object according to the given guest details.
     * @return new room object
     */
    public Rooms newRoomObject()
    {

        String roomType;
        int roomNo,nightStay,roomPrice;

        Scanner input = new Scanner(System.in);

        System.out.println("What is the guest name ?");
        firstName = input.next();

        System.out.println("What is the guest surname ?");
        lastName = input.next();

        System.out.println("What is the guest identification number ?");
        identificationNumber = input.next();

        System.out.println("What is the guest contact address ?");
        address = input.next();

        System.out.println("What is the guest phone number ?");
        phoneNumber = input.next();

        System.out.println("What is the guest e-posta ?");
        mail = input.next();

        Guest g1 = new Guest("Receptionist",firstName,lastName,
                identificationNumber,address,phoneNumber,mail);

        System.out.println("\n> Select the room type \n- Luxury\n- Suit\n- Deluxe\n ");
        roomType = input.next();
        System.out.println("\n> Enter the room no\n- Luxury - 1111\n- Suit -   2222\n- Deluxe - 3333\n");
        roomNo = input.nextInt();

        if(checkRoomStatus(roomNo)==true)
        {
            System.out.println("The room is already reserved !!");
            System.out.println("\n> Enter the guest room no <\n- Luxury - 1111\n- Suit - 2222\n- Deluxe - 3333\n");
            roomNo = input.nextInt();
        }

        System.out.println("Enter the night stay");
        nightStay=input.nextInt();
        System.out.println("Enter the room price ( $ )\n- Luxury - 300\n- Suit -   200\n- Deluxe - 100\n");
        roomPrice=input.nextInt();

        return new Rooms(g1,roomType,roomNo,nightStay,roomPrice);
    }


    /**
     * Receptionist Operation
     *
     * Reservation
     * Reservation Cancelling
     * Check-in
     * Check-out
     * @throws Exception if the an operation is fail
     */
    @Override
    public void personOperations() throws Exception
    {
        try {

            int operationChoice,roomNo;


            Scanner input = new Scanner(System.in);

            Guest g2 = new Guest("Receptionist", "Arda Can", "Doğan",
                    "12345678904",
                    "Kocaeli", "05347654321", "ardadogan@windowslive.com");

            Rooms newRoomReservation2 = new Rooms(g2,"Deluxe",
                    3333, 2, 100);

            Guest g3 = new Guest("Guest", "Duru İklim", "Hasoğlu",
                    "41234567899",
                    "Antalya", "05344654020", "duruiklim@hasoglu.com");


            Rooms newRoomReservation3 = new Rooms(g3,"Suit",
                    2222, 5, 200);

            reservation(newRoomReservation2);   // Other guest reservation operations
            reservation(newRoomReservation3);

            System.out.println("*** Receptionist Operations ***\nEnter 1 to Reservation");
            System.out.println("Enter 2 to Reservation Cancellation");
            System.out.println("Enter 3 to Check-In");
            System.out.println("Enter 4 to Check-Out");

            operationChoice = input.nextInt();

            if (operationChoice == 1)
            {
                if (true == reservation(newRoomObject()))
                {
                    System.out.println("\nYour reservation operation is successful !!\n");
                    saveTheGuestRecord();   // Save the guest reservation
                    showReservedRooms();    // Show the updated reserved rooms details
                }
            }

            // Reservation cancelling operation
            else if(operationChoice == 2)
            {
                System.out.println("\n*** Reserved Rooms In the Hotel *** \n");
                System.out.println(header);
                showReservedRooms();
                System.out.println("\nEnter guest room no");
                roomNo = input.nextInt();

                if (true == cancelReservation(roomNo))
                {
                    cancelReservation(roomNo);
                    System.out.println("Reservation cancelling operation is successful !!");
                    System.out.println("\n*** Updated Reserved Rooms In the Hotel ** \n");
                    System.out.println(header);
                    showReservedRooms();    // Show the reserved rooms details
                    saveTheGuestRecord();   // Save the updated rooms details
                }
                else
                {
                    System.out.println("Invalid Room No !!");
                }
            }

            // Check in operation
            else if(operationChoice == 3)
            {
               checkInOperation();
            }

            // Check out operation
            else if (operationChoice == 4)
            {
                checkOutOperation();
            }
            else
            {
                System.out.println("Wrong operation choice !!");
            }


        } catch (Exception E)
        {
            System.out.println(">>>>> An Exception Caught: " + E);
        }

    }

}
