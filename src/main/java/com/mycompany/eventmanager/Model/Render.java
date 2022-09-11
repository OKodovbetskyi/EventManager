/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.Model;

import com.mycompany.eventmanager.View.MainScreen;
import com.mycompany.eventmanager.View.NewEventPage;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Render {
static ArrayList<Event> events = EventManager.getEvents();
static ArrayList<Organiser> organisers = EventManager.getOrganisers();
    //render Events for new event page.
    public static void r_events(){
        String sb = "";
        String org = "Not assigned";
       int counter = 1;
        if (events.isEmpty()){
            NewEventPage.setTextArea(sb);
        } else{
        for (Event e : events){
            if (e.getPerson() != null){
                org = e.getPerson().getF_name();
            }
            sb = counter +" "+e.getTitle() + " " + e.getDate() + " " + e.getLocation() + " (organised by " + org+")" + System.lineSeparator();
               if (!NewEventPage.getTextArea().getText().contains(sb) ){
                    NewEventPage.setTextArea(sb);
                    counter++;
               }
            for (Item i: e.getItems()){
                 String ib = " \u2022 "+i.getStart_time()+ " " +i.getTitle() + System.lineSeparator();
                     if (!NewEventPage.getTextArea().getText().contains(ib)){
                    NewEventPage.setTextArea(ib);             
        } 
        }
        }
        }
        
           
     //       System.out.println("Event>>>> window is updated");
     //   } else {
     //       System.out.println("Event>>>> window is up to date");
     //   }
    }
    //Render Events Main for main Page
    public static void r_eventsMainPage(){
        System.out.println("EVENTS SIZEE" + events.size());
        String sb = "";
        String org = "Not assigned";
        int counter = 1;

        if (events.isEmpty()){
            NewEventPage.setTextArea(sb);
        } else{
            for (Event e : events){
                if (e.getPerson() != null){
                    org = e.getPerson().getF_name();
                }
                sb = counter+ ". "+ e.getTitle() + " " + e.getDate() + " " + e.getLocation() + " (organised by " + org+")" + System.lineSeparator();
                if (!MainScreen.getTextArea().getText().contains(sb) ){
                    MainScreen.setText(sb);
                    counter++;
                }
                for (Item i: e.getItems()){
                    String ib = " \u2022 "+ i.getStart_time()+ " " +i.getTitle() + System.lineSeparator();
                    if (!MainScreen.getTextArea().getText().contains(ib)){
                        MainScreen.setText(ib);
                    }
                }
            }
        }}
  

}
  

