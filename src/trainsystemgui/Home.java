/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

/**
 *
 * @author Asus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Home extends JFrame {
    private Container c;
    private JLabel label1, label2, label3;
    private JButton btn1, btn2, btn3,btn4,btn5,btn6;
    private JPanel panel1, panel2, panel3;
    private Font headingFont, buttonFont;
    private Color backgroundColor, buttonColor;
  

    Home(int i) {
        
        c = this.getContentPane();
        c.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 50, 500, 600);
        this.setTitle("User");

        // Set background color
        backgroundColor = new Color(250, 240, 230);
        c.setBackground(backgroundColor);

        // Create a panel for buttons
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 1));
        panel1.setBackground(Color.WHITE);

        // Load button images and set button properties
        ImageIcon trainIcon = new ImageIcon(getClass().getResource("button_view-train (1).png"));
        ImageIcon bookIcon = new ImageIcon(getClass().getResource("button_book-ticket.png"));
        ImageIcon canelIcon = new ImageIcon(getClass().getResource("button_cancel-ticket.png"));
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("button_view-profile.png"));
        ImageIcon historyIcon = new ImageIcon(getClass().getResource("button_view-history.png"));
        ImageIcon logIcon = new ImageIcon(getClass().getResource("button_log-out.png"));


        buttonFont = new Font("Arial", Font.BOLD, 18);
        buttonColor = new Color(70, 130, 180);

        btn1 = new JButton(trainIcon);
        btn2 = new JButton(bookIcon);
        btn3 = new JButton(canelIcon);
        btn4 = new JButton(profileIcon);
        btn5 = new JButton(historyIcon);
        btn6 = new JButton(logIcon);

        btn1.setFont(buttonFont);
        btn2.setFont(buttonFont);
        btn3.setFont(buttonFont);
        btn4.setFont(buttonFont);
        btn5.setFont(buttonFont);
        btn6.setFont(buttonFont);


        btn1.setBackground(buttonColor);
        btn2.setBackground(buttonColor);
        btn3.setBackground(buttonColor);
        btn4.setBackground(buttonColor);
        btn5.setBackground(buttonColor);
        btn6.setBackground(buttonColor);


        // Add action listeners to buttons (customize according to your needs)
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Train.viewTrainSchedule();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action for Option 2
                DataList.userList.get(i).bookTicket(i);
                //System.out.println(i);
                
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action for Option 3
                 DataList.userList.get(i).cancellTicket(i);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action for Option 3
                 DataList.userList.get(i).viewProfile();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action for Option 3
                 DataList.userList.get(i).viewPreviousRecords();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action for Option 3
                 //DataList.userList.get(i).viewPreviousRecords();
                 dispose();
                 new TrainSystemGUI();
            }
        });

        // Add buttons to the panel
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        panel1.add(btn4);
        panel1.add(btn5);
        panel1.add(btn6);

        // Create a heading label
        label1 = new JLabel("Welcome!! "+DataList.userList.get(i).first_name+" "+DataList.userList.get(i).last_name);
        headingFont = new Font("Arial", Font.BOLD, 24);
        label1.setFont(headingFont);
        label1.setHorizontalAlignment(JLabel.CENTER);

        // Add components to the content pane
        c.add(label1, BorderLayout.NORTH);
        c.add(panel1, BorderLayout.CENTER);

        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        new Home();
//    }
}