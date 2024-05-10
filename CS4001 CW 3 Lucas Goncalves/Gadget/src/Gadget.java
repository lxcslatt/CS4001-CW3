/**
 * This class represents a Gadget in the system. It is the
 * parent class of different types of gadgets, e.g., Mobile and Mp3.
 */
public class Gadget {
    private String model;
    private double price;
    private int weight;
    private String size;

    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }

    public static void main(String[] args) {
        Gadget gadget = new Gadget("GadgetX", 99.99, 150, "71mm x 137mm x 9mm");
        gadget.display();
    }
}
