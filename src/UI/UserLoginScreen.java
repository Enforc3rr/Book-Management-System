package UI;

import BackEnd.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;

public class UserLoginScreen {

    private JFrame frame;
    private JTextField userLoginScreenUserNameTextField;
    private JPasswordField userLoginScreenUserPasswordField;
    public void initializeUserLogiIn() {
        frame = new JFrame();
        frame.setBounds(100, 100, 843, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel userLoginScreenLabel1 = new JLabel("USER LOG IN");
        userLoginScreenLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        userLoginScreenLabel1.setFont(new Font("Arial Black", Font.BOLD, 50));
        userLoginScreenLabel1.setBounds(0, 0, 827, 149);
        frame.getContentPane().add(userLoginScreenLabel1);

        JLabel userLoginScreenLabel2 = new JLabel("ENTER YOUR USERNAME HERE ->");
        userLoginScreenLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userLoginScreenLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        userLoginScreenLabel2.setBounds(10, 185, 392, 97);
        frame.getContentPane().add(userLoginScreenLabel2);

        userLoginScreenUserNameTextField = new JTextField();
        userLoginScreenUserNameTextField.setText("USERNAME");
        userLoginScreenUserNameTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userLoginScreenUserNameTextField.setBounds(428, 185, 389, 97);
        frame.getContentPane().add(userLoginScreenUserNameTextField);
        userLoginScreenUserNameTextField.setColumns(10);

        JLabel userLoginScreenLabel3 = new JLabel("ENTER YOUR PASSWORD HERE ->");
        userLoginScreenLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        userLoginScreenLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userLoginScreenLabel3.setBounds(10, 334, 392, 97);
        frame.getContentPane().add(userLoginScreenLabel3);

        userLoginScreenUserPasswordField = new JPasswordField();
        userLoginScreenUserPasswordField.setFont(new Font("Tahoma", Font.BOLD, 20));
        userLoginScreenUserPasswordField.setBounds(428, 337, 389, 94);
        frame.getContentPane().add(userLoginScreenUserPasswordField);

        JButton userLoginScreenLoginButton = new JButton("CLICK HERE TO LOGIN");
        userLoginScreenLoginButton.setForeground(Color.WHITE);
        userLoginScreenLoginButton.setBackground(Color.BLUE);
        userLoginScreenLoginButton.setFont(new Font("Arial Black", Font.BOLD, 25));
        userLoginScreenLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                PassCheckUser passCheckUser = new PassCheckUser(userLoginScreenUserNameTextField.getText(),userLoginScreenUserPasswordField.getText());
                DAO dao = new DAO();
                try {
                    check = dao.checkUserLoginDetails(passCheckUser);
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
                if(check){
                    frame.dispose();
                    UserPanel userPanel = new UserPanel();
                    userPanel.initializeUserPanel();
                }else {
                    JOptionPane.showMessageDialog(null,"INCORRECT USERNAME or PASSWORD");
                }
            }
        });
        userLoginScreenLoginButton.setBounds(158, 566, 392, 74);
        frame.getContentPane().add(userLoginScreenLoginButton);

        JButton btnNewButton_1 = new JButton("EXIT");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 20));
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBackground(Color.GREEN);
        btnNewButton_1.setBounds(602, 568, 196, 72);
        frame.getContentPane().add(btnNewButton_1);
    }
}

