package BackEnd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JScrollPane;

public class TableOfBookGenre {
    private JFrame frame;
    private JTextField viewBookSearch;
    private JTable table;
    public void initializeOtherViewOptions() {
        frame = new JFrame();
        frame.setBounds(100, 100, 963, 701);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel viewBookLabel1 = new JLabel("VIEW BOOKS");
        viewBookLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        viewBookLabel1.setFont(new Font("Arial Black", Font.BOLD, 40));
        viewBookLabel1.setBounds(0, 0, 937, 45);
        frame.getContentPane().add(viewBookLabel1);

        viewBookSearch = new JTextField();
        viewBookSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DAO dao = new DAO();
                try {
                    dao.searchBookTableByGenre(table,viewBookSearch.getText());
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        viewBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
        viewBookSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        viewBookSearch.setBounds(256, 50, 273, 37);
        frame.getContentPane().add(viewBookSearch);
        viewBookSearch.setColumns(10);

        JButton viewBookSearchButton = new JButton("TO VIEW EVERY ELEMENT OF TABLE");
        viewBookSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAO dao = new DAO();
                try {
                    dao.showTableBooks(table);
                } catch (IOException | SQLException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        viewBookSearchButton.setBackground(Color.BLUE);
        viewBookSearchButton.setForeground(Color.WHITE);
        viewBookSearchButton.setFont(new Font("Arial Black", Font.BOLD, 17));
        viewBookSearchButton.setBounds(539, 50, 398, 37);
        frame.getContentPane().add(viewBookSearchButton);

        JScrollPane viewBooksScrollPane = new JScrollPane();
        viewBooksScrollPane.setBounds(10, 98, 927, 551);
        frame.getContentPane().add(viewBooksScrollPane);

        table = new JTable();
        viewBooksScrollPane.setViewportView(table);

        JLabel viewBookLabel2 = new JLabel("ENTER GENRE OF BOOK ->");
        viewBookLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        viewBookLabel2.setBounds(10, 50, 236, 37);
        frame.getContentPane().add(viewBookLabel2);
    }
}
