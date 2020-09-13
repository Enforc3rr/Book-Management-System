package AdminPanel;


import BackEnd.DAO;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteBook {
    private JFrame frame;
    private JTextField userNameToDelete;
    public void initializeDeleteBook() {
        frame = new JFrame("DELETE BOOK");
        frame.setBounds(100, 100, 666, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel deleteBookLabel1 = new JLabel("DELETE BOOK");
        deleteBookLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        deleteBookLabel1.setFont(new Font("Arial Black", Font.BOLD, 50));
        deleteBookLabel1.setBounds(0, 0, 650, 118);
        frame.getContentPane().add(deleteBookLabel1);

        JLabel lblNewLabel_1 = new JLabel("ENTER BOOKNAME TO DELETE ->");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lblNewLabel_1.setBounds(0, 206, 332, 90);
        frame.getContentPane().add(lblNewLabel_1);

        userNameToDelete = new JTextField();
        userNameToDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        userNameToDelete.setBounds(368, 206, 272, 90);
        frame.getContentPane().add(userNameToDelete);
        userNameToDelete.setColumns(10);

        JButton userNameToDeleteButton = new JButton("CLICK TO DELETE");
        userNameToDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAO dao = new DAO();
                try {
                    dao.deleteBook(userNameToDelete.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"BOOK SUCCESSFULLY DELETED");
            }
        });
        userNameToDeleteButton.setBackground(Color.RED);
        userNameToDeleteButton.setFont(new Font("Arial Black", Font.BOLD, 25));
        userNameToDeleteButton.setBounds(38, 317, 484, 93);
        frame.getContentPane().add(userNameToDeleteButton);

        JButton userNameToDeleteExit = new JButton("EXIT");
        userNameToDeleteExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        userNameToDeleteExit.setBackground(Color.GREEN);
        userNameToDeleteExit.setFont(new Font("Arial Black", Font.BOLD, 20));
        userNameToDeleteExit.setBounds(532, 317, 95, 93);
        frame.getContentPane().add(userNameToDeleteExit);
    }
}
