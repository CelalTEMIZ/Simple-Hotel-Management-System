public class Rooms {

    private String roomType;
    private int roomNo;
    private int roomPrice;
    private int nightStay;
    private PersonInterface personObject;

    /**
     * Create room object
     *
     * @param personObject  person detail
     * @param roomType      room type
     * @param roomNo        room no
     * @param nightStay     night stay
     * @param roomPrice     room price
     */
    public Rooms(PersonInterface personObject, String roomType, int roomNo, int nightStay, int roomPrice)
    {
        this.personObject = personObject;
        this.roomType=roomType;
        this.roomNo=roomNo;
        this.roomPrice=roomPrice;
        this.nightStay=nightStay;
    }

    /**
     * Getter to the person object
     * @return person object
     */
    public PersonInterface getPersonObject()
    {
        return personObject;
    }

    /**
     * Getter to the room type
     * @return room type
     */
    public String getRoomType()
    {
        return roomType;
    }

    /**
     * Getter to the room no
     * @return room no
     */
    public int getRoomNo()
    {
        return roomNo;
    }

    /**
     * Getter to the room price
     * @return room price
     */
    public int getRoomPrice()
    {
        return roomPrice;
    }

    /**
     * Getter to the night stay
     * @return night stay
     */
    public int getNightStay()
    {
        return nightStay;
    }

    /**
     * toString() method override
     * @return reserved room detail
     */
    @Override
    public String toString()
    {
        return String.format("%s,%s,%d,%d,%d,",getPersonObject().toString(),getRoomType(),getRoomNo(),getNightStay(),getRoomPrice());
    }


}
