/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.View;

import com.mycompany.eventmanager.Model.DateFormat;
import com.mycompany.eventmanager.Model.EditorJSON;
import com.mycompany.eventmanager.Model.EventManager;
import com.mycompany.eventmanager.Model.Render;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alex
 */
public class Buttons implements ActionListener {
    EditorJSON jsonEditor = new EditorJSON();
    JPanel buttons_panel_main = new JPanel();
    JButton btn_addUser = new JButton("Create User");
    JButton btn_saveUser = new JButton("Add");
    JButton btn_saveEvent = new JButton("Add Event");
    JButton btn_createUser = new JButton("Create User");
    JButton btn_loadEvents = new JButton("Load Events");
    JButton btn_newEvent = new JButton("New Event");
    JButton btn_next = new JButton("Add Item");
    JButton btn_saveItem = new JButton("Save");
    JButton btn_addAnother = new JButton("Add Another");
    JButton btn_removeEvent = new JButton("Remove");
    JButton btn_removeItem = new JButton("Remove Item");
    JButton btn_saveData = new JButton("Save Data");
    JButton btn_addAgenda = new JButton("Add Agenda");
    JButton btn_MainScreen = new JButton("Main Screen");

    MainScreen ms;
    CardLayout cl;
    JPanel panel;
    JFrame frame;
    NewEventPage nep;


    public Buttons(CardLayout cl, JFrame frame, JPanel panel, MainScreen ms) {
        this.cl = cl;
        this.ms = ms;
        this.panel = panel;
        this.frame = frame;


        buttons_panel_main.add(btn_newEvent, BorderLayout.WEST);
        buttons_panel_main.add(btn_createUser, BorderLayout.CENTER);
        buttons_panel_main.add(btn_loadEvents, BorderLayout.EAST);
        buttons_panel_main.add(btn_addAgenda, BorderLayout.NORTH);
        btn_addUser.addActionListener(this);
        btn_createUser.addActionListener(this);
        btn_saveUser.addActionListener(this);
        btn_saveEvent.addActionListener(this);
        btn_newEvent.addActionListener(this);
        btn_next.addActionListener(this);
        btn_addAnother.addActionListener(this);
        btn_saveItem.addActionListener(this);
        btn_removeEvent.addActionListener(this);
        btn_removeItem.addActionListener(this);
        btn_loadEvents.addActionListener(this);
        btn_saveData.addActionListener(this);
        btn_addAgenda.addActionListener(this);
        btn_MainScreen.addActionListener(this);
    }

    public JButton getBtn_addUser() {
        return btn_addUser;
    }

    public JPanel getButtonsPanel() {
        return this.buttons_panel_main;
    }

    public JButton getBtn_saveUser() {
        return btn_saveUser;
    }

    public JButton getBtn_loadEvents() {
        return btn_loadEvents;
    }

    public JButton getBtn_newEvent() {
        return btn_newEvent;
    }

    public JButton getBtnNext() {
        return this.btn_next;
    }

    public JButton getSaveItem() {
        return this.btn_saveItem;
    }

    public JButton getAddAnother() {
        return this.btn_addAnother;
    }

