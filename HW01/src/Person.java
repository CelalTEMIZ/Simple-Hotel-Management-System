import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Person abstract class implements the PersonInterface
 * Person abstract class that represents a Person
 * @author Celal TEMIZ
 */
public abstract class Person implements PersonInterface {

    // Data Fields
    protected String personType;                // a person who makes the reservation
    protected String firstName;                 // System user name
    protected String lastName;                  // System user surname
    protected String identificationNumber;      // System user ID number
    protected String address;                   // System user contact address
    protected String phoneNumber;               // System user phone number
    protected String mail;                      // System user e-posta


    // Keep the all reserved room details
    protected ArrayList<Rooms> roomList = new ArrayList<>();


    /**
     * Getter to the person type who makes the room reservation
     * @return the String to person type.
     */
    @Override
    public String getPersonType()
    {
        return personType;
    }

    /**
     * Getter to the first name
     * @return the String to first name.
     */
    @Override
    public String getPersonFirstName()
    {
        return firstName;
    }

    /**
     * Getter to the last name
     * @return the String to last name.
     */
    @Override
    public String getPersonLastName()
    {
        return lastName;
    }


    /**
     *
     * This method shows the reserved rooms details in the hotel.
     */
    public void showReservedRooms()
    {
        for (int i = 0; i < roomList.size(); i++)
        {
            System.out.println(roomList.get(i).toString());
        }
    }


    /**
     *
     * @param roomNo the integer to reserved room no.
     * @return the String for according to the given room no,reserved room details,
     */
    public String getRoomDetail(int roomNo)
    {
        String roomDetail;

        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                roomDetail = roomList.get(i).toString();
                return roomDetail;
            }
        }

        return null;
    }

    /**
     * This method saves the reservation records to given csv file.
     */
    public void saveTheGuestRecord()
    {
        String filePath = "GuestReservations.csv";

        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("ReservationType, Name, Surname, Identification Number, Address, Phone Number, E-Posta, Room Type, Room No, Night Stay, Room Price ( $ )");

            for (int i = 0; i < roomList.size(); i++)
            {
                pw.println(roomList.get(i).toString());
            }

            pw.flush();
            pw.close();
        } catch(Exception E){
            System.out.println("Exception Caught : " + E);
        }
    }


    /**
     * Reservation method.This method takes the room object to add reservation list.
     * @param roomObject the room Object to add reservation list
     * @return boolean. If the process is successful,return true.Otherwise,return false.
     */
    public boolean reservation(Rooms roomObject)
    {
        this.roomList.add(roomObject);
        return true;
    }


    /**
     * Reservation cancelling method,according to the room no
     * @param roomNo the integer to room no
     * @return boolean. If the process is successful,return true.Otherwise,return false
     * @exception if the roomlist is already empty
     */
    public boolean cancelReservation(int roomNo) throws Exception
    {

        try {
            if (roomList.size() == 0) {
                throw new Exception("Room list is already empty !!");
            }
        } catch (Exception E) {
            System.out.println("An Exception Caught : " + E);
        }

        for(int i=0; i<roomList.size(); ++i)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                this.roomList.remove(i);
                return true;
            }
        }

        return false;

    }

    /**
     * Check the room state,according to the room no
     * @param roomNo the integer to room no
     * @return If the process is successful,return true.Otherwise,return false
     */
    public boolean checkRoomStatus(int roomNo)
    {

        for (int i = 0; i < roomList.size(); i++)
        {
            if (roomList.get(i).getRoomNo() == roomNo)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * toString() method override
     * @return the String to person details
     */
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s",getPersonType(), getPersonFirstName(), getPersonLastName());
    }


}
