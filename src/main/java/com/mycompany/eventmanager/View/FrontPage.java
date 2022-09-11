/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author alex
 */
public class FrontPage {
     JPanel main_panel = new JPanel();
     public FrontPage(){
     }
     public FrontPage(JMenuBar mb, JTextArea textbox, CardLayout cl, JFrame frame, JPanel panel, JPanel btns){
         main_panel.setLayout(new BorderLayout());
         main_panel.add(mb , BorderLayout.NORTH);
         main_panel.add(btns, BorderLayout.SOUTH);
         main_panel.add(textbox, BorderLayout.CENTER);  
     }
     public JPanel getMainPanel (){
        return main_panel;
     } 
}
