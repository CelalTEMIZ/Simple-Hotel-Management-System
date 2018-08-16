import java.util.Scanner;

/**
 * Hotel Management System test class
 *
 * @author Celal TEMIZ
 *
 */
public class ManagementSystemTest {

    public static void main(String args[]) throws Exception
    {
        try {

            String whichPerson;
            Scanner input = new Scanner(System.in);

            System.out.println("\n*** Welcome the Hotel ISTANBUL ***");
            System.out.println("Are you a guest ?\n Y/y or N/n");

            whichPerson = input.next(); // Get the system user type

            // Guest operation
            // Reservation
            // Reservation Cancelling
            if (whichPerson.equals("Y") || whichPerson.equals("y"))
            {
                Person personObject = new Guest();          // processed polymorphically
                personObject.personOperations();
            }

            // Receptionist Operation
            // Reservation
            // Reservation Cancelling
            // Check-in
            // Check-out
            else if (whichPerson.equals("N") || whichPerson.equals("n"))
            {
                Person personObject = new Receptionist();   // processed polymorphically
                personObject.personOperations();
            }
            else {
                System.out.println("Invalid Choice !");
            }

        } catch(Exception E){

            System.out.println("An Exception Caught : " + E);
        }

    } // END MAIN FUNCTION
} // END CLASS
