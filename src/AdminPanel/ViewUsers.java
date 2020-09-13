package AdminPanel;


import BackEnd.DAO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

public class ViewUsers {

    private JFrame frame;
    private JTextField textField;
    private JTable table;

    public void initializeViewUsers() {
        frame = new JFrame();
        frame.setBounds(100, 100, 903, 706);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel viewUsersLabel1 = new JLabel("VIEW USERS");
        viewUsersLabel1.setFont(new Font("Arial Black", Font.BOLD, 40));
        viewUsersLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        viewUsersLabel1.setBounds(0, 0, 887, 70);
        frame.getContentPane().add(viewUsersLabel1);

        JLabel viewUserLabel2 = new JLabel("ENTER USERNAME TO SEARCH ->");
        viewUserLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        viewUserLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        viewUserLabel2.setBounds(10, 81, 269, 70);
        frame.getContentPane().add(viewUserLabel2);

        textField = new JTextField();
        textField.setBounds(289, 81, 352, 70);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DAO dao = new DAO();
                try {
                    dao.searchUsers(textField.getText(),table);
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton viewUserSearch = new JButton("CLICK TO VIEW EVERY USER");
        viewUserSearch.setBackground(Color.YELLOW);
        viewUserSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAO dao = new DAO();
                try {
                    dao.showUsers(table);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        viewUserSearch.setFont(new Font("Arial Black", Font.BOLD, 11));
        viewUserSearch.setBounds(651, 81, 214, 70);
        frame.getContentPane().add(viewUserSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 202, 887, 465);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }
}
