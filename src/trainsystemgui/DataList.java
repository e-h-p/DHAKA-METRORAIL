/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainsystemgui;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class DataList {
    public static ArrayList<Train> trainList=new ArrayList<>();
    public static ArrayList<User> userList=new ArrayList<>();
    public DataList() { }
    public static  ArrayList<User> GetUserList(){
        return userList;
    }
    public static  ArrayList<Train> GetTrainList(){
        return trainList;
    }
    
}
