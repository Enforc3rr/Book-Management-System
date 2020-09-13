package UI;
import BackEnd.*;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class UserSignup {
    private JFrame frame;
    private JTextField userText;
    private JTextField userUserName;
    private JTextField userMobileNumber;
    private JTextField userAddress;
    private JTextField userEmail;
    private JPasswordField userPassword;

    public void initializeUserSignup() {
        frame = new JFrame();
        frame.setBounds(100, 100, 727, 804);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 711, 67);
        frame.getContentPane().add(panel1);

        JLabel userSignupLabel1 = new JLabel("USER SIGN UP ");
        panel1.add(userSignupLabel1);
        userSignupLabel1.setFont(new Font("Arial Black", Font.BOLD, 40));

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(65, 699, 606, 55);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton userConfirm = new JButton("CONFIRM SIGN UP DETAILS");
        panel_2.add(userConfirm);
        userConfirm.setBackground(Color.BLUE);
        userConfirm.setForeground(Color.WHITE);
        userConfirm.setFont(new Font("Arial Black", Font.BOLD, 26));
        JButton userExit = new JButton("EXIT");
        userExit.setFont(new Font("Arial Black", Font.BOLD, 26));
        userExit.setBackground(Color.GREEN);
        panel_2.add(userExit);
        userExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(363, 67, 348, 626);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        userText = new JTextField();
        userText.setText("Name");
        userText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userText.setBounds(0, 11, 338, 60);
        panel_1.add(userText);
        userText.setColumns(10);

        userUserName = new JTextField();
        userUserName.setText("UserName");
        userUserName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userUserName.setBounds(0, 105, 338, 60);
        panel_1.add(userUserName);
        userUserName.setColumns(10);

        userMobileNumber = new JTextField();
        userMobileNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userMobileNumber.setText("MobileNumber");
        userMobileNumber.setBounds(0, 210, 338, 60);
        panel_1.add(userMobileNumber);
        userMobileNumber.setColumns(10);

        userAddress = new JTextField();
        userAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userAddress.setText("Address");
        userAddress.setBounds(0, 311, 338, 60);
        panel_1.add(userAddress);
        userAddress.setColumns(10);

        userEmail = new JTextField();
        userEmail.setText("Email");
        userEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userEmail.setBounds(0, 408, 338, 60);
        panel_1.add(userEmail);
        userEmail.setColumns(10);

        userPassword = new JPasswordField();
        userPassword.setBounds(0, 522, 338, 60);
        panel_1.add(userPassword);

        JPanel panel = new JPanel();
        panel.setBounds(10, 67, 348, 626);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel userSignupLabel2 = new JLabel("ENTER YOUR NAME ->");
        userSignupLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userSignupLabel2.setBounds(10, 5, 328, 72);
        panel.add(userSignupLabel2);

        JLabel userSignupLabel3 = new JLabel("ENTER YOUR USERNAME->");
        userSignupLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userSignupLabel3.setBounds(10, 88, 328, 88);
        panel.add(userSignupLabel3);

        JLabel userSignupLabel4 = new JLabel("ENTER YOUR MOBILE NUMBER ->");
        userSignupLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        userSignupLabel4.setBounds(10, 187, 328, 88);
        panel.add(userSignupLabel4);

        JLabel userSignupLabel5 = new JLabel("ENTER YOUR ADDRESS ->");
        userSignupLabel5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userSignupLabel5.setBounds(0, 294, 328, 88);
        panel.add(userSignupLabel5);

        JLabel lblNewLabel_4 = new JLabel("ENTER YOUR EMAIL ->");
        lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNewLabel_4.setBounds(10, 393, 328, 88);
        panel.add(lblNewLabel_4);

        JLabel userSignupLabel7 = new JLabel("ENTER YOUR PASSWORD ->");
        userSignupLabel7.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userSignupLabel7.setBounds(10, 509, 317, 88);
        panel.add(userSignupLabel7);
        userConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDetails userDetails = new UserDetails(userText.getText() , userUserName.getText(), userMobileNumber.getText(),userAddress.getText(),userEmail.getText(), userPassword.getText());
                DAO dao = new DAO();
                try {
                    dao.setUserValues(userDetails);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.dispose();
                System.exit(0);
            }
        });
    }
}
