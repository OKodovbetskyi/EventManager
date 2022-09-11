/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.View;

import com.mycompany.eventmanager.Model.Event;
import com.mycompany.eventmanager.Model.EventManager;
import com.mycompany.eventmanager.Model.Item;
import com.mycompany.eventmanager.Model.Organiser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alex
 */
public class MenubarFrontPage implements ActionListener {
    JMenuBar mb;
    JMenu edit, menu, help;
    JMenuItem m1, m2, m3, m4, m5, m6;
    JPanel panel;
    CardLayout cl;
    EditEventPage editEvent;
    static Event evt;
    JFrame frame;
    public MenubarFrontPage(JPanel panel, CardLayout cl, EditEventPage editEventpage,JFrame frame) {
        this.panel = panel;
        this.cl = cl;
        this.frame = frame;
        this.editEvent = editEventpage;
    }

    public JMenuBar getMenuBar() {

        mb = new JMenuBar();
        //Main Panel
        menu = new JMenu("Menu");
        help = new JMenu("Help");
        // create menuitems
        m1 = new JMenuItem("Quit");
        // add menu items to menu
        menu.add(m1);
        edit = new JMenu("Edit");
        m1 = new JMenuItem("EditEvents");
        m2 = new JMenuItem("EditUser");
        // add menu items to menu
        edit.add(m1);
        edit.add(m2);
        mb.add(menu);
        mb.add(edit);
        mb.add(help);
        m1.addActionListener(this);
        m2.addActionListener(this);
        return mb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m1) {
            if (EventManager.getEvents().size() > 0) {
                EventItemAssingmentView eventDialog = new EventItemAssingmentView(frame);
                evt = EventManager.getEventById(EventItemAssingmentView.getEventOption().split(" ")[EventItemAssingmentView.getEventOption().split(" ").length - 1]);
                editEvent.getTitle().setText(evt.getTitle());
                editEvent.getDate().setText(evt.getDate());
                editEvent.getLocation().setText(evt.getLocation());
                for (Item i : evt.getItems()) {
                    editEvent.getItemsCombo().addItem(i.getTitle());
                }
                for (Organiser org : EventManager.getOrganisers()) {
                    editEvent.getOrganiserOptions().addItem(org.getF_name());
                }
                if (evt.getPerson() != null) {
                    editEvent.getOrganiserOptions().setSelectedItem(evt.getPerson().getF_name());
                }
                cl.show(panel, "6");

            } else {
                System.out.println("You don't have any events");
            }
        } else if (e.getSource() == m2) {

        }

    }
    public static Event getEvt(){
        return evt;
    }
}
