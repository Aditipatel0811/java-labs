import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AirlinesBookingSystem {
    private static List<String> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Airlines Booking System");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        // Set the window to be visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a JLabel
        JLabel destinationLabel = new JLabel("Select Destination:");
        destinationLabel.setBounds(10, 20, 150, 25);
        panel.add(destinationLabel);

        // Create a JComboBox with some destinations
        String[] destinations = {"New York", "London", "Tokyo", "Paris", "Sydney"};
        JComboBox<String> destinationComboBox = new JComboBox<>(destinations);
        destinationComboBox.setBounds(170, 20, 150, 25);
        panel.add(destinationComboBox);

        // Create a JLabel
        JLabel ticketsLabel = new JLabel("Number of Tickets:");
        ticketsLabel.setBounds(10, 50, 150, 25);
        panel.add(ticketsLabel);

        // Create a JTextField for entering the number of tickets
        JTextField ticketsTextField = new JTextField(10);
        ticketsTextField.setBounds(170, 50, 150, 25);
        panel.add(ticketsTextField);

        // Create a JButton to book tickets
        JButton bookButton = new JButton("Book Tickets");
        bookButton.setBounds(150, 80, 150, 25);
        panel.add(bookButton);

        // Create a JButton to view bookings
        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setBounds(310, 80, 150, 25);
        panel.add(viewBookingsButton);

        // Create a JTextArea to display bookings
        JTextArea bookingsTextArea = new JTextArea();
        bookingsTextArea.setBounds(10, 120, 450, 100);
        panel.add(bookingsTextArea);

        // Add an action listener to the "Book Tickets" button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve selected destination and number of tickets
                String selectedDestination = (String) destinationComboBox.getSelectedItem();
                String numberOfTickets = ticketsTextField.getText();

                // Store booking details in the list
                String bookingDetails = "Destination: " + selectedDestination +
                        ", Tickets: " + numberOfTickets;
                bookings.add(bookingDetails);

                // Display a confirmation message
                String message = "Booking confirmed!\n" + bookingDetails;
                JOptionPane.showMessageDialog(panel, message);

                // Clear the input fields
                destinationComboBox.setSelectedIndex(0);
                ticketsTextField.setText("");
            }
        });

        // Add an action listener to the "View Bookings" button
        viewBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display bookings in the JTextArea
                StringBuilder bookingsText = new StringBuilder();
                for (String booking : bookings) {
                    bookingsText.append(booking).append("\n");
                }
                bookingsTextArea.setText(bookingsText.toString());
            }
        });
    }
}
