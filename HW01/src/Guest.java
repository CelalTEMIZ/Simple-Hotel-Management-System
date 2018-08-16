import java.util.ArrayList;
import java.util.Scanner;

/**
 * Guest Class
 * @author Celal TEMIZ
 */
public class Guest extends Person {

    private String IdentificationNumber;
    private String address;
    private String phoneNumber;
    private String eMail;

    // Hotel guests
    private ArrayList<Person> hotelGuests = new ArrayList<>();

    final String header = "ReservationType, Name, Surname, Identification Number, Address, Phone Number, E-Posta, Room Type, Room No, Night Stay, Room Price ( $ )";

    /**
     * Class constructor without parameter
     */
    public Guest()
    {
        this.personType="";
        this.firstName="";
        this.lastName="";
    }

    /**
     * Class constructor specifying objects to create
     * Initializes a Guest object with all properties speicified.
     * @param pType             person type
     * @param name              first name
     * @param surname           last name
     * @param ID                identification number
     * @param contactAddress    contact address
     * @param phone             phone number
     * @param mail              e-post
     */
    public Guest(String pType,String name, String surname, String ID, String contactAddress,
                 String phone, String mail)
    {
        this.personType = pType;
        this.firstName = name;
        this.lastName =  surname;
        setContactInfo(ID,contactAddress,phone,mail);
    }

    /**
     *
     * @param ID ID to set
     * @param contactAddress contactAddress to set
     * @param phone phone to set
     * @param mail mail to set
     */
    public void setContactInfo(String ID,String contactAddress, String phone, String mail)
    {
        IdentificationNumber = ID;
        address = contactAddress;
        phoneNumber = phone;
        eMail = mail;
    }

    /**
     * @return guest identification number
     */
    public String getIdentificationNumber()
    {
        return IdentificationNumber;
    }

    /**
     * @return guest contact address
     */
    public String getAddress()
    {
        return address;
    }


    /**
     *
     * @return guest phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     *
     * @return guest e-posta
     */
    public String geteMail()
    {
        return eMail;
    }

    /**
     * Show hotel guests
     */
    public void showHotelGuests()
    {
        for (int i = 0; i < hotelGuests.size(); i++)
        {
            System.out.println(hotelGuests.get(i).toString());
        }
    }

    /**
     * Get room details,according to the guest surname
     * @param guestSurname the String to guest surname
     */
    public String getRoomDetailToGuest(String guestSurname)
    {

        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getPersonObject().getPersonLastName().equals(guestSurname))
            {
                //System.out.println(roomList.get(i).toString());
                return  roomList.get(i).toString();
            }
        }

        return null;
    }

    /**
     * toString() method override
     * @return the String to guest details
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",super.toString(),getIdentificationNumber(),getAddress(),
                getPhoneNumber(),geteMail());
    }


    /**
     * Guest operations
     * If the guest press 1,will be able to reservation
     * If the guest press 2,will be able to reservation cancelling
     * @throws Exception if the an operation is fail.
     */


    @Override
    public void personOperations() throws Exception
    {

        try {
                int operationChoice;
                String firstName, lastName, identificationNumber, address, phoneNumber, mail;
                String roomType;
                int roomNo, nightStay, roomPrice;

                Scanner input = new Scanner(System.in);

                // Other hotel guest records
                Guest g2 = new Guest("Guest", "Deniz", "Kahraman",
                        "34981247901",
                        "Trabzon", "05422135401", "denizkahraman@yilmazgroup.com");

                Rooms newRoomReservation2 = new Rooms(g2, "Deluxe",
                        3333, 2, 100);


                Guest g3 = new Guest("Guest", "Bilge Simay", "Eroğlu",
                    "54891497628",
                    "Istanbul", "05341234567", "bilgeeroglu@galatasaray.edu.tr");

                Rooms newRoomReservation3 = new Rooms(g3, "Suit",
                        2222, 5, 200);

                // Reservation process to other guests
                reservation(newRoomReservation2);
                reservation(newRoomReservation3);

                // Show the reserved rooms in the hotel
                // showReservedRooms();

                hotelGuests.add(g2);
                hotelGuests.add(g3);
                // Show the list of hotel guests
                // showHotelGuests();

                System.out.println("Enter 1 to Reservation");
                System.out.println("Enter 2 to Reservation Cancellation");
                operationChoice = input.nextInt();

                // Reservation
                if (operationChoice == 1)
                {
                    System.out.println("What is your name ?");
                    firstName = input.next();

                    System.out.println("What is your surname ?");
                    lastName = input.next();

                    System.out.println("What is your identification number ?");
                    identificationNumber = input.next();

                    System.out.println("What is your contact address ?");
                    address = input.next();

                    System.out.println("What is your phone number ?");
                    phoneNumber = input.next();

                    System.out.println("What is your e-posta ?");
                    mail = input.next();

                    Guest g1 = new Guest("Guest", firstName, lastName,
                            identificationNumber, address, phoneNumber, mail);

                    System.out.println("\n> Select your room type < \n- Luxury\n- Suit\n- Deluxe\n ");
                    roomType = input.next();
                    System.out.println("\n> Enter your room no <\n- Luxury - 1111\n- Suit -   2222\n- Deluxe - 3333\n");
                    roomNo = input.nextInt();

                    if(checkRoomStatus(roomNo)==true)
                    {
                        System.out.println("The room is already reserved !!");
                        System.out.println("\n> Enter your room no <\n- Luxury - 1111\n- Suit - 2222\n- Deluxe - 3333\n");
                        roomNo = input.nextInt();
                    }


                    System.out.println("\n> Enter your the night stay <");
                    nightStay = input.nextInt();

                    System.out.println("> Enter the room price ( $ ) <\n- Luxury - 300\n- Suit   - 200\n- Deluxe - 100\n");
                    roomPrice = input.nextInt();


                    Rooms newRoomReservation1 = new Rooms(g1, roomType, roomNo, nightStay, roomPrice);

                    if (true == reservation(newRoomReservation1))
                    {
                        System.out.println("\nYour reservation operation is successful !!\n");
                        System.out.println("**** Your reservation detail ****");
                        System.out.println(header);
                        System.out.println(getRoomDetail(roomNo));
                    }
                }

                //Reservation cancelling
                if (operationChoice == 2)
                {
                    System.out.println("Enter your surname ");
                    lastName = input.next();

                    System.out.printf("\n%s\n", header);
                    System.out.println(getRoomDetailToGuest(lastName));

                    System.out.println("\nEnter your room number ");
                    roomNo = input.nextInt();

                    if (true == cancelReservation(roomNo))
                    {
                        System.out.println("Reservation cancelling operation is successful !!");
                    }
                    else
                    {
                        System.out.println("Invalid Room No !!");
                    }
                }

            saveTheGuestRecord();   // Save the records to an csv file


        } catch (Exception E)
        {
            System.out.println("An Exception Caught: " + E);
        }

    }


}
