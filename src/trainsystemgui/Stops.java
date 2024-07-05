/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
class Stops implements Serializable {
    String stopsName, time;
    int rent;

    public Stops() {
        stopsName = "";
        time = "";
        rent = 0;
    }
    public void inputStops(int i) {
        JTextField stopsNameField = new JTextField(20);
        JTextField timeField = new JTextField(20);
        JTextField rentField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("                   Stops INPUT:"+i));
        inputPanel.add(new JLabel("                 "));
        inputPanel.add(new JLabel("Enter stops name:"));
        inputPanel.add(stopsNameField);
        inputPanel.add(new JLabel("Enter train leaving Time:"));
        inputPanel.add(timeField);
        inputPanel.add(new JLabel("Enter rent:"));
        inputPanel.add(rentField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input Stops", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            stopsName = stopsNameField.getText();
            time = timeField.getText();
            rent = Integer.parseInt(rentField.getText());
        }
    }

    public String toString() {
        return String.format("%-24s %-9d %-18s", stopsName, rent, time);
    }
}
