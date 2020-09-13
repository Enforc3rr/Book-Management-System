package AdminPanel;
import UI.ChangePass;
import UI.ChangePassAdmin;
import UI.UserSignup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel {
    private JFrame frame;
    public void initializeAdminPanel() {
        frame = new JFrame();
        frame.setBounds(100, 100, 802, 628);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("ADMIN PANEL");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
        lblNewLabel.setBounds(44, 11, 681, 98);
        frame.getContentPane().add(lblNewLabel);

        JButton adminPanelAddBook = new JButton("ADD BOOK");
        adminPanelAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AddBook addBook = new AddBook();
                addBook.initializeAddBook();
            }
        });
        adminPanelAddBook.setBackground(Color.PINK);
        adminPanelAddBook.setForeground(Color.BLACK);
        adminPanelAddBook.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelAddBook.setBounds(10, 144, 376, 98);
        frame.getContentPane().add(adminPanelAddBook);

        JButton adminPanelViewBook = new JButton("VIEW BOOKS");
        adminPanelViewBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewBooks viewBooks = new ViewBooks();
                viewBooks.initializeViewBooks();
                frame.dispose();

            }
        });
        adminPanelViewBook.setBackground(Color.PINK);
        adminPanelViewBook.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelViewBook.setBounds(10, 253, 376, 98);
        frame.getContentPane().add(adminPanelViewBook);

        JButton adminPanelDeleteBook = new JButton("DELETE BOOK");
        adminPanelDeleteBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteBook deleteBook = new DeleteBook();
                deleteBook.initializeDeleteBook();
                frame.dispose();
            }
        });
        adminPanelDeleteBook.setBackground(Color.PINK);
        adminPanelDeleteBook.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelDeleteBook.setBounds(10, 362, 376, 98);
        frame.getContentPane().add(adminPanelDeleteBook);

        JButton adminPanelChangePassword = new JButton("CHANGE PASSWORD");
        adminPanelChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassAdmin changePassAdmin = new ChangePassAdmin();
                changePassAdmin.initializeChangePassword();
            }
        });
        adminPanelChangePassword.setForeground(Color.WHITE);
        adminPanelChangePassword.setBackground(Color.BLUE);
        adminPanelChangePassword.setFont(new Font("Arial Black", Font.BOLD, 20));
        adminPanelChangePassword.setBounds(252, 471, 283, 75);
        frame.getContentPane().add(adminPanelChangePassword);

        JButton adminPanelAddUser = new JButton("ADD USER");
        adminPanelAddUser.setBackground(Color.YELLOW);
        adminPanelAddUser.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelAddUser.setBounds(396, 144, 376, 98);
        frame.getContentPane().add(adminPanelAddUser);
        adminPanelAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserSignup userSignup = new UserSignup();
                userSignup.initializeUserSignup();
            }
        });

        JButton adminPanelViewUsers = new JButton("VIEW USERS");
        adminPanelViewUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewUsers viewUsers = new ViewUsers();
                viewUsers.initializeViewUsers();
            }
        });
        adminPanelViewUsers.setBackground(Color.YELLOW);
        adminPanelViewUsers.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelViewUsers.setBounds(396, 253, 376, 98);
        frame.getContentPane().add(adminPanelViewUsers);

        JButton adminPanelDeleteUser = new JButton("DELETE USER");
        adminPanelDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteUser deleteUser = new DeleteUser();
                deleteUser.initializeDeleteUser();
                frame.dispose();
            }
        });
        adminPanelDeleteUser.setBackground(Color.YELLOW);
        adminPanelDeleteUser.setFont(new Font("Arial Black", Font.BOLD, 25));
        adminPanelDeleteUser.setBounds(396, 362, 376, 98);
        frame.getContentPane().add(adminPanelDeleteUser);

        JButton adminPanelExit = new JButton("EXIT");
        adminPanelExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        adminPanelExit.setBackground(Color.GREEN);
        adminPanelExit.setFont(new Font("Arial Black", Font.BOLD, 11));
        adminPanelExit.setBounds(252, 557, 283, 23);
        frame.getContentPane().add(adminPanelExit);
    }

}
