/**
 * This class represents a Mp3 player in the system. It is an
 * extension of the Gadget class.
 */
public class Mp3 extends Gadget {

    private int memoryAvailable;

    public Mp3(String model, double price, int weight, String size, int memoryAvailable) {
        super(model, price, weight, size);
        this.memoryAvailable = memoryAvailable;
    }

    public int getMemoryAvailable() {
        return memoryAvailable;
    }

    /**
     * This method simulates downloading a song on the Mp3.
     * @param memoryRequired The memory required for the download.
     * @return The result of the operation.
     */
    public String downloadMusic(int memoryRequired) {
        if (this.memoryAvailable < memoryRequired) {
            // User does not have enough memory for this download.
            System.out.println("Error! Insufficient memory remaining. Cannot download. "
                    + "Available Memory: " + this.memoryAvailable);

            return "Error! Insufficient memory remaining. Cannot download. "
                    + "Available Memory: " + this.memoryAvailable;
        }
        else {
            // User has enough memory for this download.
            this.memoryAvailable -= memoryRequired;
            System.out.println("Success! Available Memory" + this.memoryAvailable);

            return "Success! Available Memory: " + this.memoryAvailable;
        }
    }

    /**
     * This method simulates deleting a song from the Mp3.
     * @param memoryReleased The memory released after delete.
     * @return The result of the operation.
     */
    public String deleteMusic(int memoryReleased) {
        this.memoryAvailable += memoryReleased;

        System.out.println("Success! Music deleted. Available Memory: " + this.memoryAvailable);
        return "Success! Music deleted. Available Memory: " + this.memoryAvailable;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + this.memoryAvailable);
    }
}
