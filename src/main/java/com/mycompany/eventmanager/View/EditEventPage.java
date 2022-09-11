package com.mycompany.eventmanager.View;

import com.mycompany.eventmanager.Model.*;
import com.mycompany.eventmanager.Model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;

public class EditEventPage implements ActionListener, ItemListener {
    JPanel eep = new JPanel();
    JPanel new_event = new JPanel();
    JPanel blayout = new JPanel();
    JLabel lbl_title = new JLabel("Event Name");
    JLabel lbl_date = new JLabel("Event Date");
    JLabel lbl_person = new JLabel("Select Organiser");
    JLabel lbl_item = new JLabel("Select Item to Edit");
    JTextField txt_title = new JTextField("hello1");
    JTextField txt_date = new JTextField(10);
    Organiser option;
    JLabel lbl_location = new JLabel("Location");
    JTextField txt_location = new JTextField(10);
    JButton btnSaveChanges = new JButton("Save Changes");
    JButton btnMainPage = new JButton("Main Page");
    JTextArea editItemsArea = new JTextArea(5,5);
    static String text_to_delete = "";
    JComboBox txt_person = new JComboBox();
    JComboBox combo_items = new JComboBox();
JPanel panel;
CardLayout cl;


    public EditEventPage(CardLayout cl, JPanel panel){
        this.cl=cl;
        this.panel=panel;

        eep.setLayout(new BorderLayout());
        txt_person.addItem("Organiser");
        GroupLayout layout = new GroupLayout(new_event);
        new_event.setLayout(layout);
        blayout.setLayout(new BorderLayout());
        blayout.add(btnMainPage, BorderLayout.SOUTH);
        blayout.add(btnSaveChanges, BorderLayout.NORTH);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lbl_title)
                        .addComponent(lbl_date)
                        .addComponent(lbl_location)
                        .addComponent(lbl_person)
                        .addComponent(lbl_item)


                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(txt_title)
                        .addComponent(txt_date)
                        .addComponent(txt_location)
                        .addComponent(txt_person)
                        .addComponent(combo_items)
                        .addComponent(editItemsArea)


                     )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(lbl_title)
                        .addComponent(txt_title))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(lbl_date)
                        .addComponent(txt_date))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(lbl_location)
                        .addComponent(txt_location))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(lbl_person)
                        .addComponent(txt_person))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(lbl_item)
                        .addComponent(combo_items))
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(editItemsArea)
                )


        );
        btnMainPage.addActionListener(this);
        btnSaveChanges.addActionListener(this);
        eep.add(new_event, BorderLayout.NORTH);
        eep.add(blayout,BorderLayout.SOUTH);
        combo_items.addItemListener(this);
        txt_person.addItemListener(this);

    }
    public JPanel getEditEventPage(){
        return this.eep;
    }
    public JPanel getEditEventPageButtons(){
        return this.blayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnMainPage){
            txt_person.removeAllItems();
            combo_items.removeAllItems();
            MainScreen.clearBoard();
            Render.r_eventsMainPage();
            cl.show(panel, "1");
        } else if (e.getSource() == btnSaveChanges){
           Event evt = MenubarFrontPage.getEvt();
           evt.setTitle(txt_title.getText());
           evt.setDate(txt_date.getText());
           evt.setLocation(txt_location.getText());
           evt.setAssociation(option);
        }
    }
    public JTextField getTitle(){
        return this.txt_title;
    }
    public JTextField getDate(){
        return this.txt_date;
    }
    public JTextField getLocation(){
        return this.txt_location;
    }
    public JComboBox getItemsCombo(){
        return this.combo_items;
    }
    public JComboBox getOrganiserOptions(){
        return this.txt_person;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()== combo_items){
            if (e.getStateChange() == ItemEvent.SELECTED){
                editItemsArea.setText(null);
                String itemTitle = findItem(e.getItem().toString()).getTitle();
                int itemTime = findItem(e.getItem().toString()).getStart_time();
                editItemsArea.append("Item title: " +itemTitle+ System.lineSeparator() + "Time: " + itemTime);
                System.out.println(MenubarFrontPage.getEvt().getItems());
            }

        } else if (e.getSource() == txt_person){
            if (e.getStateChange() == ItemEvent.SELECTED) {
                option = findOrganiser(txt_person.getSelectedItem().toString());

            }
        }
    }
    public Item findItem(String itemTitle){
        for (Item i: MenubarFrontPage.getEvt().getItems()){
    if (i.getTitle().trim().toLowerCase().equals(itemTitle.trim().toLowerCase())){
        return i;
    }
        }
        return null;
    }
    public Organiser findOrganiser(String org){
        for (Organiser i: EventManager.getOrganisers()){
            if (i.getF_name().trim().toLowerCase().equals(org.trim().toLowerCase())){
                return i;
            }
        }
        return null;
    }
}
