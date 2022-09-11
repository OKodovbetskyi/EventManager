package com.mycompany.eventmanager.View;

import com.mycompany.eventmanager.Model.EventManager;
import com.mycompany.eventmanager.Model.Event;

import javax.swing.*;

public class EventItemAssingmentView {
    Object[] possibilities;
    static String eventOption = null;
    public EventItemAssingmentView(JFrame frame) {
        ImageIcon icon = null;
        try{
            icon = new ImageIcon(getClass().getClassLoader().getResource( "imgs/icon.png"));
        }catch (Exception e){
            System.out.println(e);
        }

        possibilities = new String[EventManager.getEvents().size()];
        getPossibilities();
        String s = (String) JOptionPane.showInputDialog(
                frame,
                "Please choose event you want to add items:\n",

                "Choose Event",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                possibilities,
                "ham");
        eventOption = s;

//If a string was returned, say so.
    }
    public void getPossibilities(){
        int iterator = 0;
        for (Event e: EventManager.getEvents()){
            possibilities[iterator] = e.getTitle() +" with ID: " + e.getId() + System.lineSeparator();
            iterator++;
        }
    }
    public static String getEventOption(){
        return eventOption;
    }
}
