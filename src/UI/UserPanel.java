package UI;

import AdminPanel.ViewBooks;
import BackEnd.ChangePassValues;
import BackEnd.PassCheckUser;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPanel {

    private JFrame frame;


    public void initializeUserPanel() {
        frame = new JFrame();
        frame.setBounds(100, 100, 858, 481);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel userPanelLabel1 = new JLabel("USER PANEL ");
        userPanelLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        userPanelLabel1.setFont(new Font("Arial Black", Font.BOLD, 45));
        userPanelLabel1.setBounds(0, 0, 837, 93);
        frame.getContentPane().add(userPanelLabel1);

        JLabel userPanelLabel2 = new JLabel("CLICK HERE TO VIEW BOOKS ->");
        userPanelLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        userPanelLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        userPanelLabel2.setBounds(10, 104, 413, 93);
        frame.getContentPane().add(userPanelLabel2);

        JButton userPanelViewBooks = new JButton("VIEW BOOKS");
        userPanelViewBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewBooks viewBooks = new ViewBooks();
                viewBooks.initializeViewBooks();
            }
        });
        userPanelViewBooks.setBackground(Color.CYAN);
        userPanelViewBooks.setForeground(Color.RED);
        userPanelViewBooks.setFont(new Font("Arial Black", Font.BOLD, 25));
        userPanelViewBooks.setBounds(433, 102, 394, 95);
        frame.getContentPane().add(userPanelViewBooks);

        JLabel userPanelLabel3 = new JLabel("CLICK HERE FOR DIFFERENT SEARCH OPTIONS ->");
        userPanelLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        userPanelLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        userPanelLabel3.setBounds(10, 244, 413, 93);
        frame.getContentPane().add(userPanelLabel3);

        JButton userPanelSearch = new JButton("SEARCH");
        userPanelSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userSearchOptionScreen userSearchOptionScreen = new userSearchOptionScreen();
                userSearchOptionScreen.initializeuserSearchOptionScreen();
                frame.dispose();
            }
        });
        userPanelSearch.setBackground(Color.ORANGE);
        userPanelSearch.setFont(new Font("Arial Black", Font.BOLD, 25));
        userPanelSearch.setForeground(Color.RED);
        userPanelSearch.setBounds(433, 244, 394, 93);
        frame.getContentPane().add(userPanelSearch);

        JButton userPanelExit = new JButton("EXIT");
        userPanelExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        userPanelExit.setBackground(Color.GREEN);
        userPanelExit.setFont(new Font("Arial Black", Font.BOLD, 20));
        userPanelExit.setBounds(534, 370, 107, 61);
        frame.getContentPane().add(userPanelExit);

        JButton userPanelChangePassword = new JButton("CLICK TO CHANGE PASSWORD");
        userPanelChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ChangePass changePass = new ChangePass();
                changePass.initializeChangePassword();
            }
        });
        userPanelChangePassword.setForeground(Color.WHITE);
        userPanelChangePassword.setBackground(Color.BLUE);
        userPanelChangePassword.setFont(new Font("Arial Black", Font.BOLD, 20));
        userPanelChangePassword.setBounds(20, 370, 403, 61);
        frame.getContentPane().add(userPanelChangePassword);
    }

}
