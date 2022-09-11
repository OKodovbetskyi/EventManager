package com.mycompany.eventmanager.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alex
 */
public class Organiser {
    private String id;
    private String f_name;
    private String l_name;
    private String p_number;
    private Boolean availiability;

    
    public Organiser(String f_name, String l_name, String p_number, Event event) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.p_number = p_number;
        this.availiability = true;
        this.id = EventManager.getAlphaNumericString(5);
       
    }
    public Organiser(String f_name, String l_name, String p_number) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.p_number = p_number;
        this.id = EventManager.getAlphaNumericString(5);
    }
    public Organiser(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
   
    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }
    public Boolean getAvailiability(){
        return this.availiability;
    }
    public Boolean setAvailiability(Boolean b){
        return this.availiability = b;
    }
   

 
}
