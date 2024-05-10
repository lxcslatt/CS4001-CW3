import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop extends JFrame {

    // Model Components
    private JLabel modelLabel;
    private JTextField modelTextField;

    // Price Components
    private JLabel priceLabel;
    private JTextField priceTextField;

    // Weight Components
    private JLabel weightLabel;
    private JTextField weightTextField;

    // Size Components
    private JLabel sizeLabel;
    private JTextField sizeTextField;

    // Initial Credit Components
    private JLabel initialCreditLabel;
    private JTextField initialCreditTextField;

    // Initial Memory Components
    private JLabel initialMemoryLabel;
    private JTextField initialMemoryTextField;

    // Phone Number Components
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberTextField;

    // Duration Components
    private JLabel durationLabel;
    private JTextField durationTextField;

    // Download Size Components
    private JLabel downloadSizeLabel;
    private JTextField downloadSizeTextField;

    // Display Number Components
    private JLabel displayNumberLabel;
    private JTextField displayNumberTextField;

    // Buttons
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;

    private ArrayList<Gadget> gadgetList;

    public GadgetShop() {
        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gadgetList = new ArrayList<>();

        setLayout(new GridLayout(4, 4));

        // Initializing all child components.
        this.initializeComponents();

        // Inserting the components in the grid. The components are enclosed
        // in a box layout before insertion.
        this.add(createBox(modelLabel, modelTextField));
        this.add(createBox(priceLabel, priceTextField));
        this.add(createBox(weightLabel, weightTextField));
        this.add(createBox(sizeLabel, sizeTextField));
        this.add(createBox(initialCreditLabel, initialCreditTextField));
        this.add(createBox(initialMemoryLabel, initialMemoryTextField));
        this.add(createBox(addMobileButton, clearButton));
        this.add(createBox(addMP3Button, displayAllButton));
        this.add(createBox(phoneNumberLabel, phoneNumberTextField));
        this.add(createBox(durationLabel, durationTextField));
        this.add(createBox(downloadSizeLabel, downloadSizeTextField));
        this.add(createBox(displayNumberLabel, displayNumberTextField));


        this.makeCallButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.downloadMusicButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.add(this.makeCallButton);
        this.add(this.downloadMusicButton);

        pack(); // Adjusts the size of the frame to fit its contents
        setLocationRelativeTo(null); // Centers the frame on the screen
        setVisible(true);
    }

    private JPanel createBox(JComponent comp1, JComponent comp2) {
        JPanel boxPanel = new JPanel();

        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Make the components fill the entire space allowed by the box layout.
        comp1.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        comp2.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        boxPanel.add(comp1);
        boxPanel.add(comp2);

        return boxPanel;
    }

    /**
     * This method initializes all the child components.
     */
    private void initializeComponents() {

        this.modelLabel = new JLabel("Model:");
        this.modelTextField = new JTextField();

        this.priceLabel = new JLabel("Price:");
        this.priceTextField = new JTextField();

        this.weightLabel = new JLabel("Weight:");
        this.weightTextField = new JTextField();

        this.sizeLabel = new JLabel("Size:");
        this.sizeTextField = new JTextField();

        this.initialCreditLabel = new JLabel("Credit:");
        this.initialCreditTextField = new JTextField();

        this.initialMemoryLabel = new JLabel("Memory:");
        this.initialMemoryTextField = new JTextField();

        this.phoneNumberLabel = new JLabel("Phone Num:");
        this.phoneNumberTextField = new JTextField();

        this.durationLabel = new JLabel("Duration:");
        this.durationTextField = new JTextField();

        this.downloadSizeLabel = new JLabel("Download:");
        this.downloadSizeTextField = new JTextField();

        this.displayNumberLabel = new JLabel("Display Number:");
        this.displayNumberTextField = new JTextField();

        // Initializing buttons
        this.addMobileButton = new JButton("Add Mobile");
        this.addMobileButton.addActionListener(e -> addMobileActionHandler());

        this.addMP3Button = new JButton("Add MP3");
        this.addMP3Button.addActionListener(e -> addMP3ActionHandler());

        this.clearButton = new JButton("Clear");
        this.clearButton.addActionListener(e -> clearActionListener());

        this.displayAllButton = new JButton("Display All");
        this.displayAllButton.addActionListener(e -> displayAllActionListener());

        this.makeCallButton = new JButton("Make A Call");
        this.makeCallButton.addActionListener(e -> makeCallActionListener());

        this.downloadMusicButton = new JButton("Download Music");
        this.downloadMusicButton.addActionListener(e -> downloadMusicActionListener());

        // Clearing all the fields.
        clearActionListener();
    }

    /**
     * Handles a click on the add mobile button.
     */
    private void addMobileActionHandler() {
/**
 * This block of code shows invalid if the variables don't match up.
 */
        if (this.modelTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Model!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.priceTextField.getText().isEmpty() || !isValidNum(this.priceTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.weightTextField.getText().isEmpty() || !isValidNum(this.weightTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Weight!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.sizeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Size!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.initialCreditTextField.getText().isEmpty() || !isValidNum(this.initialCreditTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Credit!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            // We reach here only if all values are valid. So a mobile is added.
            this.gadgetList.add(new Mobile(
                        modelTextField.getText(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(weightTextField.getText()),
                        sizeTextField.getText(),
                        Integer.parseInt(initialCreditTextField.getText())
                    ));

            this.displayNumberTextField.setText(String.valueOf(this.gadgetList.size() - 1));

            JOptionPane.showMessageDialog(null, "Success! Mobile Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This Method is called when the user clicks the add mp3 button.
     */
    private void addMP3ActionHandler() {
        if (this.modelTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Model!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.priceTextField.getText().isEmpty() || !isValidNum(this.priceTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.weightTextField.getText().isEmpty() || !isValidNum(this.weightTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Weight!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.sizeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Size!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.initialMemoryTextField.getText().isEmpty() || !isValidNum(this.initialMemoryTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Memory!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            // We reach here only if all values are valid. So a MP3 is added.
            this.gadgetList.add(new Mp3(
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(weightTextField.getText()),
                    sizeTextField.getText(),
                    Integer.parseInt(initialMemoryTextField.getText())
            ));

            this.displayNumberTextField.setText(String.valueOf(this.gadgetList.size() - 1));

            JOptionPane.showMessageDialog(null, "Success! MP3 Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called when the clear button is clicked.
     */
    private void clearActionListener() {

        // Clearing all the fields.
        this.modelTextField.setText("");
        this.priceTextField.setText("");
        this.weightTextField.setText("");
        this.sizeTextField.setText("");
        this.initialCreditTextField.setText("");
        this.initialMemoryTextField.setText("");
        this.phoneNumberTextField.setText("");
        this.durationTextField.setText("");
        this.downloadSizeTextField.setText("");
        this.displayNumberTextField.setText("-1");
    }

    /**
     * This method is called when the display all button is clicked.
     */
    private void displayAllActionListener() {

        String[] columnNames = {"Model", "Price", "Weight", "Size", "Credit", "Memory"};
        Object[][] data = new Object[gadgetList.size()][columnNames.length];

        for (int i = 0; i < this.gadgetList.size(); i++) {
            Gadget gadget = gadgetList.get(i);

            data[i][0] = gadget.getModel();
            data[i][1] = gadget.getPrice();
            data[i][2] = gadget.getWeight();
            data[i][3] = gadget.getSize();

            if (gadget instanceof Mobile) {
                Mobile mob = (Mobile) gadget;
                data[i][4] = mob.getCreditRemaining();
            }
            else {
                data[i][4] = "--";
            }

            if (gadget instanceof Mp3) {
                Mp3 mob = (Mp3) gadget;
                data[i][5] = mob.getMemoryAvailable();
            }
            else {
                data[i][5] = "--";
            }
        }

        // The table of gadgets is opened in a new JFrame
        JTable table = new JTable(data, columnNames);

        // Wrap the table in a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame and add the scroll pane
        JFrame frame = new JFrame("Gadget List");
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    /**
     * This method is called when the make call button is clicked.
     */
    private void makeCallActionListener() {

        if (this.phoneNumberTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Phone Number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.durationTextField.getText().isEmpty() || !isValidNum(this.durationTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Duration!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.displayNumberTextField.getText().isEmpty() || !isValidNum(this.displayNumberTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Display Number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int selectedGadget = Integer.parseInt(this.displayNumberTextField.getText());

            if (selectedGadget < 0 || selectedGadget >= this.gadgetList.size()) {
                // Falls out of range.
                JOptionPane.showMessageDialog(null, "The selected gadget index is out of range!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Gadget gadget = this.gadgetList.get(selectedGadget);
                if (gadget instanceof Mobile) {
                    // It is a Mobile so making the call.
                    Mobile mob = (Mobile) gadget;
                    String response = mob.call(phoneNumberTextField.getText(), Integer.parseInt(durationTextField.getText()));

                    JOptionPane.showMessageDialog(null, response, "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "The selected gadget is an MP3. It doesn't support calls.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * This method is called when the download music button is clicked.
     */
    private void downloadMusicActionListener() {
        if (this.downloadSizeTextField.getText().isEmpty() || !isValidNum(this.downloadSizeTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Download Size!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (this.displayNumberTextField.getText().isEmpty() || !isValidNum(this.displayNumberTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid Display Number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int selectedGadget = Integer.parseInt(this.displayNumberTextField.getText());

            if (selectedGadget < 0 || selectedGadget >= this.gadgetList.size()) {
                // Falls out of range.
                JOptionPane.showMessageDialog(null, "The selected gadget index is out of range!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Gadget gadget = this.gadgetList.get(selectedGadget);
                if (gadget instanceof Mp3) {
                    // It is a Mobile so making the call.
                    Mp3 mp3 = (Mp3) gadget;
                    String response = mp3.downloadMusic(Integer.parseInt(downloadSizeTextField.getText()));

                    JOptionPane.showMessageDialog(null, response, "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "The selected gadget is a Mobile. It doesn't support downloads.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * This function checks if the field has a valid number.
     * @param text The text to be checked.
     * @return True if the text is a valid number.
     */
    private boolean isValidNum(String text) {

        try {
            Double.parseDouble(text);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create an instance of GadgetShop
        SwingUtilities.invokeLater(GadgetShop::new);
    }
}
