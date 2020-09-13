package UI;

import BackEnd.DAO;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ChangePassAdmin{

    private JFrame frame;
    private JTextField newPass;
    private JPasswordField confirmPass;

    public void initializeChangePassword() {
        frame = new JFrame("PASSWORD CHANGE ADMIN");
        frame.setBounds(100, 100, 903, 506);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);


        JLabel changePassLabel1 = new JLabel("CHANGE PASSWORD");
        changePassLabel1.setFont(new Font("Arial Black", Font.BOLD, 50));
        changePassLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        changePassLabel1.setBounds(10, 11, 867, 118);
        frame.getContentPane().add(changePassLabel1);

        JButton changePassApply = new JButton("CLICK HERE TO APPLY CHANGES");
        changePassApply.setBackground(Color.CYAN);
        changePassApply.setForeground(Color.WHITE);
        changePassApply.setFont(new Font("Arial Black", Font.BOLD, 20));
        changePassApply.setBounds(227, 391, 477, 65);
        frame.getContentPane().add(changePassApply);

        JLabel changePassLabel2 = new JLabel("ENTER NEW PASSWORD ->");
        changePassLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        changePassLabel2.setBounds(10, 141, 381, 65);
        frame.getContentPane().add(changePassLabel2);

        newPass = new JTextField();
        newPass.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
        newPass.setBounds(476, 140, 381, 65);
        frame.getContentPane().add(newPass);
        newPass.setColumns(10);

        JLabel changePassLabel3 = new JLabel("CONFIRM YOUR PASSWORD ->");
        changePassLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        changePassLabel3.setBounds(10, 217, 381, 65);
        frame.getContentPane().add(changePassLabel3);

        confirmPass = new JPasswordField();
        confirmPass.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
        confirmPass.setBounds(476, 224, 381, 65);
        frame.getContentPane().add(confirmPass);

        changePassApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newPass.getText().equals(confirmPass.getText())){
                    System.out.println(newPass.getText());
                    DAO dao = new DAO();
                    try {
                        dao.changePassValueAdmin(newPass.getText());
                    } catch (IOException | SQLException ioException) {
                        ioException.printStackTrace();
                    }
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"PASSWORD SUCCESSFULLY CHANGED");
                    System.exit(0);
                }else {
                    JOptionPane.showMessageDialog(null,"Passwords Don't Match");
                }
            }
        });
    }
}
