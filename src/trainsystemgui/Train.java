/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
class Train implements Serializable {

    protected String name, start, destination, leftTime, date;
    protected int trainNo, seat, totalStops, ticket, rent;
    protected  ArrayList<Stops> stopsList = new ArrayList<>();
    protected  ArrayList<Integer> availableSeatList = new ArrayList<>();

    public Train() {
        name = "";
        start = "";
        destination = "";
        leftTime = "";
        date = "";
    }

    public void inputTrain() {
        JTextField trainID = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField startField = new JTextField(20);
        JTextField destinationField = new JTextField(20);
        JTextField seatField = new JTextField(10);
        JTextField stopsField = new JTextField(10);
        JTextField leftTimeField = new JTextField(20);
        JTextField ticketField = new JTextField(10);
        JTextField dateField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2));
        inputPanel.add(new JLabel("Enter Train ID:"));
        inputPanel.add(trainID);
        inputPanel.add(new JLabel("Enter train name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Enter start place:"));
        inputPanel.add(startField);
        inputPanel.add(new JLabel("Enter destination Place:"));
        inputPanel.add(destinationField);
        inputPanel.add(new JLabel("Enter Total number of Seats:"));
        inputPanel.add(seatField);
        inputPanel.add(new JLabel("Enter Total number of Stops:"));
        inputPanel.add(stopsField);
        inputPanel.add(new JLabel("Enter train leaving time:"));
        inputPanel.add(leftTimeField);
        inputPanel.add(new JLabel("Enter starting Ticket id:"));
        inputPanel.add(ticketField);
        inputPanel.add(new JLabel("Enter date(dd-mm-yy):"));
        inputPanel.add(dateField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input Train Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            name = nameField.getText();
            trainNo = Integer.parseInt(trainID.getText());
            start = startField.getText();
            destination = destinationField.getText();
            seat = Integer.parseInt(seatField.getText());
            totalStops = Integer.parseInt(stopsField.getText());
            leftTime = leftTimeField.getText();
            ticket = Integer.parseInt(ticketField.getText());
            date = dateField.getText();

            stopsList.clear();
            availableSeatList.clear();

            for (int i = 0; i < totalStops; i++) {
                Stops stops = new Stops();
                stops.inputStops(i+1);
                stopsList.add(stops);
                availableSeatList.add(seat);
            }

            rent = stopsList.get(totalStops-1).rent;
            DataList.trainList.add(this); 
            //System.out.println("press");
            JOptionPane.showMessageDialog(null, "Train Successfully Added");
        }
    }

    public void showTrainStopsDetails() {
              DefaultTableModel model = new DefaultTableModel();

    // Create the table model with the necessary columns
    model.addColumn("Stoppage No.");
    model.addColumn("Name");
    model.addColumn("Rent");
    model.addColumn("Departure time");
    model.addColumn("Available seat");
    int ip=1;
    for (Stops sp: stopsList) {
        model.addRow(new Object[] {
            ip++,sp.stopsName, sp.rent,sp.time,availableSeatList.get(ip-2)
        });
    }
       JTable table = new JTable(model);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
     table.setRowHeight(25);
     table.setFont(new Font("Serif", Font.PLAIN, 14));
    // Display the table in a scroll pane
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame scheduleFrame = new JFrame(name+"'s Stoppages Details");
    
    scheduleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    scheduleFrame.setBounds(150, 350, 500, 300);
    scheduleFrame.add(scrollPane);
    //scheduleFrame.pack();
    scheduleFrame.setVisible(true);
    }

    public static void viewTrainSchedule() {
        
        
        DefaultTableModel model = new DefaultTableModel();

    // Create the table model with the necessary columns
    model.addColumn("Train No.");
     model.addColumn("Train ID");
    model.addColumn("Train-Name");
    model.addColumn("Start-Place");
    model.addColumn("Destination-Place");
    model.addColumn("Ticket-cost");
    model.addColumn("total-Seat");
    model.addColumn("Time");
    model.addColumn("Total-Stoppages");
    // model.addColumn("Stops Details");
     int p=1;
     
    for (Train train : DataList.trainList) {
        model.addRow(new Object[] {
            p++,
            train.trainNo,
            train.name,
            train.start,
            train.destination,
            train.rent,
            train.seat,
            train.leftTime,
            train.totalStops,
            //train.btn = new JButton("Details")
        });
    }

    JTable table = new JTable(model);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
     //centerRenderer.setFont(new Font("Arial", Font.PLAIN, 25));
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
     table.setRowHeight(40);
     table.setFont(new Font("Serif", Font.PLAIN, 17));
    // Display the table in a scroll pane
    //JButton Button = new JButton("Go Back");
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame scheduleFrame = new JFrame("Train Schedule");
    scheduleFrame.setBounds(120, 90, 1200, 400);
    scheduleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   // scheduleFrame.setSize(1200, 500);
    scheduleFrame.add(scrollPane);
    
    //scheduleFrame.pack();
    scheduleFrame.setVisible(true); 
 String input = JOptionPane.showInputDialog(
                "Press Train No. to see the train's stoppage details:");
 while(input!=null){
            StringBuilder schedule = new StringBuilder();
            int tmp = Integer.parseInt(input);
            if (tmp>=1 && tmp <= DataList.trainList.size()) {
                Train train = DataList.trainList.get(tmp - 1);
                train.showTrainStopsDetails();
                input = JOptionPane.showInputDialog(
                "Press Train No. to see the train's stoppage details:");
                
            } else {
                schedule.append("\n\t\t\t*********Invalid train Number**********\n");
                 JOptionPane.showMessageDialog(null, schedule.toString());
                 input = JOptionPane.showInputDialog(
                "Press Train No. to see the train's stoppage details:");
            }
 }

    }
    public static void deleteTrain()
    {
        JTextField trainID = new JTextField(20);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));
        inputPanel.add(new JLabel("Enter Train ID:"));
        inputPanel.add(trainID);
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input Train Details", JOptionPane.OK_CANCEL_OPTION);
        if(result== JOptionPane.OK_OPTION){
        int tmp = Integer.parseInt(trainID.getText());
          boolean ok=false;
            for(Train tr: new ArrayList<>(DataList.trainList))
            {
                if(tr.trainNo==tmp){
                DataList.trainList.remove(tr);
                ok=true;
               }
            }
            if(ok){
                JOptionPane.showMessageDialog(null, "Train has been Successfully Deleted");
            }
            else{
                JOptionPane.showMessageDialog(null, "Train ID not found!!!");
            }
        }
    }
    
}
