/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanager.Model;

import com.mycompany.eventmanager.View.EventItemAssingmentView;
import com.mycompany.eventmanager.View.MainScreen;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class EventManager {
    private static ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Organiser> organisers = new ArrayList<>();
    //UI runner for User Interface.
    public static void runEventManager(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainScreen();
            }
        });
    }
    //add Event to The list of objects.
    public static Boolean addEvent(String title, String date, String location){
        Event e = new Event(title, location, date);
        if (title.equals(null) || title.equals("") || date.equals("") || date.equals(null) || location.equals("") || location.equals(null)){
            System.out.println("Fillup the field");
        } else {
             events.add(e);
        }
        return events.contains(e);
    }
    //Add item to items array.
    public static Boolean addItem(int start_time, String title){
        Item i = new Item(title, start_time);
        if (title == null || title.equals("") || start_time == 0){
            System.out.println("Fillup the field");
        } else {
            if (EventItemAssingmentView.getEventOption() != null){
                String[] out = EventItemAssingmentView.getEventOption().split(" ");
                events.get(findObject(out[out.length-1])).setItem(i);

            }else{
                events.get(events.size()-1).setItem(i);
            }

        }
        return false;
    }
    
  public static Boolean addUser(String fname, String surname, String phone){
      Organiser u = new Organiser(fname, surname, phone);
      if (organisers.isEmpty()){
          organisers.add(u);
      }else{
      for (Organiser o: organisers){
      if (!(o.getF_name().contains(u.getF_name()) && o.getL_name().contains(u.getL_name()))){
          organisers.add(u);
          return true;
      }
       else
      {
        System.out.println("User already exists");
        return false;
    }
      
      }
       
    }
       return false;
  }
  public static int findObject(String id){
        for (Event e: events){
            if (e.getId().trim().equals(id.trim())) {
                return events.indexOf(e);
            }
        }
        return -1;
  }
    
    public static void printEvents(){
        for (Event i: events){
            System.out.println(i.getTitle());
             System.out.println(i.getDate());
              System.out.println(i.getLocation());
            
        }}
    public static void addToEvents(Event e){

            events.add(e);


    }
    public static void addToUsers(Organiser u){

            organisers.add(u);


    }
         
 public static ArrayList<Event> getEvents(){
     return events;
 }   
 public static ArrayList<Organiser> getOrganisers(){
     return organisers;
 }
 
 public static Boolean deleteEvent(int index){
     if (index > -1){
     events.remove(index);
     if (!events.contains(index)){
         Render.r_events();
         return true;
     }
     }
     return false;
 }

   public static int findIndex(String s){
      for (int i = 0; i<events.size(); i++){
          if ((events.get(i).getTitle().trim().equals(s.trim()))){
              System.out.println(events.get(i).getTitle().trim().equals(s.trim()));
              return i;
          }
  }
      return -1;
  }
  //Remove item from array in object
     public static Boolean removeItem(String s){
      for (int i=0; i<events.size(); i++){
          for (int j=0;j<events.get(i).getItems().size(); j++){
              String itemTitle = events.get(i).getItems().get(j).getTitle().trim();
              int itemTime = events.get(i).getItems().get(j).getStart_time();
              String item = itemTime+ " " +itemTitle;
              if (itemTitle.equals(s.trim()) || item.trim().equals(s.trim())){
                  events.get(i).getItems().remove(j);
                  return true;
              }
          }
  }
      return false;
  }
    //Associate User with Event method
     public static Boolean associateUserWithEvent(String p, Event e){
        if (organisers.size() <= 1){
             e.setAssociation(organisers.get(0));
         }else{
         for (Organiser i: organisers){
             if (i.getF_name().equals(p)){
                  e.setAssociation(i);
             }
         }
         }
         return true;
     }
     //generate String for uniq id So each object has on id.
     public static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    //find Event Object method by its id
    public static Event getEventById(String ev_id){
        for (Event e: events){
            System.out.println(e.getId().trim().toLowerCase().equals(ev_id.trim().toLowerCase()));
            if (e.getId().trim().toLowerCase().equals(ev_id.trim().toLowerCase())){
                return e;
            }
        }
        return null;
    }
 
}