    public JButton getBtnSaveEvent() {
        return this.btn_saveEvent;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btn_saveEvent) {
            String pattern = "dd/MM/yyyy";
            Boolean dataFormat = DateFormat.isValidFormat(pattern, ms.nep.getEventDate());
            if (dataFormat) {
                EventManager.addEvent(ms.nep.getEventTitle(), ms.nep.getEventDate(), ms.nep.getEventLocation());
                ms.nep.txt_title.setText("");
                ms.nep.txt_location.setText("");
                ms.nep.txt_date.setText("");
                ms.nep.getNep_textArea().setText("");
                Render.r_events();
            } else {
                JOptionPane.showMessageDialog(ms.frame, "Please enter date in format \"DD/MM/YYYY\"");

            }
        } else if (source == btn_saveUser) {
            if (ms.aup.txt_fname.getText().isEmpty() || ms.aup.txt_surname.getText().isEmpty() || ms.aup.txt_pnumber.getText().isEmpty()) {
                System.out.println("Please fill empty text fields");
            } else {
                EventManager.addUser(ms.aup.txt_fname.getText(), ms.aup.txt_surname.getText(), ms.aup.txt_pnumber.getText());
                ms.nep.updateOptions();

                cl.show(panel, "1");
                frame.setTitle("Event Manager/New Event");
            }
        } else if (source == btn_createUser) {
            cl.show(panel, "2");
            frame.setTitle("Event Manager / New User");
        } else if (source == btn_loadEvents) {
                MainScreen.clearBoard();
                EditorJSON.loadData("events.json");
                Render.r_eventsMainPage();
                ms.nep.updateOptions();


        } else if (source == btn_newEvent) {
            cl.show(panel, "3");
            System.out.println(EventManager.getOrganisers().size());
            if (ms.nep.getNep_textArea().getText().equals("")){
                Render.r_events();
            }
            frame.setTitle("Event Manager / New Event");
        } else if (source == btn_next) {
            String pattern = "dd/MM/yyyy";
            Boolean dataFormat = DateFormat.isValidFormat(pattern, ms.nep.getEventDate());
            if (dataFormat) {
                EventManager.addEvent(ms.nep.getEventTitle(), ms.nep.getEventDate(), ms.nep.getEventLocation());
                EventManager.associateUserWithEvent(ms.nep.getOption(), EventManager.getEvents().get(EventManager.getEvents().size() - 1));
                System.out.println(ms.nep.getOption());
                ms.nep.txt_title.setText("");
                ms.nep.txt_location.setText("");
                ms.nep.txt_date.setText("");
                Render.r_events();
                cl.show(panel, "5");
                frame.setTitle("Event Manager / New Event");
            } else {
                JOptionPane.showMessageDialog(ms.frame, "Please enter date in format \"DD/MM/YYYY\"");
            }

        } else if (source == btn_saveItem) {
            EventManager.addItem(ms.aip.getStart(), ms.aip.getTitle());
            ms.aip.txt_start.setText("");
            ms.aip.txt_title.setText("");
            NewEventPage.getTextArea().setText(null);
            Render.r_events();
            cl.show(panel, "3");
            frame.setTitle("Event Manager");
        } else if (source == btn_addAnother) {
            EventManager.addItem(ms.aip.getStart(), ms.aip.getTitle());
            ms.aip.txt_start.setText("");
            ms.aip.txt_title.setText("");
            cl.show(panel, "5");
            frame.setTitle("Event Manager / New Event ");
        } else if (source == btn_addUser) {
            cl.show(panel, "2");
            frame.setTitle("Event Manager / New User");
        } else if (source == btn_removeEvent) {
            EventManager.deleteEvent(EventManager.findIndex(NewEventPage.text_to_delete));
            if (EventManager.findIndex(NewEventPage.text_to_delete) == -1) {
                JOptionPane.showMessageDialog(ms.frame, "The event has been deleted");
                ms.nep.getNep_textArea().setText(" ");
                Render.r_events();
            } else {
                JOptionPane.showMessageDialog(ms.frame, "Couldn't delete the event");
            }
        } else if (source == btn_removeItem) {
            EventManager.removeItem(NewEventPage.text_to_delete);

            ms.nep.getNep_textArea().setText(" ");
            Render.r_events();
        } else if (source == btn_saveData) {
            EditorJSON.saveData();
        } else if (source == btn_addAgenda){
            if (EventManager.getEvents().size()>0){
                EventItemAssingmentView ev = new EventItemAssingmentView(ms.frame);
                if (ev.getEventOption() != null){
                    cl.show(panel, "5");
                }
            }else {
                System.out.println("You dont Have any events");
            }



        } else if (source == btn_MainScreen){
            cl.show(panel, "1");
            MainScreen.clearBoard();
            Render.r_eventsMainPage();

        }
    }

    public JButton getBtn_saveData() {
        return this.btn_saveData;
    }

    public JButton getBtnRemoveEvent() {
        return this.btn_removeEvent;
    }

    public JButton getBtnRemoveItem() {
        return this.btn_removeItem;
    }
    public JButton getbtn_MainScreen(){
        return this.btn_MainScreen;
    }
    public void updateJPanel (){

    }
}