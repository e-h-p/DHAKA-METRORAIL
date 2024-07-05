/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

import java.awt.Container;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class BookTicket extends JFrame implements Serializable{
    private int train_no;
    private Container c;
    private JTextField tf1,tf2;
    private JLabel lable1,lable2,lable3,imglable;
    private Font f,F;
    private ImageIcon img;
    private JButton btn1,btn2,btn3;
    private  JPanel panel1,panel2; 
    BookTicket()
    {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,50,800,480);
        this.setTitle("Ticket Booking");

        framedesign();
        paneldesign();
        buttondesign();

        this.setVisible(true);
    }
    public void framedesign() {

        f = new Font("times new roman",Font.BOLD,17);
        
       
    }
    public void panelDesign()
    {
        img = new ImageIcon(getClass().getResource("newfinal.png"));
        imglable = new JLabel(img);
        imglable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
      //  imglable.setBounds(1,2,384,480);
        c.add(imglable);
    }

    
    
}
