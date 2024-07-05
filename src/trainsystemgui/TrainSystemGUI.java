/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trainsystemgui;
import javax.swing.*;
import java.awt.*;
import static java.awt.Font.BOLD;
import java.io.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;


public class TrainSystemGUI  extends JFrame implements Serializable {

    private Container c;
    private JTextField tf1,tf2;
    private JLabel lable1,lable2,lable3,imglable;
    private JPasswordField pf;
    private Font f,F;
    private ImageIcon img;
    private JButton btn1,btn2,btn3;
    private  JPanel panel1,panel2;
    private JRadioButton userradio,manegerradio;
    private ButtonGroup radiogroup;

    TrainSystemGUI()
    {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,50,800,480);
        this.setTitle("Login");

        framedesign();
        paneldesign();
        buttondesign();

        this.setVisible(true);
    }
    public static void Admin(){
             SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Admin Panel");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            frame.setSize(500, 500);
            frame.setLocation(300, 150);

            JPanel panel = new JPanel();
            frame.add(panel);

            JButton addTrainButton = new JButton("Add Train");
            JButton viewScheduleButton = new JButton("View Schedule");
            JButton deleteTrainButton = new JButton("Delete Train");

            panel.add(addTrainButton);
             panel.add(deleteTrainButton);
            panel.add(viewScheduleButton);
            panel.setBackground(new Color(15,44,0));
            JTextArea textArea = new JTextArea(10, 40);
            //textArea.setBackground(Color.yellow);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            panel.add(scrollPane);
           
            FileSystem<Train> obj= new FileSystem<>();
             //DataList.trainList=obj.readArrayListFromFile( "TrainList.ser");
                
            addTrainButton.addActionListener(e -> {
                Train train = new Train();
                train.inputTrain();
                //trainList.add(train);
                
                //obj= new FileSystem<>();
                obj.saveArrayListToFile(DataList.trainList, "TrainList.ser");
                
                textArea.append("Train INPUT:\n");
            });
            deleteTrainButton.addActionListener(e -> {
                //textArea.setText(""); // Clear the text area
                Train.deleteTrain();
                obj.saveArrayListToFile(DataList.trainList, "TrainList.ser");
                textArea.append("Train DELETE\n");
            });
            viewScheduleButton.addActionListener(e -> {
                textArea.setText(""); // Clear the text area
                Train.viewTrainSchedule();
                textArea.append("Train Schedule Displayed\n");
            });
            frame.setVisible(true);
        });
    }
    public void framedesign() {

        f = new Font("times new roman",Font.BOLD,17);
        
        lable3 = new JLabel();
        lable3.setOpaque(true);
        lable3.setBounds(450,50,360,70);
        lable3.setBackground(Color.white);
        lable3.setFont(new Font("times new roman",F.BOLD,22));
        lable3.setText("Welcome to Dhaka Metro-Rail");
        c.add(lable3);

        userradio = new JRadioButton("User");
        userradio.setOpaque(false);
        userradio.setBounds(500,150,60,20);
        c.add(userradio);

        manegerradio = new JRadioButton("Admin");
        manegerradio.setOpaque(false);
        manegerradio.setBounds(570,150,90,20);
        c.add(manegerradio);

        radiogroup = new ButtonGroup();
        radiogroup.add(userradio);
        radiogroup.add(manegerradio);


        lable1 = new JLabel();
        lable1.setText("Username :");
        lable1.setBounds(407,200,120,50);
        lable1.setFont(f);
      //  lable1.setOpaque(true);
        lable1.setForeground(Color.BLACK);
        lable1.setToolTipText("Enter Correctly");
        lable1.setBackground(Color.yellow);

        c.add(lable1);

        lable2 = new JLabel();
        lable2.setText("Password :");
        lable2.setBounds(410,260,120,50);
        lable2.setFont(f);
      //  lable2.setOpaque(true);
        lable2.setForeground(Color.BLACK);
        lable2.setToolTipText("Password should contain character and number both");
        lable2.setBackground(Color.yellow);
        c.add(lable2);


        tf1 = new JTextField();
        tf1.setBounds(530,210,230,35);
        tf1.setFont(f);
        c.add(tf1);



        f = new Font("Arial Black",Font.BOLD,13);
        pf = new JPasswordField();
        pf.setBounds(530,270,230,35);
        pf.setFont(f);
        pf.setEchoChar('*');
        c.add(pf);

    }

    public void paneldesign(){

        img = new ImageIcon(getClass().getResource("newfinal.png"));



        imglable = new JLabel(img);
        imglable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
      //  imglable.setBounds(1,2,384,480);
        c.add(imglable);

    }

    public void buttondesign() {
        img = new ImageIcon(getClass().getResource("button2.png"));
        btn1 = new JButton(img);
        btn1.setBounds(540,320,200,30);

        img = new ImageIcon(getClass().getResource("button3.png"));
        btn2 = new JButton(img);
        btn2.setBounds(540,360,200,30);


//        img = new ImageIcon(getClass().getResource("cancel.png"));
//        btn3 = new JButton(img);
//        btn3.setBounds(600,310,80,30);

        c.add(btn1);
        c.add(btn2);
      //  c.add(btn3);

        btn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = tf1.getText();
                String pass = pf.getText();
                   
                if(manegerradio.isSelected()) {
                   //TrainSystemGUI traingui = new TrainSystemGUI();
                   if(username.equals("admin") && pass.equals("1234")){
                       tf1.setText("");
                        pf.setText("");
                        Admin();
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Unauthorized Access is Prohibited!!");
                   }
                }
                else if(userradio.isSelected()) {
                    //UserFrame user = new UserFrame();
                    boolean flag=true;
                    for(int i=0;i<DataList.userList.size();i++){
                        if(DataList.userList.get(i).get_pass(username, pass)){
                            flag=false;
                            tf1.setText("");
                            pf.setText("");
                            new Home(i); 
                             dispose();
                            break;
                        }
                    }
                    if(flag){
                        JOptionPane.showMessageDialog(null,"~~~~Enter your user id and password correctly~~");
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Select User or Admin first");
                }

            }
        });

        btn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //User
                if(manegerradio.isSelected()) {
                     JOptionPane.showMessageDialog(null,"Users Only!");
                }
                else
                 {
                    new User().registration();
                    FileSystem obj= new FileSystem<>();
                obj.saveArrayListToFile(DataList.userList, "UserList.ser");
                }
                
            }
        });

//        btn3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tf1.setText(null);;
//                pf.setText(null);
//            }
//        });


    }




    public static void main(String[] args) {
          FileSystem<Train> obj= new FileSystem<>();
        DataList.trainList=obj.readArrayListFromFile( "TrainList.ser");
         FileSystem<User> obj2= new FileSystem<>();
        DataList.userList=obj2.readArrayListFromFile( "UserList.ser");
         new TrainSystemGUI();
          //DataList.userList.get(0).bookTicket(0);
        //new Home(1);
        //new BookTi
    }

}