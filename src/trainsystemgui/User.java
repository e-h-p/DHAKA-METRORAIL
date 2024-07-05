/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

/**
 *
 * @author Asus
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

class User  implements Serializable  {
    protected String user_name, first_name, last_name, email, password, nid_no, address, gender, contact_no;
    protected ArrayList<Record> records=new ArrayList<>();
    private  int tra_no=-1,num_of_ticket=-1,st=0,ed=0;
    private  String tra_name="",stop1="",stop2="";

    public User() {  }

    public void viewPreviousRecords() {
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Booking History");
            return;
        }

        JFrame frame = new JFrame("Booking History");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
       
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Timestamp");
        columnNames.add("Tiket-ID");
        columnNames.add("Tran-Name");
        columnNames.add("Total-Tkt");
        columnNames.add("Boarding-Point");
        columnNames.add("Destination-Point");
        columnNames.add("Total-Fare");
        columnNames.add("Status");

        Vector<Vector<String>> data = new Vector<>();
        for (Record record : records) {
            Vector<String> row = new Vector<>();
            row.add(record.date);
            row.add(Integer.toString(record.ticket_ID));
            row.add(record.train_name);
            row.add(Integer.toString(record.num_of_ticket));
            row.add(record.from);
            row.add(record.to);
            row.add(Integer.toString(record.total_fare));
            row.add(record.status);
            data.add(row);
        }

        JTable table = new JTable(data, columnNames);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
     centerRenderer.setFont(new Font("Arial", Font.PLAIN, 25));
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(40);
        table.setFont(new Font("Serif", Font.CENTER_BASELINE, 17));
        TableColumn column = table.getColumnModel().getColumn(0); // Replace columnIndex with the desired column index
         column.setPreferredWidth(160);
         column = table.getColumnModel().getColumn(2); // Replace columnIndex with the desired column index
         column.setPreferredWidth(150);
         column = table.getColumnModel().getColumn(4); // Replace columnIndex with the desired column index
         column.setPreferredWidth(120);
         column = table.getColumnModel().getColumn(5); // Replace columnIndex with the desired column index
         column.setPreferredWidth(120);
         column = table.getColumnModel().getColumn(7); // Replace columnIndex with the desired column index
         column.setPreferredWidth(80);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setBounds(150, 200, 900, 500);
        frame.setBackground(new Color(240,240,240));
        frame.setVisible(true);
    }

    public void viewProfile() {
        JFrame frame = new JFrame(user_name+"'s Profile");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250); // Adjusted height to accommodate additional components.
         frame.setBounds(500,250,400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // Using GridLayout for a cleaner layout.

        JLabel nameLabel = new JLabel("    Name:");
        JLabel nameLabelValue = new JLabel(first_name + " " + last_name);
        JLabel emailLabel = new JLabel("    Email:");
        JLabel emailLabelValue = new JLabel(email);
        JLabel nidLabel = new JLabel("    NID:");
        JLabel nidLabelValue = new JLabel(nid_no);
        JLabel addressLabel = new JLabel("     Address:");
        JLabel addressLabelValue = new JLabel(address);
        JLabel genderLabel = new JLabel("    Gender:");
        JLabel genderLabelValue = new JLabel(gender);
        JLabel contactLabel = new JLabel("    Contact:");
        JLabel contactLabelValue = new JLabel(contact_no);

        panel.add(nameLabel);
        panel.add(nameLabelValue);
        panel.add(emailLabel);
        panel.add(emailLabelValue);
        panel.add(nidLabel);
        panel.add(nidLabelValue);
        panel.add(addressLabel);
        panel.add(addressLabelValue);
        panel.add(genderLabel);
        panel.add(genderLabelValue);
        panel.add(contactLabel);
        panel.add(contactLabelValue);
        
        frame.add(panel);
         
        frame.setVisible(true);
    }
    
    public  void  registration() {
         JTextField userNameField = new JTextField(20);
        JTextField fNameField = new JTextField(20);
        JTextField lNameField = new JTextField(20);
        JTextField genderField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField nidField = new JTextField(20);
        JTextField AddressField = new JTextField(20);
        JTextField contactField = new JTextField(20);
        JTextField passwordField = new JPasswordField(20);
        JTextField confirmPasswordField = new JPasswordField(20);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2));
        inputPanel.add(new JLabel("User Name: "));
        inputPanel.add(userNameField);
        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(fNameField);
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lNameField);
        inputPanel.add(new JLabel("Gender:"));
        inputPanel.add(genderField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("NID No:"));
        inputPanel.add(nidField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(AddressField);
        inputPanel.add(new JLabel("Contact no:"));
        inputPanel.add(contactField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("Confirm Password:"));
        inputPanel.add(confirmPasswordField);
       
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "User Registration", JOptionPane.OK_CANCEL_OPTION);
        while(result == JOptionPane.OK_OPTION){
         boolean flag=false,flag2=false;
        String tmp=userNameField.getText();
        for(User us: DataList.userList){
            if(us.user_name.equals(tmp)){
                flag=true;
            }
        }
        String pass = passwordField.getText();
        String confirmPass = confirmPasswordField.getText();
        if(!pass.equals(confirmPass)){
            flag2=true;
        }
        if(flag){
            JOptionPane.showMessageDialog(null, "User Name Already Exists!!!!");
            result = JOptionPane.showConfirmDialog(null, inputPanel, "User Registration", JOptionPane.OK_CANCEL_OPTION);
            continue;
        }
        else if(flag2){
            JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match!!!!");
             result = JOptionPane.showConfirmDialog(null, inputPanel, "User Registration", JOptionPane.OK_CANCEL_OPTION);
            continue;
        }
        else if(result==JOptionPane.OK_OPTION){
            user_name=tmp;
            first_name=fNameField.getText();
            last_name=lNameField.getText();
            gender=genderField.getText();
            email=emailField.getText();
            nid_no=nidField.getText();
            password=pass;
            address=AddressField.getText();
            contact_no=contactField.getText();
            JOptionPane.showMessageDialog(null, "~~~~You are now registered~~~~");
            DataList.userList.add(this);
            break;
        }
        else break;
        }
        
    }
    

    public  void bookTicket(int p) {
        
    // Create a dialog for booking a ticket
    JFrame frame=new JFrame();
    Container container = frame.getContentPane();
    container.setLayout(null);
    container.setBackground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setBounds(100,50,800,480);
    frame.setTitle("Ticket Booking");
    Font f = new Font("times new roman",Font.BOLD,17);
         ImageIcon img = new ImageIcon(getClass().getResource("bookTicket4.png"));
        JLabel imglable = new JLabel(img);
        imglable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
      //  imglable.setBounds(1,2,384,480);
        container.add(imglable);
       
        JLabel titlelable = new JLabel("Ticket Booking");
        titlelable.setOpaque(true);
        titlelable.setBounds(500,50,360,70);
        titlelable.setBackground(Color.white);
        titlelable.setFont(new Font("times new roman",BOLD,22));
        container.add(titlelable);
         
        
     
         JLabel lable1 = new JLabel();
        lable1.setText("Select Train ");
        lable1.setBounds(407,110,120,50);
        lable1.setFont(f);
      //  lable1.setOpaque(true);
        lable1.setForeground(Color.BLACK);
        lable1.setBackground(Color.yellow);
        container.add(lable1);
        JLabel lable2 = new JLabel();
        lable2.setText("Origin               ");
        lable2.setBounds(407,230,120,50);
        lable2.setFont(f);
      //  lable1.setOpaque(true);
        lable2.setForeground(Color.BLACK);
        lable2.setBackground(Color.yellow);
        container.add(lable2);
        JLabel lable3 = new JLabel();
        lable3.setText("Destination ");
        lable3.setBounds(407,290,120,50);
        lable3.setFont(f);
      //  lable1.setOpaque(true);
        lable3.setForeground(Color.BLACK);
        lable3.setBackground(Color.yellow);
        container.add(lable3);
         JLabel lable4 = new JLabel();
        lable4.setText("Num of Ticket ");
        lable4.setBounds(407,170,120,50);
        lable4.setFont(f);
      //  lable1.setOpaque(true);
        lable4.setForeground(Color.BLACK);
        lable4.setBackground(Color.yellow);
        container.add(lable4);
         JLabel lable5 = new JLabel();
        lable5.setText("Total Fare");
        lable5.setBounds(407,350,120,50);
        lable5.setFont(f);
      //  lable1.setOpaque(true);
        lable5.setForeground(Color.BLACK);
        lable5.setBackground(Color.yellow);
        container.add(lable5);
        JLabel lable6 = new JLabel();
        lable6.setText("*");
        lable6.setBounds(530,350,120,50);
        lable6.setFont(f);
        lable6.setForeground(Color.BLACK);
        lable6.setBackground(Color.yellow);
        container.add(lable6);
         lable6.setText("***");
        JComboBox cs = new JComboBox();
        JComboBox<String> cs2 = new JComboBox<String>();
        JComboBox<String> cs3 = new JComboBox<String>();
        JComboBox<String> cs4 = new JComboBox<String>();
        for(int i=0;i<DataList.trainList.size();i++){
                 cs.addItem(DataList.trainList.get(i).name);
             }
        for(int i=1;i<=5;i++){
            cs4.addItem(i+"");
        }
        cs.setBounds(530, 120, 230, 35);
//        tf1.add(cs);
        container.add(cs);
        cs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tra_name = cs.getSelectedItem().toString();
                //.setText(selected);
                //System.out.println(selected);
               // System.out.println("emon1");
                for(int i=0;i<DataList.trainList.size();i++){
                    if(DataList.trainList.get(i).name.equals(tra_name)){
                        tra_no=i;
                        break;
                    }
                }
                 
                 cs2.removeAllItems();
                // System.out.println(DataList.trainList.get(tra_no).stopsList.get(2).stopsName);
                 for(int i=0;i<DataList.trainList.get(tra_no).stopsList.size()-1;i++){
                    // System.out.println("emon2"+i);
                     cs2.addItem(DataList.trainList.get(tra_no).stopsList.get(i).stopsName);
                 }
                 cs.setBackground(Color.green);
            }
        });
       cs2.setBounds(530,240 , 230, 35);
       container.add(cs2);
                 cs2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cs2.getSelectedItem()!=null){
                stop1 = cs2.getSelectedItem().toString(); 
                //System.out.println("emon");
                boolean flag=false;
                cs3.removeAllItems();
                for(int i=0;i<DataList.trainList.get(tra_no).stopsList.size();i++){
                    //System.out.println("emon"+i);
                    if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop1)){
                        flag=true;
                        continue;
                    }
                    if(flag){
                        cs3.addItem(DataList.trainList.get(tra_no).stopsList.get(i).stopsName);
                    }
                 }
                 cs2.setBackground(Color.green);
              } 
            }
                
        }); 
         
       cs3.setBounds(530,300 , 230, 35);
       container.add(cs3);
       cs4.setBounds(530,180 , 230, 35);
       container.add(cs4);
       cs3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(cs3.getSelectedItem()!=null){
              int num_of_ticket= Integer.parseInt(cs4.getSelectedItem().toString());
                    
                //.setText(selected);
                //System.out.println(selected);
                stop2 = cs3.getSelectedItem().toString();
                 
                
                    for(int i=0;i<DataList.trainList.get(tra_no).stopsList.size();i++){
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop1)){
                            st=i+1;
                        }
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop2)){
                            ed=i+1;
                        }
                    }
                    if(num_of_ticket!=-1 && st!=0 && ed!=0){
                        int pay=DataList.trainList.get(tra_no).stopsList.get(ed-1).rent-DataList.trainList.get(tra_no).stopsList.get(st-1).rent;
                     lable6.setText(""+num_of_ticket*pay);
                    } 
                    cs3.setBackground(Color.green);
               }              
         }
        });   
                cs4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cs2.getSelectedItem()!=null && cs3.getSelectedItem()!=null ){
                    tra_no=cs.getSelectedIndex();
                    //System.out.println(""+tra_no);
                    stop2 = cs3.getSelectedItem().toString();
                    stop1=cs2.getSelectedItem().toString();
                    num_of_ticket=cs4.getSelectedIndex()+1;
                    for(int i=0;i<DataList.trainList.get(tra_no).stopsList.size();i++){
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop1)){
                            st=i+1;
                        }
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop2)){
                            ed=i+1;
                        }
                    }
                    if(num_of_ticket!=-1 && st!=0 && ed!=0){
                        int pay=DataList.trainList.get(tra_no).stopsList.get(ed-1).rent-DataList.trainList.get(tra_no).stopsList.get(st-1).rent;
                     lable6.setText(""+num_of_ticket*pay);
                    } 
                        int pay=DataList.trainList.get(tra_no).stopsList.get(ed-1).rent-DataList.trainList.get(tra_no).stopsList.get(st-1).rent;
                     lable6.setText(""+num_of_ticket*pay);
                    }
                cs4.setBackground(Color.green);
          }
        }); 
         //String selected = cs3.getSelectedItem().toString();
         //System.out.println(selected);
         
         JButton submitButton = new JButton("Submit");
          
         submitButton.setBounds(600,400,150,30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print the selected train and stoppage to the console when the button is pressed
                
                if(cs2.getSelectedItem()==null || cs3.getSelectedItem()==null){
                    System.out.println("emon");
                     JOptionPane.showMessageDialog(null, "~~~~Select the Requirements~~~~");  
                }
                else{
                    tra_no=cs.getSelectedIndex();
                    //System.out.println(""+tra_no);
                    stop2 = cs3.getSelectedItem().toString();
                    stop1=cs2.getSelectedItem().toString();
                    num_of_ticket=cs4.getSelectedIndex()+1;
                    for(int i=0;i<DataList.trainList.get(tra_no).stopsList.size();i++){
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop1)){
                            st=i+1;
                        }
                        if(DataList.trainList.get(tra_no).stopsList.get(i).stopsName.equals(stop2)){
                            ed=i+1;
                        }
                    }
                    boolean flag2=true;
            for(int i=st-1;i<ed-1;i++){
                if(DataList.trainList.get(tra_no).availableSeatList.get(i)<num_of_ticket){
                    flag2=false;
                    break;
                }
            }
            
            if(!flag2){
                 JOptionPane.showMessageDialog(null, "~~~~Ticket is unavailable as user limit is exited~~~~");  
            }
            else{
                frame.dispose();            
                JFrame frame2 = new JFrame("Book Ticket");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setBounds(500,250,400, 300);
        frame2.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));
        // Add input fields for train number, number of tickets, boarding point, and destination point
        
       
        JLabel methodLabel = new JLabel("Payment Method:");
        JTextField methodField = new JTextField();
        JLabel mobileNumLabel = new JLabel("Mobile Number:");
        JTextField mobileNumField = new JTextField();
        JLabel passlable = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel emptyLabel = new JLabel("");
        JLabel emptyLabel2 = new JLabel("");
        //JLabel destinationPointLabel = new JLabel("");
        //JTextField destinationPointField = new JTextField();

        // Add buttons for confirming or canceling the ticket
        JButton confirmButton2 = new JButton("Confirm");
        JButton cancelButton2 = new JButton("Cancel");

        String[] option = {"Bkash","Nagad","Rocket","Card"};

        JComboBox cb = new JComboBox(option);
        // Add components to the panel
        panel2.add(methodLabel);
       // panel.add(methodField);
        panel2.add(cb);
        panel2.add(mobileNumLabel);
        panel2.add(mobileNumField);
        panel2.add(passlable);
        panel2.add(passwordField);
        panel2.add(emptyLabel);
        panel2.add(emptyLabel2);
        //panel.add(destinationPointField);
        panel2.add(confirmButton2);
        panel2.add(cancelButton2);

        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setVisible(true);
        confirmButton2.addActionListener(e2 -> { 
            int tk = DataList.trainList.get(tra_no).ticket++;
              JOptionPane.showMessageDialog(null, "~~~~~Ticket successfully Booked~~~~~\n your ticket ID: "+tk);
              frame2.dispose();
              Record R=new Record();
              R.train_name=DataList.trainList.get(tra_no).name;
              R.from=DataList.trainList.get(tra_no).stopsList.get(st-1).stopsName;
              R.to=DataList.trainList.get(tra_no).stopsList.get(ed-1).stopsName;
              R.num_of_ticket=num_of_ticket;
              int pay=DataList.trainList.get(tra_no).stopsList.get(ed-1).rent-DataList.trainList.get(tra_no).stopsList.get(st-1).rent;                   
              R.total_fare=pay*num_of_ticket;
              R.status="Paid";
              R.train_no=DataList.trainList.get(tra_no).trainNo;
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Date currentDate = new Date();
              String formattedDate = dateFormat.format(currentDate);
              R.date=formattedDate;
              R.ticket_ID=tk;
              DataList.userList.get(p).records.add(R);
              for(int i=st-1;i<ed-1;i++){
                  int k=DataList.trainList.get(tra_no).availableSeatList.get(i);
                  DataList.trainList.get(tra_no).availableSeatList.set(i,k-num_of_ticket);
              }
              new FileSystem<User>().saveArrayListToFile(DataList.userList, "UserList.ser");
               new FileSystem<Train>().saveArrayListToFile(DataList.trainList, "TrainList.ser");
               
           });
        cancelButton2.addActionListener(e2 -> {
        frame2.dispose(); 
    });
        }
        }
            }
        });
       
        container.add(submitButton);
        //System.out.println(selected);
         
         JButton backButton = new JButton("Back");
         backButton.setBounds(420,400,150,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                //new Home(p);
            }
         });
        container.add(backButton);
       frame.setVisible(true);
 /*
    JFrame frame = new JFrame("Book Ticket");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //frame.setSize(600, 500);
    frame.setBounds(100,50,800,480);
    frame.setLayout(new BorderLayout());
     Font f = new Font("times new roman",Font.BOLD,17);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 2));
     String[] optionTrain = new String[DataList.trainList.size()];
     for(int i=0;i<DataList.trainList.size();i++){
         optionTrain[i]=DataList.trainList.get(i).name;
     }
        JComboBox cs = new JComboBox(optionTrain);
    // Add input fields for train number, number of tickets, boarding point, and destination point
    JLabel trainNoLabel = new JLabel("Train ID:");
    JTextField trainNoField = new JTextField();
    JLabel numTicketsLabel = new JLabel("Number of Tickets:");
    JTextField numTicketsField = new JTextField();
    JLabel boardingPointLabel = new JLabel("Boarding Point No:");
    JTextField boardingPointField = new JTextField();
    JLabel destinationPointLabel = new JLabel("Destination Point No:");
    JTextField destinationPointField = new JTextField();

    // Add buttons for confirming or canceling the ticket
    JButton confirmButton = new JButton("Next");
    JButton cancelButton = new JButton("Cancel");

    // Add components to the panel
    
    panel.add(trainNoLabel);
    panel.add(cs);
    //panel.add(trainNoField);
    panel.add(numTicketsLabel);
    panel.add(numTicketsField);
    panel.add(boardingPointLabel);
    panel.add(boardingPointField);
    panel.add(destinationPointLabel);
    panel.add(destinationPointField);
    panel.add(confirmButton);
    panel.add(cancelButton);

    frame.add(panel, BorderLayout.CENTER);
    frame.setBounds(500,250,400, 300);
    frame.setVisible(true);
    // Action listener for the confirm button
    confirmButton.addActionListener(e -> {
        //System.out.println("emon");
        int ID = Integer.parseInt(trainNoField.getText());
        int n = Integer.parseInt(numTicketsField.getText());
        int st = Integer.parseInt(boardingPointField.getText());
        int ed = Integer.parseInt(destinationPointField.getText());
        boolean flag=false;
        int no=0;
        for(Train tr: DataList.trainList){
            if(tr.trainNo==ID){
                flag=true;
                break;
            }
            no++;
        }
        //num=no;
        if(!flag){
                   JOptionPane.showMessageDialog(null, "~~~~Train ID is not Available~~~~");
        }
        else if(st>=ed || ed>DataList.trainList.get(no).totalStops || ed<=0){
                    JOptionPane.showMessageDialog(null, "~~~~Invalid Boarding and Destination Point No.~~~~");     
        }
        else{
            boolean flag2=true;
            for(int i=st-1;i<ed-1;i++){
                if(DataList.trainList.get(no).availableSeatList.get(i)<n){
                    flag2=false;
                    break;
                }
            }
            if(!flag2){
                 JOptionPane.showMessageDialog(null, "~~~~Ticket is unavailable as user limit is exited~~~~");  
            }
            else{
                 frame.dispose();
               int pay=DataList.trainList.get(no).stopsList.get(ed-1).rent-DataList.trainList.get(no).stopsList.get(st-1).rent;
               int num=no;
               JFrame frame2 = new JFrame("Book Ticket");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setBounds(500,250,400, 300);
        frame2.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));
        // Add input fields for train number, number of tickets, boarding point, and destination point
        
        JLabel Label1 = new JLabel("Your Must Pay: ");
        JLabel Label2 = new JLabel(""+n*pay);
        //JTextField methodLabel = new JTextField();
        JLabel methodLabel = new JLabel("Payment Method:");
        JTextField methodField = new JTextField();
        JLabel mobileNumLabel = new JLabel("Mobile Number:");
        JTextField mobileNumField = new JTextField();
        JLabel passlable = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel emptyLabel = new JLabel("");
        JLabel emptyLabel2 = new JLabel("");
        //JLabel destinationPointLabel = new JLabel("");
        //JTextField destinationPointField = new JTextField();

        // Add buttons for confirming or canceling the ticket
        JButton confirmButton2 = new JButton("Confirm");
        JButton cancelButton2 = new JButton("Cancel");

        String[] option = {"Bkash","Nagad","Rocket","Card"};

        JComboBox cb = new JComboBox(option);


        // Add components to the panel
        panel2.add(Label1);
        panel2.add(Label2);

        panel2.add(methodLabel);
       // panel.add(methodField);
        panel2.add(cb);
        panel2.add(mobileNumLabel);
        panel2.add(mobileNumField);
        panel2.add(passlable);
        panel2.add(passwordField);
        panel2.add(emptyLabel);
        panel2.add(emptyLabel2);
        //panel.add(destinationPointField);
        panel2.add(confirmButton2);
        panel2.add(cancelButton2);

        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setVisible(true);
        confirmButton2.addActionListener(e2 -> { 
            int tk = DataList.trainList.get(num).ticket++;
              JOptionPane.showMessageDialog(null, "~~~~~Ticket successfully Booked~~~~~\n your ticket ID: "+tk);
              frame2.dispose();
              Record R=new Record();
              R.train_name=DataList.trainList.get(num).name;
              R.from=DataList.trainList.get(num).stopsList.get(st-1).stopsName;
              R.to=DataList.trainList.get(num).stopsList.get(ed-1).stopsName;
              R.num_of_ticket=n;
              R.total_fare=pay*n;
              R.status="Paid";
              R.train_no=DataList.trainList.get(num).trainNo;
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Date currentDate = new Date();
              String formattedDate = dateFormat.format(currentDate);
              R.date=formattedDate;
              R.ticket_ID=tk;
              this.records.add(R);
              for(int i=st-1;i<ed-1;i++){
                  int k=DataList.trainList.get(num).availableSeatList.get(i);
                  DataList.trainList.get(num).availableSeatList.set(i,k-n);
              }
              new FileSystem<User>().saveArrayListToFile(DataList.userList, "UserList.ser");
                  new FileSystem<Train>().saveArrayListToFile(DataList.trainList, "TrainList.ser");
              
              
        });
        cancelButton2.addActionListener(e2 -> {
        frame2.dispose(); // Close the booking dialog
    });
        
                // Close the booking dialog
            }
        }
        // Add your booking logic here  
    });

    // Action listener for the cancel button
    cancelButton.addActionListener(e -> {
        frame.dispose(); // Close the booking dialog
    });

*/
    }

    public void cancellTicket(int p) {
        JFrame frame = new JFrame("Cancelling Ticket");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new BorderLayout());
    frame.setBounds(500,250,400, 300);
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 2));

    // Add input fields for train number, number of tickets, boarding point, and destination point
    JLabel ticketIDLabel = new JLabel("Your Ticket ID:",SwingConstants.CENTER);
    Font labelFont = ticketIDLabel.getFont();
    ticketIDLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 20)); // Use 20 as the font size
        
    JTextField ticketIDField = new JTextField();
    JButton confirmButton = new JButton("Confirm");
    JButton cancelButton = new JButton("Cancel");
    panel.add(ticketIDLabel);
    panel.add(ticketIDField);
    panel.add(confirmButton);
    panel.add(cancelButton);
    frame.add(panel, BorderLayout.CENTER);
    frame.setVisible(true);
    confirmButton.addActionListener(e -> { 
        boolean flag=true,flag2=true;
        int tmp = Integer.parseInt(ticketIDField.getText());
        for(int i=0;i<DataList.userList.get(p).records.size();i++){
            if(DataList.userList.get(p).records.get(i).ticket_ID==tmp){
                flag=false;
                if(DataList.userList.get(p).records.get(i).status.equals("Cancelled")){
                    JOptionPane.showMessageDialog(null, "~~~~Ticket already Cancelled~~~~");
                    break;
                }
                
                String s1=DataList.userList.get(p).records.get(i).from;
                 String s2=DataList.userList.get(p).records.get(i).to;
                 int st=0,en=0;
   
             for(int k=0;k<DataList.trainList.size();k++){
                if(DataList.trainList.get(k).trainNo==DataList.userList.get(p).records.get(i).train_no){
                    flag2=false;
                    DataList.userList.get(p).records.get(i).status="Cancelled";
                    for(int j=0;j<DataList.trainList.get(k).stopsList.size();j++){
                        if(DataList.trainList.get(k).stopsList.get(j).stopsName.equals(s1)) {
                            st=j+1;
                        }
                        if(DataList.trainList.get(k).stopsList.get(j).stopsName.equals(s2)) {
                            en=j+1;
                        }
                    }
                    for(int j=st-1;j<en-1;j++){
                        int number=DataList.userList.get(p).records.get(i).num_of_ticket+DataList.trainList.get(k).availableSeatList.get(j);
                        DataList.trainList.get(k).availableSeatList.set(j,number);
                                
                    }
                    // pop up
                    JOptionPane.showMessageDialog(null, "-----Ticket Successfully Cancelled------");
                    new FileSystem<User>().saveArrayListToFile(DataList.userList, "UserList.ser");
                  new FileSystem<Train>().saveArrayListToFile(DataList.trainList, "TrainList.ser");
                    break;
                }
            }
             if(flag2)
                 JOptionPane.showMessageDialog(null, "--------Sorry, Time up!!! Cancellation is not Available-------");
                    /// time up;
        }
        }
        if(flag) JOptionPane.showMessageDialog(null, "~~~~~Ticket ID not found~~~~~");
                   
     });

    // Action listener for the cancel button
    cancelButton.addActionListener(e -> {
        frame.dispose(); // Close the booking dialog
    });
    }


    public  boolean get_pass(String s1, String s2) {
        if (user_name.equals(s1) && password.equals(s2)) {
            return true;
        }
        return false;
    }
}

