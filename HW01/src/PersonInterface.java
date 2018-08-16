/**
 * PersonInterface class that represents a PersonInterface
 * @author Celal TEMIZ
 */
public interface PersonInterface {
    /**
     * Type of person who makes the operation.
     * @return This method returns the type of person who makes the room reservation.
     */
    public String getPersonType();

    /**
     * Name of person who makes the room reservation.
     * @return This method returns the first name of person who makes the room reservation.
     */
    public String getPersonFirstName();

    /**
     * Last name of person who makes the room reservation.
     * @return This method returns the last name of person who makes the room reservation.
     */
    public String getPersonLastName();

    /**
     *
     * If the guest is making process,will be able to reservation and reservation cancelling. <br>
     * If the receptionist is making process, will be able to reservation,reservation cancelling,check-in and check-out.
     * @throws Exception
     */

    public void personOperations() throws Exception;

}
