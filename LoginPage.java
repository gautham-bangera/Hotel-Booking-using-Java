import java.awt.*;
import javax.swing.*;

public class LoginPage {

    public LoginPage() {

        JFrame frame = new JFrame("Hotel Management System");
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        // LEFT PANEL (Brand / Title)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(30,144,255));
        leftPanel.setLayout(new GridBagLayout());

        JLabel title = new JLabel("<html><center>HOTEL<br>MANAGEMENT<br>SYSTEM</center></html>");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        leftPanel.add(title);

        // RIGHT PANEL (Login Form)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());

        JPanel loginBox = new JPanel();
        loginBox.setLayout(new GridLayout(4,1,10,10));
        loginBox.setPreferredSize(new Dimension(250,200));

        JLabel userLabel = new JLabel("Username");
        JTextField username = new JTextField();

        JLabel passLabel = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(30,144,255));
        loginBtn.setForeground(Color.WHITE);

        loginBox.add(userLabel);
        loginBox.add(username);
        loginBox.add(passLabel);
        loginBox.add(password);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginBtn);

        JPanel container = new JPanel(new BorderLayout(10,10));
        container.add(loginBox,BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);

        rightPanel.add(container);

        frame.add(leftPanel);
        frame.add(rightPanel);

        // LOGIN LOGIC
        loginBtn.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if(user.equals("admin") && pass.equals("1234")){
                frame.dispose();
                new Dashboard();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Invalid Username or Password");
            }

        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}