/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.View;

import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.TRAILING;

/**
 *
 * @author alex
 */
public class AddItemPage {
    JPanel addItem = new JPanel();
     JLabel lbl_title = new JLabel("Title");
     JLabel lbl_start = new JLabel("Start Time");
     JTextField txt_title = new JTextField(10);
     JTextField txt_start = new JTextField(10);
    public AddItemPage(JButton btn_another, JButton btn_save){
          GroupLayout layout = new GroupLayout(addItem);
         addItem.setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
 layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(TRAILING)
                .addComponent(lbl_title)
                .addComponent(lbl_start))
        .addGroup(layout.createParallelGroup()
                .addComponent(txt_title)
                .addComponent(txt_start))
          .addComponent(btn_another)
         .addComponent(btn_save)
        );
   layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(lbl_title)
                .addComponent(txt_title))
        .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(lbl_start)
                .addComponent(txt_start))
        .addGroup (layout.createParallelGroup(BASELINE)
                .addGroup(layout.createParallelGroup(BASELINE)
        .addComponent(btn_another)
           .addComponent(btn_save)))
         
);
    } 
    public JPanel getPanel(){
        return this.addItem;
    }
    public String getTitle(){
        return this.txt_title.getText();
    }
    public int getStart(){
        return Integer.parseInt(this.txt_start.getText());
    }
}
