import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class Dashboard {

    JFrame frame;

    public Dashboard() {

        frame = new JFrame("Hotel Management Dashboard");
        frame.setSize(720,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.getContentPane().setBackground(new Color(240,240,240));

        addHeader();
        addButtons();
        addFooter();

        frame.setVisible(true);
    }

    // Header
    private void addHeader(){

        JLabel title = new JLabel("Hotel Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel subtitle = new JLabel("Dashboard Control Panel", JLabel.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JPanel header = new JPanel(new GridLayout(2,1));
        header.setBackground(new Color(240,240,240));

        header.add(title);
        header.add(subtitle);

        frame.add(header, BorderLayout.NORTH);
    }

    // Buttons
    private void addButtons(){

        JPanel panel = new JPanel(new GridLayout(3,2,25,25));
        panel.setBorder(BorderFactory.createEmptyBorder(30,80,30,80));
        panel.setBackground(new Color(240,240,240));

        String[] buttonNames = {
                "Display Room Details",
                "Book Room",
                "Order Food",
                "Generate Bill",
                "Checkout",
                "Logout"
        };

        for(String name : buttonNames){

            JButton button = new JButton(name);

            button.setFont(new Font("Segoe UI", Font.BOLD, 16));
            button.setFocusPainted(false);
            button.setBackground(new Color(52,152,219));
            button.setForeground(Color.WHITE);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            button.addActionListener(e -> handleAction(name));

            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
    }

    // Footer
    private void addFooter(){

        JLabel date = new JLabel("Date: " + LocalDate.now(), JLabel.RIGHT);
        date.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));

        frame.add(date, BorderLayout.SOUTH);
    }

    // Button Logic
    private void handleAction(String action){

        switch(action){

            case "Display Room Details":
                selectRoomAvailability();
                break;

            case "Book Room":
                selectRoomBooking();
                break;

            case "Order Food":
                Hotel.orderFood();
                break;

            case "Generate Bill":
                JOptionPane.showMessageDialog(frame,
                        "Bill will appear after food order.",
                        "Bill Info",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Checkout":
                Hotel.checkout();
                break;

            case "Logout":
                frame.dispose();
                new LoginPage();
                break;
        }
    }

    // Room availability
    private void selectRoomAvailability(){

        String[] options = {
                "Luxury Double",
                "Deluxe Double",
                "Luxury Single",
                "Deluxe Single"
        };

        int type = JOptionPane.showOptionDialog(
                frame,
                "Select Room Type",
                "Room Availability",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if(type != -1)
            Hotel.availability(type+1);
    }

    // Room booking
    private void selectRoomBooking(){

        String[] options = {
                "Luxury Double",
                "Deluxe Double",
                "Luxury Single",
                "Deluxe Single"
        };

        int type = JOptionPane.showOptionDialog(
                frame,
                "Select Room Type",
                "Book Room",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if(type != -1)
            Hotel.bookroom(type+1);
    }
}