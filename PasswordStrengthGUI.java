import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class PasswordStrengthGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    // GUI components: text field for password input and label for the result
    private JTextField passwordField;
    private JLabel resultLabel;

    public PasswordStrengthGUI() {
        // Basic JFrame settings
        setTitle("Password Strength Checker");  // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close operation
        setSize(400, 200);  // Set size of the window
        setLayout(new BorderLayout());  // Use BorderLayout for main layout

        // Load and set background image
        ImageIcon backgroundImage = loadImageIconFromURL("https://www.simplilearn.com/ice9/free_resources_article_thumb/Top_Cybersecurity_Projects.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new FlowLayout());  // Set FlowLayout for the label that holds the image

        // Initialize password input field
        passwordField = new JTextField(20);

        // Button to initiate the password strength check
        JButton checkButton = new JButton("Check");
        resultLabel = new JLabel();  // Label to display the result

        // Panel for user input
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setOpaque(false);  // Make the panel transparent
        inputPanel.add(new JLabel("Enter a password:"));
        inputPanel.add(passwordField);
        inputPanel.add(checkButton);

        // Panel for displaying results
        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.setOpaque(false);  // Make the panel transparent
        resultPanel.add(new JLabel("Result:"));
        resultPanel.add(resultLabel);

        // Add both panels to the background label
        backgroundLabel.add(inputPanel);
        backgroundLabel.add(resultPanel);

        // Add the background label to the main frame
        add(backgroundLabel, BorderLayout.CENTER);

        // Add action listener to the button to check password strength
        checkButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Get the password from the text field
                String password = passwordField.getText();
                // Check its strength
                String result = PasswordStrength.checkPasswordStrength(password);
                // Display the result
                resultLabel.setText(result);
            }
        });
    } 

    // Utility method to load an ImageIcon from a URL
    private ImageIcon loadImageIconFromURL(String url) {
        try {
            URL imageUrl = new URL(url);
            return new ImageIcon(ImageIO.read(imageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Return null if loading fails
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Ensure that GUI updates are thread-safe
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PasswordStrengthGUI gui = new PasswordStrengthGUI();
                gui.setVisible(true);  // Make the GUI visible
            }
        });
    }
}
