package UI;


import AdminPanel.AdminPanel;
import BackEnd.DAO;
import BackEnd.PassCheckUser;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class AdminLogin {

    private JFrame frame;
    private JTextField adminLoginUserName;
    private JPasswordField adminLoginPassword;
    public void initializeAdminLogin() {
        frame = new JFrame();
        frame.setBounds(100, 100, 667, 686);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("ADMIN LOG IN");
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 631, 93);
        frame.getContentPane().add(lblNewLabel);

        JLabel adminUserNameLabel = new JLabel("ENTER YOUR USERNAME ->");
        adminUserNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        adminUserNameLabel.setBounds(10, 166, 317, 90);
        frame.getContentPane().add(adminUserNameLabel);

        adminLoginUserName = new JTextField();
        adminLoginUserName.setText("UserName");
        adminLoginUserName.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
        adminLoginUserName.setBounds(337, 163, 304, 93);
        frame.getContentPane().add(adminLoginUserName);
        adminLoginUserName.setColumns(10);

        JLabel adminPasswordLabel = new JLabel("ENTER YOUR PASSWORD ->");
        adminPasswordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        adminPasswordLabel.setBounds(10, 372, 317, 86);
        frame.getContentPane().add(adminPasswordLabel);

        adminLoginPassword = new JPasswordField();
        adminLoginPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        adminLoginPassword.setBounds(337, 369, 304, 93);
        frame.getContentPane().add(adminLoginPassword);

        JButton adminLoginButton = new JButton("LOG IN");
        adminLoginButton.setForeground(Color.WHITE);
        adminLoginButton.setBackground(Color.CYAN);
        adminLoginButton.setFont(new Font("Arial Black", Font.BOLD, 30));
        adminLoginButton.setBounds(10, 533, 498, 76);
        frame.getContentPane().add(adminLoginButton);
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                PassCheckUser passCheckUser = new PassCheckUser(adminLoginUserName.getText(),adminLoginPassword.getText());
                DAO dao = new DAO();
                try {
                    check = dao.checkAdminLoginDetails(passCheckUser);
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
                if(check){
                    frame.dispose();
                    AdminPanel adminPanel = new AdminPanel();
                    adminPanel.initializeAdminPanel();
                    frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"INCORRECT USERNAME or PASSWORD");
                }
            }
        });

        JButton btnNewButton_1 = new JButton("EXIT");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_1.setBackground(Color.GREEN);
        btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 30));
        btnNewButton_1.setBounds(518, 533, 123, 76);
        frame.getContentPane().add(btnNewButton_1);
    }
}
