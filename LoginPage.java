package LoginSystem;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class LoginPage implements ActionListener{
    
    // creation of the JFrame
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton ("RESET");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo = new HashMap<String, String>();


    LoginPage(HashMap<String,String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.BOLD, 25));
        
        userIDField.setBounds(125,100,200,25);  //this where the user will type in their ID
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userPasswordField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword()); // it's going to retrieve the password we write and convert it to string and it will store it within a string called password 

            // This following code verifies if the user ID matches with it's password
            if(logininfo.containsKey(userID)) {
                if(logininfo.get(userID).equals(password)) { // we get the ID and the associated password is equal,that means their credentials are verified.
                    messageLabel.setForeground(Color.blue);
                    messageLabel.setText("Login Successful");
                    frame.dispose(); //this get's rid of the login page once the login was successful.
                    WelcomePage welcomePage = new WelcomePage(userID);
                }

                // if the password does not match its user ID, it will display "wrong password"
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }
            
            // This following code will only be executed if the the username is not the one stored in the IDandPasswords file
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("UserID Not Found");
            }

        }

    }

}
