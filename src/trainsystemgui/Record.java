/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Record implements Serializable {
    public String train_name, date, status, from, to;
    public int total_fare, num_of_ticket, ticket_ID, train_no;

    public Record() { }

    public void showRecord() {
        System.out.printf("%-25s %-9d %-10s %-10d %-15s %-18s %-10d %-15s%n",
                date, ticket_ID, train_name, num_of_ticket, from, to, total_fare, status);
    }
}
