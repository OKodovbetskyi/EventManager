package com.mycompany.eventmanager.Model;

import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alex
 */
public class Event {
    private String id;
    private String title;
    private String location;
    private String date;
    private Organiser person;
    private ArrayList <Item> items = new ArrayList<>();
    public Event(){
    }
    public Event(String title, String location, String date) {
        String id_Generator = EventManager.getAlphaNumericString(8);
        if (title == null || title.equals("") || location == null || location.equals("") || date == null || date.equals("")){
            System.out.println("Event couldnt be added");
        } else{
        this.title = title;
        this.location = location;
        this.date = date;
        this.id = id_Generator;

        System.out.println("Event "+this.id +" succesfully added");
        }
    }
    public Event(String title, String location, String date, String id, Organiser person, ArrayList<Item> items){
        this.title =title;
        this.location =location;
        this.date =date;
        this.id=id;
        this.person =person;
        this.items = items;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setItem(Item i){
            items.add(i);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public Organiser getPerson(){
        return this.person;
    }
     public void setAssociation(Organiser p){
        this.person = p;
        System.out.println("Association set");
    }
}
