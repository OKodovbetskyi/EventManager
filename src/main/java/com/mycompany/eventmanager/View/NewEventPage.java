/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.View;
import com.mycompany.eventmanager.Model.EventManager;
import com.mycompany.eventmanager.Model.Organiser;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static javax.swing.GroupLayout.Alignment.BASELINE;

/**
 *
 * @author alex
 */
public class NewEventPage implements CaretListener,ActionListener{
    JPanel new_event = new JPanel();
     JPanel form_layout = new JPanel();
     JPanel buttons_container = new JPanel();
     JPanel buttons_bottom = new JPanel();
    JPanel buttons_bottom_l = new JPanel();
     JPanel blayout = new JPanel();
     JLabel lbl_title = new JLabel("Event Name");
     JLabel lbl_date = new JLabel("Event Date");
     JLabel lbl_person = new JLabel("Select Organiser");
     JTextField txt_title = new JTextField(10);
     JTextField txt_date = new JTextField(10);
     String option;
        JLabel lbl_location = new JLabel("Location");
     JTextField txt_location = new JTextField(10);
  static JTextArea nep_textArea = new JTextArea(20,15);
  static String text_to_delete = "";

  JComboBox txt_person = new JComboBox();
    JScrollPane scroll;
     public NewEventPage(JButton button, JButton addUser, JButton saveEvent, JButton remove, JButton remove_item, JButton savedata,JButton btn_MainScreen){
         scroll = new JScrollPane(nep_textArea);
         new_event.setLayout(new BorderLayout());
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         txt_person.addItem("Please Select Organiser");
         GroupLayout layout = new GroupLayout(form_layout);
         GroupLayout btnslayout = new GroupLayout(blayout);
         form_layout.setLayout(layout);
        buttons_bottom_l.add(remove_item, BorderLayout.WEST);
        buttons_bottom_l.add(savedata, BorderLayout.SOUTH);
         buttons_bottom_l.add(btn_MainScreen, BorderLayout.SOUTH);
         buttons_bottom.add(button, BorderLayout.WEST);
         buttons_bottom.add(addUser, BorderLayout.NORTH);
         buttons_bottom.add(saveEvent, BorderLayout.EAST);
         buttons_bottom.add(remove, BorderLayout.SOUTH);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
 layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup()
                .addComponent(lbl_title)
                .addComponent(lbl_date)
                .addComponent(lbl_location)
                .addComponent(lbl_person)

                )
        .addGroup(layout.createParallelGroup()
                .addComponent(txt_title)
                .addComponent(txt_date)
                .addComponent(txt_location) 
                .addComponent(txt_person)

         .addGroup(layout.createParallelGroup().addComponent(scroll)))
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
                .addComponent(scroll))
);new_event.add(buttons_bottom_l, BorderLayout.WEST);
   buttons_container.add(buttons_bottom,BorderLayout.SOUTH);
   new_event.add(buttons_container, BorderLayout.SOUTH);
   new_event.add(form_layout, BorderLayout.NORTH);
   
       // btnslayout.linkSize(SwingConstants.HORIZONTAL, button, addUser);
         nep_textArea.addCaretListener(this);
        
      txt_person.addItemListener(this::comboBoxitemStateChanged);
  
}
      public void comboBoxitemStateChanged(ItemEvent e) {
      ArrayList<Organiser> org = EventManager.getOrganisers();
      if (e.getStateChange() == ItemEvent.SELECTED) {
        String selectedItem = (String) e.getItem();
        option = selectedItem;
      }}

    @Override
    public void caretUpdate(CaretEvent e) { 
        if(e.getSource() == nep_textArea){
              if (nep_textArea.getSelectionEnd() - nep_textArea.getSelectionStart() >= 1){
                 text_to_delete=  nep_textArea.getSelectedText();
              } 
            }
           
        
        }
    public void updateOptions(){
       ArrayList<Organiser> org = EventManager.getOrganisers();
       ArrayList<String> options = new ArrayList<>();
       ArrayList<String> temp = new ArrayList<>();
       options.add("Please Choose Organiser");
       txt_person.removeAllItems();
        for (Organiser opt: org){
           options.add(opt.getF_name());
         
       }
        for(String i:options){
            if(!temp.contains(i)){
                  txt_person.addItem(i);
            }
        }

    }
    public String getOption(){
        return this.option;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public JPanel getEventPanel(){
         return this.new_event;
     }
     public String getEventTitle(){
        
         return this.txt_title.getText();
     }
      public String getEventDate(){
         return txt_date.getText();
     }
       public String getEventLocation(){
         return txt_location.getText();
     }
       public JTextArea getNep_textArea() {
        return nep_textArea;
    }
       public static void setTextArea(String text){
           nep_textArea.append(text);
       }
        public static JTextArea getTextArea(){
           return nep_textArea;
       }
    }