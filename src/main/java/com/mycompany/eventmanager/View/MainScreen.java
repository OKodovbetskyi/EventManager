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
public class MainScreen extends JFrame{
    JFrame frame ;
    JPanel panel;
    JPanel assign_user;
    JPanel assignUserPanel;
    static JTextArea textArea ;
    CardLayout cl ;
    MenubarFrontPage mb ;
   Buttons btns ;
    FrontPage pg1 ;
    NewEventPage nep;
    AddItemPage aip;
    AddUserPage aup;
    EditEventPage eep;
  

    public MainScreen(){
   frame = new JFrame("Event Manager");
   panel = new JPanel();
   assign_user = new JPanel();
   assignUserPanel = new JPanel();
   textArea = new JTextArea();
   textArea.setText("Currently you have no events");
   textArea.setFont(new Font(Font.SERIF, Font.PLAIN,  12));
   cl = new CardLayout();
   btns = new Buttons( cl, frame, panel, this);
   nep = new NewEventPage(btns.getBtnNext(), btns.getBtn_addUser(), btns.getBtnSaveEvent(), btns.getBtnRemoveEvent(), btns.getBtnRemoveItem(), btns.getBtn_saveData(), btns.getbtn_MainScreen());
   eep= new EditEventPage(cl,panel);
   mb = new MenubarFrontPage(panel,cl, eep, frame);

   pg1 = new FrontPage(mb.getMenuBar(), textArea,cl,frame ,panel, btns.getButtonsPanel());
   aip = new AddItemPage(btns.getAddAnother(), btns.getSaveItem());
   aup = new AddUserPage(btns.getBtn_saveUser());



    /*if (EventManager.getEvents().isEmpty() || EventManager.getOrganisers().isEmpty()){
        System.out.println("data loaded");
        EditorJSON.loadData("events.json");
        nep.updateOptions();
    }*/
        panel.setLayout(cl);
        // Pages Directions
        panel.add(pg1.getMainPanel(), "1");
        panel.add(aup.getUserPanel(), "2");
        panel.add(nep.getEventPanel(), "3");
        panel.add(assignUserPanel , "4");
        panel.add(aip.getPanel(), "5");
        panel.add(eep.getEditEventPage(), "6");

        cl.show(panel, "1");
        frame.setPreferredSize(new Dimension(500,600));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public static JTextArea getTextArea(){return textArea;}
    public static void setText(String text){
        textArea.append(text);
    }
    public static void clearBoard(){
        textArea.setText(null);
    }
}
