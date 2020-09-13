package UI;

import AdminPanel.*;
import BackEnd.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userSearchOptionScreen {

    private JFrame frame;
    public void initializeuserSearchOptionScreen() {
        frame = new JFrame();
        frame.setBounds(100, 100, 634, 622);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel userSearchOptionScreenLabel1 = new JLabel("SEARCH OPTIONS ->");
        userSearchOptionScreenLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        userSearchOptionScreenLabel1.setFont(new Font("Arial Black", Font.BOLD, 50));
        userSearchOptionScreenLabel1.setBounds(0, 0, 618, 137);
        frame.getContentPane().add(userSearchOptionScreenLabel1);

        JLabel userSearchOptionScreenLabel2 = new JLabel("BY GENRE ->");
        userSearchOptionScreenLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        userSearchOptionScreenLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        userSearchOptionScreenLabel2.setBounds(10, 148, 389, 72);
        frame.getContentPane().add(userSearchOptionScreenLabel2);

        JLabel userSearchOptionScreenLabel3 = new JLabel("BY YEAR ->");
        userSearchOptionScreenLabel3.setHorizontalAlignment(SwingConstants.LEFT);
        userSearchOptionScreenLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        userSearchOptionScreenLabel3.setBounds(10, 267, 389, 72);
        frame.getContentPane().add(userSearchOptionScreenLabel3);

        JLabel userSearchOptionScreenLabel4 = new JLabel("BY AUTHOR'S NAME ->");
        userSearchOptionScreenLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        userSearchOptionScreenLabel4.setBounds(10, 375, 395, 72);
        frame.getContentPane().add(userSearchOptionScreenLabel4);

        JButton userSearchOptionScreenButtonSearch = new JButton("SEARCH");
        userSearchOptionScreenButtonSearch.setBackground(Color.RED);
        userSearchOptionScreenButtonSearch.setFont(new Font("Arial Black", Font.BOLD, 25));
        userSearchOptionScreenButtonSearch.setBounds(95, 512, 407, 47);
        frame.getContentPane().add(userSearchOptionScreenButtonSearch);

        JButton userSearchOptionScreenButtonExit = new JButton("EXIT");
        userSearchOptionScreenButtonExit.setBackground(Color.GREEN);
        userSearchOptionScreenButtonExit.setFont(new Font("Arial Black", Font.BOLD, 20));
        userSearchOptionScreenButtonExit.setBounds(512, 512, 89, 47);
        frame.getContentPane().add(userSearchOptionScreenButtonExit);

        JRadioButton userSearchOptionScreenRadioButtonGenre = new JRadioButton("");
        userSearchOptionScreenRadioButtonGenre.setHorizontalAlignment(SwingConstants.CENTER);
        userSearchOptionScreenRadioButtonGenre.setBounds(413, 148, 166, 72);
        frame.getContentPane().add(userSearchOptionScreenRadioButtonGenre);

        JRadioButton userSearchOptionScreenRadioButtonYear = new JRadioButton("");
        userSearchOptionScreenRadioButtonYear.setHorizontalAlignment(SwingConstants.CENTER);
        userSearchOptionScreenRadioButtonYear.setBounds(413, 267, 166, 72);
        frame.getContentPane().add(userSearchOptionScreenRadioButtonYear);

        JRadioButton userSearchOptionScreenRadioButtonAuthorName = new JRadioButton("");
        userSearchOptionScreenRadioButtonAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
        userSearchOptionScreenRadioButtonAuthorName.setBounds(411, 375, 168, 72);
        frame.getContentPane().add(userSearchOptionScreenRadioButtonAuthorName);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(userSearchOptionScreenRadioButtonAuthorName);
        buttonGroup.add(userSearchOptionScreenRadioButtonGenre);
        buttonGroup.add(userSearchOptionScreenRadioButtonYear);

        userSearchOptionScreenButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       userSearchOptionScreenButtonSearch.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               DAO dao = new DAO();
               if(userSearchOptionScreenRadioButtonGenre.isSelected()){
                   TableOfBookGenre tableOfBookGenre = new TableOfBookGenre();
                   tableOfBookGenre.initializeOtherViewOptions();

               } else if(userSearchOptionScreenRadioButtonAuthorName.isSelected()){
                   TableOfBookNameAuthor tableOfBookNameAuthor = new TableOfBookNameAuthor();
                   tableOfBookNameAuthor.initializeOtherViewOptions();

               }
               else if(userSearchOptionScreenRadioButtonYear.isSelected()){
                   TableOfBookYear tableOfBookYear = new TableOfBookYear();
                   tableOfBookYear.initializeOtherViewOptions();
               }
           }
       });
    }

}
