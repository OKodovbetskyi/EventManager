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
public class AddUserPage {
      JPanel new_user = new JPanel();
      JLabel lbl_fname = new JLabel("First Name");
      JLabel lbl_surname = new JLabel("Surname");
      JLabel lbl_pnumber = new JLabel("Phone Number");
      JTextField txt_fname = new JTextField(10);
      JTextField txt_surname = new JTextField(10);
      JTextField txt_pnumber = new JTextField(10);

      public AddUserPage(JButton btn_save){
          
          // new_user.setLayout();
         GroupLayout layout = new GroupLayout(new_user);
         new_user.setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
 layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(TRAILING)
                .addComponent(lbl_fname)
                .addComponent(lbl_surname)
                .addComponent(lbl_pnumber))
        .addGroup(layout.createParallelGroup()
                .addComponent(txt_fname)
                .addComponent(txt_surname)
                .addComponent(txt_pnumber))
         .addGroup(layout.createParallelGroup()
          .addComponent(btn_save))
        );
   layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(lbl_fname)
                .addComponent(txt_fname))
        .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(lbl_surname)
                .addComponent(txt_surname))
        .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(lbl_pnumber)
                .addComponent(txt_pnumber))
       .addGroup(layout.createParallelGroup(BASELINE)
        .addComponent(btn_save))
         
);
           
      }
      public JPanel getUserPanel(){
          return this.new_user;
      }
}
