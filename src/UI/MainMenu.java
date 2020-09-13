package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu {
    private JFrame frame;
    public void initialize() {
        frame = new JFrame("MAIN MENU");
        frame.setBounds(100, 100, 675, 551);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel mainMenuLabel1 = new JLabel("BOOK MANAGMENT SYSTEM");
        mainMenuLabel1.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
        mainMenuLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(mainMenuLabel1, BorderLayout.NORTH);

        JButton mainMenuExit = new JButton("EXIT");
        mainMenuExit.setFont(new Font("Arial Black", Font.BOLD, 25));
        mainMenuExit.setBackground(Color.GREEN);
        frame.getContentPane().add(mainMenuExit, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel label_3 = new JLabel("");
        panel.add(label_3);

        JLabel mainMenuLabel2 = new JLabel("USER CLICK HERE TO LOGIN ->");
        mainMenuLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(mainMenuLabel2);

        JLabel label_4 = new JLabel("");
        panel.add(label_4);

        JLabel mainMenuLabel3 = new JLabel("USER CLICK HERE TO SIGN UP ->");
        mainMenuLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(mainMenuLabel3);

        JLabel label_5 = new JLabel("");
        panel.add(label_5);

        JLabel mainMenuLabel4 = new JLabel("ADMIN CLICK HERE TO LOG IN ->");
        mainMenuLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel.add(mainMenuLabel4);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.EAST);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel label = new JLabel("");
        panel_1.add(label);

        JButton mainMenuButtonLoginUser = new JButton("USER LOG IN");
        mainMenuButtonLoginUser.setHorizontalAlignment(SwingConstants.LEFT);
        mainMenuButtonLoginUser.setBackground(Color.BLUE);
        mainMenuButtonLoginUser.setForeground(Color.WHITE);
        mainMenuButtonLoginUser.setFont(new Font("Arial Black", Font.BOLD, 20));
        panel_1.add(mainMenuButtonLoginUser);

        JLabel label_1 = new JLabel("");
        panel_1.add(label_1);

        JButton mainMenuButtonSignupUser = new JButton("USER SIGN UP");
        mainMenuButtonSignupUser.setHorizontalAlignment(SwingConstants.LEFT);
        mainMenuButtonSignupUser.setForeground(Color.WHITE);
        mainMenuButtonSignupUser.setFont(new Font("Arial Black", Font.BOLD, 20));
        mainMenuButtonSignupUser.setBackground(Color.BLUE);
        panel_1.add(mainMenuButtonSignupUser);

        JLabel label_2 = new JLabel("");
        panel_1.add(label_2);

        JButton mainMenuButtonAdminLogin = new JButton("ADMIN LOG IN");
        mainMenuButtonAdminLogin.setHorizontalAlignment(SwingConstants.LEFT);
        mainMenuButtonAdminLogin.setBackground(Color.BLUE);
        mainMenuButtonAdminLogin.setFont(new Font("Arial Black", Font.BOLD, 20));
        mainMenuButtonAdminLogin.setForeground(Color.WHITE);
        panel_1.add(mainMenuButtonAdminLogin);

        mainMenuButtonLoginUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserLoginScreen loginScreen = new UserLoginScreen();
                loginScreen.initializeUserLogiIn();
            }
        });
        mainMenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenuButtonSignupUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserSignup userSignup = new UserSignup();
                userSignup.initializeUserSignup();
            }
        });
        mainMenuButtonAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.initializeAdminLogin();
            }
        });

    }
}
