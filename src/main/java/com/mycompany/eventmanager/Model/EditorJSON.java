package com.mycompany.eventmanager.Model;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.nio.file.Paths;


public class EditorJSON {
    //Read data from JSON FILE.
    public static void loadData(String filename){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Event[] obj = mapper.readValue(new File(System.getProperty("user.dir") + File.separator+ filename), Event[].class);
            Organiser[] organisers = mapper.readValue(new File(System.getProperty("user.dir") + File.separator+ "organisers.json"), Organiser[].class);
            for (Organiser org: organisers){
                EventManager.addToUsers(org);
            }
            for (Event e: obj){
                System.out.println("eventsloaddd >>>>>>"+e);
                EventManager.addToEvents(e);
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    //Save Data to the JSON Object.
    public static Boolean saveData(){
        Boolean fileWritten = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("events.json").toFile(), EventManager.getEvents());
fileWritten =true;
            writer.writeValue(Paths.get("organisers.json").toFile(), EventManager.getOrganisers());
            fileWritten =true;
        } catch (Exception ex) {
            System.out.println(ex);
fileWritten=false;
        }
        return fileWritten;
    }
}
