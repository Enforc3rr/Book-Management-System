package AdminPanel;

import BackEnd.BookDetails;
import BackEnd.DAO;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class AddBook {
    private JFrame frame;
    private JTextField addBookName;
    private JTextField addBookAuthor;
    private JTextField addBookGenre;
    private JTextField addBookYear;
    private JTextField addBookDescription;

    public void initializeAddBook() {
        frame = new JFrame();
        frame.setBounds(100, 100, 660, 693);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel addBookLabel1 = new JLabel("ADD BOOK ");
        addBookLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel1.setFont(new Font("Arial Black", Font.BOLD, 30));
        addBookLabel1.setBounds(0, 0, 610, 91);
        frame.getContentPane().add(addBookLabel1);

        JLabel addBookLabel2 = new JLabel("NAME OF BOOK ->");
        addBookLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addBookLabel2.setBounds(0, 102, 304, 84);
        frame.getContentPane().add(addBookLabel2);

        JLabel addBookLabel3 = new JLabel("AUTHOR OF BOOK ->");
        addBookLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addBookLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel3.setBounds(0, 197, 304, 84);
        frame.getContentPane().add(addBookLabel3);

        JLabel addBookLabel4 = new JLabel("ENTER GENRE OF BOOK ->");
        addBookLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addBookLabel4.setBounds(0, 292, 304, 84);
        frame.getContentPane().add(addBookLabel4);

        JLabel addBookLabel5 = new JLabel("ENTER YEAR OF PUBLICATION ->");
        addBookLabel5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        addBookLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel5.setBounds(0, 387, 304, 84);
        frame.getContentPane().add(addBookLabel5);

        JLabel addBookLabel6 = new JLabel("ENTER SHORT DESCRIPTION ->");
        addBookLabel6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        addBookLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        addBookLabel6.setBounds(0, 482, 304, 84);
        frame.getContentPane().add(addBookLabel6);

        JButton addBookApply = new JButton("CLICK HERE TO SAVE");
        addBookApply.setFont(new Font("Arial Black", Font.BOLD, 17));
        addBookApply.setBackground(Color.CYAN);
        addBookApply.setForeground(Color.WHITE);
        addBookApply.setBounds(0, 577, 462, 69);
        frame.getContentPane().add(addBookApply);

        JButton addBookExit = new JButton("EXIT");
        addBookExit.setBackground(Color.GREEN);
        addBookExit.setFont(new Font("Arial Black", Font.BOLD, 20));
        addBookExit.setBounds(472, 579, 160, 67);
        frame.getContentPane().add(addBookExit);

        addBookName = new JTextField();
        addBookName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        addBookName.setText("NAME ");
        addBookName.setBounds(328, 102, 304, 84);
        frame.getContentPane().add(addBookName);
        addBookName.setColumns(10);

        addBookAuthor = new JTextField();
        addBookAuthor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        addBookAuthor.setText("AUTHOR");
        addBookAuthor.setHorizontalAlignment(SwingConstants.LEFT);
        addBookAuthor.setBounds(328, 197, 304, 84);
        frame.getContentPane().add(addBookAuthor);
        addBookAuthor.setColumns(10);

        addBookGenre = new JTextField();
        addBookGenre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        addBookGenre.setText("GENRE");
        addBookGenre.setBounds(328, 292, 304, 84);
        frame.getContentPane().add(addBookGenre);
        addBookGenre.setColumns(10);

        addBookYear = new JTextField();
        addBookYear.setText("YEAR");
        addBookYear.setHorizontalAlignment(SwingConstants.LEFT);
        addBookYear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        addBookYear.setBounds(328, 387, 304, 84);
        frame.getContentPane().add(addBookYear);
        addBookYear.setColumns(10);

        addBookDescription = new JTextField();
        addBookDescription.setText("DESCRIPTION....");
        addBookDescription.setHorizontalAlignment(SwingConstants.LEFT);
        addBookDescription.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
        addBookDescription.setBounds(328, 482, 304, 84);
        frame.getContentPane().add(addBookDescription);
        addBookDescription.setColumns(10);


        addBookExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addBookApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDetails bookDetails = new BookDetails(addBookName.getText(),addBookAuthor.getText(),addBookGenre.getText(),addBookYear.getText(),addBookDescription.getText());
                DAO dao = new DAO();
                try {
                    dao.setBookValues(bookDetails);
                } catch (IOException  ioException) {
                    ioException.printStackTrace();
                }
                frame.dispose();
                System.exit(0);
            }
        });
    }
}
