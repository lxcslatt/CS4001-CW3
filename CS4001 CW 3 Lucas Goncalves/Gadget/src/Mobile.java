/**
 * This class represents a Mobile in the system. It is
 * an extension of the Gadget class.
 */
public class Mobile extends Gadget{

    private int creditRemaining;

    public Mobile(String model, double price, int weight, String size, int creditRemaining) {
        super(model, price, weight, size);
        this.creditRemaining = creditRemaining;
    }

    public int getCreditRemaining() {
        return creditRemaining;
    }

    /**
     * Adds credit to the mobile.
     * @param amount T The amount of credit to add.
     * @return The result of the operation.
     */
    public String addCredit(int amount) {

        if (amount <= 0) {
            // Invalid amount entered.
            System.out.println("Error! Invalid amount entered. Please enter a value greater than zero.");
            return "Error! Invalid amount entered. Please enter a value greater than zero.";
        }
        else {
            this.creditRemaining += amount;
            System.out.println("Success! " + amount + " is added to your credit.");
            return "Success! " + amount + " is added to your credit.";
        }
    }

    /**
     * Simulates a call on the mobile.
     * @param phoneNumber The phone number to be called.
     * @param duration The duration of the call.
     * @return The result of the operation.
     */
    public String call(String phoneNumber, int duration) {
        if (this.creditRemaining < duration) {
            // User does not have enough balance for this call.
            System.out.println("Error! Insufficient credits remaining. Cannot make this call. "
                    + "Remaining Credit: " + this.creditRemaining);

            return "Error! Insufficient credits remaining. Cannot make this call. "
                    + "Remaining Credit: " + this.creditRemaining;
        }
        else {
            // User has enough credits for this call.
            this.creditRemaining -= duration;
            System.out.println("Success! Phone Number: " + phoneNumber
                    + ", Duration: " + duration
                    + ", Remaining Credit: " + this.creditRemaining);

            return "Success! Phone Number: " + phoneNumber
                    + ", Duration: " + duration
                    + ", Remaining Credit: " + this.creditRemaining;
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Remaining Credit: " + this.creditRemaining);
    }
}
